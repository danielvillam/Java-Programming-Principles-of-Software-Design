/** 
 * @author (https://github.com/danielvillam) 
 * @version (August 8, 2023)
 */

import java.util.*;
import edu.duke.*;

public class EarthQuakeClient2 {
    public EarthQuakeClient2() {
        // TODO Auto-generated constructor stub
    }

    public ArrayList<QuakeEntry> filter(ArrayList<QuakeEntry> quakeData, Filter f) { 
        ArrayList<QuakeEntry> answer = new ArrayList<QuakeEntry>();
        for(QuakeEntry qe : quakeData) { 
            if (f.satisfies(qe)) { 
                answer.add(qe); 
            } 
        } 
        
        return answer;
    } 
    
    public void quakesOfDepth (){
        EarthQuakeParser parser = new EarthQuakeParser(); 
        String source = "data/nov20quakedata.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);         
        System.out.println("read data for "+list.size()+" quakes");
        
        Filter f = new DepthFilter(-3999.0,-2001.0,"Depth");
        ArrayList<QuakeEntry> listFilter = filter(list, f);
        for (QuakeEntry qe: listFilter) { 
            System.out.println(qe);
        }
        System.out.println("Found "+ listFilter.size() + " quakes that match that criteria");
    }
    
    public void quakesByPhrase (){
        EarthQuakeParser parser = new EarthQuakeParser(); 
        String source = "data/nov20quakedata.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);         
        System.out.println("read data for "+list.size()+" quakes");
        
        Filter f = new PhraseFilter("any","Can","Phrase");
        ArrayList<QuakeEntry> listFilter = filter(list, f);
        for (QuakeEntry qe: listFilter) { 
            System.out.println(qe);
        }
        System.out.println("Found "+ listFilter.size() + " quakes that match that criteria");
    }
    
    public void findLargestQuakes (){
        EarthQuakeParser parser = new EarthQuakeParser(); 
        String source = "data/nov20quakedata.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);         
        System.out.println("read data for "+list.size()+" quakes");
        
        Filter f = new PhraseFilter("any","Can","Phrase");
        ArrayList<QuakeEntry> listFilter = filter(list, f);
        for (QuakeEntry qe: listFilter) { 
            System.out.println(qe);
        }
        System.out.println("Found "+ listFilter.size() + " quakes that match that criteria");
    }

    public void quakesWithFilter() { 
        EarthQuakeParser parser = new EarthQuakeParser(); 
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        String source = "data/nov20quakedata.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);         
        System.out.println("read data for "+list.size()+" quakes");

        
        //Filter f = new MinMagFilter(4.0); 
        //ArrayList<QuakeEntry> m7  = filter(list, f); 
        //for (QuakeEntry qe: m7) { 
        //    System.out.println(qe);
        //}
        
        Filter f = new MagnitudeFilter(4.0,5.0,"Magnitude");
        ArrayList<QuakeEntry> listFilter = filter(list, f);
        f = new DepthFilter(-35000.0,-12000.0,"Depth");
        listFilter = filter(listFilter, f);
        for (QuakeEntry qe: listFilter) { 
            System.out.println(qe);
        }
        System.out.println("Found "+ listFilter.size() + " quakes that match that criteria");
        
        // This location is Tokyo, Japan
        //Location city = new Location(35.42, 139.43);
        //Filter f = new DistanceFilter(city, 10000000, "Distance");
        //ArrayList<QuakeEntry> listFilter = filter(list, f);
        //f = new PhraseFilter("end","Japan","Phrase");
        //listFilter = filter(listFilter, f);
        //for (QuakeEntry qe: listFilter) { 
        //    System.out.println(qe);
        //}
        //System.out.println("Found "+ listFilter.size() + " quakes that match that criteria");
    }
    
    public void testQuiz (){
        EarthQuakeParser parser = new EarthQuakeParser(); 
        String source = "data/nov20quakedata.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);         
        System.out.println("read data for "+list.size()+" quakes");
        
        // This location is Denver, Colorado
        //Location city = new Location(39.7392, -104.9903);
        //Filter f = new DistanceFilter(city, 1000000, "Distance");
        //ArrayList<QuakeEntry> listFilter = filter(list, f);
        //f = new PhraseFilter("end","a","Phrase");
        //listFilter = filter(listFilter, f);
        //for (QuakeEntry qe: listFilter) { 
        //    System.out.println(qe);
        //}
        //System.out.println("Found "+ listFilter.size() + " quakes that match that criteria");
        
        //Filter f = new MagnitudeFilter(3.5,4.5,"Magnitude");
        //ArrayList<QuakeEntry> listFilter = filter(list, f);
        //f = new DepthFilter(-55000.0,-20000.0,"Depth");
        //listFilter = filter(listFilter, f);
        //for (QuakeEntry qe: listFilter) { 
        //    System.out.println(qe);
        //}
        //System.out.println("Found "+ listFilter.size() + " quakes that match that criteria");
        
        //MatchAllFilter maf = new MatchAllFilter();
        
        //maf.addFilter(new MagnitudeFilter(1.0,4.0,"Magnitude"));
        //maf.addFilter(new DepthFilter(-180000.0,-30000.0,"Depth"));
        //maf.addFilter(new PhraseFilter("any","o","Phrase"));
        
        //ArrayList<QuakeEntry> listFilter = filter(list, maf);
        //for (QuakeEntry qe: listFilter) { 
        //    System.out.println(qe);
        //}
        //System.out.println("Found "+ listFilter.size() + " quakes that match that criteria");
        //System.out.print("Filters used are: ");
        //System.out.println(maf.getName());
        
        MatchAllFilter maf = new MatchAllFilter();
        
        // This location is Billund, Dinamarca
        Location city = new Location(55.7308, 9.1153);
        
        maf.addFilter(new MagnitudeFilter(0.0,5.0,"Magnitude"));
        maf.addFilter(new DistanceFilter(city, 3000000,"Distance"));
        maf.addFilter(new PhraseFilter("any","e","Phrase"));
        
        ArrayList<QuakeEntry> listFilter = filter(list, maf);
        for (QuakeEntry qe: listFilter) { 
            System.out.println(qe);
        }
        System.out.println("Found "+ listFilter.size() + " quakes that match that criteria");
    }
    
    public void testMatchAllFilter (){
        EarthQuakeParser parser = new EarthQuakeParser(); 
        String source = "data/nov20quakedata.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);         
        System.out.println("read data for "+list.size()+" quakes");
        
        MatchAllFilter maf = new MatchAllFilter();
        
        maf.addFilter(new MagnitudeFilter(0.0,2.0,"Magnitude"));
        maf.addFilter(new DepthFilter(-100000.0,-10000.0,"Depth"));
        maf.addFilter(new PhraseFilter("any","a","Phrase"));
        
        ArrayList<QuakeEntry> listFilter = filter(list, maf);
        for (QuakeEntry qe: listFilter) { 
            System.out.println(qe);
        }
        System.out.println("Found "+ listFilter.size() + " quakes that match that criteria");
        System.out.print("Filters used are: ");
        System.out.println(maf.getName());
    }
    
    public void testMatchAllFilter2 (){
        EarthQuakeParser parser = new EarthQuakeParser(); 
        String source = "data/nov20quakedata.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);         
        System.out.println("read data for "+list.size()+" quakes");
        
        MatchAllFilter maf = new MatchAllFilter();
        
        // This location is Tulsa, Oklahoma
        Location city = new Location(36.1314,-95.9372);
        
        maf.addFilter(new MagnitudeFilter(0.0,3.0,"Magnitude"));
        maf.addFilter(new DistanceFilter(city, 10000000,"Distance"));
        maf.addFilter(new PhraseFilter("any","Ca","Phrase"));
        
        ArrayList<QuakeEntry> listFilter = filter(list, maf);
        for (QuakeEntry qe: listFilter) { 
            System.out.println(qe);
        }
        System.out.println("Found "+ listFilter.size() + " quakes that match that criteria");
    }

    public void createCSV() {
        EarthQuakeParser parser = new EarthQuakeParser();
        //String source = "../data/nov20quakedata.atom";
        String source = "data/nov20quakedatasmall.atom";
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        dumpCSV(list);
        System.out.println("# quakes read: "+list.size());
    }

    public void dumpCSV(ArrayList<QuakeEntry> list) {
        System.out.println("Latitude,Longitude,Magnitude,Info");
        for(QuakeEntry qe : list){
            System.out.printf("%4.2f,%4.2f,%4.2f,%s\n",
                qe.getLocation().getLatitude(),
                qe.getLocation().getLongitude(),
                qe.getMagnitude(),
                qe.getInfo());
        }
    }

}
