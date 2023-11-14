import java.util.List;
import java.util.ArrayList;
import java.time.LocalDate;
import java.time.Period;

public class AddressBook {

    public static void main(String[] args) {
		if (args.length < 1 || args.length > 3) {
			System.out.println("Usage: java HelloWorld <filename> <name1>"+ 
					"(<name2> names are optional)");
			return;
		}
		String[] dArgs = { "Bill", "Paul" };
		List<People> people = createPplList(args, dArgs);
		int maleCount = Human.getMalesNbr(people);
		People oldest = Human.getOldest(people);
		dArgs = ComparePplAge.getOlder(dArgs);
		long daysOlder = ComparePplAge.getDaysOlder();
		Answers.printAll(maleCount, oldest, daysOlder, dArgs);
    }

	public static List<People> createPplList(String[] args, String[] dArgs) {
		FileParser.ParsePeople(args, dArgs);
		List<People> people = FileParser.getPeopleList();
		return people;
	}
	public static String[] nameSplit(String str){
		String trim = str.replaceFirst("^\\s+", "");
		String[] parts = new String[2];
		try{
			parts = trim.split(" ");
		} catch (NullPointerException e){
			System.out.println("Please provide a name");
			System.exit(1);
		}
		try{
			if (parts[1] == null || parts[0].isEmpty()){
				System.out.println("TRY Warning: (last) name is missing.");
				String[] part = {parts[1], "N/A"};
				return part;
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("CATCH Warning: (last) name is missing.");
			String[] part = {parts[0], "N/A"};
			return part;
		}
		try{
			if (parts[2] != null){
			System.out.println("Warning: last name has more than" 
					+" one space allowed. Please check the file next time.");
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			return parts;
		}
		return parts;
	}
}
