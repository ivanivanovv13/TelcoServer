package serverPIK3;

public class APIKey {
	
	public static String getApiKey() {
		return "at_PKaxFh0nivQEMfz0ww78RpA6nTo5x";
	}

	public static String getHostIP() {
		try (java.util.Scanner s = new java.util.Scanner(new java.net.URL("https://api.ipify.org").openStream(),
				"UTF-8").useDelimiter("\\A")) {
			return s.next();
		} catch (java.io.IOException e) {
			System.out.println("error");
		}
		return null;
	}
}
