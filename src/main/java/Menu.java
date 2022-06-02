import CommandPattern.CommandManager;
import CommandPattern.CommandOperations;
import CommandPattern.InformationModifier;

import java.util.Scanner;

public class Menu {
    private static Menu instance;

    private Menu(){}

    public static Menu getInstance(){
        if(instance == null){
            instance = new Menu();
        }
        return instance;
    }


    static int choice;
    static Scanner input = new Scanner(System.in);

    public static void menu() {
        System.out.println("======================================================");
        System.out.println("*            Hotel Management System                 *");
        System.out.println("======================================================");
        System.out.println("* 1. View all rooms                                  *");
        System.out.println("* 3. Display Empty rooms                             *");
        System.out.println("* 2. Guest management                                *");
        System.out.println("* 3. Display Empty rooms                             *");
        System.out.println("* 4. Display Room information                        *");
        System.out.println("* 5. Find room from customer name                    *");
        System.out.println("* 7. Get guest note                                  *");
        System.out.println("* 6. Display costumer information                    *");
        System.out.println("* 8. Display the names of the first 3 customers      *");
        System.out.println("* 9. Quit Program                                    *");
        System.out.println("======================================================");
        System.out.println("");

        System.out.println("Choose one of the options from above.");

        do {
            System.out.println();
            System.out.print("Choice : ");
            choice = input.nextInt();

            switch (choice) {

                case 1:
                    break;
                case 2:
                    System.out.print("Enter the information you want to modify (eg. checkin/checkout)");
                    String command = input.nextLine();
                    InformationModifier info = new InformationModifier(new CommandManager(new CommandOperations(),command));
                    info.setCommand(new CommandManager(new CommandOperations(),command));
                    info.execute();
                    break;

                case 3:
                    break;

                case 4:
                    break;

                case 5:
                    break;

                case 6:
                    break;

                case 7:
                    break;

                case 8:

                    break;
                default:
                    System.out.println("Invalid input! Please Enter one of these characters: 1,2,3,4,5,6,7,8");
            }
        }
        while ((choice == 1 || choice == 2 || choice == 3 || choice ==4 ||
                choice == 5 || choice == 6 || choice == 7 || choice == 8
                ));
    }
}