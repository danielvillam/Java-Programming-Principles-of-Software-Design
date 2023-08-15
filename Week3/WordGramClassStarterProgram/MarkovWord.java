/** 
 * @author (https://github.com/danielvillam) 
 * @version (August 14, 2023)
 */

import java.util.*;
public class MarkovWord implements IMarkovModel{
    private String[] myText;
    private Random myRandom;
    private int order;
    
    public MarkovWord(int order) {
        myRandom = new Random();
        this.order = order;
    }
    
    public void setRandom(int seed) {
        myRandom = new Random(seed);
    }
    
    public void setTraining(String text){
        myText = text.split("\\s+");
    }
    
    private int indexOf(String[] words, WordGram target, int start){
        for (int k=start;k < words.length-order; k++) {
            WordGram wg = new WordGram(words,k,order);
            if (wg.equals(target)){
                return k;
            }
    	}
    	return -1;
    }
    
    private ArrayList<String> getFollows(WordGram kGram) {
        ArrayList<String> follows = new ArrayList<String>();
        int index = indexOf(myText, kGram, 0);
        while (index!=-1) {
            follows.add(myText[index+order]);
            index = indexOf(myText, kGram, index+1);
        }
    	return follows;
    }
    
    public String getRandomText(int numWords){
        StringBuilder sb = new StringBuilder();
	int index = myRandom.nextInt(myText.length-order);
	WordGram key = new WordGram(myText,index,order);
	sb.append(key.toString());
	for (int i=0;i<numWords-order;i++) {
	    ArrayList<String> follows = getFollows(key);
	    if (follows == null || follows.size()==0){
	        break;
	    }
	    index = myRandom.nextInt(follows.size());
	    String next = follows.get(index);
	    sb.append(next);
	    sb.append(" ");
	    key = key.shiftAdd(next);
	}
	return sb.toString().trim();
    }
}
