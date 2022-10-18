package cs.vsb.tereza.service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import cs.vsb.tereza.City;
import cs.vsb.tereza.connector.WeatherstackConnector;
import cs.vsb.tereza.dto.WeatherDto;
import cs.vsb.tereza.dto.WeatherstackDto;

@Service
public class WeatherService {
	public WeatherDto getWeatherForCity(City cityEnum) {
		WeatherstackConnector connector = new WeatherstackConnector();
		
		WeatherstackDto weatherstackDto = connector.getWeatherForCity(cityEnum);
		WeatherDto wdto = transformDto(weatherstackDto);
		//dto.setLocation(connector.getWeatherForCity(cityEnum));
		return wdto;
	}
	
	private WeatherDto transformDto(WeatherstackDto weatherstackDto) {
		WeatherDto wdto = new WeatherDto();
		wdto.setLocation(weatherstackDto.getLocation().name);
		wdto.setTimestamp(weatherstackDto.getLocation().localtime);
		wdto.setWindSpeed_mps(Math.round(weatherstackDto.getCurrent().wind_speed/3.6));
		wdto.setWindDirection(weatherstackDto.getCurrent().wind_dir);
		wdto.setRel_humidity(weatherstackDto.getCurrent().humidity);
		wdto.setTemp_celsius(weatherstackDto.getCurrent().temperature);
		wdto.setWeatherDescription(weatherstackDto.getCurrent().getWeather_descriptions().get(0));
		return wdto;
	}
}
