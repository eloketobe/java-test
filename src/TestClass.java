import java.util.*;


public class TestClass {
    private static final int EMPLOYED_VALUE = 1;
    private static final int SELF_EMPLOYED_VALUE = 2;
    private static final int RESTART_VALUE = 1;
    private static final int QUIT_VALUE = 2;
    public static void main(String[] args) {
        int restartChoice;
        do {
            Scanner read = new Scanner(System.in);
            //name input section
            System.out.println("Enter your first and last names");
            String name = read.nextLine();
            printFirstName(name);

            //age input section
            System.out.println("Enter your age");
            int age = read.nextInt();
            int ans;

            //proffesion input section
            do {
                System.out.println("Are you Self employed or employed?\nEnter " +EMPLOYED_VALUE+" for employed and " +SELF_EMPLOYED_VALUE+" for self employed");
                ans = read.nextInt();
            } while (getProfession(ans).equals("again"));
            String prof = getProfession(ans);

            System.out.println("Alright got it");
            System.out.println("Scanning....");

            //waiting for 5 seconds
            waitFor5Secs();
            //information output
            System.out.println("To recap, your name is " + name + ", you are " + age + " years old and you are " + prof);


            do {
                System.out.println("Restart or Quit? \nEnter " +RESTART_VALUE+ " to Restart and "  +QUIT_VALUE+ " to Quit");
                restartChoice = read.nextInt();
                if (restartChoice != RESTART_VALUE && restartChoice != QUIT_VALUE)
                    System.out.println("Invalid input, try again");

            } while (restartChoice != 1 && restartChoice != 2);
        } while (restartChoice == 1);
        System.out.println("Good bye");
    }
    
    //5 seconds delay method
    private static void waitFor5Secs() {
        try {
            Thread.sleep(5000);

        } catch (Exception errorMessage) {
            System.out.println(errorMessage);
        }
    }

    //profession method
    private static String getProfession(int professionInput) {
        if (professionInput == EMPLOYED_VALUE) {
            return "employed";
        } else if (professionInput == SELF_EMPLOYED_VALUE) {
            return "Self employed";
        } else
            System.out.println("Invalid input try again");
        return "again";
    }

    //name method
    private static void printFirstName(String enteredName) {

        String[] nameArray = enteredName.split(" ");
        System.out.println("Welcome " + nameArray[0]);

    }


}
