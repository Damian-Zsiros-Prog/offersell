package co.edu.unisinu.desarrollo1.model.modelDAO;

import co.edu.unisinu.desarrollo1.config.MySQLConnection;
import co.edu.unisinu.desarrollo1.model.Offer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OffersDAO {

    Connection connection;

    public OffersDAO() {
        this.connection = new MySQLConnection().getConnection();
    }

    public List<Offer> list() {
        this.connection = new MySQLConnection().getConnection();
        PreparedStatement statement;
        ResultSet resultSet;
        List<Offer> offerList = new ArrayList<>();

        try {
            String sql = "SELECT * FROM offers";
            statement = this.connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int idOffer = resultSet.getInt("id_offer");
                String image_path = resultSet.getString("image_path"),
                        name = resultSet.getString("name"),
                        description = resultSet.getString("description"),
                        state = resultSet.getString("state");
                float priceStart = resultSet.getFloat("price_start");
                int idUserSeller = resultSet.getInt("id_user_seller"),
                        idCategory = resultSet.getInt("id_category"),
                        idSubcategory = resultSet.getInt("id_subcategory");
                String limitDate = resultSet.getString("limit_date");
                Offer offer = new Offer(idOffer, name, description, image_path, state, priceStart, limitDate, idUserSeller, idSubcategory, state, idCategory);
                offerList.add(offer);
            }
            resultSet.close();
            statement.close();
            this.connection.close();
            return offerList;

        } catch (SQLException e) {
            System.out.println(e.toString());
            return null;
        }

    }

    public List<Offer> listOffersByUser(int idUser) {
        this.connection = new MySQLConnection().getConnection();
        PreparedStatement statement;
        ResultSet resultSet;
        List<Offer> offerList = new ArrayList<>();

        try {
            String sql = "SELECT * FROM offers WHERE state=1 AND id_user_seller = ?";
            statement = this.connection.prepareStatement(sql);
            statement.setInt(1, idUser);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int idOffer = resultSet.getInt("id_offer");
                String image_path = resultSet.getString("image_path"),
                        name = resultSet.getString("name"),
                        description = resultSet.getString("description"),
                        state = resultSet.getString("state");
                float priceStart = resultSet.getFloat("price_start");
                int idUserSeller = resultSet.getInt("id_user_seller"),
                        idCategory = resultSet.getInt("id_category"),
                        idSubcategory = resultSet.getInt("id_subcategory");
                String limitDate = resultSet.getString("limit_date");
                Offer offer = new Offer(idOffer, name, description, image_path, state, priceStart, limitDate, idUserSeller, idSubcategory, state, idCategory);
                offerList.add(offer);
            }
            resultSet.close();
            statement.close();
            this.connection.close();
            return offerList;

        } catch (SQLException e) {
            System.out.println(e.toString());
            return null;
        }

    }

    public List<Offer> listAcceptedOffers() {
        this.connection = new MySQLConnection().getConnection();
        PreparedStatement statement;
        ResultSet resultSet;
        List<Offer> offerList = new ArrayList<>();

        try {
            String sql = "SELECT * FROM offers WHERE state=1";
            statement = this.connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int idOffer = resultSet.getInt("id_offer");
                String image_path = resultSet.getString("image_path"),
                        name = resultSet.getString("name"),
                        description = resultSet.getString("description"),
                        state = resultSet.getString("state");
                float priceStart = resultSet.getFloat("price_start");
                int idUserSeller = resultSet.getInt("id_user_seller"),
                        idCategory = resultSet.getInt("id_category"),
                        idSubcategory = resultSet.getInt("id_subcategory");
                String limitDate = resultSet.getString("limit_date");
                Offer offer = new Offer(idOffer, name, description, image_path, state, priceStart, limitDate, idUserSeller, idSubcategory, state, idCategory);
                offerList.add(offer);
            }
            resultSet.close();
            statement.close();
            this.connection.close();
            return offerList;

        } catch (SQLException e) {
            System.out.println(e.toString());
            return null;
        }

    }

    public List<Offer> listOffersByCategory(int idCategoryAtSearch) {
        this.connection = new MySQLConnection().getConnection();
        PreparedStatement statement;
        ResultSet resultSet;
        List<Offer> offerList = new ArrayList<>();

        try {
            String sql = "SELECT * FROM offers WHERE state=1 AND id_category = ?";
            statement = this.connection.prepareStatement(sql);
            statement.setInt(1, idCategoryAtSearch);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int idOffer = resultSet.getInt("id_offer");
                String image_path = resultSet.getString("image_path"),
                        name = resultSet.getString("name"),
                        description = resultSet.getString("description"),
                        state = resultSet.getString("state");
                float priceStart = resultSet.getFloat("price_start");
                int idUserSeller = resultSet.getInt("id_user_seller"),
                        idCategory = resultSet.getInt("id_category"),
                        idSubcategory = resultSet.getInt("id_subcategory");
                String limitDate = resultSet.getString("limit_date");
                Offer offer = new Offer(idOffer, name, description, image_path, state, priceStart, limitDate, idUserSeller, idSubcategory, state, idCategory);
                offerList.add(offer);
            }
            resultSet.close();
            statement.close();
            this.connection.close();

        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return offerList;

    }

    public boolean exists(int idOffer) {
        PreparedStatement statement;
        ResultSet resultSet;
        try {
            this.connection = new MySQLConnection().getConnection();
            String sql = "SELECT * FROM offers WHERE id_offer = " + idOffer;
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

    public Offer searchOne(int idOffer) {
        PreparedStatement statement;
        ResultSet resultSet;
        try {
            this.connection = new MySQLConnection().getConnection();
            String sql = "SELECT * FROM offers WHERE id_offer = " + idOffer;
            statement = this.connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String image_path = resultSet.getString("image_path"),
                        name = resultSet.getString("name"),
                        description = resultSet.getString("description"),
                        state = resultSet.getString("state");
                float priceStart = resultSet.getFloat("price_start");
                int idUserSeller = resultSet.getInt("id_user_seller"),
                        idCategory = resultSet.getInt("id_category"),
                        idSubcategory = resultSet.getInt("id_subcategory");
                String limitDate = resultSet.getString("limit_date");
                resultSet.close();
                statement.close();
                this.connection.close();
                return new Offer(idOffer, name, description, image_path, state, priceStart, limitDate, idUserSeller, idSubcategory, state, idCategory);
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return null;
    }

    public boolean createNewOffer(Offer offerAtCreate) {
        PreparedStatement statement;
        try {
            this.connection = new MySQLConnection().getConnection();
            String sql = "INSERT INTO offers "
                    + "(image_path, name, description, state, price_start,limit_date,id_user_seller,id_category,id_subcategory) "
                    + "VALUES(?,?,?,?,?,?,?,?,?)";
            statement = this.connection.prepareStatement(sql);
            statement.setString(1, offerAtCreate.getImagePath());
            statement.setString(2, offerAtCreate.getName());
            statement.setString(3, offerAtCreate.getDescription());
            statement.setString(4, offerAtCreate.getState());
            statement.setFloat(5, offerAtCreate.getPriceStart());
            statement.setString(6, offerAtCreate.getLimitDate());
            statement.setInt(7, offerAtCreate.getIdUserSeller());
            statement.setInt(8, offerAtCreate.getIdCategory());
            statement.setInt(9, offerAtCreate.getIdSubcategory());
            statement.executeUpdate();
            statement.close();
            this.connection.close();
            return true;

        } catch (SQLException e) {
            System.out.println("Create offer: " + e.toString());
        }
        return false;
    }

    public boolean update(int idOffer, Offer offerAtModify) {
        PreparedStatement statement;
        try {
            if (this.exists(idOffer)) {
                this.connection = new MySQLConnection().getConnection();
                String sql = "UPDATE offers SET"
                        + " image_path= ?,name = ?, description= ?, state= ?, price_start= ?, "
                        + "limit_date= ?, id_category= ?, id_subcategory= ?"
                        + "WHERE id_offer=?";

                statement = this.connection.prepareStatement(sql);
                statement.setString(1, offerAtModify.getImagePath());
                statement.setString(2, offerAtModify.getName());
                statement.setString(3, offerAtModify.getDescription());
                statement.setString(4, offerAtModify.getState());
                statement.setFloat(5, offerAtModify.getPriceStart());
                statement.setString(6, offerAtModify.getLimitDate());
                statement.setInt(7, offerAtModify.getIdCategory());
                statement.setInt(8, offerAtModify.getIdSubcategory());
                statement.setInt(9, idOffer);
                statement.execute();
                statement.close();
                this.connection.close();
                return true;
            } else {
                throw new Exception("La oferta no existe...");
            }

        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return false;
    }

    public boolean acceptOffer(int idOffer) {
        PreparedStatement statement;
        try {
            if (this.exists(idOffer)) {
                this.connection = new MySQLConnection().getConnection();
                String sql = "UPDATE offers SET"
                        + " state= ?"
                        + "WHERE id_offer = ?";

                statement = this.connection.prepareStatement(sql);
                statement.setString(1, "1");
                statement.setInt(2, idOffer);
                statement.execute();
            } else {
                throw new Exception("La oferta no existe...");
            }
            statement.close();
            this.connection.close();
            return true;

        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return false;
    }

    public boolean declineOffer(int idOffer) {
        PreparedStatement statement;
        try {
            if (this.exists(idOffer)) {
                this.connection = new MySQLConnection().getConnection();
                String sql = "UPDATE offers SET"
                        + " state= ?"
                        + "WHERE id_offer = ?";

                statement = this.connection.prepareStatement(sql);
                statement.setString(1, "2");
                statement.setInt(2, idOffer);
                statement.execute();
                statement.close();
                this.connection.close();
                return true;
            } else {
                throw new Exception("La oferta no existe...");
            }

        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return false;
    }

    public boolean updateState(int idOffer, String state) {
        PreparedStatement statement;
        try {
            if (this.exists(idOffer)) {
                this.connection = new MySQLConnection().getConnection();
                String sql = "UPDATE offers SET"
                        + " state= ?"
                        + "WHERE id_offer = ?";
                statement = this.connection.prepareStatement(sql);
                statement.setString(1, state);
                statement.setInt(2, idOffer);
                statement.execute();
                statement.close();
                this.connection.close();
                return true;
            } else {
                throw new Exception("La oferta no existe...");
            }

        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return false;
    }

    public boolean delete(int idOffer) {
        PreparedStatement statement;
        try {
            if (this.exists(idOffer)) {
                this.connection = new MySQLConnection().getConnection();
                String sql = "DELETE FROM offers WHERE id_offer = ?";
                statement = this.connection.prepareStatement(sql);
                statement.setInt(1, idOffer);
                statement.execute();
                statement.close();
                this.connection.close();
                return true;
            } else {
                throw new Exception("La oferta no existe...");
            }

        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return false;
    }
}
