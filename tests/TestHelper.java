import org.junit.jupiter.api.Test;

import java.util.List;

public class TestHelper{
@Test
	public void testChangeGenderToInt(){
		int result = Helper.changeGenderToInt("Male","Monsieur Monsieur");
		assert result == 1 : "Expected 1, got " + result;

		result = Helper.changeGenderToInt("male","Monsieur Monsieur");
		assert result == 1 : "Expected 1, got " + result;

		result = Helper.changeGenderToInt("female","Monsieur Monsieur");
		assert result == 2 : "Expected 2, got " + result;

		result = Helper.changeGenderToInt("female","Monsieur Madame");
		assert result == 2 : "Expected 2, got " + result;

		result = Helper.changeGenderToInt("emale", "???");
		assert result == 0 : "Expected 0, got " + result;

		result = Helper.changeGenderToInt("Emale", "???");
		assert result == 0 : "Expected 0, got " + result;

		result = Helper.changeGenderToInt("", "???");
		assert result == 0 : "Expected 0, got " + result;
	}
	/**
	@Test
	public void testInitListAndParsing(){
		String[] args = { "C:\\Users\\chiha\\Desktop\\moiquicodedesfonctions\\tech_tank\\tests\\TestAddressBook.java",
				"Bill", "Paul"};
		String[] dArgs = {"Bill", "Paul"};
		HumanMap humanMap = new HumanMap();
		List<People> peopleList = Helper.initListAndParsing(args,
				dArgs, humanMap);
		assert peopleList.isEmpty() : "Expected 0, got " + peopleList.size();

		args = new String[0];
		peopleList = Helper.initListAndParsing(args, 
				dArgs, humanMap);
		assert peopleList.isEmpty() : "Expected 0, got " + peopleList.size();

	}
	**/
}
