import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CSVreader {
    Map<String,Division> map = new HashMap<>();
    private Long idSequence=0L;
    /**
     * @param name Division name
     * @return Division instance
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

    /**
     * @param path Path to file
     * @return staff data
     * @throws IOException
     */
    public ArrayList<Person> download(String path) throws IOException {
        ArrayList<Person> persons = new ArrayList<>();
        au.com.bytecode.opencsv.CSVReader reader;
        try {
            reader = new au.com.bytecode.opencsv.CSVReader(new FileReader(path),';','"',1);
        }
        catch (FileNotFoundException e){
            throw new FileNotFoundException(path);
        }

        String[] nextLine;
        while ((nextLine = reader.readNext()) != null){
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
            Person person = new Person(Long.valueOf(nextLine[0]),
                    nextLine[1],
                    nextLine[2],
                    LocalDate.parse(nextLine[3],formatter),
                    getDivision(nextLine[4]),
                    Integer.parseInt(nextLine[5])
            );

            persons.add(person);
        }
        return persons;
    }
}
