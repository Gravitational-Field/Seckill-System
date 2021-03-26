package org.lzj.miaosha.controller;

import org.apache.commons.lang3.StringUtils;
import org.lzj.miaosha.domain.MiaoshaUser;
import org.lzj.miaosha.redis.MiaoshaUserKey;
import org.lzj.miaosha.redis.RedisService;
import org.lzj.miaosha.service.MiaoshaUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @ClassName GoodsController
 * @Description: TODO
 * @Author Keen
 * @DATE 2021/3/26 19:59
 * @Version 1.0
 **/
@Controller
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    MiaoshaUserService miaoshaUserService;

    @Autowired
    RedisService redisService;

    /*@RequestMapping("/to_list")  //如何能简化呢？
    public String list(Model model, @CookieValue(value = MiaoshaUserService.COOKIE_NAME_TOKEN, required = false) String cookieToken,
                       @RequestParam(value = MiaoshaUserService.COOKIE_NAME_TOKEN, required = false) String paramToken) {
        if(StringUtils.isEmpty(cookieToken) && StringUtils.isEmpty(paramToken)) {
            return "login";
        }
        String token = StringUtils.isEmpty(cookieToken)?paramToken:cookieToken;
        //通过token获取user
        MiaoshaUser user = redisService.get(MiaoshaUserKey.token, token, MiaoshaUser.class);
        if(user != null) {
            model.addAttribute("user", user);
        }
        return "goods_list";
    }*/

    @RequestMapping("/to_list")
    public String list(Model model, MiaoshaUser user) { //如何能将数据传输进来？   通
        if(user != null) {
            model.addAttribute("user", user);
        }
        return "goods_list";
    }

}
