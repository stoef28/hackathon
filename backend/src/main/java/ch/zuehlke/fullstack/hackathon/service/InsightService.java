package ch.zuehlke.fullstack.hackathon.service;

import ch.zuehlke.fullstack.hackathon.client.InsightClient;
import ch.zuehlke.fullstack.hackathon.client.dto.InsightAddress;
import ch.zuehlke.fullstack.hackathon.client.dto.InsightUserData;
import ch.zuehlke.fullstack.hackathon.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class InsightService {

    private final InsightClient insightClient;
    private List<InsightAddress> addresses;

    @Autowired
    public InsightService(InsightClient insightClient) {
        this.insightClient = insightClient;
        initAddressSimple();
    }

    public InsightUserData getInsightUserData(User user) {
        InsightUserData insightUserData = insightClient.getInsightUserData(user);
        if (insightUserData.getInsightAddress() == null) {
            insightUserData.setInsightAddress(generateRandomInsightAddress(insightUserData));
        }
        return insightUserData;
    }

    public List<InsightUserData> getAllInsightUsers(){
        List<InsightUserData> allInsightUsers = List.of(insightClient.getAllInsightUsers());
        for (InsightUserData insightUser : allInsightUsers) {
            insightUser.setInsightAddress(generateRandomInsightAddress(insightUser));
        }
        return allInsightUsers;
    }

    public String getInsightProfilePicture(InsightUserData insightUserData) {
        byte[] insightProfilePicture = insightClient.getInsightProfilePicture(insightUserData.getPictureId());
        return Base64.getEncoder().encodeToString(insightProfilePicture);
    }

    private InsightAddress generateRandomInsightAddress(InsightUserData insightUser) {
        int index =  Math.abs(insightUser.hashCode()) % 2;
        return addresses.get(index);
    }

    private void initAddresses() {
        addresses = Arrays.asList(
                new InsightAddress("Bahnhofstrasse 23", "8000", "Zürich", "CH"),
                new InsightAddress("Zürcherstrasse 39J", "8952", "Schlieren", "CH"),
                new InsightAddress("Europa-Strasse 27", "8152", "Opfikon", "CH"),
                new InsightAddress("Eugen-Huber-Strasse 4", "8048", "Zürich", "CH"),
                new InsightAddress("Heinrichstrasse 2", "8610", "Uster", "CH"),
                new InsightAddress("Obere-Farb-Weg 1", "8610", "Uster", "CH"),
                new InsightAddress("Espenstrasse 70", "8408", "Winterthur", "CH"),
                new InsightAddress("Löwenstrasse 6", "8400", "Winterthur", "CH"),
                new InsightAddress("St. Gallerstrasse 5", "8400", "Winterthur", "CH"),
                new InsightAddress("Hörnlistrasse 65", "8400", "Winterthur", "CH"));
    }

    private void initAddressSimple() {
        addresses = Arrays.asList(
                new InsightAddress("Bahnhofstrasse 23", "8000", "Zürich", "CH"),
                new InsightAddress("Hörnlistrasse 65", "8400", "Winterthur", "CH"));
    }

}
