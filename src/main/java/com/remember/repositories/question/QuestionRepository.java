package com.remember.repositories.question;

import com.remember.domains.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Long>, QuestionSearchRepository<Question, Long> {

}
