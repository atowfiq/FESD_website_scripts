package fesdweb.model;

import java.util.ArrayList;

public class Dos {

	public String Energy;
	public String TotalDos;
	public ArrayList<PartialDos> PartialValue;
	public Dos(String e,String t)
	{
		Energy = e;
		TotalDos = t;
		PartialValue =new ArrayList();
	}
}
