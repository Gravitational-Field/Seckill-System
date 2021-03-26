package org.lzj.miaosha.vo;

import org.hibernate.validator.constraints.Length;
import org.lzj.miaosha.validator.IsMobile;

import javax.validation.constraints.NotNull;

/**
 * @ClassName LoginVo
 * @Description: TODO
 * @Author Keen
 * @DATE 2021/3/25 19:50
 * @Version 1.0
 **/
public class LoginVo {

    @NotNull
    @IsMobile
    private String mobile;

    @NotNull
    @Length(min = 6)
    private String password;

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "LoginVo{" +
                "mobile='" + mobile + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
