package models;

import play.db.jpa.Model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static Utils.CalendarUtil.formatDate;

/**
 * Created by IntelliJ IDEA.
 * User: n_khan
 * Date: 03/04/12
 * Time: 11:40
 * To change this template use File | Settings | File Templates.
 */
@Entity
public class Sprint extends Model {
    public int sprintNumber;
    public Date startDate;
    public Date endDate;
    @Transient
    public List<SprintJira> sprintJiras = new ArrayList<SprintJira>();

    @Override
    public String toString() {
        return String.format("Sprint %s: (%s, %s)", sprintNumber, formatDate(startDate), formatDate(endDate));
    }

    public String getSprintName() {
        return String.format("Sprint %s", sprintNumber);
    }
}
