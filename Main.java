import java.util.LinkedList;
import java.util.Scanner; 

class Main {
  public static void main(String[] args) {
    //initalizes user's to-do list
    LinkedList<String> list = new LinkedList<>();

    System.out.println("Hello, welcome to your to-do list!");
    
    Scanner scan = new Scanner (System.in); //scans user input
    String ans; // user input 
    String check; //checks if user wants to continue 

    System.out.println("What would you like to edit on your to-do list? \n Type 'Help' to see a list of commands.");
    ans=scan.nextLine();
    check=run(ans,list,scan);

    //continues program if user answers 'yes'
    while (!check.equals("no")){
      System.out.println("What would you like to edit on your to-do list? \n Type 'Help' to see a list of commands.");
      ans=scan.nextLine();
      check=run(ans,list,scan);
    }

  }
  
  //starting state conversation
  //returns:
  // -1 if user wants to end program
  // 0 if user wants to continue
  public static String run(String input, LinkedList list, Scanner scan){
    switch(input.toLowerCase()){
      case "help": 
        help();
        break;
      case "add":
        add(list, scan);
        break;
      case "remove":
        remove(list, scan);
        break;
      case "view":
        view(list);
        break;
      case "end":
        input="no";
        break;
      default:
        System.out.println("Sorry, I didn't catch that. Please try again.");
    }
    System.out.println("What would you to continue?");
    input = scan.nextLine();
    return input;
  }

  //prints out a list of commands 
  public static void help(){
    System.out.println("********Available Commands*******");
    System.out.println("To add an item, type 'add'.");
    System.out.println("To remove an item once done, type 'remove'.");
    System.out.println("To view your current to-do list, type 'view'.");
    System.out.println("To end this program, type 'end'.");
  }
  
  //adds an item to list
  public static void add(LinkedList list, Scanner scan){
    System.out.println("What would you like to add?");
    String item = scan.nextLine();
    list.add(item);
  }
  
  //removes an item from list
  public static void remove(LinkedList list, Scanner scan){
    System.out.println("What would you like to remove?");
    String item = scan.nextLine();
    list.remove(item);
  }

  //prints out current to-do list
  public static void view(LinkedList list){
    System.out.println("Your current to-do list:");
    System.out.println(list);
  }
}
