public class People {

	private String name;
	private String lastName;
	private String sex;
	private String age;
	private int	date;
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
