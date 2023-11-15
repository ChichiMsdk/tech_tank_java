import java.time.LocalDate;
import java.util.List;

/**
 * {@code People} class is a class that contains information of a person
 *<p> This class contains the following information:
 *<ul>
 *<li>full name</li>
 *<li>name</li>
 *<li>LastName</li>
 *<li>age</li>
 *<li>birthDate</li>
 *
 */

public class People {

	//maybe make an array for the names ?
	private String 		fullName;
	private String 		name;
	private String 		lastName;
	private String 		genderString;
	private int			genderInt;
	private String 		birthString;
	private	LocalDate 	birthDate;
	private int 		age;

	public People (String fullName, String genderString, String birthString) {
		String[] nameParts = ParserHelper.splitName(fullName);
		this.name = nameParts[0];
		this.lastName = nameParts[1];
		this.fullName = nameParts[0] + " " + nameParts[1];
		this.genderString = genderString;
		this.birthString = birthString;
		setBirthDate();
		this.genderInt = Helper.changeGenderToInt(this.genderString,
				this.fullName);
		setAge();
	}

	private void setAge() {
		this.age = HelperDate.getAge(this.birthDate);
	}

	private	void setBirthDate() {
		//probably better to do while parsing..
		this.birthDate = HelperDate.formatDate(birthString);
	}

	public int getAge() {
		return age;
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
