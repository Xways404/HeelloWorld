package com.hspedu.c14homework;

import java.util.ArrayList;

/**
 * @author Li Mi~
 * @version 1.0
 */
public class HomeWork01 {
    public static void main(String[] args) {

        ArrayList arrayList = new ArrayList();
        arrayList.add(new News("新型コロナの患者数が千万超え、数百万のヒンドゥー教徒が川で\"聖浴\"するのが混乱を惹き及ぼす"));
        arrayList.add(new News("男性が二ヶ月前に買った弁当をずっと食べ忘れて、今からまだ食べれるかを確認しに行った"));

        int size = arrayList.size();
        for (int i = size - 1; i >= 0; i--) {
//            System.out.println(arrayList.get(i));
            News news = (News)arrayList.get(i);
            System.out.println(processTittle(news.getTitle()));
        }


    }
    public static String processTittle(String title) {

        if(title == null) {
            return "";
        }
        if(title.length() > 15) {
            return title.substring(0, 15) + "...";
        } else {
            return title;
        }
    }
}
class News {
    private String title;
    private String content;

    public News(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "News{" +
                "title='" + title + '\'' +
                '}';
    }
}
