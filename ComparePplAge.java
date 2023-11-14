public class ComparePplAge{

	private static People[] pplCompare = new People[2]; 
	private static String[] pplNames = new String[2];
	private static long daysOlder;

	public static void setPplCompare(String[] dArgs) {
		ComparePplAge.pplCompare[0] = Human.getPeople(dArgs[0]);
		ComparePplAge.pplCompare[1] = Human.getPeople(dArgs[1]);
		setPplNames();
		setDaysOlder();
	}
	public static void setPplNames() {
		ComparePplAge.pplNames[0] = pplCompare[0].getFullName();
		ComparePplAge.pplNames[1] = pplCompare[1].getFullName();
	}

	public static void setDaysOlder() {
		ComparePplAge.daysOlder = Human.compareDays(pplCompare[0], pplCompare[1]);
	}

	public static String[] getOlder(String[] dArgs){
		String[] older = new String[2];
		ComparePplAge.setPplCompare(dArgs);
		older = ComparePplAge.getPplNames();
		return older;
	}

	public People[] getPplCompare() {
		return pplCompare;
	}

	public static String[] getPplNames() {
		return pplNames;
	}

	public static long getDaysOlder() {
		return daysOlder;
	}
}
