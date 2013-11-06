/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Steven
 */
public class Main {

   public static void main(String[] args) {

      Scanner keyboard = new Scanner(System.in);
      String fileName;
      int memberCount = 0;

      MemberList memberList = new MemberList();
      
      System.out.println("What is the member list file name?");
      fileName = keyboard.nextLine();
      
      
      // Method to add member (names/multiplier) to a member list
      try {
         MemberLoader memberLoader = new MemberLoader(fileName);
         Member newMember = memberLoader.readNextMember();
         while (newMember != null) {
            memberList.add(newMember);
            memberCount++;
            newMember = memberLoader.readNextMember();
         }
         System.out.println("Loaded " + memberCount
          + " recipes! \n");
      }
      catch (IOException e) {
         System.out.println("Could not open the file "
          + fileName);
      }
      
      
   }
}
