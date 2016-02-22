package com.hashmals.imagedownloader;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.swing.*;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

/**
 * Created by HashmalS on 21.02.2016.
 * @author Sergey Soroka
 */
public class LinkExtractor {
    private Image images = new Image();
    private static Elements media;

    public LinkExtractor() {}

    public LinkExtractor(String url) throws IOException {

        Document doc = Jsoup.connect(url).get();
        media = doc.select("a[href$=.jpg]");

        System.out.println("\nFound " + media.size() + " picture(s)");
    }

    public JList getList() {
        for (Element src : media) {
            images.add(new Image(trim(src.attr("abs:href")), src.attr("width"), src.attr("height")));
            //save(src.attr("abs:href"), trim(src.attr("abs:href")));
        }
        return images;
    }

    private static void save(String source, String name) throws IOException {
        String folder = createFolder(trim(media.first().attr("abs:href")));
        URL url = new URL(source);
        InputStream in = new BufferedInputStream(url.openStream());
        OutputStream out = new BufferedOutputStream(new FileOutputStream(folder + "\\" + name + ".jpg"));
        for (int i; (i = in.read()) != -1;) {
            out.write(i);
        }
        in.close();
        out.close();
    }

    private static String createFolder(String thread) {
        String destination = System.getProperty("user.home") + "\\Pictures\\4chan downloader\\" + thread;
        File file = new File(destination);
        if(!file.exists()) {
            if (file.mkdirs()) {
                System.out.println("Directory is created!");
            } else {
                System.out.println("Failed to create directory!");
            }
        }
        return destination;
    }

    private static String trim(String s) {
        return s.substring(20, 33);
    }
}
