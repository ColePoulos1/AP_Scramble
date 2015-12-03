/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package scramble;

import java.util.ArrayList;

public class Scramble {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String myWord = "CAMCAALJA";
        myWord = scrambleWord(myWord);
        System.out.println(myWord);
        ArrayList<String> myList = new ArrayList<String>();
        myList.add("AARDVARKA");
        myList.add("DAADA");
        myList.add("PARTY");
        System.out.println(scrambleOrRemove(myList));
    }
    public static String scrambleWord(String word)
    {
        String ret = word;
        for(int i = 0;i<word.length()-1;i++)
        {
            if(word.substring(i, i+1).equals("A") && !word.substring(i+1, i+2).equals("A"))
            {
                ret = ret.substring(0,i) + word.substring(i+1, i+2) + word.substring(i, i+1) + word.substring(i+2,word.length());
                i++;
            }
        }
        return(ret);
    }
    public static ArrayList<String> scrambleOrRemove(ArrayList<String> words)
    {
        ArrayList<String> ret = words;
        for(int i=0;i<words.size();i++)
        {
            ret.set(i,scrambleWord(ret.get(i)));
            if(words.get(i).equals(scrambleWord(words.get(i))))
                ret.remove(i);
        }
        return(ret);
    }
}
