package com.imipgroup.hieuvt;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hieu.vutrong on 10/28/2014.
 */
public class BookDB {

    private static BookDB instance = new BookDB();
    public static BookDB getInstance() {
        return instance;
    }

    private List<BookVO> books;

    public BookDB() {
        setBooks(new ArrayList<BookVO>());
        for(int i = 0; i < 5; i++){
            BookVO book = new BookVO(i, "book#" + i, "author#" + i);
            getBooks().add(book);
        }
    }

    public BookVO getBookByName(String bookName){
        for (BookVO book: books){
            if (book.getBookName().equals(bookName)){
                return book;
            }
        }
        return null;
    }

    public BookVO getBook(int bookId){
        for (BookVO book: getBooks()){
            System.out.println(book.getBookId());
            if (book.getBookId() == bookId){
                return book;
            }
        }
        return null;
    }

    public BookVO createNewBook(BookVO bookVO){
        bookVO.setBookId(getBooks().size());
        getBooks().add(bookVO);
        return bookVO;
    }

    public List<BookVO> getBooks() {
        return books;
    }

    public void setBooks(List<BookVO> books) {
        this.books = books;
    }


}
