/** 
 * @author (https://github.com/danielvillam) 
 * @version (August 8, 2023)
 */

public class DepthFilter implements Filter{
    private double depMin;
    private double depMax;
    private String name;
    
    public DepthFilter (double min, double max, String name){
        depMin = min;
        depMax = max;
        this.name = name;
    }
    
    public boolean satisfies(QuakeEntry qe) { 
        double depth = qe.getDepth();
        return depth >= depMin && depth <= depMax; 
    }
    
    public String getName(){
        return name;
    }
}
