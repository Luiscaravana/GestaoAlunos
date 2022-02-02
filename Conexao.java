package Exerc7;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    public static Connection CreateConnection() throws SQLException {
        String url="jdbc:mysql://localhost:3306/users";
        String user="root";
        String pass="1234";
        Connection conexao=null;
        conexao= DriverManager.getConnection(url, user, pass);

        return conexao;

    }
}
