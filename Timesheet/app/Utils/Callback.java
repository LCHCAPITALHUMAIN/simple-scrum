package Utils;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by IntelliJ IDEA.
 * User: n_khan
 * Date: 27/03/12
 * Time: 16:15
 * To change this template use File | Settings | File Templates.
 */
public interface Callback {
    void setParameter(PreparedStatement preparedStatement) throws SQLException;

    public void collectRow(ResultSet rs) throws SQLException;
}
