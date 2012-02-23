package models;

import play.db.jpa.Model;

import javax.persistence.Entity;

/**
 * Created by IntelliJ IDEA.
 * User: nazir
 * Date: 2/16/12
 * Time: 10:43 PM
 * To change this template use File | Settings | File Templates.
 */
@Entity
public class Team extends Model{
    public String name;

    @Override
    public String toString() {
        return name;
    }
}
