package com.javacodes.springboot.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javacodes.springboot.model.Tag;

@Repository
public interface TagRepository extends JpaRepository<Tag, Long>{

}
