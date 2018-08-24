package com.example.wenda.controller;

import com.example.wenda.Service.WendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * Created by Administrator on 2018/8/23 0023.
 */
@Controller
public class SettringController {

    @Autowired
    WendaService wendaService;

    @RequestMapping(path="/setting")
    @ResponseBody
    public String index(HttpSession httpSession){
        return "setting ok "+wendaService.getMessage(123);
    }
}
