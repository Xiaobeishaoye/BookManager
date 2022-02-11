package book.manager.service;

import book.manager.entity.Book;

import java.util.List;

public interface BookService {
    List<Book> getAllBook();
    List<Book> getAllBookwithOutBorrow();
    List<Book> getAllBorrowedBookById(int id);
    void deleteBook(int bid);
    void addBook(String title,String desc,double price);
    void borrowBook(int bid,int id);
}
