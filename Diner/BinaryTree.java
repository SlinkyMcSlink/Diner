import java.util.Scanner;

public class BinaryTree{
 
   Node root;
   Node peek; 
   Node current;
   Scanner fileScanner; 
   Scanner keyboard = new Scanner(System.in);

   public BinaryTree() {
      Node a = new Node("Does is have tomato sauce?", true);
      Node b = new Node("Pizza", false);
      Node c = new Node("Chicken Soup", false);
      
      root = a;
      a.yes = b;
      a.no = c;
      current = root;
   }

   public void traverse(boolean interactive) {
       boolean done = false;
       boolean orgAns = false;
       boolean placement = false;
       while(!done) {
           current = root;
           boolean doneski = false;
           while (!doneski) {
             // ask the question (current.data)
             say(current.data);

             // get answer from file or user; <-- orginal answer
             // traverse peek to answer
             String answer = keyboard.nextLine();
             if (answer.equalsIgnoreCase("yes")) {
                peek = current.yes;
                orgAns = true;
             }
             else if (answer.equalsIgnoreCase("no")) {
                peek = current.no;
                orgAns = false;
             }
             else {
                 say("Error occurred.");
                 System.exit(1);
             }
             // check if peek is a question --> boolean in node
             // if true --> current = peek;
             // if false --> end while -- keep track of the path answer;
             if(peek.question) {
                current = peek;
             }
             else {
                doneski = true;
             }


            }

          /*  ask the question "Is this the food you were thinking of";
            get answer from file or user;
            if yes, yay got it! ask if you want to play again (if yes --> "" if no --> done = true;).
            if no, ask what is food? ask what is question? ask where does the old food go in relation to the new question? 
                         add new question and answer in appropriate place
                       ask do you want to play again?(if yes --> "" if no --> done = true;).
           */ 
            say("Is " + peek.data + " the food you are thinking of?");
            answer = keyboard.nextLine();
             if (answer.equalsIgnoreCase("yes")) {
                say("Yay! I won! Do you want to play again?");
                if (answer.equalsIgnoreCase("yes")) {}
                else if (answer.equalsIgnoreCase("no")) {
                    done = true;
                }
                else {
                    say("Error occurred.");
                    System.exit(1);
                }
             }
             else if (answer.equalsIgnoreCase("no")) {
                say("What food are you thinking of?");
                String food = keyboard.nextLine();
                say("What question?");
                String question = keyboard.nextLine();

                say("What food are you thinking of?");
                String food = keyboard.nextLine();

                say("Where should " + peek.data + " go in relation to the new question?");
                answer = keyboard.nextLine();
                if (answer.equalsIgnoreCase("yes")) {
                    placement = true;
                }
                else if (answer.equalsIgnoreCase("no")) {
                    placement = false;
                }
                else {
                    say("Error occurred.");
                    System.exit(1);
                }
                
                addNode(food,question, orgAns, placement);

                say("Do you want to play again?");
                if (answer.equalsIgnoreCase("yes")) {}
                else if (answer.equalsIgnoreCase("no")) {
                    done = true;
                }
                else {
                    say("Error occurred.");
                    System.exit(1);
                }
             }
             else {
                 say("Error occurred.");
                 System.exit(1);
             }
       }
   }

   public void addNode(String f, String q, boolean origAns, boolean placement) {
      Node food = new Node(f, false);
      Node question = new Node(q, true);
      if( origAns ) { // If adding to yes side
         peek = current.yes;
         if (placement) {
            question.yes = peek;
            question.no = food;
            current.yes = question;
         }
         else {
            question.no = peek;
            question.yes = food;
            current.yes = question;
         }
      }
      else { // If adding to no side
         peek = current.no;
         if (placement) {
            question.yes = peek;
            question.no = food;
            current.yes = question;
         }
         else {
            question.no = peek;
            question.yes = food;
            current.yes = question;
         }
      }
   }

   public String inOrder(Node a) {
      if (a == null) {
         return "";
      }
      String s = "";

      s += inOrder(a.yes);
      s += a.data + " ";
      s += inOrder(a.no);

      return s;
   }

   public String toString() {
      return inOrder(root);
   }

   public void say(String a) {
      System.out.println(a);
   }

   public void debug(String a) {
      System.out.println(a);
   }

}