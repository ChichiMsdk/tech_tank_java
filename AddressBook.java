import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

public class AddressBook {

    public static void main(String[] args) {
		if (args.length != 1) {
			System.out.println("Usage: java HelloWorld <filename> <name1>"+ 
					"<name2> names are optional");
			return;
		}
		List<People> person = new ArrayList<>();
		try { 
			List<String> lines = Files.readAllLines(Paths.get(args[0]));
			for (String line : lines) {
				String[] parts = line.split(",");
				person.add(new People(parts[0], parts[1], parts[2]));
			}
		}
		catch (IOException e) {
			System.out.println("Error reading file: "
					+ args[0] + " " + e.getMessage());
			return;
		}
		//trying to make everything in one loop
		int maleCount = 0;
		int femaleCount = 0;
		int i;
		People oldest = person.get(0);
		for (i = 0; i < person.size(); i++) {
			if (i > 0){
				if (person.get(i).getDate().isBefore(person.get(i-1)
							.getDate())){
					oldest = person.get(i);
				}
			}
			if (person.get(i).getMales() == 1){
				maleCount++;
			}
		}
		femaleCount = i - maleCount;
		printAnswers(femaleCount, maleCount, oldest);
    }

	public static void printAnswers(int femaleCount, int maleCount, 
			People oldest){
		System.out.println("The oldest person is " + oldest.getFullName());
		System.out.println("There are " + maleCount + " male(s) and "
				+ femaleCount + " female(s)");

	}
}
