/** 
 * @author (https://github.com/danielvillam) 
 * @version (August 10, 2023)
 */

import java.util.Comparator;
public class TitleLastAndMagnitudeComparator implements Comparator<QuakeEntry> {
    @Override
    public int compare(QuakeEntry q1, QuakeEntry q2) {
        String q1LastWord = q1.getInfo().substring(q1.getInfo().lastIndexOf(" ")+1);
        String q2LastWord = q2.getInfo().substring(q2.getInfo().lastIndexOf(" ")+1);
        int compare = q1LastWord.compareTo(q2LastWord);
        if(compare == 0){
            return Double.compare(q1.getMagnitude(), q2.getMagnitude());
        }else{
            return compare;
        }
    }
}
