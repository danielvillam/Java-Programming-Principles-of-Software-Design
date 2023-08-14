/** 
 * @author (https://github.com/danielvillam) 
 * @version (August 14, 2023)
 */

import java.util.*;

public class MarkovModel extends AbstractMarkovModel{
    private int n;

    public MarkovModel(int number) {
        myRandom = new Random();
        n = number;
    }
	
    public String getRandomText(int numChars){
	if (myText == null){
	    return "";
	}
	StringBuilder sb = new StringBuilder();
	int index = myRandom.nextInt(myText.length() - n);
	String key = myText.substring(index, index + n);
	sb.append(key);
	
	for(int k=0; k < numChars-4; k++){
	    ArrayList<String> follows = getFollows(key);
	    if(follows.size() == 0){
	        break;
	    }
	    index = myRandom.nextInt(follows.size());
	    String next = follows.get(index);
	    sb.append(next);
	    key = key.substring(1) + next;
	}	
	return sb.toString();
    }
    
    public String toString(){
        return "MarkovModel of order "+n;
    }
}
