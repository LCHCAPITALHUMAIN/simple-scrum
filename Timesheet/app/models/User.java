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
    public String userName;

    @ManyToOne
    @Required
    public Location location;

    @ManyToOne
    @Required
    public Team team;

    public User(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return String.format("%s %s", userName, team);
    }
}
