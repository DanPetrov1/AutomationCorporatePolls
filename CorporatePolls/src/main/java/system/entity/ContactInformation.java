package system.entity;

import javax.persistence.*;

@Entity
@Table(name = "contactinformation", schema = "project")
public class ContactInformation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_contact")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "position")
    private String position;

    @Column(name = "number_of_polls")
    private int numberOfPolls;

    @ManyToOne (optional=false, cascade=CascadeType.ALL)
    @JoinColumn (name="users_id")
    private User user;

    public int getNumberOfPolls() { return numberOfPolls; }
    public void setNumberOfPolls(int numberOfPolls) { this.numberOfPolls = numberOfPolls; }
    public int getId() {
        return id;
    }
    public void setId(int idContact) {
        this.id = idContact;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPosition() { return position; }
    public void setPosition(String position) { this.position = position; }
    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactInformation that = (ContactInformation) o;
        return id == that.id &&
                name.equals(that.name) &&
                email.equals(that.email) &&
                position.equals(that.position) &&
                user.equals(that.user) &&
                numberOfPolls == that.numberOfPolls;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (position != null ? position.hashCode() : 0);
        result = 31 * result + numberOfPolls;
        return result;
    }

    @Override
    public String toString() {
        return "ContactInformation{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", position='" + position + '\'' +
                ", numberOfPolls=" + numberOfPolls +
                ", user=" + user +
                '}';
    }
}
