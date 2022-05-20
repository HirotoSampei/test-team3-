package jp.te4a.spring.boot.myapp6;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;
    public BookBean save(BookBean bookBean) {
        return bookRepository.save(bookBean);
    }

    public List<BookBean> findAll() {
        return bookRepository.findAll();
    }
}
