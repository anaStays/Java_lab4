import java.util.Objects;

/**
 * Класс хранящий данные о подразделении
 * ---Индетификатор, имя---
 */
public class Division {
    public Long id;
    public String name;

    /**
     * Конструктор по имени
     * @param name Имя подразделения
     */
    public Division(Long id, String name)
    {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Division{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Division division = (Division) o;
        return Objects.equals(id, division.id) &&
                Objects.equals(name, division.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
