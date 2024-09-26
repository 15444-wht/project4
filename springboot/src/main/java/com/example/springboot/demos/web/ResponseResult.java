package com.example.springboot.demos.web;

import com.fasterxml.jackson.annotation.JsonInclude;


import java.util.Objects;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseResult<T> {
    private Integer code;
    private String msg;
    private Long total;
    private Object data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public ResponseResult() {
    }

    public static ResponseResult fail(){
        return responseResult(400,"失败",0L,null);
    }


    public static ResponseResult success(Object data){
        return responseResult(200,"成功",0L,data);
    }
    public static ResponseResult success(){
        return responseResult(200,"成功",0L,null);
    }
    //列表
    public static ResponseResult success(Object data, Long total){
        return responseResult(200,"成功",total,data);
    }

    private static ResponseResult responseResult(int code, String msg, Long total, Object data){
        ResponseResult responseResult = new ResponseResult();
        responseResult.setData(data);
        responseResult.setCode(code);
        responseResult.setMsg(msg);
        responseResult.setTotal(total);
        return responseResult;
    }

    public ResponseResult(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ResponseResult(Integer code, Object data) {
        this.code = code;
        this.data = data;
    }

    public ResponseResult(Integer code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }



}
