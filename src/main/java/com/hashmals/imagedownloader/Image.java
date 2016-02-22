package com.hashmals.imagedownloader;

import javax.swing.*;

/**
 * Created by HashmalS on 22.02.2016.
 * @author Sergey Soroka
 */
public class Image extends JList{
    private String name, width, height;

    public Image() {
    }

    public Image(String name, String width, String height) {
        this.name = name;
        this.width = width;
        this.height = height;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int getWidth() {
        return Integer.parseInt(width);
    }

    public void setWidth(String width) {
        this.width = width;
    }

    @Override
    public int getHeight() {
        return Integer.parseInt(height);
    }

    public void setHeight(String height) {
        this.height = height;
    }
}
