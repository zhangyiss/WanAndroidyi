package com.bier.myapplication.Baen;

import java.io.Serializable;
import java.util.List;
public class ResponseBaen implements Serializable {
    private static final long serialVersionUID = -6758293985923184244L;
    private List<NewsBean> data;
    private String errorCode;
    private  String errorMsg;

    @Override
    public String toString() {
        return "ResponseBaen{" +
                "data=" + data +
                ", errorCode='" + errorCode + '\'' +
                ", errorMsg='" + errorMsg + '\'' +
                '}';
    }

    public void setData(List<NewsBean> data) {
        this.data = data;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public List<NewsBean> getData() {
        return data;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }
}
