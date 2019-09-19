package com.playbigfoot.practicebasic1.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class HomeController {

    @RequestMapping(value = "/hi")
    public ModelAndView getMethodName(ModelAndView mav) {
        
        mav.setViewName("home.html");

        return mav;
    }

}