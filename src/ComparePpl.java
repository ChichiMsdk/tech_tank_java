import java.util.ArrayList;
import java.util.List;

/**
 * ComparePpl class is used to compare two people and return their names
 * in a String array. 
 * Classes {@code People} and {@code HumanMap} must have been created before h
 * using this class.
 * 
 */
public class ComparePpl{

	private static People[] pplCompare = new People[2]; 
	private static String[] pplNames = new String[2];

	private static void setCompare(String[] dArgs, HumanMap humanMap) {
		ComparePpl.pplCompare[0] = humanMap.getPeopleByNames(dArgs[0],
				humanMap);
		ComparePpl.pplCompare[1] = humanMap.getPeopleByNames(dArgs[1],
				humanMap);
		if (pplCompare[0] == null || pplCompare[1] == null) {
			pplNames[0] = null; 
			pplNames[1] = null;
		}
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
	public static String[] getCompFullNames(String[] dArgs, HumanMap humanMap){
		ComparePpl.setCompare(dArgs, humanMap);
		if (pplCompare[0] == null || pplCompare[1] == null) {
			System.err.println("Error: with names to compare.");
			System.err.println("Using default names..");
		} else { 
			setFullNames();
		}
		return pplNames;
	}

	public static String[] getCompLastNames(String[] dArgs, HumanMap humanMap){
		ComparePpl.setCompare(dArgs, humanMap);
		setLastNames();
		return pplNames;
	}

	public static String[] getCompNames(String[] dArgs, HumanMap humanMap){
		ComparePpl.setCompare(dArgs, humanMap);
		setNames();
		return pplNames;
	}

	public static People[] getPplCompFromStr(HumanMap humanMap, 
			String[] dArgs) {
		if (dArgs.length == 2){
			setCompare(dArgs, humanMap);
		} else {
			System.err.println("Error: not enough names to compare.");
		}
		if (pplCompare[0] == null || pplCompare[1] == null) {
			System.err.println("Error: not enough names to compare.");
		}
		return pplCompare;
	}

	public static String[] retrieveNames() {
		if (pplNames[0] == null || pplNames[1] == null) {
			System.err.println("Error: while trying to retrieve names.");
		}
		return pplNames;
	}

}
