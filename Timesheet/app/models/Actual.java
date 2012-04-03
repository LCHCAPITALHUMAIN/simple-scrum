package models;

import Utils.CalendarUtil;
import play.data.validation.Required;
import play.db.jpa.Model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.util.Date;

import static Utils.CalendarUtil.*;

/**
 * Created by IntelliJ IDEA.
 * User: n_khan
 * Date: 03/04/12
 * Time: 11:51
 * To change this template use File | Settings | File Templates.
 */
@Entity
public class Actual extends Model{
    @Required
    @ManyToOne
    public User user;

    @Required
    public Date date;

    @Required
    public Float actual;

    @Override
    public String toString() {
        return String.format("%s %s %s", user.fullName, formatDate(date), actual);
    }
}
