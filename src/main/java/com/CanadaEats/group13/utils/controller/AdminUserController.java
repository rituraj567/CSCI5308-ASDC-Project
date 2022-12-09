package com.CanadaEats.group13.utils.controller;

import com.CanadaEats.group13.authentication.dto.UserLoginDto;
import com.CanadaEats.group13.utils.APIAccessAuthorization;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class AdminUserController {
    @GetMapping("/adminuserhomepage")
    public String adminUserHomePage(Model model, HttpServletRequest request){
        boolean isAPIAccessible = APIAccessAuthorization.getInstance().getAPIAccess(request);
        if(isAPIAccessible)
        {
            return "utils/adminuserhomepage";
        }
        return "redirect:/userloginerrorpage";
    }
}
