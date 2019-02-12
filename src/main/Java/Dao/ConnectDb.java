package Dao;

import java.sql.*;

public class ConnectDb {
    private static String driver = "com.mysql.cj.jdbc.Driver";
    private static String url = "jdbc:mysql://localhost:3306/WebSpider?characterEncoding=UTF8";
    private static String user = "root";
    private static String password = "123456";

    /*
    连接数据库
     */
    static {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    public static void closeAll(Connection conn, Statement stat, ResultSet rs) throws SQLException {
        /*
        关闭连接，释放资源
         */
        if (rs != null) {
            rs.close();
        }
        if (stat != null) {
            stat.close();
        }
        if (conn != null) {
            conn.close();
        }
    }

    public int executeSQL(String prepardSql, Object[] param) throws ClassNotFoundException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = getConnection();
            pstmt = conn.prepareStatement(prepardSql);
            if (param != null) {
                for (int i = 0; i < param.length; i++) {
                    pstmt.setObject(i + 1, param[i]);
                }
            }
            ResultSet num = pstmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                ConnectDb.closeAll(conn, pstmt, null);
            } catch (SQLException es) {
                es.printStackTrace();
            }
        }
        return 0;
    }
}

