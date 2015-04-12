package entity;

/**
 * @author Tatiana
 * @version 1.00 12.04.2015.
 */
public class AutoParts_has_CarModels implements GeneralEntity{
    private int autoPartId;
    private int carModelId;
    private int carBrandId;
    public AutoParts_has_CarModels() {

    }

    public AutoParts_has_CarModels (int autoPartId, int carModelId,  int carBrandId) {
        this.autoPartId = autoPartId;
        this.carModelId = carModelId;
        this.carBrandId = carBrandId;
    }

    public Integer getId() {
        return autoPartId;
    }

    public void setId(int autoPartId) {
        this.autoPartId = autoPartId;
    }

    public int getCarModelId() {
        return carModelId;
    }

    public void setCarModelId(int carModelId) {
        this.carModelId = carModelId;
    }

    public int getCarBrandId() {
        return carBrandId;
    }

    public void setCarBrandId(int carBrandId) {
        this.carBrandId = carBrandId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AutoParts_has_CarModels)) return false;

        AutoParts_has_CarModels that = (AutoParts_has_CarModels) o;

        if (autoPartId != that.autoPartId) return false;
        if (carBrandId != that.carBrandId) return false;
        if (carModelId != that.carModelId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = autoPartId;
        result = 31 * result + carModelId;
        result = 31 * result + carBrandId;
        return result;
    }

    @Override
    public String toString() {
        return getClass().getName() +
                "autoPartId=" + autoPartId +
                ", carModelId=" + carModelId +
                ", carBrandId=" + carBrandId;
    }
}
