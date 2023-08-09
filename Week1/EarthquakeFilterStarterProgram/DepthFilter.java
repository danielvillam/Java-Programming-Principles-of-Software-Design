/** 
 * @author (https://github.com/danielvillam) 
 * @version (August 8, 2023)
 */

public class DepthFilter implements Filter{
    private double depMin;
    private double depMax;
    
    public DepthFilter (double min, double max){
        depMin = min;
        depMax = max;
    }
    
    public boolean satisfies(QuakeEntry qe) { 
        double depth = qe.getDepth();
        return depth >= depMin && depth <= depMax; 
    }
}
