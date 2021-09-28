package ch.zuehlke.fullstack.hackathon.service.mapper;

import ch.zuehlke.fullstack.hackathon.controller.dto.CategoryDto;
import ch.zuehlke.fullstack.hackathon.controller.dto.InterestDto;
import ch.zuehlke.fullstack.hackathon.model.Category;
import ch.zuehlke.fullstack.hackathon.model.Interest;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CategoryMapper {

    public static List<CategoryDto> toCategoryDto(List<Category> categoryList) {
        List<CategoryDto> categoryDtoList = new ArrayList<>();

        for (Category category : categoryList)
            categoryDtoList.add(toCategoryDto(category, category.getInterests().stream().collect(Collectors.toList())));

        return categoryDtoList;
    }

    public static CategoryDto toCategoryDto(Category category, List<Interest> interests) {
        return CategoryDto.builder()
                .id(category.getCategoryID())
                .name(category.getName())
                .interests(getInterestsDto(interests))
                .build();
    }

    private static List<InterestDto> getInterestsDto(List<Interest> interests){
        return interests
                .stream()
                .map(InterestMapper::toInterestDto)
                .collect(Collectors.toList());
    }
}
