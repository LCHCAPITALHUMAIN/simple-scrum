package Utils;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: n_khan
 * Date: 21/03/12
 * Time: 10:08
 * To change this template use File | Settings | File Templates.
 */
public class JiraUtil {

    public static List<JiraDetail> getJiras(final int sprintNumber, String sortColumn) {
        final List<JiraDetail> jiraDetails = new ArrayList<JiraDetail>();

        String query = "SELECT CustomNumberValue( I.id, 'Sprint' ) as SPRINT, CustomStringValue( I.id, 'Category' ) as CATEGORY,\n" +
                "       (SELECT REFBA.ISSUE_KEY FROM REPORT_ISSUE REFBA WHERE REFBA.ID = L.SOURCE AND REFBA.ISSUE_KEY like 'REFBA%') \"BUSINESS_JIRA\", I.ISSUE_KEY \"IT JIRA\",\n" +
                "       I.SUMMARY as DESCRIPTION, I.PRIORITY, CustomStringValue( I.id, 'Current Phase') as STATUS,\n" +
                "       (SELECT U.FULL_NAME FROM REPORT_USER U WHERE U.USER_NAME = I.ASSIGNEE and rownum=1) as ASSIGNEE,\n" +
                "       CustomStringValue( I.id, 'Implementer team(s)') as \"Team\",\n" +
                "       round(I.TIMEORIGINALESTIMATE/3600,1) as ESTIMATE, round(I.TIMESPENT/3600,1) as ACTUAL, round(I.TIMEESTIMATE/3600,1) as REMAINING\n" +
                "FROM REPORT_ISSUE I left outer join ISSUELINK L on I.ID = L.DESTINATION\n" +
                "WHERE I.PROJECT_KEY = 'ENT' AND\n" +
                "      CustomNumberValue( I.id, 'Sprint')  = ?";

        if (sortColumn != null) {
            query += " order by " + sortColumn;
        }

        executeQuery(query, new Callback() {
            public void setParameter(PreparedStatement preparedStatement) throws SQLException {
                preparedStatement.setInt(1, sprintNumber);
            }

            public void collectRow(ResultSet rs) throws SQLException {
                JiraDetail jiraDetail = new JiraDetail();
                int columnIndex = 1;
                jiraDetail.sprint = rs.getInt(columnIndex++);
                jiraDetail.category = rs.getString(columnIndex++);
                jiraDetail.businessJira = rs.getString(columnIndex++);
                jiraDetail.itJira = rs.getString(columnIndex++);
                jiraDetail.description = rs.getString(columnIndex++);
                jiraDetail.priority = rs.getString(columnIndex++);
                jiraDetail.status = rs.getString(columnIndex++);
                jiraDetail.assignee = rs.getString(columnIndex++);
                jiraDetail.team = rs.getString(columnIndex++);
                jiraDetail.estimate = rs.getInt(columnIndex++);
                jiraDetail.actual = rs.getInt(columnIndex++);
                jiraDetail.remaining = rs.getInt(columnIndex++);

                jiraDetails.add(jiraDetail);


            }
        });
        return jiraDetails;
    }
    public static List<Integer> getAllSprint() {
        String query = "select distinct(numbervalue) from REPORT_CUSTOMFIELD_VALUE cf where cfname='SPRINT' and cf.ISSUE_ID in (select id from REPORT_ISSUE r where r.PROJECT_KEY='ENT')";
        final List<Integer> jiraDetails = new ArrayList<Integer>();
        executeQuery(query, new Callback() {
            public void setParameter(PreparedStatement preparedStatement) throws SQLException {

            }

            public void collectRow(ResultSet rs) throws SQLException {
                jiraDetails.add(rs.getInt(1));
            }
        });
        return jiraDetails;
    }

    public static List<String> getAllTeam() {
        String query = "select distinct(stringvalue) from REPORT_CUSTOMFIELD_VALUE cf where cfname=upper('Implementer team(s)') and cf.ISSUE_ID in (select id from REPORT_ISSUE r where r.PROJECT_KEY='ENT')";
        final List<String> teams = new ArrayList<String>();

        executeQuery(query, new Callback() {
            public void setParameter(PreparedStatement preparedStatement) throws SQLException {
            }

            public void collectRow(ResultSet rs) throws SQLException {
                teams.add(rs.getString(1));
            }
        });
        return teams;
    }
    private static void executeQuery(String query, Callback callback) {
        String jdbcURL = "jdbc:oracle:thin:@jir2ukl.uk.net.intra:1531:JIR2UKL";
        String user = "jira_ro";
        String passwd = "endure";
        Connection conn = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
            conn = DriverManager.getConnection(jdbcURL, user, passwd);
            PreparedStatement pstmt = conn.prepareStatement(query);
            callback.setParameter(pstmt);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                callback.collectRow(rs);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
