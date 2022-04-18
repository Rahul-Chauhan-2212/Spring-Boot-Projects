package boot.spring.swagger.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import boot.spring.swagger.entity.Book;
import boot.spring.swagger.repository.BookRepository;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepository;

	public void saveBook(Book book) {
		bookRepository.save(book);
	}

	public Book findBookById(int id) {
		return bookRepository.getById(Integer.valueOf(id));
	}

	public List<Book> deleteBookById(int id) {
		bookRepository.deleteById(Integer.valueOf(id));
		return bookRepository.findAll();
	}

}
