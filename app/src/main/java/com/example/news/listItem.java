package com.example.news;

public class listItem {

    private String head;
    private String date;
    private String url;
    private String imageUrl;
    private String source;

    public listItem(String head, String date,String url,String imageUrl,String source) {
        this.head = head;
        this.date = date;
        this.imageUrl = imageUrl;
        this.url = url;
        this.source=source;
    }

    public String getHead() {
        return head;
    }

    public String getDate() {
        return date;
    }

    public String getUrl() {
        return url;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getSource() {
        return source;
    }
}

