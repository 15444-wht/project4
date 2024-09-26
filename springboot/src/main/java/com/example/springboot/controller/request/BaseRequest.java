package com.example.springboot.controller.request;

public class BaseRequest {
    private Integer pageNum = 1;
    private Integer pagSize = 12;
    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPagSize() {
        return pagSize;
    }

    public void setPagSize(Integer pagSize) {
        this.pagSize = pagSize;
    }
}

