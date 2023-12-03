package com.example.demo.repository;

import com.example.demo.model.Subpost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubpostRepository extends JpaRepository<Subpost, Long> {
}
