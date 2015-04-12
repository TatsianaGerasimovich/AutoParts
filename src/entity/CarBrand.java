package entity;

/**
 * @author Tatiana
 * @version 1.00 07.04.2015.
 */
public class CarBrand implements GeneralEntity {

    private int carBrandId;
    private String nameBrand;

    public CarBrand() {

    }

    public CarBrand(int carBrandId,  String nameBrand) {
        this.carBrandId = carBrandId;
        this.nameBrand = nameBrand;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() == obj.getClass()) {
            CarBrand temp = (CarBrand) obj;
            return this.carBrandId == temp.carBrandId                    
                    && this.nameBrand == temp.nameBrand;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return (int) (31 * carBrandId 
                + ((nameBrand == null) ? 0 : nameBrand.hashCode()));
    }

    @Override
    public String toString() {
        return getClass().getName() + "@carBrandId:" + carBrandId
                + " nameBrand: " + nameBrand;
    }

    public void print() {
        System.out.println(" carBrandId: " + carBrandId + " nameBrand: " + nameBrand);
    }

    public Integer getId() {
        return carBrandId;
    }

    public String getNameBrand() {
        return nameBrand;
    }

    public void setId(int carBrandId) {
        this.carBrandId = carBrandId;
    }

    public void setNameBrand(String nameBrand) {
        this.nameBrand = nameBrand;
    }  

}
