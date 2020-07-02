package clientServerConnection.server.mediator;
import java.sql.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DBSHelper {
    public static Connection con = null;
    public static DBSHelper instance;
    private static Lock lock = new ReentrantLock();

    public DBSHelper() {
        if(con==null){
            //Configure and start dataase
            ConfigureConnection();
        }
    }

    private void ConfigureConnection() {
        try {
          Class.forName("org.postgresql.Driver");
            //database information
            String dbUser = "postgres";
            String dbPass = "Sebbedaman123";
            String SCHEMA = "PoetForumV2";
            //Establishing connection
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres",dbUser,dbPass);
            Statement stmnt = con.createStatement();
            stmnt.execute("SET SEARCH_PATH TO " + SCHEMA);
            stmnt.close();
        }catch (ClassNotFoundException| SQLException e){
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    //gets instance of singelton
    public static DBSHelper getInstance() {
        if (instance == null) {
            synchronized (lock) {
                if (instance == null) {
                    instance = new DBSHelper();
                }
            }
        }
        return instance;
    }

    public PreparedStatement getPreparedStatement(String sql) throws SQLException {
        return con.prepareStatement(sql);
    }

}



