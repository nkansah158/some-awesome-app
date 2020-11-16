package com.example.n.myapplication.uis;

public class ExampleItem {
    private int imageResource;
    private String text;
    public ExampleItem(int imageResource, String text){
        this.imageResource=imageResource;
        this.text=text;
    }

    public int getImageResource() {
        return imageResource;
    }

    public String getText() {
        return text;
    }
}

