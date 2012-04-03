package Utils;


import org.apache.commons.lang.StringUtils;

import javax.xml.transform.Result;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * User: n_khan
 * Date: 21/03/12
 * Time: 10:08
 * To change this template use File | Settings | File Templates.
 */
public class JiraUtil {

    public void getActuals(String jiraReference) {
        String query = "SELECT W.STARTDATE \"WORK DATE\", I.ISSUE_KEY JIRA, I.SUMMARY, W.WORKLOGBODY \"COMMENT\", round(W.TIMEWORKED/3600,1) \"TIME IN HOUR\"\n" +
                "FROM WORKLOG W join REPORT_ISSUE I on W.ISSUEID = I.id\n" +
                "WHERE I.PROJECT_KEY = 'ENT'\n" +
                "      and W.AUTHOR = 'desaip'  -- your JIRA ID (refer REPORT_USER table)\n" +
                "      and W.STARTDATE between TO_DATE('12/03/2012', 'dd/mm/yyyy') and TO_DATE('18/03/2012', 'dd/mm/yyyy')\n" +
                "ORDER BY W.STARTDATE DESC";
    }
    public static Set<String> getReleases() {
        Set<String> result = new HashSet<String> ();
        final StringBuffer componentValues = new StringBuffer();
        String query = "select distinct componentsmultivalue(r.id) as \"Compontents\"\n" +
                "from REPORT_ISSUE r\n" +
                "where r.project_key = 'REFBA'\n" +
                "and componentsmultivalue(r.id) is not null";
        executeQuery(query, new Callback() {
            public void setParameter(PreparedStatement preparedStatement) throws SQLException {
            }

            public void collectRow(ResultSet rs) throws SQLException {
                componentValues.append(rs.getString(1));
            }
        });

        String[] componentValuesSplitted = StringUtils.split(componentValues.toString(), ',');
        for (String value : componentValuesSplitted) {
            if (value.trim().endsWith("Release")) {
                result.add(value.trim());
            }
        }
        return result;

    }
    public static List<JiraDetail> getTranversalJiras(String sortColumn) {
        final List<JiraDetail> jiraDetails = new ArrayList<JiraDetail>();
        String query = getJiraDetailsQuery() +
                " I.PROJECT_KEY = 'ENT' AND i.ISSUE_KEY in ('ENT-3461','ENT-3462','ENT-3463','ENT-3464','ENT-3465','ENT-3466','ENT-3467')";

        if (sortColumn != null) {
            query += " order by " + sortColumn;
        }

        executeQuery(query, new Callback() {
            public void setParameter(PreparedStatement preparedStatement) throws SQLException {
            }

            public void collectRow(ResultSet rs) throws SQLException {
                JiraDetail jiraDetail = collectJiraDetails(rs);
                jiraDetail.category = "Transversal";
                jiraDetails.add(jiraDetail);


            }
        });
        return jiraDetails;
    }

    public static List<JiraDetail> getJiras(final int sprintNumber, String sortColumn) {
        final List<JiraDetail> jiraDetails = new ArrayList<JiraDetail>();
        String query = getJiraDetailsQuery() + " I.PROJECT_KEY = 'ENT' AND CustomNumberValue( I.id, 'Sprint')  = ?";

        if (sortColumn != null) {
            query += " order by " + sortColumn;
        }

        executeQuery(query, new Callback() {
            public void setParameter(PreparedStatement preparedStatement) throws SQLException {
                preparedStatement.setInt(1, sprintNumber);
            }

            public void collectRow(ResultSet rs) throws SQLException {
                JiraDetail jiraDetail = collectJiraDetails(rs);
                jiraDetails.add(jiraDetail);
            }
        });
        return jiraDetails;
    }

    public static List<Integer> getAllSprint() {
        String query = "select distinct(numbervalue) from REPORT_CUSTOMFIELD_VALUE cf where cfname='SPRINT' and cf.ISSUE_ID in (select id from REPORT_ISSUE r where r.PROJECT_KEY='ENT')  order by 1";
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

    public static void main(String[] args) {
        List<JiraDetail> res = getJiras(90, null);
        for (JiraDetail re : res) {
            System.out.println(re);
        }
    }

    private static String getJiraDetailsQuery() {
        return
        "SELECT CustomNumberValue( I.id, 'Sprint' ) as SPRINT, CustomStringValue( I.id, 'Category' ) as CATEGORY,\n" +
                "       (SELECT REFBA.ISSUE_KEY FROM REPORT_ISSUE REFBA WHERE REFBA.ID = L.SOURCE AND REFBA.ISSUE_KEY like 'REFBA%') \"BUSINESS_JIRA\", " +
                "       (SELECT REFBA.SUMMARY FROM REPORT_ISSUE REFBA WHERE REFBA.ID = L.SOURCE AND REFBA.ISSUE_KEY like 'REFBA%') \"BUSINESS_JIRA_DESC\", " +
                "       I.ISSUE_KEY \"IT JIRA\",\n" +
                "       I.SUMMARY as DESCRIPTION, I.PRIORITY, CustomStringValue( I.id, 'Current Phase') as STATUS,\n" +
                "       (SELECT U.FULL_NAME FROM REPORT_USER U WHERE U.USER_NAME = I.ASSIGNEE and rownum=1) as ASSIGNEE,\n" +
                "       CustomStringValue( I.id, 'Implementer team(s)') as \"Team\",\n" +
                "       round(I.TIMEORIGINALESTIMATE/3600,1) as ESTIMATE, round(I.TIMESPENT/3600,1) as ACTUAL, round(I.TIMEESTIMATE/3600,1) as REMAINING\n" +
                "FROM REPORT_ISSUE I left outer join ISSUELINK L on I.ID = L.DESTINATION\n" +
                "WHERE ";
    }

    private static JiraDetail collectJiraDetails(ResultSet rs) throws SQLException {
        JiraDetail jiraDetail = new JiraDetail();
        int columnIndex = 1;
        jiraDetail.sprint = rs.getInt(columnIndex++);
        jiraDetail.category = rs.getString(columnIndex++);

        jiraDetail.counterpartJira = new JiraDetail();
        jiraDetail.counterpartJira.jiraNumber = rs.getString(columnIndex++);
        jiraDetail.counterpartJira.description = rs.getString(columnIndex++);
        jiraDetail.jiraNumber = rs.getString(columnIndex++);
//        jiraDetail.parentJira = getJira(rs.getString(columnIndex++));
        jiraDetail.description = rs.getString(columnIndex++);
        jiraDetail.priority = rs.getString(columnIndex++);
        jiraDetail.status = rs.getString(columnIndex++);
        jiraDetail.assignee = rs.getString(columnIndex++);
        jiraDetail.team = rs.getString(columnIndex++);
        jiraDetail.estimate = rs.getInt(columnIndex++);
        jiraDetail.actual = rs.getInt(columnIndex++);
        jiraDetail.remaining = rs.getInt(columnIndex++);
        return jiraDetail;
    }

    public static JiraDetail getJira(final String jiraNumber) {
//        if(1 ==1)
//        return null;

        if (StringUtils.isEmpty(jiraNumber)) {
            return null;
        }
        System.out.println("*** hitting " + jiraNumber);
        final JiraDetail[] jira = new JiraDetail[1];
        executeQuery(getJiraDetailsQuery() + " I.PROJECT_KEY IN ('ENT','REFBA') AND I.ISSUE_KEY=?", new Callback() {
            public void setParameter(PreparedStatement preparedStatement) throws SQLException {
                preparedStatement.setString(1, jiraNumber);
            }

            public void collectRow(ResultSet rs) throws SQLException {
                jira[0] = collectJiraDetails(rs);
            }
        });
        return jira[0];
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
