package cs.vsb.tereza.controller;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cs.vsb.tereza.City;
import cs.vsb.tereza.dto.WeatherDto;
import cs.vsb.tereza.service.WeatherService;

@RestController
public class WeatherController {
	private WeatherService weatherService;
	public WeatherController() {
		weatherService = new WeatherService();
	}
	@RequestMapping("/weather")
	public Collection<WeatherDto> getWeather() {
		List<WeatherDto> weatherList = new ArrayList<>();
		for(City city: City.values()) {
			WeatherDto wdto = weatherService.getWeatherForCity(city);
			weatherList.add(wdto);			
		}		
		return weatherList;
		
	}
	@CrossOrigin
	@RequestMapping("/weather/{city}")
	public WeatherDto getWeatherForCity(@PathVariable String city) {
		City cityEnum = City.valueOf(city.toUpperCase());
		return weatherService.getWeatherForCity(cityEnum);		
	}
	
	@RequestMapping("/weather/bruntal")
	public String getWeatherForBruntal() {
		return "<h2>Bruntál nenalezen!</h2><p> Pouze mlha, bláto a vzdálené kvákání žab</p>"
				+ "<img src='http://zubatezaby.cz/files/IMG_24.jpg'>";
	}
}
