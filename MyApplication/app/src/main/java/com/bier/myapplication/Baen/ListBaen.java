package com.bier.myapplication.Baen;

import java.io.Serializable;

public class ListBaen implements Serializable {
    private static final long serialVersionUID = -1243479399699889726L;
//    "id": 6,
//            "link": "",
//            "name": "面试",
//            "order": 1,
//            "visible": 1


    private int id;
    private String name;
    private  String link;
    private  long order;
    private  int visible;


    @Override
    public String toString() {
        return "ListBaen{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", link='" + link + '\'' +
                ", order=" + order +
                ", visible=" + visible +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public void setOrder(long order) {
        this.order = order;
    }

    public void setVisible(int visible) {
        this.visible = visible;
    }

    public int getId() {
        return id;
    }

    public String getLink() {
        return link;
    }

    public long getOrder() {
        return order;
    }

    public int getVisible() {
        return visible;
    }
}
