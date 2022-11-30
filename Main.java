import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Hi, what would you like to do?");
        char choice;

        do {
            System.out.println("1: Buy a computer");
            System.out.println("2: See my shopping cart");
		    System.out.println("3: Sort by order ID (Descending order)");
		    System.out.println("4: Sort by order price (Descending order)");
		    System.out.println("5: Quit");

            choice = input.nextLine().charAt(0);
            
            MarketSpace.getInstance().newProduct(choice);

        } while (choice != '5');



        
        

    }
}
