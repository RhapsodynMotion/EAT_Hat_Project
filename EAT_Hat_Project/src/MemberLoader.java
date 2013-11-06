/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Scanner;
import java.io.*;

/**
 *
 * @author Steven
 */
public class MemberLoader {

   private Scanner mFileScanner;

   public MemberLoader(String fileName) throws IOException {
      mFileScanner = new Scanner(new FileReader(fileName));
      mFileScanner.useDelimiter("\n|\\|");
   }

   MemberLoader() {
      throw new UnsupportedOperationException("Not supported yet."); 
   }
   
    public Member readNextMember() {
      if (mFileScanner.hasNext()) {
         String name = mFileScanner.next();
         int multiplier = mFileScanner.nextInt();
         
         return new Member(name, multiplier);
      }
      return null;
   }
}
