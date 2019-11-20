package system.entity;

import javax.persistence.*;

@Entity
@Table(name = "contactinformation", schema = "project")
public class ContactInformation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idContact;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "position")
    private String position;

    @ManyToOne (optional=false, cascade=CascadeType.ALL)
    @JoinColumn (name="id_user")
    private User user;

    public int getIdContact() {
        return idContact;
    }
    public void setIdContact(int idContact) {
        this.idContact = idContact;
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
        return idContact == that.idContact &&
                name.equals(that.name) &&
                email.equals(that.email) &&
                position.equals(that.position) &&
                user.equals(that.user);
    }

    @Override
    public int hashCode() {
        int result = idContact;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (position != null ? position.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ContactInformation{" +
                "idContact=" + idContact +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", position='" + position + '\'' +
                ", user=" + user +
                '}';
    }
}
