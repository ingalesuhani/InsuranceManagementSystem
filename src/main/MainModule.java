package main;
import dao.IPolicyService;
import dao.InsuranceServiceImpl;
import entity.Policy;
import java.util.List;
import java.util.Scanner;

public class MainModule {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        IPolicyService service = new InsuranceServiceImpl();

        System.out.println(" Welcome to the Insurance Policy Manager!");

        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Add New Policy");
            System.out.println("2. Find Policy by ID");
            System.out.println("3. Show All Policies");
            System.out.println("4. Update Policy");
            System.out.println("5. Delete Policy");
            System.out.println("6. Exit");

            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter Policy ID, Name, and Coverage:");
                    Policy p1 = new Policy(sc.nextInt(), sc.next(), sc.nextDouble());
                    System.out.println(service.createNewPolicy(p1) ? " Policy added." : " Couldn't add policy.");
                    break;
                case 2:
                    System.out.print("Enter Policy ID: ");
                    Policy found = service.findPolicyById(sc.nextInt());
                    System.out.println(found != null ? found : " Policy not found.");
                    break;
                case 3:
                    System.out.println("Fetching all policies...");
                    List<Policy> all = service.fetchAllInsurancePlans();
                    if (all.isEmpty()) {
                        System.out.println(" No policies found.");
                    } else {
                        all.forEach(System.out::println);
                    }
                    break;
                case 4:
                    System.out.println("Enter ID, New Name, and New Coverage:");
                    Policy p2 = new Policy(sc.nextInt(), sc.next(), sc.nextDouble());
                    System.out.println(service.updateExistingPolicy(p2) ? " Updated!" : " Update failed.");
                    break;
                case 5:
                    System.out.print("Enter Policy ID to delete: ");
                    System.out.println(service.removePolicy(sc.nextInt()) ? " Deleted." : " Deletion failed.");
                    break;
                case 6:
                    System.out.println(" Bye! Thanks for using the manager.");
                    sc.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println(" Invalid choice. Try again.");
            }
        }
    }
}
