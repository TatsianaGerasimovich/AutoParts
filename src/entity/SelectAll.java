package entity;

/**
 * @author Tatiana
 * @version 1.00 12.04.2015.
 */
public class SelectAll implements GeneralEntity{
    private int autoPartId;
    private String name;
    private String nameBrand;
    private String nameModel;
    private int yearOfRelease;
    private String nameOfAgent;
    private int price;
    private int number;

    public SelectAll() {
    }
    public SelectAll(int autoPartId,String name,String nameBrand, String nameModel,int yearOfRelease,String nameOfAgent,int price,int number) {
        this.autoPartId=autoPartId;
        this.name=name;
        this.nameBrand=nameBrand;
        this.nameModel=nameModel;
        this.yearOfRelease=yearOfRelease;
        this.nameOfAgent=nameOfAgent;
        this.price=price;
        this.number=number;
    }

    public Integer getId() {
        return autoPartId;
    }

    public void setId(int autoPartId) {
        this.autoPartId = autoPartId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameBrand() {
        return nameBrand;
    }

    public void setNameBrand(String nameBrand) {
        this.nameBrand = nameBrand;
    }

    public String getNameModel() {
        return nameModel;
    }

    public void setNameModel(String nameModel) {
        this.nameModel = nameModel;
    }

    public int getYearOfRelease() {
        return yearOfRelease;
    }

    public void setYearOfRelease(int yearOfRelease) {
        this.yearOfRelease = yearOfRelease;
    }

    public String getNameOfAgent() {
        return nameOfAgent;
    }

    public void setNameOfAgent(String nameOfAgent) {
        this.nameOfAgent = nameOfAgent;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SelectAll)) return false;

        SelectAll selectAll = (SelectAll) o;

        if (autoPartId != selectAll.autoPartId) return false;
        if (number != selectAll.number) return false;
        if (price != selectAll.price) return false;
        if (yearOfRelease != selectAll.yearOfRelease) return false;
        if (!name.equals(selectAll.name)) return false;
        if (!nameBrand.equals(selectAll.nameBrand)) return false;
        if (!nameModel.equals(selectAll.nameModel)) return false;
        if (!nameOfAgent.equals(selectAll.nameOfAgent)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = autoPartId;
        result = 31 * result + name.hashCode();
        result = 31 * result + nameBrand.hashCode();
        result = 31 * result + nameModel.hashCode();
        result = 31 * result + yearOfRelease;
        result = 31 * result + nameOfAgent.hashCode();
        result = 31 * result + price;
        result = 31 * result + number;
        return result;
    }

    @Override
    public String toString() {
        return getClass().getName() +
                " autoPartId=" + autoPartId +
                ", name='" + name + '\'' +
                ", nameBrand='" + nameBrand + '\'' +
                ", nameModel='" + nameModel + '\'' +
                ", yearOfRelease=" + yearOfRelease +
                ", nameOfAgent='" + nameOfAgent + '\'' +
                ", price=" + price +
                ", number=" + number;
    }
}
