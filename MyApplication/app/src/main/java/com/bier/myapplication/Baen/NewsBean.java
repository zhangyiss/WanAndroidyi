package com.bier.myapplication.Baen;

import java.io.Serializable;
import java.util.List;

public class NewsBean implements Serializable {
    private static final long serialVersionUID = 8970879467506365414L;
//   "data": [{
//        "children": [],
//        "courseId": 13,
//                "id": 408,
//                "name": "鸿洋",
//                "order": 190000,
//                "parentChapterId": 407,
//                "userControlSetTop": false,
//                "visible": 1



    private List<String> children;
    private int  courseId;
    private int id;
    private  String name;
    private  long order;
    private  int parentChapterId;
    private boolean userControlSetTop;
    private  int  visible;

    @Override
    public String toString() {
        return "NewsBean{" +
                "children=" + children +
                ", courseId=" + courseId +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", order='" + order + '\'' +
                ", parentChapterId=" + parentChapterId +
                ", userControlSetTop='" + userControlSetTop + '\'' +
                ", visible=" + visible +
                '}';
    }

    public void setChildren(List<String> children) {
        this.children = children;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOrder(long order) {
        this.order = order;
    }

    public void setParentChapterId(int parentChapterId) {
        this.parentChapterId = parentChapterId;
    }

    public void setUserControlSetTop(boolean userControlSetTop) {
        this.userControlSetTop = userControlSetTop;
    }

    public void setVisible(int visible) {
        this.visible = visible;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public List<String> getChildren() {
        return children;
    }

    public int getCourseId() {
        return courseId;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public long getOrder() {
        return order;
    }

    public int getParentChapterId() {
        return parentChapterId;
    }

    public boolean isUserControlSetTop() {
        return userControlSetTop;
    }

    public int getVisible() {
        return visible;
    }
}
