package com.bier.myapplication.Baen;

import java.io.Serializable;
import java.util.List;

public class TobBaen implements Serializable {
    private static final long serialVersionUID = -4184056678750534397L;
//     "apkLink": "",
//             "author": "小编",
//             "chapterId": 272,
//             "chapterName": "常用网站",
//             "collect": false,
//             "courseId": 13,
//             "desc": "",
//             "envelopePic": "",
//             "fresh": false,
//             "id": 1848,
//             "link": "https://developers.google.cn/",
//             "niceDate": "2018-01-07",
//             "origin": "",
//             "prefix": "",
//             "projectLink": "",
//             "publishTime": 1515322795000,
//             "superChapterId": 0,
//             "superChapterName": "",
//             "tags": [],
//             "title": "Google开发者",
//             "type": 0,
//             "userId": -1,
//             "visible": 0,
//             "zan": 0


    private String author;
    private  String  chapterId;
    private  String  chapterName;
    private  boolean  collect;
    private  int   courseId;
    private  String  desc;
    private  String envelopePic;
    private  boolean fresh;
    private  int  id;
    private  String link;
    private String origin;
    private String  prefix;
    private String  projectLink;
    private long   publishTime;
    private int  superChapterId;
    private String  superChapterName;
    private List<String> tags;
    private  String title;
    private  int  userId;
    private  int  visible;
    private  int  zan;
    private int type;

    @Override
    public String toString() {
        return "TobBaen{" +
                "author='" + author + '\'' +
                ", chapterId='" + chapterId + '\'' +
                ", chapterName='" + chapterName + '\'' +
                ", collect=" + collect +
                ", courseId=" + courseId +
                ", desc='" + desc + '\'' +
                ", envelopePic='" + envelopePic + '\'' +
                ", fresh=" + fresh +
                ", id=" + id +
                ", link='" + link + '\'' +
                ", origin='" + origin + '\'' +
                ", prefix='" + prefix + '\'' +
                ", projectLink='" + projectLink + '\'' +
                ", publishTime=" + publishTime +
                ", superChapterId=" + superChapterId +
                ", superChapterName='" + superChapterName + '\'' +
                ", tags=" + tags +
                ", title='" + title + '\'' +
                ", userId=" + userId +
                ", visible=" + visible +
                ", zan=" + zan +
                ", type=" + type +
                '}';
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setChapterId(String chapterId) {
        this.chapterId = chapterId;
    }

    public void setChapterName(String chapterName) {
        this.chapterName = chapterName;
    }

    public void setCollect(boolean collect) {
        this.collect = collect;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setEnvelopePic(String envelopePic) {
        this.envelopePic = envelopePic;
    }

    public void setFresh(boolean fresh) {
        this.fresh = fresh;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public void setProjectLink(String projectLink) {
        this.projectLink = projectLink;
    }

    public void setPublishTime(long publishTime) {
        this.publishTime = publishTime;
    }

    public void setSuperChapterId(int superChapterId) {
        this.superChapterId = superChapterId;
    }

    public void setSuperChapterName(String superChapterName) {
        this.superChapterName = superChapterName;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setVisible(int visible) {
        this.visible = visible;
    }

    public void setZan(int zan) {
        this.zan = zan;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getAuthor() {
        return author;
    }

    public String getChapterId() {
        return chapterId;
    }

    public String getChapterName() {
        return chapterName;
    }

    public boolean isCollect() {
        return collect;
    }

    public int getCourseId() {
        return courseId;
    }

    public String getDesc() {
        return desc;
    }

    public String getEnvelopePic() {
        return envelopePic;
    }

    public boolean isFresh() {
        return fresh;
    }

    public int getId() {
        return id;
    }

    public String getLink() {
        return link;
    }

    public String getOrigin() {
        return origin;
    }

    public String getPrefix() {
        return prefix;
    }

    public String getProjectLink() {
        return projectLink;
    }

    public long getPublishTime() {
        return publishTime;
    }

    public int getSuperChapterId() {
        return superChapterId;
    }

    public String getSuperChapterName() {
        return superChapterName;
    }

    public List<String> getTags() {
        return tags;
    }

    public String getTitle() {
        return title;
    }

    public int getUserId() {
        return userId;
    }

    public int getVisible() {
        return visible;
    }

    public int getZan() {
        return zan;
    }

    public int getType() {
        return type;
    }
}
