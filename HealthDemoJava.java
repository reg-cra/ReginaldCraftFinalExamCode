// Reginald Craft
import java.util.Scanner;
public class HealthDemoJava {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("Enter the name of the patient:");
            String name = scanner.nextLine();
//This will be where you enter the health insurance and the program will check based on what you enter whether it is valid.
            System.out.println("Enter the name of the health insurance provider:");
            String insuranceProvider = scanner.nextLine();

            patient1 patient = new patient1(name, insuranceProvider, 0);
//This is where you enter the type of medical emergency you are visiting for
            System.out.println("ID\tName of Lab Test");
            System.out.println("1\tX-rays");
            System.out.println("2\tAllergy Testing");
            System.out.println("3\tCholesterol");
            System.out.println("4\tVitamin D");
            System.out.println("5\tIron Profile");

            double totalCost = 0;
            int labTestId;

            do {
                System.out.println("From the list above, select one or more lab tests.");
                System.out.println("Enter the lab test ID and enter a negative value once done:");
                labTestId = scanner.nextInt();
//This informs  you of the prices based on which number is picked 
                if (labTestId > 0 && labTestId <= 5) {
                    // Accumulate the cost of selected lab tests
                    switch (labTestId) {
                        case 1:
                            totalCost += 595;
                            break;
                        case 2:
                            totalCost += 560;
                            break;
                        case 3:
                            totalCost += 572;
                            break;
                        case 4:
                            totalCost += 585;
                            break;
                        case 5:
                            totalCost += 67;
                            break;
                        default:
                            break;
                    }
                }

            } while (labTestId > 0);

            patient.setCostBeforeTax(totalCost);
            patient.calculateTaxes();
            patient.calculateCopayAmount();
//This is where the final bill we be printed out at with all of the copay and the taxes.
            System.out.println("Final Bill:");
            patient.print();

            System.out.println("Do you want to enter a patient's data? Enter \"Yes\" or \"no\":");
            scanner.nextLine();
        } while (scanner.nextLine().equalsIgnoreCase("yes"));

        System.out.println("End of program!");
    }
}
