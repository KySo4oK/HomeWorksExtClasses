package extclasses.final_project_spring.repository;

import extclasses.final_project_spring.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.Set;

public interface BookRepository extends JpaRepository<Book, Long> {
    Set<Book> findFirst10ByAvailableIsTrue();

    Optional<Book> findByName(String name);

    @Query(nativeQuery = true, value =
            "select * from book  \n" +
                    "where available = true\n" +
                    "  and book_id in\n" +
                    "      (select book_id\n" +
                    "       from book_author \n" +
                    "       where author_id in (select author_id\n" +
                    "                           from author \n" +
                    "                           where name in (:authors)))\n" +
                    "  and book_id in (select book_id\n" +
                    "                  from book_tag \n" +
                    "                  where tag_id in (select tag_id \n" +
                    "                                   from tag  \n" +
                    "                                   where name in (:tags)))\n" +
                    "and name like :name\n")
    Set<Book> getBooksByFilter(@Param("name") String partOfName,
                               @Param("authors") String[] authors,
                               @Param("tags") String[] tags);
}
