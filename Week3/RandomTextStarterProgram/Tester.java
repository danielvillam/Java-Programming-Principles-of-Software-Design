/** 
 * @author (https://github.com/danielvillam) 
 * @version (August 12, 2023)
 */

import edu.duke.*;
import java.util.*;
public class Tester {
    public void testGetFollows (){
        MarkovOne markov = new MarkovOne();
        String training = "this is a test yes this is a test.";
        markov.setTraining(training);
        ArrayList<String> follows = markov.getFollows("es");
        System.out.println(follows);
        System.out.println(follows.size());
    }
    
    public void testGetFollowsWithFile (){
        FileResource fr = new FileResource();
        String st = fr.asString();
        st = st.replace('\n', ' ');
        MarkovOne markov = new MarkovOne();
        markov.setTraining(st);
        ArrayList<String> follows = markov.getFollows("t");
        System.out.println(follows.size());
    }
}
