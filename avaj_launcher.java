
package fr.nice42.student.dkhatri.avaj;

import java.io.*;

class avajLaucher {
	int				numWeather;
	int				numAircraft;
	WeatherTower	weatherTower;

	private int	ft_parse_single_aircraft(Parser pr, BufferedReader br) throws Exception, IOException
	{
		Coordinates		new_coordinates;
		Flyable			fly;
		int[]			coor;
		int				ret;
		StringBuilder	type;
		StringBuilder	name;

		if (br == null)
			throw new Exception("Error found BufferedReader null");
		type = new StringBuilder();
		name = new StringBuilder();
		coor = new int[3];
		ret = pr.getLineParameters(type, name, coor, br);
		if (ret == -1)
			throw new Exception("Error while parsing file");
		if (ret == 0)
			return (0);
		new_coordinates = new Coordinates(coor[0], coor[1], coor[2]);
		fly = AircraftFactory.newAircraft(type.toString(), name.toString(), new_coordinates);
		if (fly == null)
			throw new Exception("Error while parsing Flyable");
		fly.registerTower(weatherTower);
		System.out.print("Tower says: " + type.toString() + "#" + name.toString());
		System.out.println("(" + ((Aircraft)fly).id + ") registered to weather tower.");
		this.numAircraft += 1;
		return (1);
	}

	public int	ft_parse_coordinates(Parser pr) {
		BufferedReader	br;
		int				ret;
		int[]			coor;

		coor = new int[1];
		try {
			br = pr.getNumberOfWeather(coor);
			this.numWeather = coor[0];
			ret = 1;
			if (br == null)
				throw new Exception("Error while forming BufferedReader");
			while (ret > 0)
				ret = ft_parse_single_aircraft(pr, br);
		}  catch (IOException e) {
			System.out.println("IOException occured");
			return (-1);
		} catch (Exception e) {
			System.out.println(e.toString());
			return (-1);
		}
		return (0);
	}
 
	public static void main(String[] args) {
		avajLaucher	avaj;
		Parser		pr;
		int			i;

		if (args.length != 1) {
			System.out.println("Incorrect number of parameters");
			return;
		}

		avaj = new avajLaucher();
		try {
			pr = new Parser(args[0]);
		} catch (FileNotFoundException e) {
			System.out.println("Invalid File");
			return;
		}
		avaj.weatherTower = new WeatherTower();
		i = avaj.ft_parse_coordinates(pr);
		if (i == -1)
			return;
		i = 0;
		while (i < avaj.numWeather) {
			avaj.weatherTower.changeWeather();
			i += avaj.numAircraft;
		}
	}
}