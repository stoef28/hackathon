package ch.zuehlke.fullstack.hackathon.controller.dto;

import ch.zuehlke.fullstack.hackathon.client.dto.InsightAddress;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserWithInsightData {

    private String code;
    private String firstName;
    private String lastName;
    private String pictureId;
    private InsightAddress insightAddress;
}
