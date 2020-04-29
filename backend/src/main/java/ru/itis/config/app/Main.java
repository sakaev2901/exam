package ru.itis.config.app;

import java.util.Date;

public class Main {

    public static void main(String[] args) {
        Date date = new Date();
        String text = "ksh hjdfghj dhfgjh djfhgjdhf gjhdfjgh jdfhgj hdjghd jhjfhg jhdjgh djfhg jdhfgj dh" + date.toString();
        System.out.println(text);
        Integer hash = text.hashCode();
        System.out.println(hash);
        String slug = "";
        while (hash > 0) {
            int charCode = 'a' + hash % 10;
            slug += (char)charCode;
            hash /= 10;
        }
        System.out.println(slug);
    }
}
