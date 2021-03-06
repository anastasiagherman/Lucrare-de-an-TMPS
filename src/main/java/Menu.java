import DatabaseOperation.SelectApartmentInfo;
import command.CommandManager;
import command.CommandOperations;
import command.InformationModifier;
import DatabaseOperation.SelectInfo;
import composite.AccommodationManager;
import pattern.strategy.decorator.IRoom;
import pattern.strategy.decorator.PersonalisedRoomFactory;
import pattern.strategy.NoDiscount;
import pattern.strategy.PercentageDiscount;
import pattern.strategy.PriceCalculator;
import pattern.strategy.PriceDiscount;

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
        System.out.println("* 1. View hotel information                          *");
        System.out.println("* 2. Guest management                                *");
        System.out.println("* 3. Display Room information                        *");
        System.out.println("* 4. Personalise a Room                              *");
        System.out.println("* 5. Find room from customer name                    *");
        System.out.println("* 6. Get guest note                                  *");
        System.out.println("* 7. Display costumer information                    *");
        System.out.println("* 8. Quit Program                                    *");
        System.out.println("======================================================");
        System.out.println("");

        System.out.println("Choose one of the options from above.");

        do {
            System.out.println();
            System.out.print("Choice : ");
            choice = input.nextInt();
            input.nextLine();

            switch (choice) {

                case 1:
                    AccommodationManager man = new AccommodationManager();
                    System.out.println("Choose info to display:\n 1.Rooms info\n 2.Apartments info\n 3.Accommodation info");
                    int choice2 = input.nextInt();
                    switch(choice2){
                        case 1:
                            System.out.println("Hotel Rooms info: ");
                            System.out.println(man.getRooms());
                            break;
                        case 2:
                            System.out.println("Hotel Apartments info: ");
                            System.out.println(man.getApartments());
                            break;
                        case 3:
                            System.out.println("Accommodation info: ");
                            System.out.println(man.getAccommodation());
                            break;
                        default:
                            System.out.println("Invalid option, please choose one of the available options");
                    }
                    break;
                case 2:
                    System.out.print("Enter the information you want to modify (eg. checkin/checkout)");
                    String command = input.nextLine();
                    InformationModifier info = new InformationModifier(new CommandManager(new CommandOperations(),command));
                    info.setCommand(new CommandManager(new CommandOperations(),command));
                    info.execute();
                    break;

                case 3:
                    System.out.print("Enter room number: ");
                    int roomNbr = input.nextInt();
                    SelectInfo inf = new SelectInfo();
                    System.out.println(inf.selectSpecificRoom(roomNbr));
                    break;

                case 4:
                    PersonalisedRoomFactory factory = new PersonalisedRoomFactory();
                    System.out.println("Enter the room number:");
                    int roomNr = input.nextInt();
                    input.nextLine();
                    System.out.println("Choose the features you want to add to the room");
                    System.out.println("MiniBar, Room Service, MiniBar and Room Service");
                    String roomFeatures = input.nextLine();
                    IRoom room = factory.createRoom(roomFeatures);
                    room.getRoom(roomNr);
                    break;

                case 5:
                    System.out.print("Enter guest name: ");
                    String guestName = input.nextLine();
                    //SelectApartmentInfo aptInfo = new SelectApartmentInfo();
                    //System.out.println(aptInfo.selectApartmentByName(guestName));
                    SelectInfo rInfo = new SelectInfo();
                    System.out.println(rInfo.selectRoomByName(guestName));

                    break;

                case 6:
                    System.out.println("Enter room price: ");
                    double price = input.nextDouble();
                    input.nextLine();
                    System.out.println("Enter nr of days: ");
                    int nrDays = input.nextInt();
                    input.nextLine();
                    System.out.println("Enter type of discount (no discount, percent discount, price discount): ");
                    String discountType = input.nextLine();
                    if (discountType.equalsIgnoreCase("percent discount")){
                        System.out.println("Enter discount percent: ");
                        int percent = input.nextInt();
                        input.nextLine();
                        PriceCalculator note = new PriceCalculator();
                        note.setStrategy(new PercentageDiscount(percent));
                        note.calculatePrice(price,nrDays);
                        System.out.println("The guest has to pay: " + note.executeStrategy(note.getPrice()));
                    }
                    else if(discountType.equalsIgnoreCase("price discount")){
                        System.out.println("Enter discount amount: ");
                        double discountAmount = input.nextDouble();
                        PriceCalculator note = new PriceCalculator();
                        note.setStrategy(new PriceDiscount(discountAmount));
                        note.calculatePrice(price, nrDays);
                        System.out.println("The guest has to pay: " + note.executeStrategy(note.getPrice()));
                    }
                    else if(discountType.equalsIgnoreCase("no discount")){
                        PriceCalculator note = new PriceCalculator();
                        note.setStrategy(new NoDiscount());
                        note.calculatePrice(price, nrDays);
                        System.out.println("The guest has to pay: " + note.executeStrategy(note.getPrice()));
                    }
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
