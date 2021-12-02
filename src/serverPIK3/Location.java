package serverPIK3;

import java.io.IOException;
import java.net.URL;
import java.util.Map;
import java.util.Scanner;

import org.apache.http.HttpEntity;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

public class Location {
 
	
	public static String getLocation() {
		String location;
		String apiUrl = "https://geo.ipify.org/api/v2/country,city?apiKey=";
		String url = apiUrl + APIKey.getApiKey() + "&ipAddress=" + APIKey.getHostIP();

		try (Scanner s = new java.util.Scanner(new URL(url).openStream())) {
			location = s.useDelimiter("\\A").next();
			return new JSONObject(location).getJSONObject("location").getString("region");

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	public static String getWeather() {
		
		String url = "https://api.openweathermap.org/data/2.5/weather?q=" + getLocation() + "&units=metric&appid="+"84e963fbfc76581f4171c54d2bf66b68"; 
		String weather;

		CloseableHttpClient client = HttpClients.createDefault();
		HttpGet get = new HttpGet(url);
		CloseableHttpResponse resp=null;
		try  {
			resp=client.execute(get);
			HttpEntity enity= resp.getEntity();
			weather=EntityUtils.toString(enity);
			return  Double.toString(Math.round(new JSONObject(weather).getJSONObject("main").getDouble("temp")));
		

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}
}
