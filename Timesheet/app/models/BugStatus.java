package models;

import play.db.jpa.Model;

import javax.persistence.Entity;

/**
 * Created by IntelliJ IDEA.
 * User: n_khan
 * Date: 02/04/12
 * Time: 12:05
 * To change this template use File | Settings | File Templates.
 */
@Entity

public class BugStatus extends Model{
    public String code;

    @Override
    public String toString() {
        return code;
    }
}
