package org.lzj.miaosha.controller;

import org.apache.commons.lang3.StringUtils;
import org.lzj.miaosha.domain.MiaoshaUser;
import org.lzj.miaosha.redis.MiaoshaUserKey;
import org.lzj.miaosha.redis.RedisService;
import org.lzj.miaosha.service.GoodsService;
import org.lzj.miaosha.service.MiaoshaUserService;
import org.lzj.miaosha.vo.GoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

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

    @Autowired
    GoodsService goodsService;

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
    public String list(Model model, MiaoshaUser user) { //如何能将数据传输进来？   通过拦截器
        if(user != null) {
            model.addAttribute("user", user);
        }
        List<GoodsVo> goodsList = goodsService.listGoodsVo();
        model.addAttribute("goodsList",goodsList);
        //System.out.println(goodsList);
        return "goods_list";
    }

    @RequestMapping("/to_detail/{goodsId}")
    public String list(Model model, MiaoshaUser user, @PathVariable("goodsId")long goodsId) { //如何能将数据传输进来？   通过拦截器
        model.addAttribute("user", user);

        GoodsVo goods = goodsService.getGoodsVoByGoodsId(goodsId);
        model.addAttribute("goods", goods);

        long startAt = goods.getStartDate().getTime();
        long endAt = goods.getEndDate().getTime();
        long now = System.currentTimeMillis();

        int miaoshaStatus = 0;
        int remainSeconds = 0;
        if(now < startAt ) {//秒杀还没开始，倒计时
            miaoshaStatus = 0;
            remainSeconds = (int)((startAt - now )/1000);
        }else if(now > endAt){//秒杀已经结束
            miaoshaStatus = 2;
            remainSeconds = -1;
        }else {//秒杀进行中
            miaoshaStatus = 1;
            remainSeconds = 0;
        }
        model.addAttribute("miaoshaStatus", miaoshaStatus);
        model.addAttribute("remainSeconds", remainSeconds);
        return "goods_detail";
    }

}
