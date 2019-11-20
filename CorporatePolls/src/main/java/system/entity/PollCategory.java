package system.entity;

import javax.persistence.*;

@Entity
@Table(name = "category", schema = "project")
public class PollCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "number_of_polls")
    private int numberOfPolls;

    public PollCategory() { numberOfPolls = 0; }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getNumberOfPolls() { return numberOfPolls; }
    public void setNumberOfPolls(int numberOfPolls) { this.numberOfPolls = numberOfPolls; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PollCategory that = (PollCategory) o;
        return id == that.id &&
                numberOfPolls == that.numberOfPolls &&
                name.equals(that.name);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + numberOfPolls;
        return result;
    }

    @Override
    public String toString() {
        return "PollCategory{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", numberOfPolls=" + numberOfPolls +
                '}';
    }
}
