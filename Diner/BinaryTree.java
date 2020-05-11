import java.util.Scanner;

public class BinaryTree{
 
   Node root;
   Node peek; 
   Node current;
   Scanner peek; 
   Scanner current;

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
           while (peek is question) {
              ask the question (current.data)
              get answer from file or user; <-- orginal answer
              traverse peek to answer
              check if peek is a question --> boolean in node
              if true --> current = peek;
              if false --> end while -- keep track of the path answer;
            }
            ask the question "Is this the food you were thinking of";
            get answer from file or user;
            if yes, then done, ask if you want to play again.
            if no
           
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

}