import java.util.*;


public class TestClass {
    private static final int RESTART_OPTION = 1;
    private static final int EMPLOYMENT_OPTION = 2;
    private static final int EMPLOYED_VALUE = 1;
    private static final int SELF_EMPLOYED_VALUE = 2;
    private static final int RESTART_VALUE = 1;
    private static final int QUIT_VALUE = 2;
    private static int restartChoice;
    private static Scanner read = new Scanner(System.in);

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

        //name input section
        System.out.println("Enter your first and last names");
        String name = read.nextLine();
        printFirstName(name);

        //age input section

        int age = 0;
        String promptMessage = "Enter your age";
        age = checkForInputtedInteger(age, promptMessage);
        checkAgeRange(age);

        int ans = 0;
        promptMessage = "Are you Self employed or employed?\nEnter " + EMPLOYED_VALUE + " for employed and " + SELF_EMPLOYED_VALUE + " for self employed";
        ans = checkForInputtedInteger(ans, promptMessage, EMPLOYMENT_OPTION);
        String profession = getProfession(ans);

        System.out.println("Alright got it");
        System.out.println("Scanning....");

        //waiting for 5 seconds
        waitFor5Secs();
        //information output
        System.out.println("To recap, your name is " + name + ", you are " + age + " years old and you are " + profession);


        promptMessage = "Restart or Quit? \nEnter " + RESTART_VALUE + " to Restart and " + QUIT_VALUE + " to Quit";
        restartChoice = checkForInputtedInteger(restartChoice, promptMessage, RESTART_OPTION);

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

    private static int checkForInputtedInteger(int requiredInput, String requiredPromptMessage, int inputOption) {
        boolean requiredInputIsValid = false;


        outer:
        do {
            System.out.println(requiredPromptMessage);
            try {

                requiredInput = read.nextInt();
                //requiredInputIsValid = true;
                if (inputOption == EMPLOYMENT_OPTION) {
                    if (requiredInput != EMPLOYED_VALUE && requiredInput != SELF_EMPLOYED_VALUE) {
                        System.out.println("Invalid input, try again");
                        continue outer;
                    } else {

                        read.nextLine();

                    }
                    requiredInputIsValid = true;
                } else if (inputOption == RESTART_OPTION) {
                    if (requiredInput != RESTART_VALUE && requiredInput != QUIT_VALUE) {
                        System.out.println("Invalid input, try again");
                        continue outer;
                    } else {

                        read.nextLine();

                    }
                    requiredInputIsValid = true;
                }


            } catch (InputMismatchException exception) {
                System.out.println("Invalid Input, try again");
                read.nextLine();
                requiredInputIsValid = false;
            }
        } while (!requiredInputIsValid);

//        while (getProfession(requiredInput).equals("again"));
        return requiredInput;

    }

    private static int checkForInputtedInteger(int requiredInput, String requiredPromptMessage) {
        boolean requiredInputIsValid;

        do {
            System.out.println(requiredPromptMessage);
            try {

                requiredInput = read.nextInt();
                requiredInputIsValid = true;
                if (requiredInput < 1) {
                    System.out.println("Your input must be greater then zero");
                    requiredInputIsValid = false;

                }
            } catch (InputMismatchException exception) {
                System.out.println("Invalid Input, try again");
                read.nextLine();
                requiredInputIsValid = false;
            }
        } while (!requiredInputIsValid);
        return requiredInput;

//        while (getProfession(requiredInput).equals("again"));

    }


}
