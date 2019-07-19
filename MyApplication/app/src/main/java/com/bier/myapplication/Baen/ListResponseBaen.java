package com.bier.myapplication.Baen;

import java.io.Serializable;
import java.util.List;

public class ListResponseBaen implements Serializable {
    private static final long serialVersionUID = 3053225057526307979L;

    public void setData(List<ListBaen> data) {
        this.data = data;
    }

    public List<ListBaen> getData() {
        return data;
    }

    private List<ListBaen> data;
    private  String  errorCode;
    private  String  errorMsg;

    @Override
    public String toString() {
        return "ListResponseBaen{" +
                "data=" + data +
                ", errorCode='" + errorCode + '\'' +
                ", errorMsg='" + errorMsg + '\'' +
                '}';
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }



    public String getErrorCode() {
        return errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }
}
