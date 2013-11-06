/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Steven
 */
public class Hat {

   private MemberList memberList;
   private Member[] hat;
   private int mCount;
   private static final int DEFAULT_SIZE = 10;
   Random random = new Random();
   Scanner keyboard = new Scanner(System.in);

   public Hat(MemberList memberList) {
      hat = new Member[DEFAULT_SIZE];
      this.memberList = memberList;
      // Loop to build the "hat" of members
      for (int i = 0; i < memberList.getTotalMembers(); i++) {
         for (int j = 0; j < memberList.getMember(i).getMultiplier(); j++) {
            resizeIfNecessary();
            hat[mCount++] = memberList.getMember(i);
         }
      }
   }
   
   public Member pullRandomName() {
     // int randomPlace = random.nextInt(mCount);
     // Member randomMember = hat[randomPlace];
     // System.out.println("Place in the hat: " + randomPlace);
      
      Member randomMember = hat[random.nextInt(mCount)];
      return randomMember;
   }
   
   // Get the number of names in the hat
   public int getTotalNames() {
      if (mCount <= 0) {
         return 0;
      }
      else {
         return mCount;
      }
   }
   // Shuffles the hat a million times
   public void shuffle() {
      for (int i = 0; i < 1000000; i++) {
         int x = random.nextInt(mCount),
          y = random.nextInt(mCount);
         Member swapHolder;
         if (x != y) {
            swapHolder = hat[x];
            hat[x] = hat[y];
            hat[y] = swapHolder;
         }
      }
   }

   // Shows all the names/objects in the hat
   public void showHat() {
      int choice;
      String flushBuffer;
      boolean valid = true;
      while (valid) {
         System.out.println("Do you want to see 1) names only or 2) with multiplier? or 3) exit");
         choice = keyboard.nextInt();
         flushBuffer = keyboard.nextLine();
         if (choice == 1) {
            // major error: use mCount instead of hat.lenth because hat.length represents the size of the array and not all the memembers actualy in the array 
            for (int i = 0; i < mCount; i++) {
               System.out.println("Slot " + i + ": " + hat[i].getName());
            }
         }
         else if (choice == 2) {
            for (int i = 0; i < mCount; i++) {
               System.out.println("Slot " + i + ": " + hat[i]);
            }
         }
         else {
            valid = false;
         }
      }
   }

   private void resizeIfNecessary() {
      if (mCount == hat.length) {
         Member[] newHat = new Member[hat.length * 2];
         System.arraycopy(hat, 0, newHat, 0, mCount);
         hat = newHat;
      }
   }
}
