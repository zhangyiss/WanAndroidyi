package com.bier.myapplication.Baen;

import android.util.Log;

import java.io.Serializable;

public class BannerBaen implements Serializable {
    private static final long serialVersionUID = -4486430455878754740L;
//   "desc": "Android高级进阶直播课免费学习",
//           "id": 23,
//           "imagePath": "https://wanandroid.com/blogimgs/0b712568-6203-4a03-b475-ff55e68d89e8.jpeg",
//           "isVisible": 1,
//           "order": 0,
//           "title": "Android高级进阶直播课免费学习",
//           "type": 0,
//           "url": "https://url.163.com/4bj"

    private  String  desc;
    private int id;
    private  String  imagePath;
    private int  isVisible;
    private long order;
    private  String title;
    private  int  type;
    private  String  url;

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public void setIsVisible(int isVisible) {
        this.isVisible = isVisible;
    }

    public void setOrder(long order) {
        this.order = order;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setType(int type) {
        this.type = type;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDesc() {
        return desc;
    }

    public int getId() {
        return id;
    }

    public String getImagePath() {
        return imagePath;
    }

    public int getIsVisible() {
        return isVisible;
    }

    public long getOrder() {
        return order;
    }

    public String getTitle() {
        return title;
    }

    public int getType() {
        return type;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public String toString() {
        return "bannerBaen{" +
                "desc='" + desc + '\'' +
                ", id=" + id +
                ", imagePath='" + imagePath + '\'' +
                ", isVisible=" + isVisible +
                ", order=" + order +
                ", title='" + title + '\'' +
                ", type=" + type +
                ", url='" + url + '\'' +
                '}';
    }
}
