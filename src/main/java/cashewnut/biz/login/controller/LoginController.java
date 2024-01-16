package cashewnut.biz.login.controller;

import cashewnut.biz.login.dto.LoginKakaoDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @RequestMapping("/login")
    public String login() {
        return "/login/VIEW009001M";
    }

    @RequestMapping("/login/kakaoSession")
    @ResponseBody
    public String kakaoSession(@RequestBody LoginKakaoDto loginKakaoDto, HttpSession session) {
        System.out.println("data : " + loginKakaoDto);
        session.setAttribute("userId", loginKakaoDto.getId());

        return "redirect:/home";
    }

}
