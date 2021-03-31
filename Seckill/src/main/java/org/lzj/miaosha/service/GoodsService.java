package org.lzj.miaosha.service;

import org.lzj.miaosha.dao.GoodsDao;
import org.lzj.miaosha.domain.Goods;
import org.lzj.miaosha.domain.MiaoshaGoods;
import org.lzj.miaosha.vo.GoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName GoodsService
 * @Description: TODO
 * @Author Keen
 * @DATE 2021/3/27 21:46
 * @Version 1.0
 **/
@Service
public class GoodsService {

    @Autowired
    GoodsDao goodsDao;


    public List<GoodsVo> listGoodsVo() {
        List<GoodsVo> goodsList = goodsDao.listGoodsVo();
        return goodsList;
    }

    public GoodsVo getGoodsVoByGoodsId(long goodsId) {
        return goodsDao.getGoodsVoByGoodsId(goodsId);
    }

    public void ruduceStock(GoodsVo goods) {
        MiaoshaGoods g = new MiaoshaGoods();
        g.setGoodsId(goods.getId());
        goodsDao.ruduceStock(g);
    }
}
