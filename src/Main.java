import java.util.Scanner;

public class Main {
    Scanner scan = new Scanner(System.in);

    Main(){
        selectAccount();
    }

    private void selectAccount() {
        int choice = 0;
        do{
            System.out.println("===========================");
            System.out.println("Choose Account:");
            System.out.println("1. Client");
            System.out.println("2. Admin");
            System.out.println("0. Exit");
            System.out.print(">> ");
            choice = scan.nextInt();
            scan.nextLine();
            switch(choice){
                case 1:
                    clientMenu();
                    break;
                case 2:
                    adminMenu();
                    break;
                case 3:
                    System.exit(0);
            }
        }while(choice < 1 || choice > 2);
    }

    private void adminMenu() {
        // Add Car
        // Remove Car
        // View All Cars

    }

    private void clientMenu() {
        // Buy Car
        // View All Cars
    }

    public static void main(String[] args) {
        new Main();
    }
}