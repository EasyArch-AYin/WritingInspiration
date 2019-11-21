package spider;

import java.io.IOException;

class BookGetterHelper {
    static void getBook() throws Exception {
        BookGetter bookGetter = new BookGetter(
                "http://book.zongheng.com/chapter/389811/6495763.html",
                ".title_txtbox",
                "p",
                "a.nextchapter",
                "javascript:void(0)"
        );
        bookGetter.crawl();
        bookGetter.close();
    }
}
