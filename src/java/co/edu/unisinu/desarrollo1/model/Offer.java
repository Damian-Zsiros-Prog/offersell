package co.edu.unisinu.desarrollo1.model;

import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Offer extends SubcategoryArticle {

    private int idOffer;
    private String name;
    private String description;
    private String imagePath;
    private String state;
    private float priceStart;
    private String limitDate;
    private int idUserSeller;

    public Offer(int idOffer, String name, String description, String imagePath, String state, float priceStart, String limitDate, int idUserSeller, int idSubcategory, String nameSubcategory, int idCategory) {
        super(idSubcategory, nameSubcategory, idCategory);
        this.idOffer = idOffer;
        this.name = name;
        this.description = description;
        this.imagePath = imagePath;
        this.state = state;
        this.priceStart = priceStart;
        this.limitDate = limitDate;
        this.idUserSeller = idUserSeller;
    }

    public Offer(int idOffer, String name, String description, String imagePath, String state, float priceStart, String limitDate, int idUserSeller, int idSubcategory, int idCategory) {
        super(idSubcategory, idCategory);
        this.idOffer = idOffer;
        this.name = name;
        this.description = description;
        this.imagePath = imagePath;
        this.state = state;
        this.priceStart = priceStart;
        this.limitDate = limitDate;
        this.idUserSeller = idUserSeller;
    }

    public Offer(int idOffer, String name, String description, String imagePath, String state, float priceStart, String limitDate, int idUserSeller) {
        this.idOffer = idOffer;
        this.name = name;
        this.description = description;
        this.imagePath = imagePath;
        this.state = state;
        this.priceStart = priceStart;
        this.limitDate = limitDate;
        this.idUserSeller = idUserSeller;
    }

    public Offer(String name, String description, String imagePath, String state, float priceStart, String limitDate, int idUserSeller, int idSubcategory, int idCategory) {
        super(idSubcategory, idCategory);
        this.name = name;
        this.description = description;
        this.imagePath = imagePath;
        this.state = state;
        this.priceStart = priceStart;
        this.limitDate = limitDate;
        this.idUserSeller = idUserSeller;
    }

    public Offer(int idOffer) {
        this.idOffer = idOffer;
    }


    public int getIdOffer() {
        return idOffer;
    }

    public void setIdOffer(int idOffer) {
        this.idOffer = idOffer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public float getPriceStart() {
        return priceStart;
    }

    public void setPriceStart(float priceStart) {
        this.priceStart = priceStart;
    }

    public String getLimitDate() {
        return limitDate;
    }

    public void setLimitDate(String limitDate) {
        this.limitDate = limitDate;
    }

    public int getIdUserSeller() {
        return idUserSeller;
    }

    public void setIdUserSeller(int idUserSeller) {
        this.idUserSeller = idUserSeller;
    }



}
