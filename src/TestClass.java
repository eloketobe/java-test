import java.util.*;


public class TestClass {
    private static final int EMPLOYED_VALUE = 1;
    private static final int SELF_EMPLOYED_VALUE = 2;
    private static final int RESTART_VALUE = 1;
    private static final int QUIT_VALUE = 2;
    private static final int ERROR_CHECKING_VALUE = 1;
    private static final int LOOP_COUNTER_VALUE = 1;
    private static int restartChoice;


    public static void main(String[] args) {
        //Initialized so it can satisfy the while loop at the first run
        restartChoice = RESTART_VALUE;


        //Changed it to a while loop for better readability
        while (restartChoice == RESTART_VALUE) {
            runProgram();
        }

        // This only runs if the while loop is exited
        quitProgram();


    }


    private static void runProgram() {

        Scanner read = new Scanner(System.in);


        //name input section
        System.out.println("Enter your first and last names");
        String name = read.nextLine();
        printFirstName(name);

        //age input section

        int age = 0, errorChecker = ERROR_CHECKING_VALUE, loopCounter = LOOP_COUNTER_VALUE;

        outer:
        do {
            try {
                System.out.println("Enter your age");
                if (loopCounter > 1) {
                    read.nextLine();
                }
                age = read.nextInt();
                if (age < 1) {
                    System.out.println("Your input must be greater then zero");
                    continue outer;
                }
                errorChecker++;
            } catch (InputMismatchException exception2) {
                System.out.println("Please input a valid integer");
                loopCounter++;
            }
        } while (errorChecker == ERROR_CHECKING_VALUE);
        read.nextLine();

        checkAgeRange(age);

        int ans;

        //proffesion input section
        do {
            System.out.println("Are you Self employed or employed?\nEnter " + EMPLOYED_VALUE + " for employed and " + SELF_EMPLOYED_VALUE + " for self employed");
            ans = read.nextInt();
        } while (getProfession(ans).equals("again"));
        String prof = getProfession(ans);

        System.out.println("Alright got it");
        System.out.println("Scanning....");

        //waiting for 5 seconds
        waitFor5Secs();
        //information output
        System.out.println("To recap, your name is " + name + ", you are " + age + " years old and you are " + prof);

        boolean restartValueIsValid;


        do {
            System.out.println("Restart or Quit? \nEnter " + RESTART_VALUE + " to Restart and " + QUIT_VALUE + " to Quit");
            try {
                restartChoice = read.nextInt();
                if (restartChoice != RESTART_VALUE && restartChoice != QUIT_VALUE) {
                    System.out.println("Invalid input, try again");
                    restartValueIsValid = false;

                } else {
                    restartValueIsValid = true;

                }


            } catch (Exception exception) {
                System.out.println("Invalid input, try again");
                read.nextLine();

                restartValueIsValid = false;

            }

        } while (!restartValueIsValid);


    }

    public static void quitProgram() {
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

    private static void checkAgeRange(int ageInput) {

        if (ageInput <= 11) {
            System.out.println("You are an adolescent");
        } else if (ageInput <= 19) {
            System.out.println("You are a teenager");
        } else if (ageInput <= 30) {
            System.out.println("You are a young adult");
        } else if (ageInput > 30) {
            System.out.println("You are an adult");
        }
    }

}
