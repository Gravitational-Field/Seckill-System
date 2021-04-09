package org.lzj.miaosha.result;

import com.sun.org.apache.bcel.internal.classfile.Code;
import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

/**
 * @ClassName Result
 * @Description: TODO
 * @Author Keen
 * @DATE 2021/3/24 15:59
 * @Version 1.0
 **/

public class Result<T> {
    private int code;
    private String msg;
    private T data;

    //构造器
    public Result(T data) {
        this.code = 0;
        this.msg = "success";
        this.data = data;
    }

    private Result(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    private Result(CodeMsg cm) {
        if(cm == null) {
            return;
        }
        this.code = cm.getCode();
        this.msg = cm.getMsg();
    }


    //成功时调用
    public static <T> Result<T> success(T data) {
        return new Result<T>(data);
    }

    //失败时调用
    public static <T> Result<T> error(CodeMsg cm) {
        return new Result<T>(cm);
    }


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
