package com.remember.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Cacheable
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 255, nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    private Platform platform;

    @Enumerated(EnumType.STRING)
    private PracticeStatus practiceStatus;

//    @OneToMany(mappedBy = "question", fetch = FetchType.LAZY)
//    private List<QuestionAlgorithm> algorithms = new ArrayList<>();


    /*
     * user
     */
//    @Embedded
//    private UserIdentityField user;

    /*
     * methods
     */
//    public void partial_update(Question updated) {
//        if(updated.practiceStatus != null)
//            this.practiceStatus = updated.practiceStatus;
//    }
}
