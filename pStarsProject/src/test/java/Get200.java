import org.apache.http.client.methods.HttpGet;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.Assert.assertEquals;

public class Get200 extends BaseClass{

    @Test
    public void fixturesReturns200() throws IOException {

        HttpGet get = new HttpGet(BASE_ENDPOINT + "/fixtures");

        response = client.execute(get);

        int actualStatus = response.getStatusLine().getStatusCode();

        assertEquals(actualStatus, 200);
    }

    @Test
    public void totalFixturesReturns200() throws IOException {

        HttpGet get = new HttpGet(BASE_ENDPOINT + "/fixtures/fixtureId/fixtureStatus/displayed");

        response = client.execute(get);

        int actualStatus = response.getStatusLine().getStatusCode();

        assertEquals(actualStatus, 200);
    }
}
