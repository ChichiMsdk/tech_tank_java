import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * ComparePpl class is used to compare two people and return their names
 * in a String array.<br>
 * Classes {@code People} and {@code HumanMap} must have been created before
 * using this class.
 * 
 */
public class ComparePpl{

	private static final People[] pplCompare = new People[2];
	private static final String[] pplNames = new String[2];

	/**
	 * {@code setCompare}<br>
	 * Allows to set the {@code People} pplCompare objects to compare using<br>
	 * their names.
	 */
	private static void setCompare(String @NotNull [] names,
			@NotNull HumanMap humanMap) {
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

	/**
	 * {@code getCompFullNames}<br>
	 * Allows to change the names of the people to compare to display
	 * the right names<br> in the output, especially if "N/A" had to be used.
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

	/**
	 * {@code getPplCompFromStr}<br>
	 * Allows to retrieve the {@code People} objects from the {@code HumanMap}
	 * using the names<br>passed as arguments.
	 */

	public static People @Nullable [] getPplCompFromStr(HumanMap humanMap,
			String @NotNull [] names) {
		if (names.length == 2){
			setCompare(names, humanMap);
		} else {
			ErrorHelper.flagWrng("Error: not enough names to compare.",
					ErrorHelper.getVerbose());
			return null;
		}
		if (pplCompare[0] == null || pplCompare[1] == null) {
			ErrorHelper.flagWrng("Error: not enough names to compare.",
					ErrorHelper.getVerbose());
			return null;
		}
		return pplCompare;
	}
}
