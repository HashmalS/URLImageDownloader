package com.hashmals.imagedownloader;

import org.jsoup.Jsoup;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by HashmalS on 21.02.2016.
 * @author Sergey Soroka
 */
public class LinkExtractor {

    public static void main(String[] args) throws IOException {
        Validate.isTrue(args.length == 1, "usage: supply url to fetch");
        String url = args[0];
        print("Fetching %s...", url);

        Document doc = Jsoup.connect(url).get();
        Elements media = doc.select("a[href$=.jpg]");
        String folder = createFolder(trim(media.first().attr("abs:href")));

        System.out.println("\nFound " + media.size() + " picture(s)");
        for (Element src : media) {
            print("<%s> (%s)", src.attr("abs:href"), trim(src.attr("abs:href")));
            save(src.attr("abs:href"), trim(src.attr("abs:href")), folder);
        }
    }

    private static void print(String msg, Object... args) {
        System.out.println(String.format(msg, args));
    }

    private static void save(String source, String name, String folder) throws MalformedURLException, IOException, FileNotFoundException {
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
