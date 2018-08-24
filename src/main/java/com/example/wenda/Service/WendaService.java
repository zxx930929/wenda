package com.example.wenda.Service;

import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2018/8/23 0023.
 */
@Service
public class WendaService {
    public String getMessage(int userId){
        return  "Hello Message" + String.valueOf(userId);
    }
}
