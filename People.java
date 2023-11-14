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
		this.fullName = fullName;
		String[] nameParts = fullName.split(" ");
		this.name = nameParts[0];
		this.lastName = nameParts[1];
		this.genderString = genderString.split(" ")[1];
		this.birthString = birthString.split(" ")[1];
		setBirthDate();
		setGenderToInt();
	}
	public void setGenderToInt() {
		if (genderString.compareTo("Male") == 0) {
			thsi.genderInt = 1;
		}
		if (genderString.compareTo("Female") == 0) {
			this.genderInt = 2;
		} else {
			genderString = "N/A";
			this.genderInt = 0;
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
