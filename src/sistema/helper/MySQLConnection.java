package sistema.helper;

import java.sql.*;

public class MySQLConnection {
    private String url;
    private String user;
    private String password;

    public MySQLConnection(String database, String user, String password, String host) {
        this.url = "jdbc:mysql://" + host + ":3306/" + database;
        this.user = user;
        this.password = password;
    }

    public MySQLConnection(String database, String user, String password, String host, int port) {
        this.url = "jdbc:mysql://" + host + ":" + port + "/" + database;
        this.user = user;
        this.password = password;
    }

    public Connection getConnection() throws SQLException {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Conexão realizada com sucesso !");
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Erro ao realizar a conexão com o banco !");
            e.printStackTrace();
        }
        return conn;
    }
}
