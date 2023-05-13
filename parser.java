package fr.nice42.student.dkhatri.avaj;

import java.io.*;

class	Parser
{
	private FileReader		fr;

	public Parser(String filename) throws FileNotFoundException
	{
		fr = new FileReader(filename);
	}

	public int getNumberOfWeather() throws IOException
	{
		BufferedReader	br;
		String			line;

		br = new BufferedReader(fr);
		line = br.readLine();
		if (line == null)
			return (-1);
		return (Integer.parseInt(line));
	}

	public BufferedReader	getCordinatesReader() throws IOException
	{
		BufferedReader br;

		br = new BufferedReader(fr);
		br.readLine();
		return (br);
	}

	public int	getLineParameters(Object[] obj, BufferedReader br) throws IOException
	{
		String		line;
		String[]	str;
		int			i;

		line = br.readLine();
		if (line == null)
			return (0);
		str = line.split(" ");
		if (str.length != 5)
			return (-1);
		i = -1;
		while (++i < 5)
			obj[i] = new String(str[i]);
		return (1);
	}
}