package com.nazir.customscrum.client.model;

import com.nazir.customscrum.client.model.util.DomainObject;

import javax.persistence.Embeddable;
import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: n_khan
 * Date: 11-May-2010
 * Time: 15:20:15
 * To change this template use File | Settings | File Templates.
 */
@Embeddable
public class ActualKey extends DomainObject {
    private Date sprintDayId;
    String teamMemberId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ActualKey)) return false;

        ActualKey actualKey = (ActualKey) o;

        if (!sprintDayId.equals(actualKey.sprintDayId)) return false;
        if (!teamMemberId.equals(actualKey.teamMemberId)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = sprintDayId.hashCode();
        result = 31 * result + teamMemberId.hashCode();
        return result;
    }
}