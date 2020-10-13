package com.example.robi10minschool;

import android.widget.ImageView;

public class SubItemClass {
    private String subItemTitle;
    private String subItemSubTitle;
    private int icon;


    public SubItemClass(String subItemTitle, String subItemSubTitle, int icon){
        this.subItemTitle = subItemTitle;
        this.subItemSubTitle = subItemSubTitle;
        this.icon = icon;
    }

    public String getSubItemTitle() {
        return subItemTitle;
    }

    public void setSubItemTitle(String subItemTitle) {
        this.subItemTitle = subItemTitle;
    }

    public String getSubItemSubTitle() {
        return subItemSubTitle;
    }

    public void setSubItemSubTitle(String subItemSubTitle) {
        this.subItemSubTitle = subItemSubTitle;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

}
