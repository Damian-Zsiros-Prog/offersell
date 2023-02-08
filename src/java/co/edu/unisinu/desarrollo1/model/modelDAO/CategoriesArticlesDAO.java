package co.edu.unisinu.desarrollo1.model.modelDAO;

import co.edu.unisinu.desarrollo1.config.MySQLConnection;
import co.edu.unisinu.desarrollo1.model.CategoryArticle;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoriesArticlesDAO {

    Connection con;

    public CategoriesArticlesDAO() {
        this.con = new MySQLConnection().getConnection();
    }

    public List<CategoryArticle> listCategories() {
        PreparedStatement ps;
        List<CategoryArticle> categoriesList = new ArrayList<>();

        try { 
            ps = this.con.prepareStatement("SELECT * FROM categories");
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    int idCategory = rs.getInt("id_category");
                    String name = rs.getString("name");
                    CategoryArticle categoryArticle = new CategoryArticle(idCategory, name);
                    categoriesList.add(categoryArticle);
                }
            }
            ps.close();
            this.con.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return categoriesList;
    }

    public CategoryArticle getCategorieOne(int idCategory) {
        this.con = new MySQLConnection().getConnection();
        PreparedStatement ps;
        try {
            ps = this.con.prepareStatement("SELECT * FROM categories WHERE id_category=?");
            ps.setInt(1, idCategory);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    String name = rs.getString("name");
                    CategoryArticle categoryArticle = new CategoryArticle(idCategory, name);
                    return categoryArticle;
                }
            }
            ps.close();
            this.con.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

}
