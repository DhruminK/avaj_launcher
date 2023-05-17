package fr.nice42.student.dkhatri.avaj;

import java.io.*;

class Baloon extends Aircraft {
	public Baloon(long p_id, String p_name, Coordinates p_coordinates) {
		super(p_id, p_name, p_coordinates);
	}

	@Override
	public void updateConditions() {
		String weather;

		weather = super.weatherTower.getWeather(this.coordinates);
		if (weather.equals("SUN")) {
			this.coordinates = new Coordinates(this.coordinates.getLongitude() + 2,
					this.coordinates.getLatitude(),
					this.coordinates.getHeight() + 4);
			System.out.println("Baloon#" + this.name + "(" + this.id + ") : Sunny weather, gonna send it to the moon");
		} else if (weather.equals("RAIN")) {
			this.coordinates = new Coordinates(this.coordinates.getLongitude(),
					this.coordinates.getLatitude() - 5,
					this.coordinates.getHeight());
			System.out.println("Baloon#" + this.name + "(" + this.id + ") : Raining sub-optimal conditions");
		} else if (weather.equals("FOG")) {
			this.coordinates = new Coordinates(this.coordinates.getLongitude(),
					this.coordinates.getLatitude() - 3,
					this.coordinates.getHeight());
			System.out
					.println("Baloon#" + this.name + "(" + this.id + ") : Fog cant see anything, no instructments too");
		} else {
			this.coordinates = new Coordinates(this.coordinates.getLongitude(),
					this.coordinates.getLatitude(),
					this.coordinates.getHeight() - 15);
			System.out.println(
					"Baloon#" + this.name + "(" + this.id + ") : snow on my head, gonna start descending rapidly");
		}
		if (this.coordinates.getHeight() <= 0) {
			System.out.println("Baloon#" + this.name + "(" + this.id + ") : Landed on the ground safely");
			this.weatherTower.deregister(this);
			System.out.println(
					"Tower says: Baloon#" + this.name + "(" + this.id + ") : unregistered from weather tower.");
		}
	}
}