package entity;

/**
 * @author Tatiana
 * @version 1.00 12.04.2015.
 */
public class AutoPart implements GeneralEntity{
    private int autoPartId;
    private String name;


    public AutoPart() {

    }

    public AutoPart(int autoPartId, String name) {
        this.autoPartId = autoPartId;
        this.name = name;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AutoPart)) return false;

        AutoPart autoPart = (AutoPart) o;

        if (autoPartId != autoPart.autoPartId) return false;
        if (name != null ? !name.equals(autoPart.name) : autoPart.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = autoPartId;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return getClass().getName() +
                " autoPartId=" + autoPartId +
                ", name='" + name + '\'';
    }
    public void print() {
        System.out.println(" autoPartId: " + autoPartId + " name: " + name);
    }

}
