/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Steven
 */
public class MemberList {

   private Member[] memberList;
   private int mCount;
   private static final int DEFAULT_SIZE = 10;

   public MemberList() {
      memberList = new Member[DEFAULT_SIZE];
   }

   public int getTotalMembers() {
      if (mCount <= 0) {
         return 0;
      }
      else {
         return mCount;
      }
   }

   public void add(Member memberAdded) {
      resizeIfNecessary();
      memberList[mCount++] = memberAdded;
   }

   public void remove(String name) {
      for (int i = 0; i < mCount; i++) {
         if (memberList[i].getName().equalsIgnoreCase(name)) {
            shiftLeft(i);
            mCount--;
         }
      }
   }

   private void resizeIfNecessary() {
      if (mCount == memberList.length) {
         Member[] newMemberList = new Member[memberList.length * 2];
         System.arraycopy(memberList, 0, newMemberList, 0, mCount);
         memberList = newMemberList;
      }
   }

   private void shiftLeft(int startNdx) {
      System.arraycopy(memberList, startNdx + 1, memberList, startNdx,
       mCount - startNdx - 1);
   }
}
