package entity;

/**
 * @author Tatiana
 * @version 1.00 12.04.2015.
 */
public class Documents_has_AutoParts implements GeneralEntity{
    private int autoParts_autoPartId;
    private int documents_DocumentId;
    private int price;
    private int number;
    private String currency;


    public Documents_has_AutoParts() {

    }

    public Documents_has_AutoParts (int autoParts_autoPartId, int documents_DocumentId,int price,int number,String currency) {
        this.autoParts_autoPartId = autoParts_autoPartId;
        this.documents_DocumentId = documents_DocumentId;
        this.price = price;
        this.number = number;
        this.currency = currency;

    }

    public Integer getId() {
        return autoParts_autoPartId;
    }

    public void setId(int autoPartId) {
        this.autoParts_autoPartId = autoPartId;
    }

    public int getDocumentId() {
        return documents_DocumentId;
    }

    public void setDocumentId(int documents_DocumentId) {
        this.documents_DocumentId = documents_DocumentId;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Documents_has_AutoParts)) return false;

        Documents_has_AutoParts that = (Documents_has_AutoParts) o;

        if (autoParts_autoPartId != that.autoParts_autoPartId) return false;
        if (documents_DocumentId != that.documents_DocumentId) return false;
        if (number != that.number) return false;
        if (price != that.price) return false;
        if (currency != null ? !currency.equals(that.currency) : that.currency != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = autoParts_autoPartId;
        result = 31 * result + documents_DocumentId;
        result = 31 * result + price;
        result = 31 * result + number;
        result = 31 * result + (currency != null ? currency.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Documents_has_AutoParts{" +
                "autoParts_autoPartId=" + autoParts_autoPartId +
                ", documents_DocumentId=" + documents_DocumentId +
                ", price=" + price +
                ", number=" + number +
                ", currency='" + currency + '\'' +
                '}';
    }
}