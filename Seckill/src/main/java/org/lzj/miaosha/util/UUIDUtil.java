package org.lzj.miaosha.util;

import java.util.UUID;

/**
 * @ClassName UUIDUtil
 * @Description: TODO
 * @Author Keen
 * @DATE 2021/3/26 19:40
 * @Version 1.0
 **/
public class UUIDUtil {

    public static String uuid() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
