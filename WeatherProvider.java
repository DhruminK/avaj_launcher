package fr.nice42.student.dkhatri.avaj;

class WeatherProvider
{
	private static String[] weather = {"SUN", "SNOW", "RAIN", "FOG"};

	private WeatherProvider()
	{
	}

	public static String getCurrentWeather(Coordinates p_coordinates)
	{
		int	sum;

		sum = p_coordinates.getLatitude() + p_coordinates.getLongitude() + p_coordinates.getHeight();
		return (weather[sum % weather.length]);
	}
}