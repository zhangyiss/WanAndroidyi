package com.bier.myapplication.Baen;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public class TobResponseBaen implements Serializable {
    private static final long serialVersionUID = 7268341086090126480L;
    private List<TobListBaen> data;
    private int errorCode;
    private String errorMsg;

    @Override
    public String toString() {
        return "TobResponseBaen{" +
                "data=" + data +
                ", errorCode=" + errorCode +
                ", errorMsg='" + errorMsg + '\'' +
                '}';
    }

    public void setData(List<TobListBaen> data) {
        this.data = data;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public List<TobListBaen> getData() {
        return data;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }
}
