package fesdweb.model;

public class PartialDos {

	public String Element;
	public int ElementIndex;
	public String PartialDosOrbital;
	public String PartialDosValue;
	
	public PartialDos(String e, int ei,String pdo, String pdv)
	{
			Element =e;	
			ElementIndex = ei;
			PartialDosOrbital = pdo;
			PartialDosValue=pdv;
	}
	
}
