/** 
 * @author (https://github.com/danielvillam) 
 * @version (August 8, 2023)
 */

public class MagnitudeFilter implements Filter {
    private double magMin;
    private double magMax;
    private String name;
    
    public MagnitudeFilter (double min, double max, String name){
        magMin = min;
        magMax = max;
        this.name = name;
    }
    
    public boolean satisfies(QuakeEntry qe) { 
        double magnitude = qe.getMagnitude();
        return magnitude >= magMin && magnitude <= magMax; 
    }
    
    public String getName(){
        return name;
    }
}
