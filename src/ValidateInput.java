import java.util.Scanner;

/*****@Author: Linmei Mills*****/
public class ValidateInput {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String userContinue = "y";
		while (userContinue.equalsIgnoreCase("y")) {

			evaluationEntryNotEmpty(sc);

			System.out.println("Continue? (y/n): ");
			userContinue = sc.nextLine();
		}
		System.out.println("Goodbye!");
	}
	
	//Method purpose: evaluation the entry is not empty and calling validate methods.
	public static void evaluationEntryNotEmpty(Scanner sc) {
		String[] userInputData = { "name", "email", "phone number", "date" };
		for (int i = 0; i < userInputData.length; i++) {
			System.out.printf("Please enter a %s: %n", userInputData[i]);
			while (sc.hasNextLine()) {
				String dataInput = sc.nextLine();
				if (i == 0) {
					validateNames(sc, userInputData[i], dataInput);
					System.out.println();
				} else if (i == 1) {
					validateEmails(sc, userInputData[i], dataInput);
					System.out.println();
				} else if (i == 2) {
					validatePhoneNumber(sc, userInputData[i], dataInput);
					System.out.println();
				} else
					validateDate(sc, userInputData[i], dataInput);
				System.out.println();
				break;
			}
		}
	}

	//Method purpose:valideate names
	public static void validateNames(Scanner sc, String name, String dataInput) {
		char c = dataInput.charAt(0);
		if (dataInput.matches("[a-zA-Z ]+") && Character.isUpperCase(c) && dataInput.length() <= 30){
			System.out.printf("A valid %s! %n", name);
		} else {
			System.out.printf("Sorry, %s is invalid. %n", name);
		}
	}
	
	//Method purpose: valideate emails
	public static void validateEmails(Scanner sc, String email, String dataInput) {

		if (dataInput.matches("^[a-zA-Z0-9]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$")) {
			System.out.printf("A valid %s! %n", email);
		} else {
			System.out.printf("Sorry, %s is invalid. %n ", email);
		}
	}
	
	// Method purpose: valideate phone number
	public static void validatePhoneNumber(Scanner sc, String phoneNo, String dataInput) {
		
		if (dataInput.matches("^\\d{3}-\\d{3}-\\d{4}$")) {
			System.out.printf("A valide %s! %n", phoneNo);
		}
		else System.out.printf("Sorry, %s is invalid. %n", phoneNo);
	}
	
	//Method purpose: valideate date 
	public static void validateDate(Scanner sc, String date, String dataInput) {
		
		if (dataInput.matches("^(1[0-2]|0[1-9])/(3[01]|[12][0-9]|0[1-9])/[0-9]{4}$")) {
			System.out.printf("A valid %s! %n", date);
		} else {
			System.out.printf("Sorry, %s is invalid. %n ", date);
		}
	}
}


