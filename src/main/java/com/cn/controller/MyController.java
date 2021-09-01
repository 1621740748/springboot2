package com.cn.controller;

import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;
import com.cn.bean.City;

/**
 * Created by Administrator on 1/18/2017.
 */
@Controller
public class MyController {

    @GetMapping("/index")
    public String index(Map<String, Object> model) {
        model.put("msg", "welocme");
        return "index";
    }

    @GetMapping("/getCity")
    @ResponseBody
    public City getCity() {
        City city = new City();
        city.setName("上海");
        city.setCityCode("0212");
        return city;
    }
    @RequestMapping("/getCity1")
    @ResponseBody
    public String  getCity1(HttpServletRequest req, HttpServletResponse resp) {
      String data = req.getParameter("data");
       JSONObject obj = JSON.parseObject(data, Feature.SupportNonPublicField);
       return "index";
    }
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(value = "/greeting1")
    @ResponseBody
    public String  greeting1(@RequestBody City request) {
        return "index";
    }
}
