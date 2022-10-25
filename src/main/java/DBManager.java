import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DBManager {

    public final  String AGE18_60 = """
            SELECT * FROM user WHERE age BETWEEN 18 AND 60
            """;
    public final  String LESS_18 = """
            SELECT * FROM user WHERE age < 18
            """;
    public final  String O_ENDING   = """
            SELECT * FROM user WHERE first_name LIKE "%o"
            """;
    public final  String A_CONTAINS   = """
            SELECT * FROM user WHERE first_name LIKE "a%" OR first_name LIKE "%a%" OR first_name LIKE "%a"
            """;
    public final  String OLDER_18 = """
            SELECT * FROM user WHERE age >= 18
            """;

    public void execute(Statement statement, String query){
        try{
        var resultSET = statement.executeQuery(query);
        var users = new ArrayList<>();
        while (resultSET.next())
        {
            //System.out.println(resultSET.getString("first_name")+" "+resultSET.getString("last_name"));
            User user = new User();
            user.setId(resultSET.getInt("id"));
            user.setFirstName(resultSET.getString("first_name"));
            user.setLastName(resultSET.getString("last_name"));
            user.setAge(resultSET.getInt("age"));
            user.setGender(resultSET.getString("gender"));

            users.add(user);
        }
            users.forEach(System.out::println);
        }
        catch (SQLException e)
        {
            System.out.println(e);
        }
    }
}
