package org.lzj.miaosha.redis;

/**
 * @ClassName MiaoshaUserKey
 * @Description: TODO
 * @Author Keen
 * @DATE 2021/3/26 19:43
 * @Version 1.0
 **/
public class MiaoshaUserKey extends BasePrefix{

    private static final int TOKEN_EXPIRE = 1800;  //半个小时

    public static MiaoshaUserKey token = new MiaoshaUserKey(TOKEN_EXPIRE, "tk");

    public MiaoshaUserKey(int expireSeconds, String prefix) {
        super(expireSeconds, prefix);
    }
}
