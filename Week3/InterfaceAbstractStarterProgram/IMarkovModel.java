/** 
 * @author (https://github.com/danielvillam) 
 * @version (August 14, 2023)
 */

public interface IMarkovModel {
    public void setTraining(String text);
    
    public String getRandomText(int numChars);
    
}
