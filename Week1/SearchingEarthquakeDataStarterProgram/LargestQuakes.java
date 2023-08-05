/** 
 * @author (https://github.com/danielvillam) 
 * @version (August 5, 2023)
 */

import java.util.*;
public class LargestQuakes {
    public void findLargestQuakes (){
        EarthQuakeParser parser = new EarthQuakeParser();
        String source = "data/nov20quakedatasmall.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        System.out.println("read data for "+list.size()+" quakes");
        int idxLargest = indexOfLargest(list);
        //System.out.println(idxLargest+" "+list.get(id,xLargest).getMagnitude());
        ArrayList<QuakeEntry> listFilter = getLargest(list, 5);
        
        for (QuakeEntry qe : listFilter) {
            System.out.println(qe);
        }
    }
    
    public int indexOfLargest (ArrayList<QuakeEntry> data){
        double largest = 0.0;
        int idx = 0;
        int i = 0;
        for (QuakeEntry qe : data) {
            double current = qe.getMagnitude();
            if(current > largest){
                largest = current;
                idx = i;
            }
            i++;
        }
        return idx;
    }
    
    public ArrayList<QuakeEntry> getLargest (ArrayList<QuakeEntry> quakeData, int howMany){
        ArrayList<QuakeEntry> ret = new ArrayList<QuakeEntry>();
        ArrayList<QuakeEntry> in = new ArrayList<QuakeEntry>(quakeData);

        while (howMany > 0 && ! in.isEmpty()) {
            int largestIndex = indexOfLargest(in);
            QuakeEntry qe = in.get(largestIndex);
            ret.add(qe);
            in.remove(qe);
            howMany--;
        }
        return ret;
    }
}
