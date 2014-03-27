package com.example.web.ui.signin;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: magnus.smith
 * Date: 12/03/14
 * Time: 10:09
 */
@Controller
@SessionAttributes("userRoles")
public class SigninController {

    @RequestMapping(value = "signin", method = RequestMethod.GET)
    public String signin(Model model) {
        Set<String> userRoles = AuthorityUtils.authorityListToSet(SecurityContextHolder.getContext().getAuthentication().getAuthorities());


        model.addAttribute("userRole", userRoles);
        return "signin/signin";
    }


}