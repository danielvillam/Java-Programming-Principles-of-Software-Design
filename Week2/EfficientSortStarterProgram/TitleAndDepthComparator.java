/** 
 * @author (https://github.com/danielvillam) 
 * @version (August 10, 2023)
 */

import java.util.Comparator;
public class TitleAndDepthComparator implements Comparator<QuakeEntry> {
    @Override
    public int compare(QuakeEntry q1, QuakeEntry q2) {
        int compare = q1.getInfo().compareTo(q2.getInfo());
        if(compare == 0){
            return Double.compare(q1.getDepth(), q2.getDepth());
        }else{
            return compare;
        }
    }
}
