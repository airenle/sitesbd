package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SelectPageDao extends ConnectDb implements PageDao {
    @Override
    public List<Page> findAllPages() throws Exception {
        Connection conn = ConnectDb.getConnection();
        String sql = "select * from sitebd";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        List<Page> bdpage = new ArrayList<>();
        while (rs.next()) {
            Page page = new Page();
            page.setType(rs.getString("type"));
            page.setLink(rs.getString("link"));
            page.setContent(rs.getString("content"));
            bdpage.add(page);
        }
        ConnectDb.closeAll(conn, pstmt, rs);
        return bdpage;
    }

    @Override
    public List<Page> findByType(String type) throws Exception {
        Connection conn = ConnectDb.getConnection();
        String sql = "select * from sitebd where type = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, type);
        ResultSet rs = pstmt.executeQuery();
        List<Page> bdpage = new ArrayList<>();
        while (rs.next()) {
            Page page = new Page();
            page.setType(rs.getString("type"));
            page.setLink(rs.getString("link"));
            page.setContent(rs.getString("content"));
            bdpage.add(page);
        }
        ConnectDb.closeAll(conn, pstmt, rs);
        return bdpage;
    }

    @Override
    public void add(Page p) throws Exception {
        String sql = "insert into sitebd(type,link,content)values(?,?,?)";
        Connection conn = ConnectDb.getConnection();
        PreparedStatement psmt = conn.prepareStatement(sql);
        try {

            psmt.setString(1, p.getType());
            psmt.setString(2, p.getLink());
            psmt.setString(3, p.getContent());
            psmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException("数据添加失败！");
        } finally {
            ConnectDb.closeAll(conn, psmt, null);
        }

    }

    @Override
    public void update(int id) throws Exception {

    }

    @Override
    public void delete(int id) throws Exception {

    }
}
