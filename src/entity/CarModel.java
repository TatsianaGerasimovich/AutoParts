package entity;

/**
 * @author Tatiana
 * @version 1.00 08.04.2015.
 */
public class CarModel implements GeneralEntity{
    private int carModelId;
    private int carBrandId;
    private String nameModel;
    private int yearOfRelease;

    public CarModel() {

    }

    public CarModel(int carModelId, int carBrandId, String nameModel,int yearOfRelease) {
        this.carModelId = carModelId;
        this.carBrandId = carBrandId;
        this.nameModel = nameModel;
        this.yearOfRelease = yearOfRelease;
    }

    public Integer getId() {
        return carModelId;
    }

    public void setId(int carModelId) {
        this.carModelId = carModelId;
    }

    public int getCarBrandId() {
        return carBrandId;
    }

    public void setCarBrandId(int carBrandId) {
        this.carBrandId = carBrandId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CarModel)) return false;

        CarModel carModel = (CarModel) o;

        if (carBrandId != carModel.carBrandId) return false;
        if (carModelId != carModel.carModelId) return false;
        if (yearOfRelease != carModel.yearOfRelease) return false;
        if (nameModel != null ? !nameModel.equals(carModel.nameModel) : carModel.nameModel != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = carModelId;
        result = 31 * result + carBrandId;
        result = 31 * result + (nameModel != null ? nameModel.hashCode() : 0);
        result = 31 * result + yearOfRelease;
        return result;
    }

    @Override
    public String toString() {
        return getClass().getName() +
                " carModelId=" + carModelId +
                ", carBrandId=" + carBrandId +
                ", nameModel='" + nameModel + '\'' +
                ", yearOfRelease=" + yearOfRelease;
    }
    public void print() {
        System.out.println(" carModelId: " + carModelId + " carBrandId: " + carBrandId+ " nameModel: " + nameModel+ " yearOfRelease: " + yearOfRelease);
    }

}
