import org.apache.http.client.methods.HttpGet;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BodyTestWithSimpleMap extends BaseClass {

    private int getLengthOfArray(String jsonArrayStr )
    {
        JSONArray jsonArray = new JSONArray(jsonArrayStr);
        return jsonArray.length();
    }

    private  List<String> getValuesForGivenKey(String jsonArrayStr, String key) {
        JSONArray jsonArray = new JSONArray(jsonArrayStr);
        return IntStream.range(0, jsonArray.length())
                .mapToObj(index -> ((JSONObject)jsonArray.get(index)).optString(key))
                .collect(Collectors.toList());
    }

    private  String getValuesForLastRecord(String jsonArrayStr, String key) {
        JSONArray jsonArray = new JSONArray(jsonArrayStr);
        List<String> output = IntStream.range(0, jsonArray.length())
                .mapToObj(index -> ((JSONObject)jsonArray.get(index)).optString(key))
                .collect(Collectors.toList());
        String last = output.get(output.size() - 1);



        return last;
    }

private void findTeamId(JSONObject jsonObj) {
    String firstName = null;

    JSONObject shipmentLocation = jsonObj.getJSONObject("footballFullState");
    if (shipmentLocation != null) {
        JSONObject personName = shipmentLocation.getJSONObject("period");
        if (personName != null) {
            firstName = personName.getString("teams");
        }
    }

    if (firstName != null) {
        // do something with the first name
    }
}

private String getObject(String str) {
    JSONObject json;
    String strTeam="";
    JSONArray infoJsonArray;
    JSONObject infoObject;
    json = new JSONObject(str);

    Object info = json.get("footballFullState");
    if (info instanceof JSONArray) {
        infoJsonArray = (JSONArray) info;
    } else if (info instanceof JSONObject) {
        infoObject = (JSONObject) info;
        infoJsonArray =  infoObject.getJSONArray("teams");
        JSONObject teamObj = infoJsonArray.getJSONObject(0);
        strTeam = (String) teamObj.get("teamId");

    } else {
// string or number
    }
    return strTeam;
}

    private void output(JSONArray array )
        {
        for(int i=0; i < array.length(); i++)
        {
            JSONObject object = array.getJSONObject(i);
            System.out.println(object.getString("fixtureId"));
        }
    }

    //Question 2 Part II
    @Test
    public void returnsFirstFixtureteamId() throws IOException {

        HttpGet get = new HttpGet(BASE_ENDPOINT + "/fixture/1");

        response = client.execute(get);

        String jsonBody = EntityUtils.toString(response.getEntity());


        String expectedValue = getObject(jsonBody);
        Assert.assertEquals(expectedValue, "HOME");

    }

    //Question 2 Part I
    @Test
    public void returnsNewFixture() throws IOException {

        // Run this text case first  - whenPostJsonUsingHttpClient_thenCorrect

        HttpGet get = new HttpGet(BASE_ENDPOINT + "/fixtures");

        response = client.execute(get);

        String jsonBody = EntityUtils.toString(response.getEntity());
        System.out.println(jsonBody);
        JSONArray array = new JSONArray(jsonBody);

        String ret =   getValuesForLastRecord(jsonBody, "fixtureId");

        List<String> results =  getValuesForGivenKey(jsonBody, "fixtureId");
        System.out.println(Arrays.toString(results.toArray()));

        Assert.assertEquals(Integer.parseInt(ret), 5);
    }

    // Question 1 Part I
    @Test
    public void returnCorrectNumberOfFixtures() throws IOException {

        HttpGet get = new HttpGet(BASE_ENDPOINT + "/fixtures");

        response = client.execute(get);

        String jsonBody = EntityUtils.toString(response.getEntity());

        Integer length = getLengthOfArray(jsonBody);

        Assert.assertEquals(length, Integer.valueOf(3));
    }



    // Question 1 Part II
    @Test
    public void returnCorrectNumberOfFixtureIds() throws IOException {

        HttpGet get = new HttpGet(BASE_ENDPOINT + "/fixtures");

        response = client.execute(get);

        String jsonBody = EntityUtils.toString(response.getEntity());

        List<String> output = getValuesForGivenKey(jsonBody, "fixtureId");

        System.out.println("Fixtures IDs: " + Arrays.toString(output.toArray()));

        Assert.assertEquals(output.size(), 3);
    }

    private Object getValueFor(JSONObject jsonObject, String key) {
        return jsonObject.get(key);
    }

}
