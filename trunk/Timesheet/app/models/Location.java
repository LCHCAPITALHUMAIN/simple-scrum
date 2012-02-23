package models;

import play.db.jpa.Model;

import javax.persistence.Entity;

/**
 * Created by IntelliJ IDEA.
 * User: nazir
 * Date: 2/16/12
 * Time: 11:02 PM
 * To change this template use File | Settings | File Templates.
 */
@Entity
public class Location extends Model {
    public String code;

    @Override
    public String toString() {
        return code;
    }
}
