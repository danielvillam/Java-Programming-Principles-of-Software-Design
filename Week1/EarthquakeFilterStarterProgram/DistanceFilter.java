/** 
 * @author (https://github.com/danielvillam) 
 * @version (August 8, 2023)
 */

public class DistanceFilter implements Filter{
    private Location location;
    private double distMax;
    
    public DistanceFilter (Location loc, double max){
        location = loc;
        distMax = max;
    }
    
    public boolean satisfies(QuakeEntry qe) { 
        return qe.getLocation().distanceTo(location) < distMax; 
    }
}
