package org.com.estudos.hexagonal.adapter.persistence.repository.book;

import org.com.estudos.hexagonal.adapter.persistence.entity.BookEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<BookEntity, Long> {
    Optional<BookEntity> findByTitle(String title);

    @Query("SELECT bk FROM BookEntity bk WHERE (:title IS NULL OR lower(bk.title) LIKE concat('%', lower(:title), '%'))")
    Page<BookEntity> findAllFiltering(Pageable pageable, @Param("title") String title);
}
