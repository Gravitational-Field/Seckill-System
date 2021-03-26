package org.lzj.miaosha.controller;

import org.lzj.miaosha.domain.User;
import org.lzj.miaosha.redis.RedisService;
import org.lzj.miaosha.redis.UserKey;
import org.lzj.miaosha.result.CodeMsg;
import org.lzj.miaosha.result.Result;
import org.lzj.miaosha.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName DemoController
 * @Description: TODO
 * @Author Keen
 * @DATE 2021/3/20 11:36
 * @Version 1.0
 **/

@Controller
@RequestMapping("/demo")
/*@RestController("/demo")*/
public class DemoController {

    @Autowired
    UserService userService;

    @Autowired
    RedisService redisService;

    @RequestMapping("/")
    @ResponseBody
    public String home() {
        return "hello world";
    }

    @RequestMapping("/hello")
    @ResponseBody
    public Result<String> hello() {
        //return new Result<String>("hello,imooc");
        return Result.success("hello,imooc");
    }

    @RequestMapping("/helloError")
    @ResponseBody
    public Result<String> helloError() {
        return Result.error(CodeMsg.SERVER_ERROR);
    }

    @RequestMapping("/thymeleaf")
    public String thymeleaf(Model model) {
        model.addAttribute("name", "keen");
        return "hello";
    }

    @RequestMapping("/db/get")
    @ResponseBody
    public Result<User> dbGet() {
        User user = userService.getById(1);
        return Result.success(user);
    }


    @RequestMapping("/db/tx")
    @ResponseBody
    public Result<Boolean> dbtx() {
        userService.tx();
        return Result.success(true);
    }

    @RequestMapping("/redis/get")
    @ResponseBody
    public Result<User> redisGet() {
        User user = redisService.get(UserKey.getById,""+1, User.class);
        return Result.success(user);
    }

    @RequestMapping("/redis/set")
    @ResponseBody
    public Result<User> redisSet() {
        User user = new User();
        user.setId(1);
        user.setName("keen");
        Boolean b = redisService.set(UserKey.getById, ""+1, user);
        User user1 = redisService.get(UserKey.getById, "" + 1, User.class);
        return Result.success(user1);
    }

}
