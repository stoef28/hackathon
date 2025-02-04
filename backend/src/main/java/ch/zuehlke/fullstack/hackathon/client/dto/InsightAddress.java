package ch.zuehlke.fullstack.hackathon.client.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class InsightAddress {
    @JsonProperty("Street")
    private String street;
    @JsonProperty("Zip")
    private String zip;
    @JsonProperty("City")
    private String city;
    @JsonProperty("Country")
    private String country;
}
