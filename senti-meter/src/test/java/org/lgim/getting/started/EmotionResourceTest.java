package org.lgim.getting.started;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;
import org.lgim.model.Channel;
import org.lgim.model.ContactPreference;
import org.lgim.model.Emotion;
import org.lgim.rest.model.EmotionIncident;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class EmotionResourceTest {

    //URL for local testing : http://localhost:8080/emotions

    @Test
    public void testEmotionsListEndpoint() {
        given()
                .when().get("/emotions")
                .then()
                .statusCode(200);

/* Sample response
[{"cause":"Hackathon Going well","channel":"WEBSITE","comments":"New Incident","contactPreference":"No","emotion":"HAPPY","id":3,"time":"2020-11-20T06:21:07.177338","userName":""},
        {"cause":"Hackathon Going well","channel":"WEBSITE","comments":"New Incident","contactPreference":"No","emotion":"HAPPY","id":4,"time":"2020-11-20T06:27:24.501414","userName":""}]
 */

    }

    @Test
    public void testNewEmotionIncident() throws JsonProcessingException {

        //Sample Json Payload
        //{"emotion":"HAPPY","cause":"Hackathon Going well","userName":"","channel":"WEBSITE","comments":"New Incident","contactPreference":"No"}

        final EmotionIncident emotionIncident = new EmotionIncident();
        emotionIncident.setEmotion(Emotion.HAPPY);
        emotionIncident.setCause("Hackathon Going well");
        emotionIncident.setUserName("");
        emotionIncident.setComments("New Incident");
        emotionIncident.setChannel(Channel.WEBSITE);
        emotionIncident.setComments("New Incident");
        emotionIncident.setContactPreference(ContactPreference.No);

        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        final String emotionInstanceJson = mapper.writeValueAsString(emotionIncident);

        given()
                .when()
                .body(emotionInstanceJson)
                .contentType("application/json")
                .post("/emotions")
                .then()
                .statusCode(200)
                .body(is("Cheers"));
    }

}