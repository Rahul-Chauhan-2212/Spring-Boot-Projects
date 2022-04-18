package boot.spring.swagger.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import boot.spring.swagger.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

}
