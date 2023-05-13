package fr.nice42.student.dkhatri.avaj;

import java.lang.*;

class Aircraft extends Flyable
{
	long		id;
	String		name;
	Coordinates coordinates;

	protected Aircraft(long p_id, String p_name, Coordinates p_coordinates)
	{
		this.id = p_id;
		this.name = p_name;
		this.coordinates = p_coordinates;
	}

	void	updateConditions()
	{
	}
}