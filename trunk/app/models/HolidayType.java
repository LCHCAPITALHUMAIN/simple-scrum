package models;

import play.data.validation.Required;
import play.db.jpa.Model;

import javax.persistence.Entity;

/**
 * Created by IntelliJ IDEA.
 * User: nazir
 * Date: 2/17/12
 * Time: 8:57 PM
 * To change this template use File | Settings | File Templates.
 */
@Entity
public class HolidayType extends Model{
    @Required
    public String code;

    @Required
    public String description;

    @Required
    public String color;

    @Override
    public String toString() {
        return String.format("[%s] %s", code, description);
    }
}
