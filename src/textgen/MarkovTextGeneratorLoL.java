package textgen;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Optional;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

/** 
 * An implementation of the MTG interface that uses a list of lists.
 * @author UC San Diego Intermediate Programming MOOC team 
 */
public class MarkovTextGeneratorLoL implements MarkovTextGenerator {

	// The list of words with their next words
	private List<ListNode> wordList; 
	
	// The starting "word"
	private String starter;
	
	// The random number generator
	private Random rnGenerator;
	

	public MarkovTextGeneratorLoL(Random generator)
	{
		wordList = new LinkedList<ListNode>();
		starter = "";
		rnGenerator = generator;
	}
	


	
	/** Train the generator by adding the sourceText */
	@Override
	public void train(String sourceText)
	{
//		wordList = new LinkedList<ListNode>();
//		Stream<ListNode> o = wordList.stream();
		
//		starter="";
	//for (ListNode w: wordList){
	//		if( w.getWord().equals(starter) ){
	//			w.addNextWord(starter);}
	//}
//starter.nextWords=w; //  add w as a nextWord to the "starter" node
//else {   
//wordList.add(w);
//w.addNextWord(starter);}
//			w.getWord().equals(starter);
	//add a node to the list with "starter" as the node's word}
	//add w as a nextWord to the "starter" node			
//}

	//	}
	 
	//	for each word w in the source text
	//	   check to see if "starter" is already a node in the list
	//	      if "starter" is a node in the list
	//	         add w as a nextWord to the "starter" node
	//	      else
	//	         add a node to the list with "starter" as the node's word
	//	         add w as a nextWord to the "starter" node
	//	    set starter = w
//
//		add "" to be a next word for the last word in the source text.
		
			// TODO: Implement this method
			List<String> sourceList = splitWord(sourceText);
			ListNode node;
			ListNode newNode;
			String word;
			// Set starter to be an empty String ""
			starter = "";
			wordList.add(new ListNode(starter));
			// For each word w in the source text
			for (String w : sourceList) {
				// check to see if "starter" is already a node in the list
				for (int i = 0; i < wordList.size(); i++) {
					
				//	System.out.println(wordList.size());
					node = wordList.get(i);
					word = node.getWord();
					// if starter is a node in list
					if (starter.equals(word)) {
						// add w as a nextWord to the "starter" node
						node.addNextWord(w);
						//System.out.println(wordList.size());
					} 
					
					// else
					else {
						//add a node to the list with "starter" as the node's word
						
						newNode = new ListNode(starter);
						wordList.add(newNode);
						//add w as nextWord to the "starter" node
					//	newNode.addNextWord(w+" here we add something");
						
					}
					
				}
				//	i++;
				starter = w;
			}
			//add "" to be a next word for the last word in the source text.
			ListNode thelast=wordList.get(wordList.size()-1);
			thelast.addNextWord("lastnode with empty string");
		}
	
	
	
	
	// private helper method
		private List<String> splitWord(String input) {
			return getTokens("[a-zA-Z']+", input);
		}

		private List<String> getTokens(String pattern, String text) {
			ArrayList<String> tokens = new ArrayList<String>();
			Pattern tokSplitter = Pattern.compile(pattern);
			Matcher m = tokSplitter.matcher(text);

			while (m.find()) {
				tokens.add(m.group());
			}

			return tokens;
		}
		
		// TODO: Implement this method
	

	
	/** 
	 * Generate the number of words requested.
	 */
	@Override
	public String generateText(int numWords) {
		ListNode node;
		ListNode newNode;
		String word;
//		set "starter" to be an empty String "" 
		String starter="";
//		set "output" to be ""
		String output="";
	   
		for (int i = 0; i < wordList.size(); i++) {
			
			//	System.out.println(wordList.size());
				node = wordList.get(i);
				word = node.getWord();
				// if starter is a node in list
				if (starter.equals(word)) {
				//	node.getRandomNextWord(Random i);
					
				}
				
				}
		return null;
				
					
	//	while you need more words
	//	 find the "node" corresponding to "starter" in the list
	//	   if that node does not exist
	//	      find the "node" corresponding to the empty String ""
	//	   select a random word from the "wordList" for "node"
	//	   add the random word to the "output"
	//	   set "starter" to the random word 
	//	   increment number of words added to the list
		
	//	return null;
	}
	
	
	// Can be helpful for debugging
	@Override
	public String toString()
	{
		String toReturn = "";
		for (ListNode n : wordList)
		{
			toReturn += n.toString();
		}
		return toReturn;
	}
	
	/** Retrain the generator from scratch on the source text */
	@Override
	public void retrain(String sourceText)
	{
		// TODO: Implement this method.
	}
	
	// TODO: Add any private helper methods you need here.
	
	
	/**
	 * This is a minimal set of tests.  Note that it can be difficult
	 * to test methods/classes with randomized behavior.   
	 * @param args
	 */
	public static void main(String[] args)
	{
	//	System.out.println(randomGenerator+"It's important random thing");
		
		// feed the generator a fixed random value for repeatable behavior
		MarkovTextGeneratorLoL gen = new MarkovTextGeneratorLoL(new Random(42));
		String textString ="hi there hi Leo";
				//"Hello.  Hello there.  This is a test.  Hello there.  Hello Bob.  Test again.";
		System.out.println(textString);
		gen.train(textString); 
		System.out.println(gen);
		System.out.println(gen.generateText(20));
		String textString2 = "You say yes, I say no, "+
				"You say stop, and I say go, go, go, "+
				"Oh no. You say goodbye and I say hello, hello, hello, "+
				"I don't know why you say goodbye, I say hello, hello, hello, "+
				"I don't know why you say goodbye, I say hello. "+
				"I say high, you say low, "+
				"You say why, and I say I don't know. "+
				"Oh no. "+
				"You say goodbye and I say hello, hello, hello. "+
				"I don't know why you say goodbye, I say hello, hello, hello, "+
				"I don't know why you say goodbye, I say hello. "+
				"Why, why, why, why, why, why, "+
				"Do you say goodbye. "+
				"Oh no. "+
				"You say goodbye and I say hello, hello, hello. "+
				"I don't know why you say goodbye, I say hello, hello, hello, "+
				"I don't know why you say goodbye, I say hello. "+
				"You say yes, I say no, "+
				"You say stop and I say go, go, go. "+
				"Oh, oh no. "+
				"You say goodbye and I say hello, hello, hello. "+
				"I don't know why you say goodbye, I say hello, hello, hello, "+
				"I don't know why you say goodbye, I say hello, hello, hello, "+
				"I don't know why you say goodbye, I say hello, hello, hello,";
		System.out.println(textString2);
		gen.retrain(textString2);
		System.out.println(gen);
		System.out.println(gen.generateText(20));
	}

}

/** Links a word to the next words in the list 
 * You should use this class in your implementation. */
class ListNode
{
    // The word that is linking to the next words
	private String word;
	
	// The next words that could follow it
	private List<String> nextWords;
	
	ListNode(String word)
	{
		this.word = word;
		nextWords = new LinkedList<String>();
	}
	
	public String getWord()
	{
		return word;
	}

	public void addNextWord(String nextWord)
	{
		nextWords.add(nextWord);
	}
	
	
	public String getRandomNextWord(Random generator)
	{ if(nextWords.size()>= 0)
		{
	    int ran = generator.nextInt(nextWords.size());
	    return nextWords.get(ran);
	}
		
	// TODO: Implement this method
	    // The random number generator should be passed from 
	    // the MarkovTextGeneratorLoL class
    return null;
	
	}

	public String toString()
	{
		String toReturn = word + ": ";
		for (String s : nextWords) {
			toReturn += s + "->";
		}
		toReturn += "\n";
		return toReturn;
	}
	
}


