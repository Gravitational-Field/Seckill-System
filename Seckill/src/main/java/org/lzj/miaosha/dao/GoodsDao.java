package org.lzj.miaosha.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.lzj.miaosha.domain.MiaoshaGoods;
import org.lzj.miaosha.vo.GoodsVo;

import javax.websocket.server.PathParam;
import java.util.List;

/**
 * @ClassName GoodsDao
 * @Description: TODO
 * @Author Keen
 * @DATE 2021/3/27 21:49
 * @Version 1.0
 **/
@Mapper
public interface GoodsDao {

    @Select("select g.*,mg.miaosha_price,mg.stock_count,mg.start_date,mg.end_date from miaosha_goods mg left join goods g on mg.goods_id=g.id")
    List<GoodsVo> listGoodsVo();

    @Select("select g.*,mg.miaosha_price,mg.stock_count,mg.start_date,mg.end_date " +
            "from miaosha_goods mg left join goods g on mg.goods_id=g.id where g.id = #{goodsId}")
    GoodsVo getGoodsVoByGoodsId(@Param("goodsId")long goodsId);

    @Update("update miaosha_goods set stock_count = stock_count-1 where goods_id = #{goodsId}")
    int reduceStock(MiaoshaGoods goods);

    @Update("update miaosha_goods set stock_count = #{stockCount} where goods_id = #{goodsId}")
    int resetStock(MiaoshaGoods g);
}
