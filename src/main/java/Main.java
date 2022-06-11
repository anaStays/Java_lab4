
import java.io.IOException;
import java.lang.String;
import java.util.List;

public class Main {
    public  static void main(String args[]) throws IOException {
        CSVreader reader = new CSVreader();
        List<Person> peopleList = reader.download("src/main/resources/foreign_names.csv");

        for (Person person: peopleList) {
            System.out.println(person.toString());
        }
    }
}
