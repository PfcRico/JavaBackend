package com.backend.javabackend.repository;

import com.backend.javabackend.entity.Fanfic;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FanficRepository extends JpaRepository<Fanfic, Integer> {
    Fanfic findByAuthor(String name);

    List<Fanfic> findAllByAuthor(String name);

    List<Fanfic> findAllByGenre(String genre);

    List<Fanfic> findAllByFandom(String fandom);
}
