package com.example.myapplication;

public class itemvo {
    String typestr;
    String titlestr;
    String contentstr;

    public itemvo(String typestr, String titlestr, String contentstr) {
        this.typestr = typestr;
        this.titlestr = titlestr;
        this.contentstr = contentstr;
    }

    public String getTypestr() {
        return typestr;
    }

    public void setTypestr(String typestr) {
        this.typestr = typestr;
    }

    public String getTitlestr() {
        return titlestr;
    }

    public void setTitlestr(String titlestr) {
        this.titlestr = titlestr;
    }

    public String getContentstr() {
        return contentstr;
    }

    public void setContentstr(String contentstr) {
        this.contentstr = contentstr;
    }
}
