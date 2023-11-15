import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
/**
 * The {@code HumanMap} class is used to initialize, store the {@code People}
 * objects in map. The goal is to retrieve the {@code People} object from the
 * map using the name directly.
 *
 */

public class HumanMap {

	private Map<String, People> peopleMap;
	private List<People> peopleList;
	
	public HumanMap(){
		this.peopleMap = new HashMap<>();
		this.peopleList = new ArrayList<>();
	}

	public void initPeopleFromLines(List<String> lines){
		for (String line : lines) {
			String[] parts = ParserHelper.splitFields(line);
			if (parts != null){
				this.peopleList.add(new People(parts[0], parts[1],
							parts[2]));
			}
		}
	}

	public void addPeopleToMap(List<People> peopleList){
		if (!peopleList.isEmpty()){
			for (People p : peopleList){
				this.peopleMap.put(p.getFullName(), p);
				this.peopleMap.put(p.getName(), p);
				this.peopleMap.put(p.getLastName(), p);
			}
		} else {
			ErrorHelper.flagWrng("Error: no people to add to map", 
					ErrorHelper.getVerbose());
		}
	}

	public List<People> getPeopleList(){
		return this.peopleList;
	}

	public People getPeopleByNames(String name, HumanMap humanMap){
		People people = humanMap.peopleMap.get(name);
		if (people == null){
			return null;
		}
		return people;
	}

	public int getAge(String name, HumanMap humanMap){
		return getPeopleByNames(name, humanMap).getAge();
	}
}
