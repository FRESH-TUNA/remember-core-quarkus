package com.remember.dto;

import com.remember.domain.Question;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class QuestionDto extends AbstractDomainDto {
    private long id;
    private String name;
    private String platform;
    private String practiceStatus;

    public static QuestionDto of(Question question) {
        return new QuestionDto(
                question.getId(),
                question.getName(),
                question.getPlatform().name(),
                question.getPracticeStatus().name());
    }

    public static List<QuestionDto> of(List<Question> questions) {
        return questions.stream().map(QuestionDto::of).collect(Collectors.toList());
    }
}
