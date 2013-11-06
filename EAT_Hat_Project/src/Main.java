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
      boolean accurateFile = true;

      MemberList memberList = new MemberList();
      
      // While loop to keep keep checking until theres an accurate file name
      // to load
      while(accurateFile) {
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
          + " Members! \n");
         accurateFile = false;
      }
      catch (IOException e) {
         System.out.println("Could not open the file "
          + fileName + "\n");
      }
      }
      
      for(int i = 0; i < memberList.getTotalMembers(); i++) {
         System.out.println(memberList.getMember(i));
      }
   }
}
