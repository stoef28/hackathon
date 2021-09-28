package ch.zuehlke.fullstack.hackathon.service.mapper;

import ch.zuehlke.fullstack.hackathon.controller.dto.InterestDto;
import ch.zuehlke.fullstack.hackathon.model.Interest;

public class InterestMapper {
    public static InterestDto toInterestDto(Interest interest) {
        return InterestDto.builder()
                .id(interest.getInterestID())
                .name(interest.getName())
                .build();
    }
}
