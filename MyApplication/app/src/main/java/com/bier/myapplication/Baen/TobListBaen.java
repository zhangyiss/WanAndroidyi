package com.bier.myapplication.Baen;

import java.io.Serializable;
import java.util.List;

public class TobListBaen implements Serializable {
    private static final long serialVersionUID = -7011607490037560627L;
    private List<TobBaen> articles;
    private  int  cid;
    private  String  name;




    public void setCid(int cid) {
        this.cid = cid;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setArticles(List<TobBaen> articles) {
        this.articles = articles;
    }

    public List<TobBaen> getArticles() {
        return articles;
    }

    public int getCid() {
        return cid;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "TobListBaen{" +
                "articles='" + articles + '\'' +
                ", cid=" + cid +
                ", name='" + name + '\'' +
                '}';
    }
}
