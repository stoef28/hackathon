package ch.zuehlke.fullstack.hackathon.controller.dto;

import ch.zuehlke.fullstack.hackathon.client.dto.InsightAddress;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@Builder
@EqualsAndHashCode
public class UserWithInsightData {

    private String code;
    private String firstName;
    private String lastName;
    private String pictureId;
    private InsightAddress insightAddress;
    private List<CategoryDto> categories;
}
