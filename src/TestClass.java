import java.util.*;


public class TestClass {
    public static void main(String[] args) {
        int choice;
        do {
            Scanner read = new Scanner(System.in);
            //name input section
            System.out.println("Enter your first and last names");
            String name = read.nextLine();
            nameMethod(name);

            //age input section
            System.out.println("Enter your age");
            int age = read.nextInt();
            int ans;

            //proffesion input section
            do {
                System.out.println("Are you Self employed or employed?\nEnter 1 for employed and 2 for self employed");
                ans = read.nextInt();
            } while (profession(ans) == "again");
            String prof = profession(ans);

            System.out.println("Alright got it");
            System.out.println("Scanning....");

            //waiting for 5 seconds
            timeWait();
            //information output
            System.out.println("To recap, your name is " + name + ", you are " + age + " years old and you are " + prof);


            do {
                System.out.println("Restart or Quit? \nEnter 1 to Restart and 2 to Quit");
                choice = read.nextInt();
                if (choice != 1 && choice != 2)
                    System.out.println("Invalid input, try again");

            } while (choice != 1 && choice != 2);
        } while (choice == 1);
        System.out.println("Good bye");
    }
    
    //5 seconds delay method
    private static void timeWait() {
        try {
            Thread.sleep(5000);

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    //profession method
    private static String profession(int p) {
        if (p == 1) {
            return "employed";
        } else if (p == 2) {
            return "Self employed";
        } else
            System.out.println("Invalid input try again");
        return "again";
    }

    //name method
    private static void nameMethod(String n) {
/*        The following two lines of code is one way to print only the first name entered
        Scanner firstN = new Scanner(n);
        System.out.println("Welcome " + firstN.next());
*/
        String[] nameArray = n.split(" ");
        System.out.println("Welcome " + nameArray[0]);

    }

    ;
}
