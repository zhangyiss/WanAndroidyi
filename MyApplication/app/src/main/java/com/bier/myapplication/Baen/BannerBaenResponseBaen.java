package com.bier.myapplication.Baen;

import java.io.Serializable;
import java.util.List;

public class BannerBaenResponseBaen implements Serializable {
    private static final long serialVersionUID = 7350779371566346100L;
    private List<BannerBaen> data;
    private  String  errorCode;
    private  String  errorMsg;

    @Override
    public String toString() {
        return "bannerBaenResponseBaen{" +
                "data=" + data +
                ", errorCode='" + errorCode + '\'' +
                ", errorMsg='" + errorMsg + '\'' +
                '}';
    }

    public void setData(List<BannerBaen> data) {
        this.data = data;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public List<BannerBaen> getData() {
        return data;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }
}
