package ch.zuehlke.fullstack.hackathon.service.mapper;

import ch.zuehlke.fullstack.hackathon.client.dto.InsightUserData;
import ch.zuehlke.fullstack.hackathon.controller.dto.CategoryDto;
import ch.zuehlke.fullstack.hackathon.controller.dto.UserWithInsightData;
import ch.zuehlke.fullstack.hackathon.model.Category;
import ch.zuehlke.fullstack.hackathon.model.Interest;
import ch.zuehlke.fullstack.hackathon.model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserWithInsightDataMapper {

    public static UserWithInsightData mapToUserWithInsightData(InsightUserData insightUserData, User user){
        return UserWithInsightData.builder()
                .code(user.getCode())
                .firstName(insightUserData.getFirstName())
                .lastName(insightUserData.getLastName())
                .insightAddress(insightUserData.getInsightAddress())
                .pictureId(insightUserData.getPictureId())
                .categories(getListOfCategoryDtos(user))
                .build();
    }

    private static List<CategoryDto> getListOfCategoryDtos(User user){
        Map<Category, List<Interest>> categoryMap = buildCategoryMap(user);
        List<CategoryDto> categoryDtos = new ArrayList<>();
        for (Category category : categoryMap.keySet()) {
            categoryDtos.add(CategoryMapper.toCategoryDto(category, categoryMap.get(category))) ;
        }
        return categoryDtos;
    }

    private static Map<Category, List<Interest>> buildCategoryMap(User user) {
        Map<Category, List<Interest>> categoryMap = new HashMap<>();
        for (Interest interest : user.getInterests()) {
            if (categoryMap.get(interest.getCategory()) == null) {
                categoryMap.put(interest.getCategory(), List.of(interest));
            } else {
                List<Interest> interests = categoryMap.get(interest.getCategory());
                interests.add(interest);
                categoryMap.put(interest.getCategory(), interests);
            }
        }
        return categoryMap;
    }
}
