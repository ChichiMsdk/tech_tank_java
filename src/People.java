import java.time.LocalDate;
public class People {

	//maybe make an array for the names ?
	private final String fullName;
	private final String name;
	private final String lastName;
	private String genderString;
	private final int genderInt;
	private final String birthString;
	private LocalDate birthDate;
	private int age;

	public People(String genderString, String birthString,
				  String name, String lastName) {
		this.name = name;
		this.lastName = lastName;
		this.fullName = name + " " + lastName;
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

	private void setBirthDate() {
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
}
