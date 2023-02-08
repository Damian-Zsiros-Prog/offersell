package co.edu.unisinu.desarrollo1.model.modelDAO;

import co.edu.unisinu.desarrollo1.config.MySQLConnection;
import co.edu.unisinu.desarrollo1.model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class UsersDAO {

    Connection connection;

    public UsersDAO() {
        this.connection = new MySQLConnection().getConnection();
    }

    public List<User> list() {
        this.connection = new MySQLConnection().getConnection();
        PreparedStatement statement;
        ResultSet resultSet;
        List<User> usersList = new ArrayList<>();

        try {
            String sql = "SELECT * FROM users";
            statement = this.connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int idUser = resultSet.getInt("id_user");
                String names = resultSet.getString("names"),
                        surnames = resultSet.getString("surnames"),
                        direction = resultSet.getString("direction"),
                        email = resultSet.getString("email"),
                        password = resultSet.getString("password"),
                        phoneNumber = resultSet.getString("phoneNumber");
                int rol = resultSet.getInt("rol");
                Timestamp dateRegister = resultSet.getTimestamp("date_register");
                User userListed
                        = new User(idUser, names, surnames, direction, email, password, phoneNumber, rol, dateRegister);
                usersList.add(userListed);

            }
            resultSet.close();
            statement.close();
            this.connection.close();
            return usersList;

        } catch (SQLException e) {
            System.out.println(e.toString());
            return null;
        }

    }

    public boolean exists(String emailAtVerify) {
        this.connection = new MySQLConnection().getConnection();
        PreparedStatement statement;
        ResultSet resultSet;
        try {
            String sql = "SELECT * FROM users WHERE email = " + emailAtVerify;
            statement = this.connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                resultSet.close();
                statement.close();
                this.connection.close();
                return true;
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return false;
    }

    public User searchOne(int idUserAtFound) {
        this.connection = new MySQLConnection().getConnection();
        PreparedStatement statement;
        ResultSet resultSet;
        try {
            String sql = "SELECT * FROM users WHERE id_user = " + idUserAtFound;
            statement = this.connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int idUser = resultSet.getInt("id_user");
                String names = resultSet.getString("names"),
                        surnames = resultSet.getString("surnames"),
                        direction = resultSet.getString("direction"),
                        email = resultSet.getString("email"),
                        password = resultSet.getString("password"),
                        phoneNumber = resultSet.getString("phoneNumber");
                int rol = resultSet.getInt("rol");
                Timestamp dateRegister = resultSet.getTimestamp("date_register");
                resultSet.close();
                statement.close();
                this.connection.close();
                return new User(idUser, names, surnames, direction, email, password, phoneNumber, rol, dateRegister);
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return null;
    }

    public User signin(String emailAtSignin, String passwordAtSignin) {
        this.connection = new MySQLConnection().getConnection();
        PreparedStatement statement;
        ResultSet resultSet;
        try {
            String sql = "SELECT * FROM users WHERE email = '" + emailAtSignin
                    + "' AND password = '" + passwordAtSignin + "'";
            statement = this.connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int idUser = resultSet.getInt("id_user");
                String names = resultSet.getString("names"),
                        surnames = resultSet.getString("surnames"),
                        direction = resultSet.getString("direction"),
                        email = resultSet.getString("email"),
                        password = resultSet.getString("password"),
                        phoneNumber = resultSet.getString("phoneNumber");
                int rol = resultSet.getInt("rol");
                Timestamp dateRegister = resultSet.getTimestamp("date_register");
                return new User(idUser, names, surnames, direction, email, password, phoneNumber, rol, dateRegister);
            }
            resultSet.close();
            statement.close();
            this.connection.close();
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return null;
    }

    public boolean signup(User userAtRegister) {
        this.connection = new MySQLConnection().getConnection();
        PreparedStatement statement;
        try {
            if (!this.exists(userAtRegister.getEmail())) {
                String sql = "INSERT INTO users "
                        + "(names, surnames, direction, email, password,phoneNumber,rol) "
                        + "VALUES(?,?,?,?,?,?,?)";
                statement = this.connection.prepareStatement(sql);
                statement.setString(1, userAtRegister.getNames());
                statement.setString(2, userAtRegister.getSurnnames());
                statement.setString(3, userAtRegister.getDirection());
                statement.setString(4, userAtRegister.getEmail());
                statement.setString(5, userAtRegister.getPassword());
                statement.setString(6, userAtRegister.getPhoneNumber());
                statement.setInt(7, 2);
                statement.executeUpdate();
                statement.close();
                this.connection.close();
                return true;
            } else {
                throw new Exception("El email del usuario ya existe en otro usuario...");
            }

        } catch (Exception e) {
            System.out.println("Signup: " + e.toString());
        }
        return false;
    }

    public boolean update(int idUser, User userModified) {
        this.connection = new MySQLConnection().getConnection();
        PreparedStatement statement;
        try {
            if (this.searchOne(idUser) != null) {
                String sql = "UPDATE users SET"
                        + " names = ?, surnames = ?, direction = ?, email = ?, password = ?, rol = ?"
                        + "WHERE id_user = ?";
                statement = this.connection.prepareStatement(sql);
                statement.setString(0, userModified.getNames());
                statement.setString(1, userModified.getSurnnames());
                statement.setString(2, userModified.getDirection());
                statement.setString(3, userModified.getEmail());
                statement.setString(4, userModified.getPassword());
                statement.setInt(5, userModified.getRol());
                statement.setString(6, "" + idUser);
                statement.execute();
                statement.close();
                this.connection.close();
                return true;
            } else {
                throw new Exception("El usuario no existe...");
            }

        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return false;
    }

    public boolean delete(int idUser) {
        this.connection = new MySQLConnection().getConnection();
        PreparedStatement statement;
        try {
            if (this.searchOne(idUser) != null) {
                String sql = "DELETE users WHERE id_user = ?";
                statement = this.connection.prepareStatement(sql);
                statement.setString(1, "" + idUser);
                statement.execute();
                statement.close();
                this.connection.close();
                return true;
            } else {
                throw new Exception("El usuario no existe...");
            }

        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return false;
    }

}
