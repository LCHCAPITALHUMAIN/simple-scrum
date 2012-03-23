package controllers;

import play.mvc.With;

/**
 * Created by IntelliJ IDEA.
 * User: nazir
 * Date: 2/13/12
 * Time: 2:27 PM
 * To change this template use File | Settings | File Templates.
 */
@With(Secure.class)
@Check("admin")
public class Teams extends CRUD{
}
