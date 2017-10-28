package com.github.alexivchenko.springoauth2restapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Alex Ivchenko
 */
@RestController
public class MainController {
    @GetMapping("/public")
    public String unprotected() {
        return "public";
    }

    @GetMapping("/private")
    public String secured() {
        return "private";
    }
}
