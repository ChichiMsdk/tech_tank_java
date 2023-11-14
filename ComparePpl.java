public class ComparePpl{

	private static People[] pplCompare = new People[2]; 
	private static String[] pplNames = new String[2];

	public static void setCompare(String[] dArgs) {
		ComparePpl.pplCompare[0] = Human.getPeople(dArgs[0]);
		ComparePpl.pplCompare[1] = Human.getPeople(dArgs[1]);
		setNames();
		HelperDate.setDaysOlder();
	}
	private static void setNames() {
		ComparePpl.pplNames[0] = pplCompare[0].getFullName();
		ComparePpl.pplNames[1] = pplCompare[1].getFullName();
	}
	//not so important but better if there is "N/A" in the output
	public static String[] getFullNames(String[] dArgs){
		String[] comparingNames = new String[2];
		ComparePpl.setCompare(dArgs);
		comparingNames = ComparePpl.getNames();
		return comparingNames;
	}

	public static People[] getPplCompare() {
		return pplCompare;
	}

	public static String[] getNames() {
		return pplNames;
	}

}
