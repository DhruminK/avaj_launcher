//import fr.nice42.student.dkhatri.avaj.*;
import fr.nice42.student.dkhatri.avaj.Parser;

import java.io.*;

class	avajLaucher
{
	static int			numWeather;
	static int			numAircraft;
	static WeatherTower	weatherTower;

	private static int	ft_parse_coordinates(Parser pr)
	{
		BufferedReader	br;
		Flyable			fly;
		Object[]		obj;
		Coordinates		coordinates;
		int				ret;

		obj = new Object[5];
		try {
			br = pr.getCordinatesReader();
			ret = 1;
			numAircraft = 0;
			while (ret > 1)
			{
				ret = pr.getLineParameters(obj, br);
				if (ret < 1)
					break ;
				coordinates = new Coordinates(Integer.parseInt(obj[2].toString()), 
					Integer.parseInt(obj[3].toString()), Integer.parseInt(obj[4].toString()));
				fly = AircraftFactory.newAircraft(obj[0].toString(), obj[1].toString(), coordinates);
				fly.registerTower(weatherTower);
			}
			if (ret == -1)
				throw new Exception("Error while parsing file");
		} catch (IOException e){
			System.out.println("IOException occured");
			return (-1);
		} catch (Exception e) {
			System.out.println(e.toString());
			return (-1);
		}
		return (0);
	}

	public static void	main(String[] args)
	{
		Parser			pr;
		int				i;
		
		if (args.length != 1)
		{
			System.out.println("Incorrect number of parameters");
			return ;
		}

		try {
			pr = new Parser(args[1]);
		} catch (FileNotFoundException e) {
			System.out.println("Invalid File");
			return ;
		}

		if (ft_parse_coordinates(pr) == -1)
			return ;
		i = 0;
		while (i < numWeather)
		{
			weatherTower.changeWeather();
			i += numAircraft;
		}
	}
}