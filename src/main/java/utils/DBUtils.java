package utils;

import pojo.Mobile;
import pojo.UserAccount;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DBUtils {
    public static final String INSERT_INTO_MOBILE = "INSERT INTO mobile values (?, ?, ?, ?)";
    public static final String SELECT_FROM_MOBILE = "SELECT * FROM mobile WHERE id = ?";
    public static final String SELECT_ALL_FROM_MOBILE = "SELECT * FROM mobile";
    public static final String UPDATE_MOBILE = "UPDATE mobile SET model=?, price=?, manufacturer=? where id=?";
    public static final String DELETE_FROM_MOBILE = "DELETE FROM mobile WHERE id=?";
    public static final String SELECT_FROM_USERS = "SELECT * FROM users WHERE id = ?";
    public static final String INSERT_INTO_USERS = "INSERT INTO users values (?, ?)";
    public static final String UPDATE_USERS = "UPDATE users SET username=?, password=? where id=?";
    public static final String DELETE_FROM_USERS = "DELETE FROM users WHERE id=?";
    public static final String SELECT_ALL_FROM_USERS = "SELECT * FROM users";
    public static final String CREATE_TABLE_MOBILE
            = "DROP TABLE IF EXISTS mobile;\n"
            + "create table mobile\n"
            + "(\n"
            + "    id bigserial not null\n"
            + "        constraint mobile_pkey\n"
            + "            primary key,\n"
            + "    model varchar(100) not null,\n"
            + "    price integer not null,\n"
            + "    manufacturer varchar(100) not null\n"
            + ");\n"
            + "\n"
            + "alter table mobile owner to postgres;";

    public static final String CREATE_TABLE_USERS
            = "DROP TABLE IF EXISTS users;\n"
            + "create table users\n"
            + "(\n"
            + "    id bigserial not null\n"
            + "        constraint users_pkey\n"
            + "            primary key,\n"
            + "    username varchar(100) not null,\n"
            + "    password varchar(100) not null\n"
            + ");\n"
            + "\n"
            + "alter table users owner to postgres;";

    public static void createTableMobiles(Connection conn) throws SQLException{
        PreparedStatement pstm = conn.prepareStatement(CREATE_TABLE_MOBILE);
        pstm.execute();
    }

    public static void createTableUsers(Connection conn) throws SQLException{
        PreparedStatement pstm = conn.prepareStatement(CREATE_TABLE_USERS);
        pstm.execute();
    }

    public static UserAccount findUser(Connection conn,
                                       String userName, String password) throws SQLException {
        String sql = "Select a.User_Name, a.Password from User_Account a " //
                + " where a.User_Name = ? and a.password= ?";
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, userName);
        pstm.setString(2, password);
        ResultSet rs = pstm.executeQuery();
        if (rs.next()) {
            UserAccount user = new UserAccount();
            user.setUserName(userName);
            user.setPassword(password);
            return user;
        }
        return null;
    }

    public static UserAccount findUser(Connection conn, String userName) throws SQLException {
        String sql = "Select a.User_Name, a.Password from User_Account a "
                + " where a.User_Name = ? ";
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, userName);
        ResultSet rs = pstm.executeQuery();
        if (rs.next()) {
            String password = rs.getString("Password");
            UserAccount user = new UserAccount();
            user.setUserName(userName);
            user.setPassword(password);
            return user;
        }
        return null;
    }

    public static UserAccount findUserById(Connection conn, Integer id) throws SQLException {
        PreparedStatement pstm = conn.prepareStatement(SELECT_FROM_USERS);
        pstm.setInt(1, id);
        ResultSet rs = pstm.executeQuery();
        while (rs.next()) {
            return new UserAccount(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3));
        }
        return null;
    }

    public static void addUser(Connection conn, UserAccount user) throws SQLException {
        PreparedStatement pstm = conn.prepareStatement(INSERT_INTO_USERS);
        pstm.setString(1, user.getUserName());
        pstm.setString(2, user.getPassword());
        pstm.executeUpdate();
    }

    public static void updateUser(Connection conn, UserAccount user) throws SQLException {
        PreparedStatement pstm = conn.prepareStatement(UPDATE_USERS);
        pstm.setString(1, user.getUserName());
        pstm.setString(2, user.getPassword());
        pstm.setInt(3, user.getId());
        pstm.executeUpdate();
    }

    public static void deleteUser(Connection conn, Integer id) throws SQLException {
        PreparedStatement pstm = conn.prepareStatement(DELETE_FROM_USERS);
        pstm.setInt(1, id);
        pstm.executeUpdate();
    }

    public static List<UserAccount> queryUser(Connection conn) throws SQLException {
        PreparedStatement pstm = conn.prepareStatement(SELECT_ALL_FROM_USERS);
        ResultSet rs = pstm.executeQuery();
        List<UserAccount> list = new ArrayList<UserAccount>();
        while (rs.next()) {
            list.add(new UserAccount(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3)));
        }
        return list;
    }

    public static List<Mobile> queryProduct(Connection conn) throws SQLException {
        PreparedStatement pstm = conn.prepareStatement(SELECT_ALL_FROM_MOBILE);
        ResultSet rs = pstm.executeQuery();
        List<Mobile> list = new ArrayList<Mobile>();
        while (rs.next()) {
            list.add(new Mobile(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getInt(3),
                    rs.getString(4)));
        }
        return list;
    }

    public static Mobile findProduct(Connection conn, Integer id) throws SQLException {
        PreparedStatement pstm = conn.prepareStatement(SELECT_FROM_MOBILE);
        pstm.setInt(1, id);
        ResultSet rs = pstm.executeQuery();
        while (rs.next()) {
            return new Mobile(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getInt(3),
                    rs.getString(4));
        }
        return null;
    }

    public static void updateProduct(Connection conn, Mobile mobile) throws SQLException {
        PreparedStatement pstm = conn.prepareStatement(UPDATE_MOBILE);
        pstm.setString(1, mobile.getModel());
        pstm.setInt(2, mobile.getPrice());
        pstm.setString(3, mobile.getManufacturer());
        pstm.setInt(4, mobile.getId());
        pstm.executeUpdate();
    }

    public static void insertProduct(Connection conn, Mobile mobile) throws SQLException {
        PreparedStatement pstm = conn.prepareStatement(INSERT_INTO_MOBILE);
        pstm.setInt(1, mobile.getId());
        pstm.setString(2, mobile.getModel());
        pstm.setInt(3, mobile.getPrice());
        pstm.setString(4, mobile.getManufacturer());
        pstm.executeUpdate();
    }

    public static void deleteProduct(Connection conn, Integer id) throws SQLException {
        PreparedStatement pstm = conn.prepareStatement(DELETE_FROM_MOBILE);
        pstm.setInt(1, id);
        pstm.executeUpdate();
    }

}
