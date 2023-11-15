/**
 * The {@code ErrorHelper} class is used to keep track of the errors that
 * occur during the<br> execution of the program. It is an attempt to make actions
 * upon errors happening.
 */
public class ErrorHelper{
	
	private static int errorCheck = 0;
	public static final String ERROR_MSG = "Error occured.";
	
	/**
	 * The {@code flagError} is used to flag an error when it occurs.
	 * so I can check when out of scope.
	 */
	public static void flagError(){
		ErrorHelper.errorCheck += 1;
		System.err.println(ErrorHelper.ERROR_MSG + " Flagged.");
	}

	/**
	 * The {@code resetError} is used after taking care of the error or 
	 * atleast being aware of it.
	 */
	public static void resetError(){
		ErrorHelper.errorCheck = 0;
	}

	/**
	 * The {@code getErrorCheck} is used to check if there is an error
	 * that has not been taken care of.
	 * @return the errorCheck
	 */
	public static int getErrorCheck(){
		return ErrorHelper.errorCheck;
	}
}
