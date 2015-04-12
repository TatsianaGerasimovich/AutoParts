package entity;

/**
 * @author Tatiana
 * @version 1.00 07.04.2015.
 */
public class Contractor implements GeneralEntity {

    private int agentId;
    private String nameOfAgent;
    private String address;
    private long phone;
    private String typeOfAgent;
    private int rating;

    public Contractor() {

    }

    public Contractor(int AgentId, String nameOfAgent, String typeOfAgent, int rating, String address, long phone) {
        this.agentId = AgentId;
        this.nameOfAgent = nameOfAgent;
        this.typeOfAgent = typeOfAgent;
        this.rating = rating;
        this.address = address;
        this.phone = phone;
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
            Contractor temp = (Contractor) obj;
            return this.agentId == temp.agentId
                    && nameOfAgent.equals(temp.nameOfAgent)
                    && typeOfAgent.equals(temp.typeOfAgent)
                    && rating == temp.rating
                    && address.equals(temp.address)
                    && phone == temp.phone;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return (int) (31 * agentId
                + ((nameOfAgent == null) ? 0 : nameOfAgent.hashCode())
                + ((typeOfAgent == null) ? 0 : typeOfAgent.hashCode())
                + rating
                + ((address == null) ? 0 : address.hashCode())
                + phone / 1000000);

    }

    @Override
    public String toString() {
        return getClass().getName() + "@agentId:" + agentId + " lastName: "
                + typeOfAgent + " Name: " + nameOfAgent + " middleName: " + rating
                + " address: " + address + " phone: " + phone;
    }

    public void print() {
        System.out.println(" agentId: " + agentId + " typeOfAgent: " + typeOfAgent + " Name: " + nameOfAgent + " middleName: " + rating + " address: " + address + " phone: " + phone);
    }

    public Integer getId() {
        return agentId;
    }

    public String getNameOfAgent() {
        return nameOfAgent;
    }

    public String getAddress() {
        return address;
    }

    public long getPhone() {
        return phone;
    }

    public String getTypeOfAgent() {
        return typeOfAgent;
    }

    public int getRating() {
        return rating;
    }

    public void setId(int agentId) {
        this.agentId = agentId;
    }

    public void setNameOfAgent(String nameOfAgent) {
        this.nameOfAgent = nameOfAgent;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public void setTypeOfAgent(String typeOfAgent) {
        this.typeOfAgent = typeOfAgent;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

}
