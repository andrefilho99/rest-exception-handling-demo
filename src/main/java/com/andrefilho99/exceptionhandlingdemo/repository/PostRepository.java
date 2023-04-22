package com.andrefilho99.exceptionhandlingdemo.repository;

import com.andrefilho99.exceptionhandlingdemo.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
}
