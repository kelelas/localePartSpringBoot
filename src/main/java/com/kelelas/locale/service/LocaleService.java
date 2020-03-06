package com.kelelas.locale.service;

import com.kelelas.locale.dto.UsersDTO;
import com.kelelas.locale.repository.UserRepository;
import com.kelelas.locale.text_constant.TextConstant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Locale;
import java.util.ResourceBundle;


@Slf4j
@Service

public class LocaleService {

    private UserRepository userRepository;
    private Locale locale;
    private ResourceBundle bundle;

    @Autowired
    public LocaleService(UserRepository userRepository) {
        this.userRepository = userRepository;

        this.locale = new Locale("en");
        this.bundle =  ResourceBundle.getBundle("message", locale);
    }

    public void setLocale(Locale locale){
        this.bundle = ResourceBundle.getBundle(
               "message", locale);
    }

    public void print(){
        System.out.println(bundle.getString(TextConstant.INPUT_LOCALE));
    }

    public UsersDTO getAllUsers() {
        return new UsersDTO(userRepository.findAll());
    }

}
