package fr.nice42.student.dkhatri.avaj;

import java.lang.*;
import java.io.*;

class JetPlane extends Aircraft
{
	public JetPlane(long p_id, String p_name, Coordinates p_coordinates)
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
			this.coordinates = new Coordinates(this.coordinates.getLongitude(),
												this.coordinates.getLatitude() + 10,
												this.coordinates.getHeight() + 2);
			System.out.println("JetPlane#" + this.name + "(" + this.id + ") : My ass is on fire, Gonna send it");
		}
		else if (weather.equals("RAIN"))
		{
			this.coordinates = new Coordinates(this.coordinates.getLongitude(),
												this.coordinates.getLatitude() + 5,
												this.coordinates.getHeight());
			System.out.println("JetPlane#" + this.name + "(" + this.id + ") : Why is it raining, it's not in the flight report");
		}
		else if (weather.equals("FOG"))
		{
			this.coordinates = new Coordinates(this.coordinates.getLongitude(),
												this.coordinates.getLatitude() + 1,
												this.coordinates.getHeight());
			System.out.println("JetPlane#" + this.name + "(" + this.id + ") : Damn, where did this fog come from ?");
		}
		else
		{
			this.coordinates = new Coordinates(this.coordinates.getLongitude(),
												this.coordinates.getLatitude(),
												this.coordinates.getHeight() - 7);
			System.out.println("JetPlane#" + this.name + "(" + this.id + ") : snow on our wings, gonna start descending");
		}
		if (this.coordinates.getHeight() <= 0)
		{
			System.out.println("JetPlane#" + this.name + "(" + this.id + ") : My wings are cliped");
			this.weatherTower.deregister(this);
			System.out.println("Tower says: JetPlane#" + this.name + "(" + this.id + ") : unregistered from weather tower.");
		}
	}
}