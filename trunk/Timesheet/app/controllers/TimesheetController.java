package controllers;

import play.mvc.Before;
import play.mvc.Controller;

/**
 * Created by IntelliJ IDEA.
 * User: n_khan
 * Date: 28/03/12
 * Time: 11:51
 * To change this template use File | Settings | File Templates.
 */
public class TimesheetController extends Controller {
    public static void renderJSONSuccessResult() {
        renderJSONResult("Success");
    }
    public static void renderJSONResult(String result) {
        renderJSON(new JSONResult(result));
    }

    @Before
    public static void setVariables() {
//        renderArgs.put("selectedMenu", "Naz");
    }
}
