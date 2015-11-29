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
		String[] words = sourceText.split(" ");
	//	set "starter" to be the first word in the text 
		starter = words[0];
		//set "prevWord" to be starter
		String prevWord = starter;
		//for each word "w" in the source text starting at the second word
		for (int i = 1; i < words.length; i++) {
		String currentWord = words[i];
		//check to see if "prevWord" is already a node in the list
		if (this.wordList.isEmpty()) {
		ListNode newNode = new ListNode(prevWord);
		//add a node to the list with "prevWord" as the node's word
      //  add "w" as a nextWord to the "prevWord" node
		newNode.addNextWord(currentWord);
		this.wordList.add(newNode);
		prevWord = currentWord;
		} else {
		for (ListNode node : this.wordList) {
			// add "w" as a nextWord to the "prevWord" node
		if (node.getWord().equals(prevWord)) {
			node.addNextWord(currentWord);
			prevWord = currentWord;
		//	return;
			}
			}
		if (i == words.length-1) {   
			ListNode newNode = new ListNode(currentWord);
			newNode.addNextWord(starter);
			this.wordList.add(newNode);
		prevWord = currentWord;
			} else {
			ListNode newNode = new ListNode(prevWord);
			newNode.addNextWord(currentWord);
			this.wordList.add(newNode);
			prevWord = currentWord;
			
		}
		
	}
	}
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
		String word;
//		set "currWord" to be the starter word
		String currWord=starter;
//		set "output" to be ""
		String output=" ";
//		add "currWord" to output
		output=output+currWord;
//		while you need more words
//		   find the "node" corresponding to "currWord" in the list
		if (numWords!=0){
		for (int i = 0; i < wordList.size(); i++) {
			node = wordList.get(i);
			currWord = node.getWord();
		//	Random k = null;
		//	select a random word "w" from the "wordList" for "node"
		
			String w=node.getRandomNextWord(rnGenerator);
			//add "w" to the "output"
			output=output+" "+w;
			//set "currWord" to be "w" 
			currWord=w;
//			increment number of words added to the list
			int wordlistsize=wordList.size();
			wordlistsize++;
		}
		return output;
		}
		String a="";
		return a;
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
		for (int i=0; i< wordList.size(); i++ ){
		wordList.remove(i);
		}
		String[] wordss = sourceText.split(" ");
		//	set "starter" to be the first word in the text 
			starter = wordss[0];
			//set "prevWord" to be starter
			String prevWordd = starter;
			//for each word "w" in the source text starting at the second word
			for (int i = 1; i < wordss.length; i++) {
			String currentWord = wordss[i];
			//check to see if "prevWord" is already a node in the list
			if (this.wordList.isEmpty()) {
			ListNode newNode = new ListNode(prevWordd);
			//add a node to the list with "prevWord" as the node's word
	      //  add "w" as a nextWord to the "prevWord" node
			newNode.addNextWord(currentWord);
			this.wordList.add(newNode);
			prevWordd = currentWord;
			} else {
			for (ListNode node : this.wordList) {
				// add "w" as a nextWord to the "prevWord" node
			if (node.getWord().equals(prevWordd)) {
				node.addNextWord(currentWord);
				prevWordd = currentWord;
				}
				}
			if (i == wordss.length-1) {   
				ListNode newNode = new ListNode(currentWord);
				newNode.addNextWord(starter);
				this.wordList.add(newNode);
			prevWordd = currentWord;
				} else {
				ListNode newNode = new ListNode(prevWordd);
				newNode.addNextWord(currentWord);
				this.wordList.add(newNode);
				prevWordd = currentWord;
			}	
		}
		}
		}
		
		
		// TODO: Implement this method.

	
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
	
	
	public String getRandomNextWord(Random generator){
	
	int randomIndex = generator.nextInt(nextWords.size());
	return nextWords.get(randomIndex);
	
	// TODO: Implement this method
	    // The random number generator should be passed from 
	    // the MarkovTextGeneratorLoL class
 
	
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


