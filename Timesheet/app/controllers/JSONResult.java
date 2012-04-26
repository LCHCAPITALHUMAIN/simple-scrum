package controllers;

/**
 * Created by IntelliJ IDEA.
 * User: n_khan
 * Date: 04/04/12
 * Time: 16:53
 * To change this template use File | Settings | File Templates.
 */
public class JSONResult {
    private String result;
    private long holidayId;
    public static final String SUCCESS = "Success";

    public JSONResult(String result, long holidayId) {
        this(result);

        this.holidayId = holidayId;
    }
    public JSONResult(String result) {
        this.result = result;
    }
}
