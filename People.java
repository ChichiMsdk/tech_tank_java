import java.time.LocalDate;
import java.util.List;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Comparator;
import java.time.Period;

public class People {

	private String fullName;
	private String name;
	private String lastName;
	private String genderString;
	private int	genderInt;
	private List<People> people;
	private String birthString;
	private	LocalDate birthDate;

	public People (String fullName, String genderString, String birthString,
			List<People> people){
		this.fullName = fullName;
		String[] nameParts = fullName.split(" ");
		this.name = nameParts[0];
		this.lastName = nameParts[1];
		this.genderString = genderString.split(" ")[1];
		this.birthString = birthString.split(" ")[1];
		setBirthDate();
		this.genderInt = setGenderToInt();
		this.people = people;
	}
	public int setGenderToInt() {
		if (genderString.compareTo("Male") == 0) {
			//"John is a <male>." rather than "John is a <Male>."
			genderString = "male";
			return 1;
		}
		if (genderString.compareTo("Female") == 0) {
			genderString = "female";
			return 2;
		} else {
			genderString = "N/A";
			return 0;
		}
	}
	private	void setBirthDate() {
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yy");
		try {
			birthDate = LocalDate.parse(birthString, format);
		} catch (DateTimeParseException e) {
			System.out.println("Error parsing date: " + e.getMessage());
			System.out.println("format should be: dd/mm/yy");
			System.exit(1);
		}
		birthDate = FileParser.parseDate(birthDate);
	}

	public int getMales() {
		int maleCount = 0;
		for ( int i = 0; i < people.size(); i++) {
			if (people.get(i).getGenderInt() == 1) {
				maleCount++;
			}
		}
		return maleCount;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}
	public String getFullName() {
		return fullName;
	}
	public String getName() {
		return name;
	}
	public String getLastName() {
		return lastName;
	}
	public int getGenderInt() {
		return genderInt;
	}
	public String getGenderString() {
		return genderString;
	}
	public String getBirthString() {
		return birthString;
	}
}
