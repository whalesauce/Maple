package util.SQL;

import org.jooq.SQL;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by williamallen on 4/17/18.
 */
public class SQLHandler {

    public static Connection connection;


  public static void openConnection(String url, String user, String pass) throws SQLException {


          connection = DriverManager.getConnection(url, user, pass);


  }


  public static void addQuery(String query){

      /**
       *
       *
       */



  }



  public static void closeConnection() throws SQLException {
      if(connection.isClosed()){
          //Log connection is already closed
      }else{
          connection.close();
      }

  }




}
