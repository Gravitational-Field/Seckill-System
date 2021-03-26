package org.lzj.miaosha.service;

import org.apache.commons.lang3.StringUtils;
import org.lzj.miaosha.dao.MiaoshaUserDao;
import org.lzj.miaosha.domain.MiaoshaUser;
import org.lzj.miaosha.exception.GlobalException;
import org.lzj.miaosha.redis.MiaoshaUserKey;
import org.lzj.miaosha.redis.RedisService;
import org.lzj.miaosha.result.CodeMsg;
import org.lzj.miaosha.util.MD5Util;
import org.lzj.miaosha.util.UUIDUtil;
import org.lzj.miaosha.vo.LoginVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName MiaoshaUserService
 * @Description: TODO
 * @Author Keen
 * @DATE 2021/3/26 9:21
 * @Version 1.0
 **/
@Service
public class MiaoshaUserService {

    public static final String COOKIE_NAME_TOKEN = "token";

    @Autowired
    MiaoshaUserDao miaoshaUserDao;

    @Autowired
    RedisService redisService;

    public MiaoshaUser getById(long id) {
        return miaoshaUserDao.getById(id);
    }

    public MiaoshaUser getByToken(HttpServletResponse response, String token) {
        if(StringUtils.isEmpty(token)) {
            return null;
        }
        MiaoshaUser user = redisService.get(MiaoshaUserKey.token, token, MiaoshaUser.class);
        if(user != null) {
            //延长有效期
            addCookie(response, token, user);
        }
        return user;
    }

    /*登录服务*/
    public boolean login(HttpServletResponse response, LoginVo loginVo) {
        if(loginVo == null) {
            throw new GlobalException(CodeMsg.SERVER_ERROR);
        }
        String mobile = loginVo.getMobile();
        String password = loginVo.getPassword();
        //判断手机号是否存在
        MiaoshaUser user = getById(Long.parseLong(mobile));
        if(user == null) {
            throw new GlobalException(CodeMsg.MOBILE_NOT_EXIST);
        }
        //验证密码
        String dbPass = user.getPassword();
        String dbSalt = user.getSalt();
        String calcPass = MD5Util.formPassToDBPass(password, dbSalt);
        if(!calcPass.equals(dbPass)) {
            throw new GlobalException(CodeMsg.PASSWORD_ERROR);
        }
        //生成token
        String token = UUIDUtil.uuid();
        addCookie(response, token,user);
        return true;
    }

    //生成token，并存到cookie中，将token与相应的user存到redis中
    private void addCookie(HttpServletResponse response, String token, MiaoshaUser user) {

        redisService.set(MiaoshaUserKey.token, token, user);
        Cookie cookie = new Cookie(COOKIE_NAME_TOKEN,token);
        cookie.setMaxAge(MiaoshaUserKey.token.expireSeconds());
        cookie.setPath("/");
        response.addCookie(cookie);
    }


}
