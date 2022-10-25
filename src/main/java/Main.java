import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

    private final static String URL = "jdbc:mysql://localhost/myBASE";
    private final static String USERNAME = "root";
    private final static String PASSWORD = "Pass*5672";

    public static void main(String[] args) {

        try(Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);)
        {
            Statement statement = connection.createStatement();
            DBManager dbManager = new DBManager();

            System.out.println("------------------------------------------------");
            System.out.println("Younger than 18: ");
            dbManager.execute(statement, dbManager.LESS_18);
            System.out.println("------------------------------------------------");
            System.out.println("The names ends in 'o': ");
            dbManager.execute(statement, dbManager.O_ENDING);
            System.out.println("------------------------------------------------");
            System.out.println("Users whose age between 18 and 60: ");
            dbManager.execute(statement, dbManager.AGE18_60);
            System.out.println("------------------------------------------------");
            System.out.println("The names that include the letter 'a': ");
            dbManager.execute(statement, dbManager.A_CONTAINS);
            System.out.println("------------------------------------------------");
            System.out.println("Adult users : ");
            dbManager.execute(statement, dbManager.OLDER_18);
        }
        catch (SQLException e )
        {
            System.out.printf("Error:" + e.getMessage());
        }

    }
}
