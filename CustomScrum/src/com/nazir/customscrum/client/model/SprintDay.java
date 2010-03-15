package com.nazir.customscrum.client.model;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: nazir
 * Date: Mar 6, 2010
 * Time: 8:06:04 AM
 * To change this template use File | Settings | File Templates.
 */
@Entity
public class SprintDay  extends DomainObject{
    @Id
    private Date date;
    private String comment;
}
