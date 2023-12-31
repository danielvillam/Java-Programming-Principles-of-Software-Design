/** 
 * @author (https://github.com/danielvillam) 
 * @version (August 8, 2023)
 */

public class PhraseFilter implements Filter{
    private String typeRequest ;
    private String phrase;
    private String name;
    
    public PhraseFilter (String where, String phrase, String name){
        typeRequest = where;
        this.phrase = phrase;
        this.name = name;
    }
    
    public boolean satisfies(QuakeEntry qe) { 
        if(typeRequest.equals("start")){
                if(qe.getInfo().startsWith(phrase)){
                    return true;
                }
            }else if(typeRequest.equals("end")){
                if(qe.getInfo().endsWith(phrase)){
                    return true;
                }
            }else if(typeRequest.equals("any")){
                if(qe.getInfo().indexOf(phrase) != -1){
                    return true;
                }
            }
        return false;
    }
    
    public String getName(){
        return name;
    }
}
