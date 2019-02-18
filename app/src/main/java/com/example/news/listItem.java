package com.example.news;

public class listItem {

    private String head;
    private String desc;
    private String url;
    private String imageUrl;

    public listItem(String head, String desc,String url,String imageUrl) {
        this.head = head;
        this.desc = desc;
        this.imageUrl = imageUrl;
        this.url = url;
    }

    public String getHead() {
        return head;
    }

    public String getDesc() {
        return desc;
    }

    public String getUrl() {
        return url;
    }

    public String getImageUrl() {
        return imageUrl;
    }


}

