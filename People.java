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
	private String sex;
	private int	gender;
	private List<People> people;
	private String age;
	private	LocalDate date;

	public People (String fullName, String sex, String age, List<People> people){
		this.fullName = fullName;
		String[] nameParts = fullName.split(" ");
		this.name = nameParts[0];
		this.lastName = nameParts[1];
		this.sex = sex.split(" ")[1];
		this.age = age.split(" ")[1];
		setRealAge();
		this.gender = changeSex();
		this.people = people;
	}
	public int changeSex(){
		if (sex.compareTo("Male") == 0)
		{
			sex = "male";
			return 1;
		}
		if (sex.compareTo("Female") == 0)
		{
			sex = "female";
			return 2;
		}
		else
		{
			sex = "N/A";
			return 0;
		}
	}
	private	void	setRealAge(){
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yy");
		try{
			date = LocalDate.parse(age, format);
		}
		catch (DateTimeParseException e){
			System.out.println("Error parsing date: " + e.getMessage());
			System.out.println("format should be: dd/mm/yy");
			System.exit(1);
		}
		date = AddressBook.parseDate(date);
	}
	public LocalDate getDate(){
		return date;
	}
	public String getFullName(){
		return fullName;
	}
	public String getName(){
		return name;
	}
	public String getLastName(){
		return lastName;
	}
	public int getGender(){
		return gender;
	}
	public String getSex(){
		return sex;
	}
	public String getAge(){
		return age;
	}
	//there should be a better way to do this, not sure.. feels off
	public int getMales(){
		int maleCount = 0;
		for ( int i = 0; i < people.size(); i++){
			if (people.get(i).getGender() == 1)
				maleCount++;
		}
		return maleCount;
	}
}
