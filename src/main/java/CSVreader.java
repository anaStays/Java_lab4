import java.util.HashMap;
import java.util.Map;

public class CSVReader {
    Map<String,Division> map = new HashMap<>();
    private Long idSequence=0L;
    /**
     * @param name Имя подразделения
     * @return Объект подразделения
     */
    private Division getDivision(String name){
        if(map.containsKey(name)){
            return map.get(name);
        }
        else{
            Division division = new Division(++idSequence,name);
            map.put(name, division);
            return division;
        }
    }
}
