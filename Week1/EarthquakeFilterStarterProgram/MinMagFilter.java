/** 
 * @author (https://github.com/danielvillam) 
 * @version (August 8, 2023)
 */

public class MinMagFilter implements Filter
{
    private double magMin; 
    private String name;
    
    public MinMagFilter(double min, String name) { 
        magMin = min;
        this.name = name;
    } 

    public boolean satisfies(QuakeEntry qe) { 
        return qe.getMagnitude() >= magMin; 
    } 
    
    public String getName(){
        return name;
    }
}
