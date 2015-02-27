/**
 * Created by yasassri on 12/18/14.
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.*;

public class clusterDB {

    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String dbUrl = "192.168.XX.6";
    static String scriptFilePath = "script.sql";

    //  Database credentials
    static final String username = "root-user";
    static final String passWd = "root-password";

    public static void main(String[] args) {
        mysqlDbInitializer(dbUrl,username,passWd);
    }

    public static void mysqlDbInitializer(String dbURL,String username,String passWd){
        Connection conn = null;
        String dbUrl = "jdbc:mysql://"+dbURL+"/";
        try{
            Class.forName("com.mysql.jdbc.Driver");

            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(dbUrl, username, passWd);
            ScriptRunner runner = new ScriptRunner(conn, false, true);
            runner.runScript(new BufferedReader(new FileReader(scriptFilePath)));

            System.out.println("Databases created successfully!!!");
        }catch(SQLException e){
            //Handle errors for JDBC
            e.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally{
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
    }
}
