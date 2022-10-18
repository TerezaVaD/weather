package cs.vsb.tereza.connector;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import cs.vsb.tereza.City;
import cs.vsb.tereza.dto.WeatherstackDto;

public class WeatherstackConnector {
	private static String baseUrl = "http://api.weatherstack.com/";
	private static String urlParams = "current?access_key=";
	private static String apiKey = "0f8adc02555f61ec4768da029c543010";
	private static String url = baseUrl+urlParams+apiKey+"&query=";
	
	
	public WeatherstackDto getWeatherForCity(City cityEnum) {
		RestTemplate template = new RestTemplate();
		URI uri=null;
		try {
			uri = new URI(url + cityEnum.toString());
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ResponseEntity<WeatherstackDto> response = template.getForEntity(uri, WeatherstackDto.class);
		return response.getBody();
	}
}
