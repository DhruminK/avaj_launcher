package fr.nice42.student.dkhatri.avaj;

import java.io.*;

class	Parser
{
	private FileReader		fr;

	public Parser(String filename) throws FileNotFoundException
	{
		fr = new FileReader(filename);
	}

	public BufferedReader getNumberOfWeather(int[] numWeather) throws IOException
	{
		BufferedReader	br;
		String			line;

		br = new BufferedReader(fr);
		line = br.readLine();
		if (line == null)
			return (null);
		numWeather[0] = Integer.parseInt(line);
		return (br);
	}

	public int	getLineParameters(StringBuilder type, StringBuilder name, int[] coor , BufferedReader br) throws IOException
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
		name.setLength(0);
		name.append(str[1]);
		type.setLength(0);
		type.append(str[0]);
		coor[0] = Integer.parseInt(str[2]);
		coor[1] = Integer.parseInt(str[3]);
		coor[2] = Integer.parseInt(str[4]);
		return (1);
	}
}