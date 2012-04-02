package models;

import play.data.validation.Required;
import play.data.validation.Unique;
import play.db.jpa.Model;

import javax.persistence.Entity;

/**
 * Created by IntelliJ IDEA.
 * User: nazir
 * Date: 3/23/12
 * Time: 11:52 PM
 * To change this template use File | Settings | File Templates.
 */
@Entity
public class Profile extends Model {
    @Unique(message = "This profileName is already used.")
    @Required
    public String profileName;

    @Override
    public String toString() {
        return "Profile{" +
                 profileName +
                '}';
    }
}
