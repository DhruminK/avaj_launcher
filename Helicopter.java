package fr.nice42.student.dkhatri.avaj;

import java.lang.*;
import java.io.*;

class Helicopter extends Aircraft
{
	public Helicopter(long p_id, String p_name, Coordinates p_coordinates)
	{
		super(p_id, p_name, p_coordinates);
	}

	@Override
	public void updateConditions()
	{
		String	weather;

		weather = super.weatherTower.getWeather(this.coordinates);
		if (weather.equals("SUN"))
		{
			this.coordinates = new Coordinates(this.coordinates.getLongitude() + 10,
												this.coordinates.getLatitude(),
												this.coordinates.getHeight() + 2);
			System.out.println("Helicopter#" + this.name + "(" + this.id + ") : Weather's nice and sunny");
		}
		else if (weather.equals("RAIN"))
		{
			this.coordinates = new Coordinates(this.coordinates.getLongitude() + 5,
												this.coordinates.getLatitude(),
												this.coordinates.getHeight());
			System.out.println("Helicopter#" + this.name + "(" + this.id + ") : Bit of rain, no issue for us");
		}
		else if (weather.equals("FOG"))
		{
			this.coordinates = new Coordinates(this.coordinates.getLongitude() + 1,
												this.coordinates.getLatitude(),
												this.coordinates.getHeight());
			System.out.println("Helicopter#" + this.name + "(" + this.id + ") : Damn, where did this fog come from ?");
		}
		else
		{
			this.coordinates = new Coordinates(this.coordinates.getLongitude(),
												this.coordinates.getLatitude(),
												this.coordinates.getHeight() - 12);
			System.out.println("Helicopter#" + this.name + "(" + this.id + ") : snow on our wings, gonna start descending");
		}
		if (this.coordinates.getHeight() <= 0)
		{
			System.out.println("Helicopter#" + this.name + "(" + this.id + ") : My wings are cliped");
			this.weatherTower.deregister(this);
			System.out.println("Tower says: Helicopter#" + this.name + "(" + this.id + ") : unregistered from weather tower.");
		}
	}
}