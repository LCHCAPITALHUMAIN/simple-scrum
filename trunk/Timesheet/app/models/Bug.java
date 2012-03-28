package models;

import play.data.validation.Required;
import play.db.jpa.Model;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

/**
 * Created by IntelliJ IDEA.
 * User: n_khan
 * Date: 28/03/12
 * Time: 12:12
 * To change this template use File | Settings | File Templates.
 */
@Entity
public class Bug extends Model {
    @Required
    public String description;

    @OneToOne
    @Required
    public User user;

    @OneToOne
    @Required
    public Criticality criticality;

    @Override
    public String toString() {
        return String.format("[%s] %s", user.fullName, description);
    }
}
