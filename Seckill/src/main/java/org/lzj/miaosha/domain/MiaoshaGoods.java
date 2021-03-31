package org.lzj.miaosha.domain;


import java.util.Date;

public class MiaoshaGoods {

    private Long id;
    private Long goodsId;
    private Double miaoshaPrice;
    private Long stockCount;
    private Date startDate;
    private Date endDate;


    public long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }


    public double getMiaoshaPrice() {
        return miaoshaPrice;
    }

    public void setMiaoshaPrice(double miaoshaPrice) {
        this.miaoshaPrice = miaoshaPrice;
    }


    public long getStockCount() {
        return stockCount;
    }

    public void setStockCount(Long stockCount) {
        this.stockCount = stockCount;
    }


    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }


    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

}
