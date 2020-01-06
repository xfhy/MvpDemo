package com.xfhy.mvpdemo.mvp.model.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * @author : xfhy
 * Create time : 2020/1/5 16:38
 * Description :
 */
public class Today {

    public boolean error;
    public ResultsBean results;
    public List<String> category;

    public static class ResultsBean {
        public List<Content> Android;
        public List<Content> App;
        public List<Content> iOS;
        @SerializedName(value = "\\u4f11\\u606f\\u89c6\\u9891")
        public List<Content> restVideo;
        @SerializedName(value = "\\u524d\\u7aef")
        public List<Content> frontEnd;
        @SerializedName(value = "\\u62d3\\u5c55\\u8d44\\u6e90")
        public List<Content> expandResources;
        @SerializedName(value = "\\u778e\\u63a8\\u8350")
        public List<Content> blindlyRecommend;
        @SerializedName(value = "\\u798f\\u5229")
        public List<Content> welfare;

        public static class Content {

            public String _id;
            public String createdAt;
            public String desc;
            public String publishedAt;
            public String source;
            public String type;
            public String url;
            public boolean used;
            public String who;
            public List<String> images;

            @Override
            public String toString() {
                return "Content{" +
                        "_id='" + _id + '\'' +
                        ", createdAt='" + createdAt + '\'' +
                        ", desc='" + desc + '\'' +
                        ", publishedAt='" + publishedAt + '\'' +
                        ", source='" + source + '\'' +
                        ", type='" + type + '\'' +
                        ", url='" + url + '\'' +
                        ", used=" + used +
                        ", who='" + who + '\'' +
                        ", images=" + images +
                        '}';
            }
        }

        @Override
        public String toString() {
            return "ResultsBean{" +
                    "Android=" + Android +
                    ", App=" + App +
                    ", iOS=" + iOS +
                    ", restVideo=" + restVideo +
                    ", frontEnd=" + frontEnd +
                    ", expandResources=" + expandResources +
                    ", blindlyRecommend=" + blindlyRecommend +
                    ", welfare=" + welfare +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "Today{" +
                "error=" + error +
                ", results=" + results +
                ", category=" + category +
                '}';
    }
}
