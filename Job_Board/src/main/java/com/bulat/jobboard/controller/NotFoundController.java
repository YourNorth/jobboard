package com.bulat.jobboard.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controller for handling 404 errors
 * @author Bulat Bilalov
 * @version 1.0
 */
@Controller
public class NotFoundController implements ErrorController {

    /** A method that converts a 404 error into a prepared page */
    @RequestMapping("/error")
    public String handleError() {
        return "404";
    }

    /** Method that gets 404 error */
    @Override
    public String getErrorPath() {
        return "/error";
    }
}
