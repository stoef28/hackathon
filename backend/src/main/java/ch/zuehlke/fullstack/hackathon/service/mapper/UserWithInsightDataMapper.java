package ch.zuehlke.fullstack.hackathon.service.mapper;

import ch.zuehlke.fullstack.hackathon.client.dto.InsightUserData;
import ch.zuehlke.fullstack.hackathon.controller.dto.UserWithInsightData;
import ch.zuehlke.fullstack.hackathon.model.User;

public class UserWithInsightDataMapper {

    public static UserWithInsightData mapToUserWithInsightData(InsightUserData insightUserData, User user){
        return UserWithInsightData.builder()
                .code(user.getCode())
                .firstName(insightUserData.getFirstName())
                .lastName(insightUserData.getLastName())
                .insightAddress(insightUserData.getInsightAddress())
                .pictureId(insightUserData.getPictureId())
                .build();
    }
}
