package models;

import controllers.CRUD;
import play.db.jpa.Model;

import javax.persistence.Entity;
import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: nazir
 * Date: 4/3/12
 * Time: 7:02 PM
 * To change this template use File | Settings | File Templates.
 */
@Entity
public class Remaining extends Model {
    public Date date;
    public Float remaining;
}
