/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Steven
 */
public class Member {
   private String mName;
   private int mMultiplier;
   
   public Member (String name, int multiplier) {
      mName = name;
      mMultiplier = multiplier;
   }
   
   public String getName() {
      return mName;
   }
   
   public int getMultiplier() {
      return mMultiplier;
   }
   
   public String toString() {
      String memberInfo = "Member's name is: " + mName + "\n" 
                           + "His/her multiplier is: " + mMultiplier;
      
      return memberInfo;
   }
}
