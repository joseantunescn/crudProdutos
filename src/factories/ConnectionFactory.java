package factories;

public class ConnectionFactory {

    //method to return a connection to the database
    public static java.sql.Connection getConnection() throws exception {
        var host = "jdbc:postgresql://localhost:5432/dbprodutos";
        var user = "postgres";
        var pass = "coti";

        //return the connection
        return DriverManager.getConnection(host, user, pass);

        }
    }