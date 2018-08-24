package com.example.wenda.controller;

import com.example.wenda.Model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.*;

/**
 * Created by Administrator on 2018/8/19 0019.
 */
@Controller
public class IndexController {


    @RequestMapping(path="/")
    @ResponseBody
    public String index(HttpSession httpSession){
        return "Hello"+httpSession.getAttribute("msg");
    }

    @RequestMapping(path={"/vm"},method = {RequestMethod.GET})
    public String templates(Model model){
        model.addAttribute("value","vvvvv");
        List<String> colors = Arrays.asList(new String[]{"RED","GREEN","Blue"});
        model.addAttribute("colors",colors);

        Map<String,String> map = new HashMap<>();
        for(int i =0;i<4;i++){
            map.put(String.valueOf(i),String.valueOf(i*i));
        }
        model.addAttribute("map",map);
        model.addAttribute("user",new User("canace"));
        return "home";
    }
//    请求
    @RequestMapping(path="/request")
    @ResponseBody
    public String index(Model model, HttpSession session,
                        HttpServletRequest request,
                        HttpServletResponse response,
                        @CookieValue("JSESSIONID") String sessionId){
        StringBuffer sb = new StringBuffer();
        sb.append(request.getMethod()+"</br>");
        sb.append(request.getQueryString()+"</br>");
        sb.append(request.getPathInfo()+"</br>");
        sb.append(request.getRequestURL()+"</br>");

        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()){
            String names = headerNames.nextElement();
            sb.append(names + "" + request.getHeader(names)+ "</br>");
        }

        if(request.getCookies() != null){
            for(Cookie cookie: request.getCookies() ){
                sb.append("Cookie:"+cookie.getName() + "  Value:"+cookie.getValue() + "</br>");
            }
        }

        sb.append("CookieValue:" + sessionId);
        return  sb.toString();

    }
//    重定向
    @RequestMapping(path="/redirect/{code}",method = {RequestMethod.GET})
    public String redirect(@PathVariable("code") int code,
                           HttpSession httpSession){
        httpSession.setAttribute("msg"," is from redirect");
        return "redirect:/";
    }

    //管理员界面下才能访问
    @RequestMapping(path="/admin",method = {RequestMethod.GET})
    @ResponseBody
    public String admin(@RequestParam("key") String key){
        if("admin".equals(key)){
        return "Hello Admin";
        }
        throw new IllegalArgumentException("参数不对");
    }
    // 抛出异常
    @ExceptionHandler()
    @ResponseBody
    public String error(Exception e){
        return "error:" + e.getMessage();
    }
}
