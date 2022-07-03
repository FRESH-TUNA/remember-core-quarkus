package com.remember.repositories;

import com.remember.domains.Algorithm;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlgorithmsRepository extends JpaRepository<Algorithm, Long> {
}
