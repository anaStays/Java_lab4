import java.time.LocalDate;
import java.util.Objects;

/**
 * Person data
 * ---Name, Sex, Division, Salary, Birthday---
 */
public class Person {
    public Long id;
    public String name;
    public String Sex;
    public Division division;
    public Integer salary;
    public LocalDate birthDate;

    /**
     * All-in-one constructor
     * @param _id identificator
     * @param _name Name
     * @param _sex Sex
     * @param _division Division
     * @param _salary Salary
     * @param _birthDate Birthday
     */
    public Person(Long _id, String _name, String _sex, LocalDate _birthDate, Division _division, Integer _salary)
    {
        this.id = _id;
        this.name = _name;
        this.Sex = _sex;
        this.division = _division;
        this.salary = _salary;
        this.birthDate = _birthDate;
    }

    public Person()
    {

    }

    @Override
    public String toString() {
        return "Man{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + Sex + '\'' +
                ", division=" + division +
                ", salary=" + salary +
                ", birthDate=" + birthDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person man = (Person) o;
        return id == man.id &&
                Double.compare(man.salary, salary) == 0 &&
                Objects.equals(name, man.name) &&
                Objects.equals(Sex, man.Sex) &&
                Objects.equals(division, man.division) &&
                Objects.equals(birthDate, man.birthDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, Sex, division, salary, birthDate);
    }
}
