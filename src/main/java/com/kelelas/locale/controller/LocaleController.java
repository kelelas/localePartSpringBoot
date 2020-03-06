package com.kelelas.locale.controller;


import com.kelelas.locale.dto.UsersDTO;
import com.kelelas.locale.service.LocaleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@Slf4j
@RestController
@RequestMapping(value = "/")
public class LocaleController {
private final LocaleService localeService;
    @Autowired
    public LocaleController(LocaleService localeService) {
        this.localeService = localeService;
    }
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "eng")
    public UsersDTO localeEngFromController(){

        localeService.setLocale(new Locale("en"));
        localeService.print();
        return  localeService.getAllUsers();
    }
    @PostMapping(value = "ukr")
    public UsersDTO localeUkrFromController(){

        localeService.setLocale(new Locale("ua", "UA"));
        localeService.print();
        return  localeService.getAllUsers();
    }
}
