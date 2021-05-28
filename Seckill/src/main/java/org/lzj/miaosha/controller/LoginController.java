package org.lzj.miaosha.controller;

import com.sun.org.apache.xpath.internal.operations.Bool;
import org.lzj.miaosha.redis.RedisService;
import org.lzj.miaosha.result.CodeMsg;
import org.lzj.miaosha.result.Result;
import org.lzj.miaosha.service.MiaoshaUserService;
import org.lzj.miaosha.service.UserService;
import org.lzj.miaosha.vo.LoginVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName LoginController
 * @Description: TODO
 * @Author Keen
 * @DATE 2021/3/25 19:28
 * @Version 1.0
 **/
@Controller
@RequestMapping("/login")
public class LoginController {

    private static Logger log = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    MiaoshaUserService miaoshaUserService;

    /*@Autowired
    RedisService redisService;*/

    @RequestMapping("/to_login")
    public String toLogin() {
        return "login";
    }


    @RequestMapping("/do_login")
    @ResponseBody
    public Result<Boolean> doLogin(HttpServletResponse response,LoginVo loginVo) {
        log.info(loginVo.toString());
        //参数校验
        /*String password = loginVo.getPassword();
        String mobile = loginVo.getMobile();
        if(password == null) {
            return Result.error(CodeMsg.PASSWORD_EMPTY);
        }
        if(mobile == null) {
            return Result.error(CodeMsg.MOBILE_EMPTY);
        }*/

        miaoshaUserService.login(response, loginVo);
        return Result.success(true);
    }
}
