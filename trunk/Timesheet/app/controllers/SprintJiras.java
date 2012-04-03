package controllers;

import play.mvc.With;

/**
 * Created by IntelliJ IDEA.
 * User: n_khan
 * Date: 03/04/12
 * Time: 11:52
 * To change this template use File | Settings | File Templates.
 */
@With(Secure.class)
@Check("admin")

public class SprintJiras extends CRUD{
}
