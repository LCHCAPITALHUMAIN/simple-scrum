package models;

import org.hibernate.annotations.ManyToAny;
import play.data.validation.Required;
import play.db.jpa.Model;
import play.jobs.On;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * User: nazir
 * Date: 2/13/12
 * Time: 1:56 PM
 * To change this template use File | Settings | File Templates.
 */
@Entity
public class User extends Model{
    @Required
    public String userName;
    @Required
    public String fullName;

    @ManyToOne
    @Required
    public Location location;

    @ManyToOne
    @Required
    public Team team;

    @ManyToOne
    @Required
    public Profile profile;

    @ManyToMany
    public Set<Team> managerFor = new HashSet<Team>();

    public float devPart;

    public User(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return String.format("%s-%s %s [%s]", userName, fullName, team, profile);
    }
}
