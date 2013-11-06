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
      int memberCount = 0, memberAdd = 0;
      boolean accurateFile = true;

      MemberList memberList = new MemberList();

      // While loop to keep keep checking until theres an accurate file name
      // to load
      while (accurateFile) {
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

      Hat hat = new Hat(memberList);

      boolean testHat = true;
      while (testHat) {
         System.out.println("1) Get total names in the hat \n"
          + "2) Show what's in the hat \n"
          + "3) Shuffle the hat \n"
          + "4) Pull random person from hat \n"
          + "5) Exit");
         int choice = keyboard.nextInt();
         String flushBuffer = keyboard.nextLine();
         switch (choice) {
            case 1:
               System.out.println("The total names in the hat is: " + hat.getTotalNames());
               break;
            case 2:
               hat.showHat();
               break;
            case 3:
               hat.shuffle();
               System.out.println("The hat has been shuffled!");
               break;
            case 4:
               System.out.println("You picked: " + hat.pullRandomName().getName());
               break;
            case 5:
               testHat = false;
               break;

            default:
               System.out.println("You've enter default state");
         }
         System.out.println();
      }


      /*
       for(int i = 0; i < memberList.getTotalMembers(); i++) {
       System.out.println(memberList.getMember(i));
       }
       */
   }
}
