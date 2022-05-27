package jp.te4a.spring.boot.myapp12;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<BookBean, Integer>{
	@Query("SELECT X FROM BookBean X ORDER BY X.title")
	  List<BookBean> findAllOrderByTitle();

}

