package models;

import play.data.validation.Required;
import play.db.jpa.Model;

import javax.persistence.Entity;

/**
 * Created by IntelliJ IDEA.
 * User: n_khan
 * Date: 28/03/12
 * Time: 12:38
 * To change this template use File | Settings | File Templates.
 */
@Entity
public class Criticality extends Model{
    @Required
    public String description;

    @Override
    public String toString() {
        return description;
    }
}
