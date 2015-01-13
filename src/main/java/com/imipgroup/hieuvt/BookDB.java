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
            if (book.getBookId() == bookId){
                return book;
            }
        }
        return null;
    }

    public BookVO createNewBook(BookVO bookVO){
        int maxBookId = Integer.MIN_VALUE;
        for (BookVO book: getBooks()){
            if (maxBookId < book.getBookId()){
                maxBookId = book.getBookId();
            }
        }
        bookVO.setBookId(maxBookId + 1);
        getBooks().add(bookVO);
        return bookVO;
    }

    public BookVO updateBookInfo(BookVO bookVO){
        for (BookVO book: getBooks()){
            if (book.getBookId() == bookVO.getBookId()){
                book.setAuthor(bookVO.getAuthor());
                book.setBookName(bookVO.getBookName());
                return book;
            }
        }
        return null;
    }

    public List<BookVO> removeBook(int bookId){
        for (BookVO bookVO:getBooks()){
            if (bookVO.getBookId() == bookId){
                getBooks().remove(bookVO);
            }
        }
        return getBooks();
    }

    public List<BookVO> getBooks() {
        return books;
    }

    public void setBooks(List<BookVO> books) {
        this.books = books;
    }


}
