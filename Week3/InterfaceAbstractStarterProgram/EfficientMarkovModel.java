/** 
 * @author (https://github.com/danielvillam) 
 * @version (August 14, 2023)
 */

import java.util.*;

public class EfficientMarkovModel extends AbstractMarkovModel{
    private int n;
    private HashMap<String,ArrayList<String>> markovMap;

    public EfficientMarkovModel(int number) {
        myRandom = new Random();
        n = number;
    }
    
    public void setTraining(String s){
        myText = s;
        markovMap = buildMap();
    }
    
    private HashMap<String,ArrayList<String>> buildMap() {
        HashMap<String,ArrayList<String>> mappedChars = new HashMap<String,ArrayList<String>>();
        int idx = 0;
        while (idx < myText.length()-(n-1)) {
            String key = myText.substring(idx,idx+n);
            if (!mappedChars.containsKey(key) && idx + n < myText.length()) {
                mappedChars.put(key,new ArrayList<String>(Arrays.asList(
                          myText.substring(idx+key.length(),idx+key.length()+1))));
            }
            else if (mappedChars.containsKey(key) && idx + n < myText.length()){
                ArrayList<String> currentValues = mappedChars.get(key);
                currentValues.add(myText.substring(idx+key.length(),idx+key.length()+1));
                mappedChars.replace(key,currentValues);
            }
            else if (idx + n == myText.length()){
                mappedChars.put(key, new ArrayList<String>());
            }
            idx++;
        }     
        return mappedChars;
    }
    
    public ArrayList<String> getFollows(String key) {
        return markovMap.get(key);
    }
	
    public String getRandomText(int numChars){
	//printHashMapInfo();
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
    
    public void printHashMapInfo() {
        System.out.println("Key total: "+markovMap.size());
        int largest = 0;
        int counter = 0;
        for (String key: markovMap.keySet()) {
            if (markovMap.get(key).size() > largest) {
                largest = markovMap.get(key).size();
            }
            counter++;
        }
        System.out.println("Largest value in HashMap: "+largest);
        ArrayList<String> keysWithMax = new ArrayList<String>();
        for (String key: markovMap.keySet()) {
            if (markovMap.get(key).size() == largest) {
                keysWithMax.add(key);
            }
        }
        System.out.println("Keys with maximum size value: "+keysWithMax);
    }
    
    public String toString(){
        return "EfficientMarkovModel of order "+n;
    }
}
