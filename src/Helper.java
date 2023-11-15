import java.util.List;

public class Helper{

	/**
	 * Returns a list of {@code People} objects.
	 * {@code People} objects are created from file in and added to the list.
	 */
	public static List<People> initListAndParsing(String[] args,
			String[] dArgs, HumanMap humanMap) {
		ParserHelper.FileToLinesList(args, dArgs);
		humanMap.initPeopleFromLines(ParserHelper.getLinesList());
		List<People> peopleList = humanMap.getPeopleList();
		humanMap.addPeopleToMap(peopleList);
		return peopleList;
	}

	public static int changeGenderToInt(String genderString, String fullName) {
		if (genderString.compareTo("Male") == 0
				|| genderString.compareTo("male") == 0) {
			return 1;
		}
		if (genderString.compareTo("Female") == 0
				|| genderString.compareTo("female") == 0) {
			return 2;
		} else {
			ErrorHelper.flagWrng("Warning: could not retrieve gender of "
					+ fullName + ".", ErrorHelper.getVerbose());
			return 0;
		}
	}
}
