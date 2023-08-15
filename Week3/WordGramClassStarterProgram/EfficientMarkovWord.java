/** 
 * @author (https://github.com/danielvillam) 
 * @version (August 15, 2023)
 */


import java.util.*;
public class EfficientMarkovWord implements IMarkovModel {
    private String[] myText;
    private Random myRandom;
    private int order;
    private HashMap<WordGram, ArrayList<String>> map;
    
    public EfficientMarkovWord(int order) {
        myRandom = new Random();
        this.order = order;
        map = new HashMap<WordGram, ArrayList<String>>();
    }
    
    public void setRandom(int seed) {
        myRandom = new Random(seed);
    }
    
    public void setTraining(String text){
        myText = text.split("\\s+");
        buildMap();
    }
    
//    private int indexOf(String[] words, WordGram target, int start) {
//      
//      for (int i=start;i<words.length-order;i++) {
//          WordGram wg = new WordGram(words,i,order);
//          if (wg.equals(target)) return i;
//      }
//      
//      return -1;
//    }
    
    private void buildMap () {
        map.clear();
        if (order <= 0) return;

        for (int k = 0; k < myText.length-order; k++) {
            WordGram kGram = new WordGram(myText, k, order);
            ArrayList<String> follows = getFollows(kGram);
            follows.add(myText[k+order]);
            map.put(kGram, follows);
        }
        WordGram kGram = new WordGram(myText, myText.length-order, order);
        if (!map.containsKey(kGram))
            map.put(kGram, new ArrayList<String>());
    }
    
    private ArrayList<String> getFollows (WordGram kGram) {
        return map.getOrDefault(kGram, new ArrayList<String>());
    }
    
    public String getRandomText(int numChars) {
        StringBuilder sb = new StringBuilder();
        int index = myRandom.nextInt(myText.length-order);
        WordGram key = new WordGram(myText,index,order);
        sb.append(key.toString());
        for (int i=0;i<numChars-order;i++) {
            ArrayList<String> follows = getFollows(key);
            if (follows == null || follows.size()==0) break;
            index = myRandom.nextInt(follows.size());
            String next = follows.get(index);
            sb.append(next);
            sb.append(" ");
            key = key.shiftAdd(next);
        }
        return sb.toString().trim();
    }
    
    public void printHashMapInfo() {
        int maxSetSize = -1;
        for (WordGram wg : map.keySet()) {
            maxSetSize = Math.max(maxSetSize, map.get(wg).size());
            System.out.println(wg+"\t: "+map.get(wg));
        }
        
        System.out.println("Number of keys:\t"+map.keySet().size());
        System.out.println("Max Set Size:\t"+maxSetSize);
        System.out.println("Keys with Max Size:");
        
        for (WordGram wg : map.keySet()) {
            if (map.get(wg).size()==maxSetSize) 
                System.out.println(wg);
        }
        
    }

}
