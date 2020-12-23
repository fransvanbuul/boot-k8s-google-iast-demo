package com.example.bootk8sgoogleiastdemo;

import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "")
@RequiredArgsConstructor
public class WebController {

    private final CaptchaService captchaService;

    @GetMapping("")
    public ModelAndView index() {
        val modelAndView = new ModelAndView("index");
        return modelAndView;
    }

    @GetMapping("testpage")
    public ModelAndView testpage(
            @RequestParam(required = false) String inputtext,
            @RequestParam(name = "g-recaptcha-response", required = false) String gRecaptchaResponse,
            HttpServletRequest request) {
        String captchaError = null;
        if(inputtext != null && !inputtext.isEmpty()) {
            if(gRecaptchaResponse == null || gRecaptchaResponse.isEmpty() || gRecaptchaResponse.equals("#")) {
                captchaError = "Captcha Required";
            } else {
                captchaError = captchaService.processResponse(gRecaptchaResponse, request.getRemoteAddr());
            }
        }
        val modelAndView = new ModelAndView("testpage");
        modelAndView.addObject("captchaerror", captchaError);
        if(captchaError == null) {
            modelAndView.addObject("inputtext", inputtext);
        }
        return modelAndView;
    }
}
