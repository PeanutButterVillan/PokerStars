import entities.Fixture;
import entities.NotFound;
import org.apache.http.client.methods.HttpGet;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.Assert.assertEquals;

public class BodyTestWithJackson extends BaseClass {

    @Test
    public void returnsCorrectLogin() throws IOException {

        HttpGet get = new HttpGet(BASE_ENDPOINT + "/fixture/{1}");

        response = client.execute(get);

        Fixture fixture = ResponseUtils.unmarshallGeneric(response, Fixture.class);

    }

    @Test
    public void returnsCountOfIds() throws IOException {

        HttpGet get = new HttpGet(BASE_ENDPOINT + "/fixture/1");

        response = client.execute(get);

        Fixture fixture = ResponseUtils.unmarshallGeneric(response, Fixture.class);

        assertEquals(fixture.getFixtureId(), 1);
    }

    @Test
    public void notFoundMessageIsCorrect() throws IOException {

        HttpGet get = new HttpGet(BASE_ENDPOINT + "/nonexistingendpoint");

        response = client.execute(get);

        NotFound notFoundMessage = ResponseUtils.unmarshallGeneric(response, NotFound.class);

        assertEquals(notFoundMessage.getMessage(), "Not Found");
    }

}
