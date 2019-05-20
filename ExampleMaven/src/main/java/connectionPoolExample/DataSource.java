package connectionPoolExample;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

public class DataSource {

    private static volatile DataSource dataSource;
    private ComboPooledDataSource cpds;

    private DataSource() throws PropertyVetoException {
        cpds = new ComboPooledDataSource(); // Не пул потоков, а пул соединений, хранит в себе несколько объектов Connection
        cpds.setDriverClass("org.postgresql.Driver"); //регистрация драйвера
        cpds.setJdbcUrl("jdbc:postgresql://localhostL5432/exampleDB");
        cpds.setUser("matveevkp");
        cpds.setPassword("12345678");

        cpds.setMinPoolSize(1);
        cpds.setMaxPoolSize(10);

    }


    public static DataSource getInstance() {

        if (dataSource == null) {

            synchronized (DataSource.class) {
                if (dataSource == null) {
                    try {

                        dataSource = new DataSource();
                    } catch (PropertyVetoException e) {
                        e.printStackTrace();
                    }
                }
            }

        }
        return dataSource;
    }


    public Connection connection() throws SQLException {
        return cpds.getConnection();
    }

    public static Connection getCoonection() throws SQLException {
        return getInstance().connection();
    }

}


class ConnectionPool {
    public static void main(String[] args) throws SQLException {
        Connection connection = DataSource.getCoonection();


    }
}