package fr.nice42.student.dkhatri.avaj;

import java.io.*;

abstract class	Flyable
{
	protected WeatherTower	weatherTower;

	abstract void	updateConditions();

	public void	registerTower(WeatherTower p_tower)
	{
		this.weatherTower = p_tower;
		this.weatherTower.register(this);
	}
}