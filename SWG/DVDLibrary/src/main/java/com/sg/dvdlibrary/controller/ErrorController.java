package com.sg.dvdlibrary.controller;

import java.text.MessageFormat;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author saduk
 */

@Controller
public class ErrorController {
    @RequestMapping(value="/error")
    public String customError(HttpServletRequest request, HttpServletResponse response, 
                            Model model){
        // retrieve useful information from the request
        // Get the HTTP Status Code
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        HttpStatus httpStatus = HttpStatus.valueOf(statusCode);
        // Get the error object itself
        Throwable throwable = (Throwable) request.getAttribute("javax.servlet.error.exception");
        String exceptionMessage = null;
        exceptionMessage = httpStatus.getReasonPhrase();
        
        // Get the Request URI
        String requestUri = (String) request.getAttribute("javax.servlet.error.request_uri");
        if (requestUri == null) {
            requestUri = "Unknown";
        }
        
        // format the message for the view
        String message = MessageFormat.format("{0} returned for {1}: {2}",
                                            statusCode, requestUri, exceptionMessage);
        
        // put the message in the model
        model.addAttribute("errorMessage",message);
        return "customError";
        
    }
}