package ch.zuehlke.fullstack.hackathon.client.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class InsightUserData  {
    @JsonProperty("FirstName")
    private String firstName;
    @JsonProperty("LastName")
    private String lastName;
    @JsonProperty("PictureId")
    private String pictureId;
    @JsonProperty("PrivateAddress")
    private InsightAddress insightAddress;
}
