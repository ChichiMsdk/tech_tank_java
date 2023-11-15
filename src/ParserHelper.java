import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

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
	private static List<String> lines = new ArrayList<>();

	/**
	 * Gets all the lines in {@code lines} and checks the arguments passed.
	 * @param args the arguments passed to the program
	 * @param dArgs the names of the people to compare
	 */
	public static void FileToLinesList(String @NotNull [] args, String @NotNull [] dArgs){
		try { 
			List<String> lines = Files.readAllLines(Paths.get(args[0]));
			setLineList(lines);
			if (lines.isEmpty()) {
				System.err.println("Error: file is empty, no one is here..");
				ErrorHelper.getWarningCountEnd(ErrorHelper.getVerbose());
				System.exit(1);
			}
		} catch (IOException | ArrayIndexOutOfBoundsException e) {
			System.err.println("Error reading file: " + e.getMessage());
			ErrorHelper.getWarningCountEnd(ErrorHelper.getVerbose());
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

	public static String @Nullable [] splitName(@NotNull String str){
		String[] parts = str.split(" ");
		if (parts[0].isEmpty()){
			ErrorHelper.flagWrng("Warning: empty name found" 
					+ str, ErrorHelper.getVerbose());
			return null;
		}
		if (parts.length > 2){
			ErrorHelper.flagWrng("Warning: (last) name has more than" 
					+" one space allowed.\nTaking first and last\n"
					+ str, ErrorHelper.getVerbose());
			String[] change = new String[2];
			change[0] = parts[0];
			change[1] = parts[parts.length - 1];
			return change;
		}
		if (parts.length < 2)
			return null;
		return parts;
	}

	public static String @Nullable [] splitFields(@NotNull String lines){
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

	public static List<String> getLinesList(){
		return lines;
	}
}
