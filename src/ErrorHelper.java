/**
 * The {@code ErrorHelper} class is used to keep track of the errors that
 * occur during the<br> execution of the program. It is an attempt to make actions
 * upon errors happening.
 */
public class ErrorHelper{
	
	private static int errorCheck = 0;
	private static int warningCount = 0;
	public static final String ERROR_MSG = "Error occured.";
	public static final String WRNG_COUNT = " warning(s).";
	/**
	 * {@code flagError} is useful when to check when out of scope.
	 */
	public static void flagError(){
		ErrorHelper.errorCheck += 1;
		System.err.println(ErrorHelper.ERROR_MSG + " Flagged.");
	}
	/**
	 * {@code flagWarning}<br>
	 * A warning is not as serious as an error, but it is still important to 
	 * have an idea on how many happened without having to print them all.
	 */
	public static void flagWarning(){
		ErrorHelper.warningCount += 1;
		if (warningCount >= 10){
			System.err.println(ErrorHelper.WRNG_COUNT);
		}
	}
	/**
	 * {@code resetError} is used after taking care of the error or 
	 * atleast being aware of it.
	 */
	public static void resetError(){
		ErrorHelper.errorCheck = 0;
	}
	/**
	 * {@code getErrorCheck} check if there is still an error.
	 * @return the errorCheck
	 */
	public static int getErrorCheck(){
		return ErrorHelper.errorCheck;
	}
	/**
	 * {@code getWarningCount} prints the number of warnings at the end.
	 */
	public static void getWarningCount(){
		if (warningCount >= 1){
			System.err.println(ErrorHelper.WRNG_COUNT);
		}
	}
}
