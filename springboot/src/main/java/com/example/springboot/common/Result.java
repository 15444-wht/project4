package com.example.springboot.common;


import org.springframework.web.util.pattern.PathPattern;

public class Result {
    private static final String SUCESS_CODE="200";
    private static final String ERROR_CODE="-1";
    private String code;
    private Object data;
    private String msg;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public static Result success(){
        Result result = new Result();
        result.setCode(SUCESS_CODE);
        return result;
    }
    public static Result success(Object data){
        Result result = new Result();
        result.setCode(SUCESS_CODE);
        result.setData(data);
        return result;
    }
    public static Result error(String msg){
        Result result = new Result();
        result.setCode(ERROR_CODE);
        result.setMsg(msg);
        return result;
    }

}