package com.imipgroup.hieuvt;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hieu.vutrong on 10/28/2014.
 */
public class BookDB {
    private static BookDB ourInstance = new BookDB();

    public static BookDB getInstance() {
        return ourInstance;
    }

    private List<BookVO> books;

    private BookDB() {
        setBooks(new ArrayList<BookVO>());
        for(int i = 0; i < 5; i++){
            BookVO book = new BookVO();
            book.setBookId(i);
            book.setBookName("book #" + i);
            book.setAuthor("author #" + i);
            getBooks().add(book);
        }
    }

    public BookVO getBook(String bookName){
        for (BookVO book: books){
            if (book.getBookName() == bookName){
                return book;
            }
        }
        return null;
    }

    public List<BookVO> getBooks() {
        return books;
    }

    public void setBooks(List<BookVO> books) {
        this.books = books;
    }


}
