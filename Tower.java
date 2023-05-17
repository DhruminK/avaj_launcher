package fr.nice42.student.dkhatri.avaj;

import java.util.List;
import java.util.ArrayList;

class	Tower
{
	private List<Flyable> observers = new ArrayList<Flyable>();

	public void	register(Flyable p_flyable)
	{
		observers.add(p_flyable);
	}

	public void deregister(Flyable p_flyable)
	{
		int	index;

		index = observers.indexOf(p_flyable);
		if (index != -1)
			observers.remove(index);
	}

	protected void	conditionsChanged()
	{
		int		i;
		Flyable	f;

		i = -1;
		while (++i < observers.size())
		{
			f = observers.get(i);
			f.updateConditions();
		}
	}
}