package co.edu.unisinu.desarrollo1.model;

import java.sql.Timestamp;

public class OfferArticle extends Offer {

    private int idOfferUser;
    private int idUser;
    private float priceOffer;
    private Timestamp dateOfferUser;

    public OfferArticle(int idUser, float priceOffer, Timestamp dateOfferUser, int idOffer, String name, String description, String imagePath, String state, float priceStart, String limitDate, int idUserSeller, int idSubcategory, String nameSubcategory, int idCategory) {
        super(idOffer, name, description, imagePath, state, priceStart, limitDate, idUserSeller, idSubcategory, nameSubcategory, idCategory);
        this.idUser = idUser;
        this.priceOffer = priceOffer;
        this.dateOfferUser = dateOfferUser;
    }

    public OfferArticle(int idUser, float priceOffer, Timestamp dateOfferUser, int idOffer, String name, String description, String imagePath, String state, float priceStart, String limitDate, int idUserSeller, int idSubcategory, int idCategory) {
        super(idOffer, name, description, imagePath, state, priceStart, limitDate, idUserSeller, idSubcategory, idCategory);
        this.idUser = idUser;
        this.priceOffer = priceOffer;
        this.dateOfferUser = dateOfferUser;
    }

    public OfferArticle(int idUser, float priceOffer, Timestamp dateOfferUser, int idOffer, String name, String description, String imagePath, String state, float priceStart, String limitDate, int idUserSeller) {
        super(idOffer, name, description, imagePath, state, priceStart, limitDate, idUserSeller);
        this.idUser = idUser;
        this.priceOffer = priceOffer;
        this.dateOfferUser = dateOfferUser;
    }

    public OfferArticle(int idUser, float priceOffer, int idOffer) {
        super(idOffer);
        this.idUser = idUser;
        this.priceOffer = priceOffer;
    }

    public OfferArticle(int idOfferUser, int idUser, float priceOffer, int idOffer) {
        super(idOffer);
        this.idOfferUser = idOfferUser;
        this.idUser = idUser;
        this.priceOffer = priceOffer;
    }

    public OfferArticle(int idUser, float priceOffer, Timestamp dateOfferUser, String name, String description, String imagePath, String state, float priceStart, String limitDate, int idUserSeller, int idSubcategory, int idCategory) {
        super(name, description, imagePath, state, priceStart, limitDate, idUserSeller, idSubcategory, idCategory);
        this.idUser = idUser;
        this.priceOffer = priceOffer;
        this.dateOfferUser = dateOfferUser;
    }

    public OfferArticle(int idUser, int idOffer) {
        super(idOffer);
        this.idUser = idUser;
    }

    public int getIdOfferUser() {
        return idOfferUser;
    }

    public void setIdOfferUser(int idOfferUser) {
        this.idOfferUser = idOfferUser;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public float getPriceOffer() {
        return priceOffer;
    }

    public void setPriceOffer(float priceOffer) {
        this.priceOffer = priceOffer;
    }

    public Timestamp getDateOfferUser() {
        return dateOfferUser;
    }

    public void setDateOfferUser(Timestamp dateOfferUser) {
        this.dateOfferUser = dateOfferUser;
    }

}
