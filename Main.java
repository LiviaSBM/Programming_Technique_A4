public class main {
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
            
            switch (choice) {
                case '1':
                    // TODO
                    break;
                case '2':
                    // TODO
                    break;
                case '3':
                    // TODO
                    break;
                case '4':
                    // TODO
                    break;
                case '5':
                    System.out.println("It was a pleasure doing business with you!");
                    break;
                default:
                    System.out.println("Please enter a valid option.");
                    
                }



        } while (choice != '5');


        // add components
        Component mouse = new Component("Mouse", "Wireless mouse", 20.00, "1");
        Component keyboard = new Component("Keyboard", "Wireless keyboard", 30.00, "2");
        Component monitor = new Component("Monitor", "24 inch monitor", 200.00, "3");
        Component cpu = new Component("CPU", "Intel i7", 500.00, "4");

        // add components to computer
        Computer c1 = new ComputerDecorator("PC1", 5000.00, 2);
        Computer c2 = new ComputerDecorator("PC2", 6000.00, 1);
        Computer c3 = new ComputerDecorator("PC3", 7000.00, 3);


        //add to marketspace
        MarketSpace marketSpace = new MarketSpace();
        marketSpace.cart.add(c1);
        marketSpace.addProductToComputer(c1, mouse);
        marketSpace.addProductToComputer(c1, keyboard);
        marketSpace.cart.add(c2);
        marketSpace.addProductToComputer(c2, monitor);
        marketSpace.cart.add(c3);
        marketSpace.addProductToComputer(c3, cpu);

        // Checkout
        marketSpace.computerCheckout(c1);
        System.out.println();
        marketSpace.computerCheckout(c2);
        System.out.println();
        marketSpace.computerCheckout(c3);


        System.out.println("\n\nTest Sortings: ");
        System.out.println("Original Cart Order: ");
        for (Computer computer : marketSpace.cart) {
            System.out.println(computer.getDescription() + " " + computer.getPrice());
        }

        //sort by price inverse
        marketSpace.sortByPrice(false);

        System.out.println("\nSorted by price inverse: ");
        for (Computer computer : marketSpace.cart) {
            System.out.println(computer.getDescription() + " $" + computer.getPrice());
        }


        System.out.println("\nCurrent Cart Order: ");
        for (Computer computer : marketSpace.cart) {
            System.out.println(computer.getDescription() + " " + computer.getPrice() + " " + computer.getOrderId());
        }

        //sort by order id
        marketSpace.sortById(true);

        System.out.println("\nSorted by order id: ");
        for (Computer computer : marketSpace.cart) {
            System.out.println(computer.getDescription() + " " + computer.getPrice() + " " + computer.getOrderId());
        }

        marketSpace.sortById(false);
        System.out.println("\nSorted by order id inverse: ");
        for (Computer computer : marketSpace.cart) {
            System.out.println(computer.getDescription() + " " + computer.getPrice() + " " + computer.getOrderId());
        }

        System.out.println("\n\nTest Remove: ");
        System.out.println("Original Cart Order: \n");
        for (Computer computer : marketSpace.cart) {
            //checout
            marketSpace.computerCheckout(computer);
        }

        marketSpace.removeFromCart(c1);
        System.out.println("\nRemove PC1: ");
        for (Computer computer : marketSpace.cart) {
            //checkout
            marketSpace.computerCheckout(computer);
        }


    }
}
