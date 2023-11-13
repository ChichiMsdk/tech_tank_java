import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Comparator;

public class People {

	private String name;
	private String lastName;
	private String sex;
	private String age;
	private	LocalDate realAge;
	private int	gender;
	private String fullName;
	public People (String fullName, String sex, String age){
		this.fullName = fullName;
		String[] nameParts = fullName.split(" ");
		this.name = nameParts[0];
		this.lastName = nameParts[1];
		this.sex = sex.split(" ")[1];
		this.age = age.split(" ")[1];
		this.gender = changeSex();
	}
	public int getMales(){
		return gender;
	}
	//maybe this is faster to compare rather than strings every time? idk
	public int changeSex(){
		if (sex.compareTo("Male") == 0)
			return 1;
		if (sex.compareTo("Female") == 0)
			return 2;
		else
			return 0;
	}
	public void	setRealAge(){
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yy");
		try{
			realAge = LocalDate.parse(age, format);
		}
		catch (DateTimeParseException e){
			System.out.println("Error parsing date: " + e.getMessage());
			return;
		}
		realAge = parseDate(realAge);
	}
	private static LocalDate parseDate(LocalDate date){
		if (date == null)
			return null;
		if (date.getYear() > 2023)
			date = date.minusYears(100);
		return date;
	}
	public LocalDate getRealAge(){
		return realAge;
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
	public String getGender(){
		return sex;
	}
	public String getAge(){
		return age;
	}
}
