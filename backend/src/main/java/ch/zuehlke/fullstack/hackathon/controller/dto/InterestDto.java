package ch.zuehlke.fullstack.hackathon.controller.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class InterestDto {
    private Long id;
    private String name;
}
