package system.entity;

import javax.persistence.*;

@Entity
@Table(name = "poll_form", schema = "project")
public class PollForm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "result")
    private int result;

    @ManyToOne (optional=false, cascade=CascadeType.ALL)
    @JoinColumn (name="id_user")
    private User user;

    @ManyToOne (optional=false, cascade=CascadeType.MERGE)
    @JoinColumn (name="id_poll")
    private Poll poll;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public int getResult() { return result; }
    public void setResult(int result) { this.result = result; }
    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }
    public Poll getPoll() { return poll; }
    public void setPoll(Poll poll) { this.poll = poll; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PollForm pollForm = (PollForm) o;
        return id == pollForm.id &&
                result == pollForm.result &&
                user.equals(pollForm.user) &&
                poll.equals(pollForm.poll);
    }

    @Override
    public int hashCode() {
        int hashResult = id;
        hashResult = 31 * hashResult + result;
        return hashResult;
    }

    @Override
    public String toString() {
        return "PollForm{" +
                "id=" + id +
                ", result=" + result +
                ", user=" + user +
                ", poll=" + poll +
                '}';
    }
}
