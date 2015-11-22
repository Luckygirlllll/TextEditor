package spelling;

import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;

/** 
 * An trie data structure that implements the Dictionary and the AutoComplete ADT
 * @author You
 *
 */
public class AutoCompleteDictionaryTrie implements  Dictionary, AutoComplete {

   private TrieNode root;
    private int size;
    public String word;
    

    public AutoCompleteDictionaryTrie()
	{
		root = new TrieNode();
	}
	
	
	/** Insert a word into the trie.
	 * For the basic part of the assignment (part 2), you should ignore the word's case.
	 * That is, you should convert the string to all lower case as you insert it. */
	public boolean addWord(String word)
	{
		 boolean result = false;
		    TrieNode prevN = root;
		    TrieNode nextN = null;
			word = word.toLowerCase();
			for (char ch:word.toCharArray()){
				nextN = prevN.insert(ch);
				if (nextN==null){
					nextN = prevN.getChild(ch);
				}
				prevN = nextN;
			}
			if (!nextN.endsWord()) {
				nextN.setEndsWord(true);
				size++;
				result = true;
			}
		return result;
		
			
	    //TODO: Implement this method.
	   
	}
	
	/** 
	 * Return the number of words in the dictionary.  This is NOT necessarily the same
	 * as the number of TrieNodes in the trie.
	 */
	public int size()
	{    
		return size;

	}
	
	
	/** Returns whether the string is a word in the trie */
	@Override
	public boolean isWord(String s) 
	{
		
			// TODO: Implement this method
		{
			TrieNode current = root;
			s = s.toLowerCase();
		    for (Character x : s.toCharArray()) {
		    	if(current.getChild(x)==null){
		    		return false;
		    	}
		    	else	current = current.getChild(x); 
		    }
		    if(current.endsWord()) {
		    	return true;
		    }
			return false;
		}
	}
		
	 


	/** 
	 *  * Returns up to the n "best" predictions, including the word itself,
     * in terms of length
     * If this string is not in the trie, it returns null.
     * @param text The text to use at the word stem
     * @param n The maximum number of predictions desired.
     * @return A list containing the up to n best predictions
     */@Override
     public List<String> predictCompletions(String prefix, int numCompletions) 
     {
    	 // TODO: Implement this method
    	 // This method should implement the following algorithm:
    	 // 1. Find the stem in the trie.  If the stem does not appear in the trie, return an
    	 //    empty list
    	 // 2. Once the stem is found, perform a breadth first search to generate completions
    	 //    using the following algorithm:
    	 //    Create a queue (LinkedList) and add the node that completes the stem to the back
    	 //       of the list.
    	 //    Create a list of completions to return (initially empty)
    	 //    While the queue is not empty and you don't have enough completions:
    	 //       remove the first Node from the queue
    	 //       If it is a word, add it to the completions list
    	 //       Add all of its child nodes to the back of the queue
    	 // Return the list of completions
    	 List<String> temp = new LinkedList<String>();
    	 TrieNode t = root;
    	 int flag = 0;
    	 char[] str = (prefix.toLowerCase()).toCharArray();
    	 for(char i : str)
    	 {
    	 if(t.getChild(i)!=null)
    	 t = t.getChild(i);
    	 else
    	 flag = 1;
    	 }
    	 if(flag == 1) 
    		 return new LinkedList<>();
    	 Queue<TrieNode> q = new LinkedList<TrieNode>();
    	 q.add(t);
    	 while(q.size()!=0 && numCompletions > 0)
    	 {
    	 TrieNode z = q.remove();
    	 if(z.endsWord())
    	 temp.add(z.getText());
    	 for(char s : z.getValidNextCharacters())
    	 q.add(z.getChild(s));
    	
    	 }
    	 numCompletions--;
return temp;

}


 	// For debugging
 	public void printTree()
 	{
 		printNode(root);
 	}
 	
 	/** Do a pre-order traversal from this node down */
 	public void printNode(TrieNode curr)
 	{
 		if (curr == null) 
 			return;
 		
 		System.out.println(curr.getText());
 		
 		TrieNode next = null;
 		for (Character c : curr.getValidNextCharacters()) {
 			next = curr.getChild(c);
 			printNode(next);
 		}
 	}
 	

	
}