/**
 * ComparePpl class is used to compare two people and return their names
 * in a String array. 
 * 
 */
public class ComparePpl{

	private static People[] pplCompare = new People[2]; 
	private static String[] pplNames = new String[2];

	public static void setCompare(String[] dArgs) {
		ComparePpl.pplCompare[0] = Human.getPeople(dArgs[0]);
		ComparePpl.pplCompare[1] = Human.getPeople(dArgs[1]);
		HelperDate.setDaysOlder();
	}
	private static void setFullNames() {
		ComparePpl.pplNames[0] = pplCompare[0].getFullName();
		ComparePpl.pplNames[1] = pplCompare[1].getFullName();
	}

	private static void setNames() {
		ComparePpl.pplNames[0] = pplCompare[0].getName();
		ComparePpl.pplNames[1] = pplCompare[1].getName();
	}

	private static void setLastNames() {
		ComparePpl.pplNames[0] = pplCompare[0].getLastName();
		ComparePpl.pplNames[1] = pplCompare[1].getLastName();
	}
// better if there is "N/A" in the output
	public static String[] getFullNames(String[] dArgs){
		String[] comparingNames = new String[2];
		ComparePpl.setCompare(dArgs);
		setFullNames();
		comparingNames = ComparePpl.retrieveNames();
		return comparingNames;
	}

	public static String[] getLastNames(String[] dArgs){
		String[] comparingNames = new String[2];
		ComparePpl.setCompare(dArgs);
		setLastNames();
		comparingNames = ComparePpl.retrieveNames();
		return comparingNames;
	}

	public static String[] getNames(String[] dArgs){
		String[] comparingNames = new String[2];
		ComparePpl.setCompare(dArgs);
		setNames();
		comparingNames = ComparePpl.retrieveNames();
		return comparingNames;
	}

	public static People[] getPplCompare() {
		return pplCompare;
	}

	public static String[] retrieveNames() {
		return pplNames;
	}

}
