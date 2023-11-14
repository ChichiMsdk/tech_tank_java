import java.util.List;
import java.util.ArrayList;
import java.util.ArrayList;

public class Helper{
	public static String[] nameSplit(String str){
		String trimmed = str.replaceFirst("^\\s+", "");
		//does this return a copy?..
		String[] parts = new String[2];
		parts = trimmed.split(" ");
		try{
			if (parts[1] == null || parts[0].isEmpty()){
				System.err.println("Warning: (last) name is missing.");
				String[] part = {parts[1], "N/A"};
				return part;
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			if (parts[0].isEmpty()){
				System.err.println("Warning: empty name found.. still added.");
				String[] part = {"N/A", "N/A"};
				return part;
			}
			System.err.println("Warning: (last) name is missing.");
			String[] part = {parts[0], "N/A"};
			return part;
		}
		try{
			if (parts[2] != null){
			System.err.println("Warning: (last) name has more than" 
					+" one space allowed. Please check the file next time.");
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			return parts;
		}
		return parts;
	}
	/**
	 * Returns a list of {@code People} objects.
	 * {@code People} objects are created from the file in {@see ParsePeople}
	 * and added to the list.
	 * @param args the command line arguments
	 * @param dArgs the default names
	 * @return the list of {@code People} objects
	 */
	public static List<People> initListAndParsing(String[] args,
			String[] dArgs) {
		FileParser.ParsePeople(args, dArgs);
		List<People> people = FileParser.getPeopleList();
		return people;
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
			System.out.println("Warning: could not retrieve gender of "
					+ fullName + ". Please check the file next time.");
			return 0;
		}
	}
}
