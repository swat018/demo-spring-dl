package com.swat018.demospringdl;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/*@Repository
public class BookRepository {
}*/

public interface BookRepository extends JpaRepository<Book, Integer> {
}