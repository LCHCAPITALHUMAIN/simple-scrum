package controllers;

import play.mvc.With;

/**
 * Created by IntelliJ IDEA.
 * User: n_khan
 * Date: 20/03/12
 * Time: 16:57
 * To change this template use File | Settings | File Templates.
 */
@With(Secure.class)

public class Admin extends CRUD{

}
