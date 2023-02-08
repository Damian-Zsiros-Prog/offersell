package co.edu.unisinu.desarrollo1.model;

public class SubcategoryArticle extends CategoryArticle {

    private int idSubcategory;
    private String nameSubcategory;
    
    public SubcategoryArticle(int idSubcategory, String nameSubcategory, int idCategory) {
        super(idCategory);
        this.idSubcategory = idSubcategory;
        this.nameSubcategory = nameSubcategory;
        
    }
    
    public SubcategoryArticle(int idSubcategory, int idCategory) {
        super(idCategory);
        this.idSubcategory = idSubcategory;
        
    }
    
    public SubcategoryArticle() {
        super(0);
    }
    
    public int getIdSubcategory() {
        return idSubcategory;
    }
    
    public void setIdSubcategory(int idSubcategory) {
        this.idSubcategory = idSubcategory;
    }
    
    public String getNameSubcategory() {
        return nameSubcategory;
    }
    
    public void setNameSubcategory(String nameSubcategory) {
        this.nameSubcategory = nameSubcategory;
    }
    
}
