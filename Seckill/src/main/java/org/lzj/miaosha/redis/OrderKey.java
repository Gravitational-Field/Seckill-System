package org.lzj.miaosha.redis;

/**
 * @ClassName OrderKey
 * @Description: TODO
 * @Author Keen
 * @DATE 2021/3/25 16:44
 * @Version 1.0
 **/
public class OrderKey extends BasePrefix{

    public OrderKey(int expireSeconds, String prefix) {
        super(expireSeconds, prefix);
    }
}
