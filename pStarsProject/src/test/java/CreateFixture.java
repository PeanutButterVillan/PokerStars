import com.google.gson.Gson;

import entities.*;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpPost;

import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;

import org.apache.http.impl.client.HttpClients;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class CreateFixture extends BaseClass {

// Create New Fixture
    @Test
    public void whenPostJsonUsingHttpClient_thenCorrect()
            throws ClientProtocolException, IOException {
        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost("http://localhost:3000/fixture");

        Fixture fix = new Fixture();
        fix.setFixtureId(5);

        fix.fixtureStatus = new FixtureStatus();
        fix.fixtureStatus.displayed = true;
        fix.fixtureStatus.suspended = false;
        fix.footballFullState = new FootballFullState();
        fix.footballFullState.homeTeam = "Aston Villa";
        fix.footballFullState.awayTeam = "Burneley";
        fix.footballFullState.finished = true;
        fix.footballFullState.gameTimeInSeconds = 200;
        fix.footballFullState.goals = new Goal[0];
        fix.footballFullState.period = "Second";
        fix.footballFullState.possibles = new String[0];
        fix.footballFullState.corners = new String[0];
        fix.footballFullState.redCards = new String[0];
        fix.footballFullState.yellowCards = new String[0];
        fix.footballFullState.startDateTime = "27/01/2021:18:00";
        fix.footballFullState.started = true;

        fix.footballFullState.team = new Team();
        fix.footballFullState.team.teamId = "Burnley";
        fix.footballFullState.team.association = "AWAY";
        fix.footballFullState.team.name = "AWAY";

        Team[] teams = new Team[1];

        teams[0] = new Team("Burnley", "AWAY", "AWAY");

        fix.footballFullState.teams = new Team[1];
         fix.footballFullState.teams[0] = new Team("AWAY", "Burnley", "AWAY");

        Gson gson = new Gson();
        String jsonStr = gson.toJson(fix);

        StringEntity entity = new StringEntity(jsonStr);
        httpPost.setEntity(entity);
        httpPost.setHeader("Accept", "application/json");
        httpPost.setHeader("Content-type", "application/json");

        CloseableHttpResponse response = client.execute(httpPost);
        Assert.assertEquals(response.getStatusLine().getStatusCode(), 200);


    }

    //Question 3
    @Test
    public void pollURLforChage() {
        // Perform a get all fixtures
        // GetMethod get = new UrlGetMethod("http://localhost:3000/fixtures");

        // Enable this GET to be conditional by checking on any change when pooling via the eTag
        // get.addRequestHeader(new Header("If-None-Match", etag));
        // get.addRequestHeader(new Header("If-Modified-Since", lastModified));
    }

    //Question 4
    @Test
    public void postThenDelete()
            throws ClientProtocolException, IOException {
        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost("http://localhost:3000/fixture");

        Fixture fix = new Fixture();
        fix.setFixtureId(6);

        fix.fixtureStatus = new FixtureStatus();
        fix.fixtureStatus.displayed = true;
        fix.fixtureStatus.suspended = false;
        fix.footballFullState = new FootballFullState();
        fix.footballFullState.homeTeam = "Aston Villa";
        fix.footballFullState.awayTeam = "Burneley";
        fix.footballFullState.finished = true;
        fix.footballFullState.gameTimeInSeconds = 200;
        fix.footballFullState.goals = new Goal[0];
        fix.footballFullState.period = "Second";
        fix.footballFullState.possibles = new String[0];
        fix.footballFullState.corners = new String[0];
        fix.footballFullState.redCards = new String[0];
        fix.footballFullState.yellowCards = new String[0];
        fix.footballFullState.startDateTime = "27/01/2021:18:00";
        fix.footballFullState.started = true;

        fix.footballFullState.team = new Team();
        fix.footballFullState.team.teamId = "Burnley";
        fix.footballFullState.team.association = "AWAY";
        fix.footballFullState.team.name = "AWAY";

        Team[] teams = new Team[1];


        teams[0] = new Team("Burnley", "AWAY", "AWAY");

        fix.footballFullState.teams = new Team[1];
        fix.footballFullState.teams[0] = new Team("AWAY", "Burnley", "AWAY");

        Gson gson = new Gson();
        String jsonStr = gson.toJson(fix);

        StringEntity entity = new StringEntity(jsonStr);
        httpPost.setEntity(entity);
        httpPost.setHeader("Accept", "application/json");
        httpPost.setHeader("Content-type", "application/json");

        CloseableHttpResponse response = client.execute(httpPost);

        String deleteEndpoint = "http://localhost:3000/fixture/6";

        CloseableHttpClient httpclient = HttpClients.createDefault();

        HttpDelete httpDelete = new HttpDelete(deleteEndpoint);
        System.out.println("Executing request " + httpDelete.getRequestLine());

        HttpResponse deleteResponse = httpclient.execute(httpDelete);

        if (response.getStatusLine().getStatusCode() != 200) {
            throw new RuntimeException("Failed : HTTP error code : " + response.getStatusLine().getStatusCode());
        }

        Assert.assertEquals(response.getStatusLine().getStatusCode(), 200);

    }

}
