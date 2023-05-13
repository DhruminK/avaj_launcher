package fr.nice42.student.dkhatri.avaj;

import java.lang.*;

class	WeatherTower extends Tower
{
	String getWeather(Coordinates p_coordinates)
	{
		return (WeatherProvider.getCurrentWeather(p_coordinates));
	}

	public	void	changeWeather()
	{
		super.conditionsChanged();
	}
}