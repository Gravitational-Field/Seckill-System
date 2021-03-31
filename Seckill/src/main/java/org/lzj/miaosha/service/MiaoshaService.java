package org.lzj.miaosha.service;

import org.lzj.miaosha.domain.MiaoshaOrder;
import org.lzj.miaosha.domain.MiaoshaUser;
import org.lzj.miaosha.domain.OrderInfo;
import org.lzj.miaosha.vo.GoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @ClassName MiaoshaService
 * @Description: TODO
 * @Author Keen
 * @DATE 2021/3/29 10:39
 * @Version 1.0
 **/
@Service
public class MiaoshaService {

    @Autowired
    GoodsService goodsService;

    @Autowired
    OrderService orderService;

    //减库存、下订单、写入秒杀订单
    @Transactional
    public OrderInfo miaosha(MiaoshaUser user, GoodsVo goods) {
        //减库存
        goodsService.ruduceStock(goods);
        //下订单
        return orderService.createOrder(user, goods);
    }
}
