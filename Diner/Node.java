public class Node {

   boolean question;
   String data;
   Node yes, no;
  
   public Node(String n, boolean q) {
      data = n;
      yes = null;
      no = null;
      question = q;
   }

}