import java.util.ArrayList;
import java.util.List;

/**
 * ComparePpl class is used to compare two people and return their names
 * in a String array.<br>
 * Classes {@code People} and {@code HumanMap} must have been created before
 * using this class.
 * 
 */
public class ComparePpl{

	private static People[] pplCompare = new People[2]; 
	private static String[] pplNames = new String[2];

	/**
	 * {@code setCompare}<br>
	 * Allows to set the {@code People} pplCompare objects to compare using<br>
	 * their names.
	 */
	private static void setCompare(String[] names, HumanMap humanMap) {
		ComparePpl.pplCompare[0] = humanMap.getPeopleByNames(names[0],
				humanMap);
		ComparePpl.pplCompare[1] = humanMap.getPeopleByNames(names[1],
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

	/**
	 * {@code getCompFullNames}<br>
	 * Allows to change the names of the people to compare to display
	 * the right names<br> in the output, especially if "N/A" had to be used.
	 * @see getCompNames
	 * @see getCompLastNames
	 */

	public static String[] getCompFullNames(String[] names, HumanMap humanMap){
		ComparePpl.setCompare(names, humanMap);
		if (pplCompare[0] == null || pplCompare[1] == null) {
			ErrorHelper.flagWrng("Error names to compare\nUsing defaults ",
					ErrorHelper.getVerbose());
		} else { 
			setFullNames();
		}
		return pplNames;
	}

	public static String[] getCompLastNames(String[] names, HumanMap humanMap){
		ComparePpl.setCompare(names, humanMap);
		setLastNames();
		return pplNames;
	}

	public static String[] getCompNames(String[] names, HumanMap humanMap){
		ComparePpl.setCompare(names, humanMap);
		setNames();
		return pplNames;
	}

	/**
	 * {@code getPplCompFromStr}<br>
	 * Allows to retrieve the {@code People} objects from the {@code HumanMap}
	 * using the names<br>passed as arguments.
	 */

	public static People[] getPplCompFromStr(HumanMap humanMap, 
			String[] names) {
		if (names.length == 2){
			setCompare(names, humanMap);
		} else {
			ErrorHelper.flagWrng("Error: not enough names to compare.",
					ErrorHelper.getVerbose());
		}
		if (pplCompare[0] == null || pplCompare[1] == null) {
			ErrorHelper.flagWrng("Error: not enough names to compare.",
					ErrorHelper.getVerbose());
		}
		return pplCompare;
	}
}
