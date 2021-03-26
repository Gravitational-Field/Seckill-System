package org.lzj.miaosha.redis;

/**
 * @ClassName UserKey
 * @Description: TODO
 * @Author Keen
 * @DATE 2021/3/25 16:41
 * @Version 1.0
 **/
public class UserKey extends BasePrefix{

    public static UserKey getById = new UserKey("id");
    public static UserKey getByName = new UserKey("name");

    public UserKey(String prefix) {
        super(prefix);
    }

}
