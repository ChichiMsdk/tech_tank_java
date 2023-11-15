/**
 * The {@code ErrorHelper} class is used to keep track of the errors that
 * occur during the<br> execution of the program. It is an attempt to make actions
 * upon errors happening.
 */
public class ErrorHelper{
	
	private static int errorCheck = 0;
	private static int warningCount = 0;
	private static boolean verbose = false;
	public static final String ERROR_MSG = "Error occured.";
	public static final String WRNG_COUNT = " warning(s).";

	/**
	 * {@code flagError} is useful when to check when out of scope.
	 */
	public static void flagError(){
		ErrorHelper.errorCheck += 1;
		flagWrng(ErrorHelper.ERROR_MSG + " Flagged.", getVerbose());
	}

	/**
	 * {@code flagWrng}<br>
	 * A warning is not as serious as an error, but it is still important to 
	 * have an idea on how many happened without having to print them all.
	 */
	public static void flagWrng(String msg, boolean verbose){
		ErrorHelper.warningCount += 1;
		if (verbose){
			System.err.println("Warning: "+ msg);
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
	 * {@code setVerbose} 
	 * Toggles the warning to be printed or not.
	 */
	public static void toggleVerbose(){
		ErrorHelper.verbose = true;
		System.err.println("Verbose is now " + ErrorHelper.verbose);
	}

	public static int getErrorCheck(){
		return ErrorHelper.errorCheck;
	}

	public static void getWarningCountEnd(boolean verbose){
		if(!verbose){
			return;
		}
		if (warningCount >= 1){
			System.err.println(ErrorHelper.warningCount 
					+ ErrorHelper.WRNG_COUNT);
		}
	}

	public static boolean getVerbose(){
		return ErrorHelper.verbose;
	}

}
