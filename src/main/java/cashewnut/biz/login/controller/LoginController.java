package cashewnut.biz.login.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

@Controller
public class LoginController {

    @RequestMapping("/login")
    public String login() {
        return "/login/VIEW009001M";
    }

    @RequestMapping("/login/kakaoSession")
    public String kakaoSession(HttpSession session, Object data) {
        System.out.println("data : " + data);
        session.setAttribute("userId", data.toString());

        return "redirect:/home";
    }

}
