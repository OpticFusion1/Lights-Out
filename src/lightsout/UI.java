 

import java.util.Scanner;

/**
 *
 * @author David
 */
public class UI {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        run();
    }
    
    public static void run() {
        Scanner scan = new Scanner(System.in);
        int numLights = 0;

        boolean valid = false;
        while (!valid) {
            System.out.println("How many lights?");
            try {
                numLights = scan.nextInt();
            } catch (NumberFormatException e) {
                System.out.println("Please enter a number.");
            }
            if (numLights >= 3 && numLights <= 15) {
                valid = true;
            }
            else {
                System.out.println("Please enter a number between 3 and 15 (inclusive).");
            }
        }
        valid = false;
        LightsOut game = new LightsOut(numLights);

        System.out.print("\f");
        System.out.println(game);
        while (!game.isOver()) { 
            int move = -1;
            while (!valid) {
                System.out.println("Which light would you like to toggle?");
                try {
                    move = scan.nextInt();
                    valid = true;
                } catch (NumberFormatException e) {
                    System.out.println("Please enter a number within the bounds 0 and " + numLights);
                }
            }
            valid = false;
            
            game.move(move);
            
            System.out.print("\f");
            System.out.println(game);
        }
        
        System.out.println("You Win!\n\nWould you like to play again? (Y/N)");
        
        String choice = "";
        while (!valid) {
            choice = scan.nextLine();
            if (choice.equals("Y") || choice.equals("N")) valid = true;
        }
        if (choice.equals("Y")) {
            run();
        }
    }
}
