package fr.nice42.student.dkhatri.avaj;

class AircraftFactory
{
	private static AircraftFactory	aircraftFactoryInstance = null;
	private int						uniq_id;

	private AircraftFactory()
	{
		uniq_id = 0;
	}

	public static Flyable newAircraft(String p_type, String p_name, Coordinates p_coordinates)
	{
		Flyable	f;

		f = null;
		if (aircraftFactoryInstance == null)
			aircraftFactoryInstance = new AircraftFactory();
		if (p_type.equalsIgnoreCase("Helicopter"))
			f = new Helicopter((aircraftFactoryInstance.uniq_id)++, p_name, p_coordinates);
		else if (p_type.equalsIgnoreCase("JetPlane"))
			f = new JetPlane((aircraftFactoryInstance.uniq_id)++, p_name, p_coordinates);
		else if (p_type.equalsIgnoreCase("Baloon"))
			f = new Baloon((aircraftFactoryInstance.uniq_id)++, p_name, p_coordinates);
		return (f);
	}
}