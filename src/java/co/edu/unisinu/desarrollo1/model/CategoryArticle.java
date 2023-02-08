package co.edu.unisinu.desarrollo1.model;

public class CategoryArticle {
    private int idCategory;
    private String name;

    public CategoryArticle(int idCategory, String name) {
        this.idCategory = idCategory;
        this.name = name;
    }
    public CategoryArticle(int idCategory) {
        this.idCategory = idCategory;
    }

    public int getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
