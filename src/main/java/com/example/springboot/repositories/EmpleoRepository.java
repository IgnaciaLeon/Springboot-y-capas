package com.example.springboot.repositories;

import com.example.springboot.models.Empleo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpleoRepository extends JpaRepository<Empleo, Long> {
}
