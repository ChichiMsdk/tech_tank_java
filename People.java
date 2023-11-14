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
	private String birthString;
	private	LocalDate birthDate;

	public People (String fullName, String genderString, String birthString){
		String[] nameParts = AddressBook.nameSplit(fullName);
		this.name = nameParts[0];
		this.lastName = nameParts[1];
		this.fullName = nameParts[0] + " " + nameParts[1];
		this.genderString = genderString.split(" ")[1];
		this.birthString = birthString.split(" ")[1];
		setBirthDate();
		this.genderInt = changeGenderToInt();
	}
	public int changeGenderToInt() {
		if (genderString.compareTo("Male") == 0) {
			return 1;
		}
		if (genderString.compareTo("Female") == 0) {
			return 2;
		} else {
			return 0;
		}
	}
	private	void setBirthDate() {

		this.birthDate = FileParser.formatDate(birthString);
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
