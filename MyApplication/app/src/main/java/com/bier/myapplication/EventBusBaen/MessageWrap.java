package com.bier.myapplication.EventBusBaen;

import java.io.Serializable;

public class MessageWrap implements Serializable {
    private static final long serialVersionUID = 350093614862550582L;
    private  String Type;

    public void setType(String type) {
        Type = type;
    }

    public String getType() {
        return Type;
    }

    public  MessageWrap(String Type){
        this.Type=Type;

    }

    @Override
    public String toString() {
        return "MessageWrap{" +
                "Type='" + Type + '\'' +
                '}';
    }
}
