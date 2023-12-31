/** 
 * @author (https://github.com/danielvillam) 
 * @version (August 5, 2023)
 */

import java.util.*;

public class ClosestQuakes {
    private QuakeEntry findTheClosestQuake (ArrayList<QuakeEntry> list, Location from) {
        QuakeEntry closest = list.get(0);
        for (int k = 1; k < list.size(); k++) {
            if (list.get(k).getLocation().distanceTo(from) < closest.getLocation().distanceTo(from))
                closest = list.get(k);
        }
        return closest;
    }

    public ArrayList<QuakeEntry> getClosest(ArrayList<QuakeEntry> quakeData, Location current, int howMany) {
        ArrayList<QuakeEntry> ret = new ArrayList<QuakeEntry>();
        ArrayList<QuakeEntry> in = new ArrayList<QuakeEntry>(quakeData);

        while (howMany > 0 && ! in.isEmpty()) {
            QuakeEntry closest = findTheClosestQuake(in, current);
            ret.add(closest);
            in.remove(closest);
            howMany--;
        }
        return ret;
    }

    public void findClosestQuakes() {
        EarthQuakeParser parser = new EarthQuakeParser();
        String source = "data/nov20quakedatasmall.atom";
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        System.out.println("read data for "+list.size());

        Location jakarta  = new Location(-6.211,106.845);

        ArrayList<QuakeEntry> close = getClosest(list,jakarta,3);
        for(int k=0; k < close.size(); k++){
            QuakeEntry entry = close.get(k);
            double distanceInMeters = jakarta.distanceTo(entry.getLocation());
            System.out.printf("%4.2f\t %s\n", distanceInMeters/1000,entry);
        }
        System.out.println("number found: "+close.size());
    }
    
}
