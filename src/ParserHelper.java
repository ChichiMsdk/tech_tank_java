import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
/**
 * {@code ParserHelper} is used to parse the file and create the list of people.
 * <p> It contains methods to ensure that the file is read correctly and that<br>
 * it is formatted the right way which is: <br>
 * <b>"FirstName LastName", "Gender", "Date of Birth"</b></p>
 * </br>
 */

public class ParserHelper{

	private static List<People> peopleList = new ArrayList<>();
	private static List<String> lines = new ArrayList<>();

	/**
	 * Gets all the lines in {@code lines} and checks the arguments passed.
	 * @param args the arguments passed to the program
	 * @param dArgs the names of the people to compare
	 */
	public static void FileToLinesList(String[] args, String[] dArgs){
		try { 
			List<String> lines = Files.readAllLines(Paths.get(args[0]));
			setLineList(lines);
			if (lines.isEmpty()) {
				System.err.println("Error: file is empty, no one is here..");
				System.exit(1);
			}
		} catch (IOException e) {
			System.err.println("Error reading file: " + e.getMessage());
			System.exit(1);
		}
		if (args.length == 4 || args.length == 3){
			dArgs[0] = args[1];
			dArgs[1] = args[2];
		} else {
			ErrorHelper.flagWrng("Not enough <names>, using default ones "
					+ "'" + dArgs[0] + " and " + dArgs[1] + "'", 
					ErrorHelper.getVerbose());
		}
	}

	public static String[] splitName(String str){
		String[] parts = new String[2];
		parts = str.split(" ");
		try{
			if (parts[1] == null || parts[0].isEmpty()){
				ErrorHelper.flagWrng("Warning: (last) name is missing. " 
						+ str, ErrorHelper.getVerbose());
				String[] part = {parts[1], "N/A"};
				return part;
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			if (parts[0].isEmpty()){
				ErrorHelper.flagWrng("Warning: empty name found.. still "
						+ "added. " + str, ErrorHelper.getVerbose());
				String[] part = {"N/A", "N/A"};
				return part;
			}
			ErrorHelper.flagWrng("Warning: (last) name is missing. " 
					+ str, ErrorHelper.getVerbose());
			String[] part = {parts[0], "N/A"};
			return part;
		}
		try{
			if (parts[2] != null){
			ErrorHelper.flagWrng("Warning: (last) name has more than" 
					+" one space allowed. " + str, ErrorHelper.getVerbose());
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			return parts;
		}
		return parts;
	}

	public static String[] splitFields(String lines){
		String[] parts = lines.split(",");
		if (parts.length != 3) {
			ErrorHelper.flagWrng("Warning: skipping line: " + lines, 
					ErrorHelper.getVerbose());
			return null;
		}
		for ( int i = 0; i < parts.length; i++) {
			parts[i] = parts[i].trim();
		}
		return parts;
	}

	private static void setLineList(List<String> lines){
		ParserHelper.lines = lines;
	}

	public static List<People> getPeopleList(){
		return peopleList;
	}

	public static List<String> getLinesList(){
		return lines;
	}
}
