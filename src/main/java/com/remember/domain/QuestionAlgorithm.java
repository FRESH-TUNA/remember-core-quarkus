package com.remember.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Cacheable
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class QuestionAlgorithm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="question_id", foreignKey = @ForeignKey(name = "none"))
    private Question question;

    @Enumerated(EnumType.STRING)
    private Algorithm algorithm;
}
