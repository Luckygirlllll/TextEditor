package spelling;

import java.util.ArrayList;
import java.util.List;
import java.util.NavigableMap;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author UC San Diego Intermediate MOOC team
 *
 */
public class DictionaryBST implements Dictionary 
{
   private TreeSet<String> dict;

   
    public DictionaryBST() {
	dict = new TreeSet<String>();
}


	// TODO: Implement the dictionary interface using a TreeSet.  
 	// You'll need a constructor here
	
    
 


	/** Add this word to the dictionary.  Convert it to lowercase first
     * for the assignment requirements.
     * @param word The word to add
     * @return true if the word was added to the dictionary 
     * (it wasn't already there). */
    public boolean addWord(String word) {
    	// TODO: Implement this method 
    	String nword=word.toLowerCase();
    	if(dict.add(nword)){
        return true;
        }
    	else
    		return false;
        
    }


    /** Return the number of words in the dictionary */
    public int size()
    {
    	return dict.size();
    	// TODO: Implement this method
   //  return 0;
    }

    /** Is this a word according to this dictionary? */
    public boolean isWord(String s) {
    	  if(dict.contains(s.toLowerCase())){
    	        return true;}
    	    else 
    	    	return false;
          //TODO: Implement this method
        }
  


}
