package org.lzj.miaosha.exception;

import org.lzj.miaosha.result.CodeMsg;

/**
 * @ClassName GlobalException
 * @Description: TODO
 * @Author Keen
 * @DATE 2021/3/26 11:03
 * @Version 1.0
 **/
public class GlobalException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    private CodeMsg cm;
    public GlobalException(CodeMsg cm) {
        super(cm.toString());
        this.cm = cm;
    }

    public CodeMsg getCm() {
        return cm;
    }
}
