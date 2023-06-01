package com.lq.SmartWardrobe.exception;



import com.lq.SmartWardrobe.result.ResultCodeEnum;
import lombok.Data;

@Data
public class lqException extends RuntimeException{

    private Integer code;

    private String msg;

    public lqException(Integer code,String msg){
        super(msg);
        this.code = code;
        this.msg = msg;
    }

    /**
     * 接收枚举类型对象
     * @param resultCodeEnum
     */
    public lqException(ResultCodeEnum resultCodeEnum) {
        super(resultCodeEnum.getMessage());
        this.code = resultCodeEnum.getCode();
        this.msg = resultCodeEnum.getMessage();
    }

    @Override
    public String toString() {
        return "lqException{" +
                "code=" + code +
                ", msg=" + this.getMessage() +
                '}';
    }
}
