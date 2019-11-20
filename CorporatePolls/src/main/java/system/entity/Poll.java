package system.entity;

import javax.persistence.*;

@Entity
@Table(name = "poll", schema = "project")
public class Poll {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "max_result")
    private int maxResult;

    @ManyToOne (optional=false, cascade=CascadeType.ALL)
    @JoinColumn (name="id_compiler")
    private Compiler compiler;

    @ManyToOne (optional=false, cascade=CascadeType.ALL)
    @JoinColumn (name="id_category")
    private PollCategory pollCategory;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public int getMaxResult() { return maxResult; }
    public void setMaxResult(int maxResult) { this.maxResult = maxResult; }
    public Compiler getCompiler() { return compiler; }
    public void setCompiler(Compiler compiler) { this.compiler = compiler; }
    public PollCategory getPollCategory() { return pollCategory; }
    public void setPollCategory(PollCategory pollCategory) { this.pollCategory = pollCategory; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Poll poll = (Poll) o;
        return id == poll.id &&
                maxResult == poll.maxResult &&
                name.equals(poll.name) &&
                description.equals(poll.description) &&
                compiler.equals(poll.compiler) &&
                pollCategory.equals(poll.pollCategory);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + maxResult;
        return result;
    }

    @Override
    public String toString() {
        return "Poll{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", maxResult=" + maxResult +
                ", compiler=" + compiler +
                ", pollCategory=" + pollCategory +
                '}';
    }
}
