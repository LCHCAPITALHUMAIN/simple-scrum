package models;

import play.data.binding.As;
import play.data.validation.Required;
import play.db.jpa.Model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: nazir
 * Date: 2/13/12
 * Time: 1:55 PM
 * To change this template use File | Settings | File Templates.
 */
@Entity
public class PublicHoliday extends Model {
    @OneToOne
    @Required
    public Location location;

    @Required
    @As("dd-MM-yyyy")
    public Date date;

    public String description;


    public PublicHoliday(Location location, Date date, String description) {
        this.location = location;
        this.date = date;
        this.description = description;
    }

    @Override
    public String toString() {
        return String.format("%s [%s] %s", date, location.code, description);
    }
}
