package models;

import play.db.jpa.Model;

import javax.persistence.Entity;

/**
 * Created by IntelliJ IDEA.
 * User: nazir
 * Date: 4/3/12
 * Time: 9:12 PM
 * To change this template use File | Settings | File Templates.
 */
@Entity
public class JiraCategory extends Model{
    public String name;

    @Override
    public String toString() {
        return name;
    }
}
