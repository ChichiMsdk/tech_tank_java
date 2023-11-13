public class HelloWorld {
    public static void main(String[] args) {
		if (args.length < 2)
		{
			System.out.println("Usage: java HelloWorld <example1> <example2>");
			return;
		}
        System.out.println("Hello, World!");
        System.out.println(args[0]);
        System.out.println(args[1]);
    }
}
