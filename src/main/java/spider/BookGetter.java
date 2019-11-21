package spider;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;

class BookGetter {

    private String url;
    private String destroyURL;
    private String title;
    private String content;
    private String nextChapter;
    private String filename = "./xxx.txt";
    /*
    构造函数传参
     */
    BookGetter(String url, String title, String content, String nextChapter,String destroyURL) throws FileNotFoundException {
        this.url = url;
        this.title = title;
        this.content = content;
        this.nextChapter = nextChapter;
        this.destroyURL = destroyURL;
    }
    BookGetter(String url) throws FileNotFoundException {
        this.url=url;
    }
    /*
    写入文件的Buffer对象，传入存储小说的目标文件名
     */
    BufferedWriter bw = new BufferedWriter(
            new OutputStreamWriter(
                    new FileOutputStream(filename)));
    /*
    爬取内容并且存入文件的方法
     */
    void crawl() throws Exception {

        Elements Newtitle = getTitle();
        Elements Newcontent= getContent();

//        System.out.println(title);
        bw.write(Newtitle.text());
        for (Element p : Newcontent){
            bw.write(p.text());
//            System.out.println(p.text());
            bw.newLine();
            bw.newLine();
            bw.flush();
        }
        getNextChapter();
    }
    /*
    获取小说章节名
     */
    private Elements getTitle() throws IOException {
        Elements document = Jsoup.connect(url).get()
                .select(title);
        return document;
    }
    /*
    获取小说内容
     */
    private Elements getContent() throws IOException {
        Elements document = Jsoup.connect(url).get()
                .getElementsByTag(content);
        return document;
    }
    /*
    获取小说下一章的URL
     */
    private void getNextChapter() throws Exception {
        Elements document = Jsoup.connect(url).get()
                .select(nextChapter);
        Object newurl = document.attr("href");
        url = newurl.toString();
        System.out.println(url);
        if (url.equals(destroyURL) ||url.length()==0) {
            System.out.println("we got it!");
        }else{
            crawl();
        }
    }

    void close() throws IOException {
        bw.close();
    }
}
