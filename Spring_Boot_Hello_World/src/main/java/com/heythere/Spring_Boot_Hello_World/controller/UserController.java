package com.heythere.Spring_Boot_Hello_World.controller;

import com.heythere.Spring_Boot_Hello_World.ConfigBean;
import com.heythere.Spring_Boot_Hello_World.ConfigTestBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    /*@Value("${com.heythere.me}")
    private String me;

    @Value("${com.heythere.say}")
    private String say;

    @RequestMapping("/")
    public String hexo() {
        return me + " " + say;
    }*/

    private final ConfigBean configBean;
    private final ConfigTestBean configTestBean;

    @Autowired
    public UserController(ConfigBean configBean, ConfigTestBean configTestBean) {
        this.configBean = configBean;
        this.configTestBean = configTestBean;
    }

    @RequestMapping("/")
    public String hexo() {
        return "secret:" + configBean.getSecret() +
                "  number:" + configBean.getNumber() +
                "  longNumber:" + configBean.getLongNumber() +
                "  uuid:" + configBean.getUuid() +
                "  lessThanTen:" + configBean.getLessThanTen() +
                "  range:" + configBean.getRange();
    }
}
