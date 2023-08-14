/** 
 * @author (https://github.com/danielvillam) 
 * @version (August 14, 2023)
 */

public interface IMarkovModel {
    public void setTraining(String text);
    
    public void setRandom(int seed);
    
    public String getRandomText(int numChars);
    
}
