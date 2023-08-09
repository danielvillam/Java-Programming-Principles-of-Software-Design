/** 
 * @author (https://github.com/danielvillam) 
 * @version (August 8, 2023)
 */

public class MagnitudeFilter implements Filter {
    private double magMin;
    private double magMax;
    
    public MagnitudeFilter (double min, double max){
        magMin = min;
        magMax = max;
    }
    
    public boolean satisfies(QuakeEntry qe) { 
        double magnitude = qe.getMagnitude();
        return magnitude >= magMin && magnitude <= magMax; 
    } 
    
}
