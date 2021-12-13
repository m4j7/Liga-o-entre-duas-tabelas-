package Factory;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConectionFactory {

    public Connection getConnection(){
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost/tabelaprod", "MariaJulia", "M99905406");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
