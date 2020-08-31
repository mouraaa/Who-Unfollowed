import java.io.*;
import java.util.*;
import java.nio.file.*; 

public class WhoUnfollowed {
   public static void main(String[] args) throws IOException {

      List<String> original_list = new LinkedList<>();
      List<String> afterwards_list = new LinkedList<>(); 

      changeDirectory();
      readData(original_list,afterwards_list);
		writeFile(afterwards_list);
   }

   //find the file and change directories
   public static void changeDirectory() {
      try {
         String sourceFile = ""; 
         String substring = "followed_by"; 
         File dir = new File("/Users/princeamrr/Downloads"); 
         File[] directoryListing = dir.listFiles(); 
         for (File child : directoryListing) { 
            if(child.getName().contains(substring)) { 
               sourceFile = child.getName();
               break;
            }
         }      
         File originalFile = new File("/Users/princeamrr/Downloads/" + sourceFile); 
         File newFile = new File("/Users/princeamrr/Desktop/Projects/Instagram Follower App/afterwards.csv"); 
         Files.copy(originalFile.toPath(),newFile.toPath()); 
         originalFile.delete();       
      }
      catch(Exception e) {
         System.out.println("Something is wrong with the file. Check if you downloaded the correct one");
         System.exit(0);
      }
   }

   public static void readData(List<String> original_list, List<String> afterwards_list) throws IOException {
      File original = new File("original.csv");
      File afterwards = new File("afterwards.csv");

      Scanner scanner1 = new Scanner(original);
      while(scanner1.hasNext()) {
         String data = scanner1.next(); 
         String[] names = data.split(","); 
         original_list.add(names[1]); 
      }

      Scanner scanner2 = new Scanner(afterwards);
      while(scanner2.hasNext()) {
         String data = scanner2.next();
         String[] names = data.split(",");
         afterwards_list.add(names[1]);
      }
      original_list.removeAll(afterwards_list); 
      System.out.println(original_list);
      afterwards.delete();
   }

   public static void writeFile(List<String> afterwards_list) throws IOException {
      PrintStream ps = new PrintStream("original.csv"); 
      for(int i = 0; i < afterwards_list.size(); i++) { 
         ps.println(i + "," + afterwards_list.get(i));
      }   
      ps.close();    
   }
}