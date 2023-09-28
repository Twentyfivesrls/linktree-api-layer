package com.twentyfive.linktreeapilayer.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/public")
public class PublicController {

        @RequestMapping("/prova")
        public String prova(){
            return "prova";
        }
}
