/** 
 * @author (https://github.com/danielvillam) 
 * @version (August 8, 2023)
 */

public interface Filter
{
    public  boolean satisfies(QuakeEntry qe); 
    
    public String getName();
}
