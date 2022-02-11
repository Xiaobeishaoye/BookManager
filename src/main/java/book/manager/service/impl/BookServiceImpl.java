package book.manager.service.impl;

import book.manager.entity.Book;
import book.manager.entity.Borrow;
import book.manager.mapper.BookMapper;
import book.manager.mapper.UserMapper;
import book.manager.service.BookService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {

    @Resource
    BookMapper mapper;
    @Resource
    UserMapper userMapper;

    @Override
    public List<Book> getAllBook(){
        return mapper.allBook();
    }

    @Override
    public List<Book> getAllBookwithOutBorrow(){
        List<Book> books= mapper.allBook();
        List<Integer> borrows=mapper.borrowList()
                .stream()
                .map(Borrow::getBid)
                .collect(Collectors.toList());
        return books.stream()
                .filter(book -> !borrows.contains(book.getBid()))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteBook(int bid) {
        mapper.deleteBook(bid);
    }

    @Override
    public void addBook(String title, String desc, double price) {
        mapper.addBook(title, desc, price);
    }

    @Override
    public void borrowBook(int bid,int id) {
        Integer sid= userMapper.getSidUserId(id);
        if(sid==null)return;
        mapper.addBorrow(bid,sid);
    }
}
