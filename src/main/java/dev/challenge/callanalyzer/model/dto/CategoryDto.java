package dev.challenge.callanalyzer.model.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Builder
@Getter
@Setter
public class CategoryDto {
    private long id;
    private String title;
    private List<String> points;
}
