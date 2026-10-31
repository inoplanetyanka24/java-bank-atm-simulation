import java.util.Scanner;

public class ATMSim {
    public static void main(String[] args) {
        //Create a Scanner object to read inputs
        Scanner input = new Scanner(System.in);

        //Initialize the PIN, account balance, and menu variables
        int correctPIN = 4422;
        int enteredPIN = 0;
        double money = 100;
        int operation = 0;

        //Tracks whether the user has entered the correct PIN
        boolean accessGranted = false;

        //Display the bank's welcome message
        System.out.print("==========JAVA BANK==========");
        System.out.println();


        //PIN checking (5 times)
        for (int attempt = 0; attempt < 5; attempt++) {
            System.out.print("Enter your PIN: ");
            enteredPIN = input.nextInt();

            //Check whether the entered PIN matches the correct PIN
            if (enteredPIN == correctPIN) {
                System.out.println("Access granted.");

                //Grant access and stop asking for the PIN
                accessGranted = true;
                break;
            } else {
                System.out.println("Incorrect PIN!");
            }
        }

        //Display the ATM menu only if the user is authenticated
        if (accessGranted) {

            //Keep displaying the menu until the user chooses to exit
            do {
                System.out.println("1. Check Balance" +
                        "\n2. Deposit Money" +
                        "\n3. Withdraw Money" +
                        "\n4. Exit" +
                        "\n================================");

                //Read the operation
                System.out.print("Choose an operation: ");
                operation = input.nextInt();

                //Execute the selected operation
                switch (operation) {
                    case 1:
                        System.out.println("Your balance: " + money);
                        break;
                    case 2:
                        System.out.print("Enter the deposit amount: ");
                        double depositMoney = input.nextDouble();
                        if (depositMoney <= 0) {
                            System.out.println("Invalid amount.");
                        } else {
                            money += depositMoney;
                            System.out.println("Your new balance: " + money);
                        }
                        break;
                    case 3:
                        System.out.print("Enter the withdrawal amount: ");
                        double withdrawMoney = input.nextDouble();

                        // Validate the withdrawal amount
                        if (withdrawMoney <= 0) {
                            System.out.println("Invalid number.");
                        } else if (withdrawMoney > money) {
                            System.out.println("What a poor guy. You cannot withdraw that amount of money.");
                        } else{
                            money -= withdrawMoney;
                            System.out.println("Your new balance: " + money);
                        }
                        break;
                    case 4:
                        System.out.println("Good Bye!");
                        break;
                    default:
                        // Handle invalid menu selections
                        System.out.println("Invalid operation!");
                        break;
                }
            } while (operation != 4);
        }else{
            // Deny access if all five PIN attempts fail
            System.out.println("Too many incorrect attempts. Access denied.");
        }
        //Close the Scanner
        input.close();
    }
}
