/** 
 * @author (https://github.com/danielvillam) 
 * @version (August 8, 2023)
 */

public class DistanceFilter implements Filter{
    private Location location;
    private double distMax;
    private String name;
    
    public DistanceFilter (Location loc, double max, String name){
        location = loc;
        distMax = max;
        this.name = name;
    }
    
    public boolean satisfies(QuakeEntry qe) { 
        return qe.getLocation().distanceTo(location) < distMax; 
    }
    
    public String getName(){
        return name;
    }
}
