package ch.zuehlke.fullstack.hackathon.controller.dto;

import lombok.Data;

@Data
public class AddInterestDto {
    private Long id;
    private String name;
    private Long categoryId;
}
