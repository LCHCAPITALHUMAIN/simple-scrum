package controllers;

import models.BugStatus;
import play.mvc.With;

/**
 * Created by IntelliJ IDEA.
 * User: n_khan
 * Date: 02/04/12
 * Time: 12:06
 * To change this template use File | Settings | File Templates.
 */
@With(Secure.class)
@Check("admin")
@CRUD.For(models.BugStatus.class)
public class BugStatusList extends CRUD{
}
