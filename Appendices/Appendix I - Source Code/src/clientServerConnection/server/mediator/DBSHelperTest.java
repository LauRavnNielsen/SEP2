package clientServerConnection.server.mediator;

import org.junit.Before;
import org.junit.Test;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.Assert.*;

public class DBSHelperTest {

    DBSHelper db;
    @Before
    public void setup() {db = new DBSHelper();}

    @Test
    public void TestGetPreparedStatement() throws SQLException {
        String querysql = "SELECT userName, password, emailAddress, rank, f_name, l_name, dob FROM MyPage;";
        db.getPreparedStatement(querysql);
        assertEquals(db.getPreparedStatement(querysql).toString(),"SELECT userName, password, emailAddress, " +
                "rank, f_name, l_name, dob FROM MyPage");
        System.out.println(db.getPreparedStatement(querysql).toString());
    }
    @Test(expected = SQLException.class)
    public void TestGetSQLExeption() throws SQLException {
        String querysql = "SELECT userName, password, emailAddress, rank, f_name, l_name, dob FROM lol;";
        PreparedStatement queryStudenStatement = db.getPreparedStatement(querysql);
        ResultSet resultSet = queryStudenStatement.executeQuery();

    }
}