package cashewnut.biz.login.controller;

import cashewnut.biz.login.dto.LoginGoogleDto;
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
        try {
            System.out.println("data : " + loginKakaoDto);

            // Check if LoginKakaoDto attributes are correctly populated
            System.out.println("LoginKakaoDto: " + loginKakaoDto.toString());

            // Set session attributes
            session.setAttribute("Id", loginKakaoDto.getId());
            session.setAttribute("connected_at", loginKakaoDto.getConnected_at());
            session.setAttribute("email", loginKakaoDto.getEmail());
            session.setAttribute("age_range", loginKakaoDto.getAge_range());
            session.setAttribute("gender", loginKakaoDto.getGender());
            session.setAttribute("profile_nickname", loginKakaoDto.getProfile_nickname());
            session.setAttribute("birthday", loginKakaoDto.getBirthday());
            session.setAttribute("birthday_type", loginKakaoDto.getBirthday_type());
            session.setAttribute("profile_image_url", loginKakaoDto.getProfile_image_url());

            session.setMaxInactiveInterval(60 * 60);

            // Check if session attributes are correctly set
            System.out.println("session : " + session);

            // Log session attributes
            System.out.println("Id: " + session.getAttribute("Id"));
            System.out.println("connected_at: " + session.getAttribute("connected_at"));
            System.out.println("email: " + session.getAttribute("email"));
            System.out.println("age_range: " + session.getAttribute("age_range"));
            System.out.println("gender: " + session.getAttribute("gender"));
            System.out.println("profile_nickname: " + session.getAttribute("profile_nickname"));
            System.out.println("birthday: " + session.getAttribute("birthday"));
            System.out.println("birthday_type: " + session.getAttribute("birthday_type"));
            System.out.println("profile_image_url: " + session.getAttribute("profile_image_url"));


            return "redirect:/home";
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/error"; // Redirect to an error page if an exception occurs
        }
    }

    @RequestMapping("/login/googleSession")
    @ResponseBody
    public String googleSession(@RequestBody LoginGoogleDto loginGoogleDto, HttpSession session) {
        try {
            System.out.println("data : " + loginGoogleDto);

            // Check if LoginKakaoDto attributes are correctly populated
            System.out.println("LoginKakaoDto: " + loginGoogleDto.toString());

            // Set session attributes
            session.setAttribute("Id", loginGoogleDto.getId());
            session.setAttribute("connected_at", loginGoogleDto.getName());
            session.setAttribute("connected_at", loginGoogleDto.getImageUrl());
            session.setAttribute("email", loginGoogleDto.getEmail());

            session.setMaxInactiveInterval(60 * 60);

            // Check if session attributes are correctly set
            System.out.println("session : " + session);

            return "redirect:/home";
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/error"; // Redirect to an error page if an exception occurs
        }
    }
}
