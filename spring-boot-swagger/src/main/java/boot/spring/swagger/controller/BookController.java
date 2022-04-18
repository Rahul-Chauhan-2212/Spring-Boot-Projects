package boot.spring.swagger.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import boot.spring.swagger.entity.Book;
import boot.spring.swagger.service.BookService;
import io.swagger.annotations.Api;

@RestController
@RequestMapping("/bookapi")
public class BookController {

	@Autowired
	private BookService bookService;

	@PostMapping("/book/save")
	private String saveBook(@RequestBody Book book) {
		bookService.saveBook(book);
		return "Book Saved with book id--> " + book.getId();
	}

	@GetMapping("/book/{id}")
	private Book findBookById(@PathVariable int id) {
		return bookService.findBookById(id);
	}

	@DeleteMapping("/book/{id}")
	private List<Book> deleteBookById(@PathVariable int id) {
		return bookService.deleteBookById(id);
	}

}
