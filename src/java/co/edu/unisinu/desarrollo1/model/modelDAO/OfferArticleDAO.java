package co.edu.unisinu.desarrollo1.model.modelDAO;

import co.edu.unisinu.desarrollo1.config.MySQLConnection;
import co.edu.unisinu.desarrollo1.model.Offer;
import co.edu.unisinu.desarrollo1.model.OfferArticle;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OfferArticleDAO {

    Connection connection;

    public OfferArticleDAO() {
        this.connection = new MySQLConnection().getConnection();
    }

    public boolean addOfferOfUser(OfferArticle offerAtAdd) {
        PreparedStatement statement;
        try {
            String sql = "INSERT INTO `offers_users`"
                    + "(`id_user`, `id_offer`, `price_offer`) "
                    + "VALUES (?,?,?)";
            statement = this.connection.prepareStatement(sql);
            statement.setInt(1, offerAtAdd.getIdUser());
            statement.setInt(2, offerAtAdd.getIdOffer());
            statement.setFloat(3, offerAtAdd.getPriceOffer());
            statement.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.out.println("Add offer of user: " + e.toString());
        }
        return false;
    }

    public List<OfferArticle> listOferters(int idOffer) {
        PreparedStatement statement;
        ResultSet resultSet;
        List<OfferArticle> ofertersList = new ArrayList<>();

        try {
            String sql = "SELECT * FROM offers_users WHERE id_offer = ?";
            statement = this.connection.prepareStatement(sql);
            statement.setInt(1, idOffer);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int idOfferUser = resultSet.getInt("id_offer_user");
                idOffer = resultSet.getInt("id_offer");
                int idUser = resultSet.getInt("id_user");
                float priceOffer = resultSet.getFloat("price_offer");
                OfferArticle offerArticle = new OfferArticle(idOfferUser, idUser, priceOffer, idOffer);
                ofertersList.add(offerArticle);
            }
            return ofertersList;

        } catch (SQLException e) {
            System.out.println(e.toString());
            return null;
        }
    }

    public List<OfferArticle> listOffersMakeMe(int idUser) {
        PreparedStatement statement;
        ResultSet resultSet;
        List<OfferArticle> ofertersList = new ArrayList<>();

        try {
            String sql = "SELECT * FROM offers_users WHERE id_user = ?";
            statement = this.connection.prepareStatement(sql);
            statement.setInt(1, idUser);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int idOfferUser = resultSet.getInt("id_offer_user");
                int idOffer = resultSet.getInt("id_offer");
                idUser = resultSet.getInt("id_user");
                float priceOffer = resultSet.getFloat("price_offer");
                OfferArticle offerArticle = new OfferArticle(idOfferUser, idUser, priceOffer, idOffer);
                ofertersList.add(offerArticle);
            }
            return ofertersList;

        } catch (SQLException e) {
            System.out.println(e.toString());
            return null;
        }
    }

    public boolean sellOfferAtUser(OfferArticle offerAtSell) {
        PreparedStatement statement;
        try {
            String sql = "DELETE FROM`offers_users` WHERE id_offer=?";
            statement = this.connection.prepareStatement(sql);
            statement.setInt(1, offerAtSell.getIdOffer());
            statement.executeUpdate();
            sql = "UPDATE `offers` SET state=3 WHERE id_offer=?";
            statement = this.connection.prepareStatement(sql);
            statement.setInt(1, offerAtSell.getIdOffer());
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Sell offer at user: " + e.toString());
        }
        return false;
    }
}
