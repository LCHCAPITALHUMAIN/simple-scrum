package controllers;

import models.JiraCategory;
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
@CRUD.For(JiraCategory.class)
public class JiraCategories extends CRUD{
}
