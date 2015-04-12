package entity;

import java.sql.Date;

/**
 * @author Tatiana
 * @version 1.00 07.04.2015.
 */
public class Document implements GeneralEntity {

    private int documentId;
    private int agentId;
    private String documentType;
    private Date date;

    public void print() {
        System.out.println(" documentId: " + documentId + " agentId: " + agentId + " documentType: " + documentType + " date: " + date);
    }

    public Document() {

    }

    public Document(int documentId, int agentId, String documentType, Date date) {
        this.documentId = documentId;
        this.agentId = agentId;
        this.documentType = documentType;
        this.date = date;
    }
    @Override
    public String toString() {
		return getClass().getName() + "@documentId" + documentId 
			+ " agentId: " + agentId + " documentType: " 
                        + documentType + " date: " + date;
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
            Document temp = (Document) obj;
            return this.documentId == temp.documentId
                    && this.agentId == temp.agentId
                    && documentType.equals(temp.documentType)
                    && date.equals(temp.date);
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return (int) (31 * documentId + agentId
                + ((documentType == null) ? 0 : documentType.hashCode())
                + ((date == null) ? 0 : date.hashCode()));
    }

    public Integer getId() {
        return documentId;
    }

    public int getAgentId() {
        return agentId;
    }

    public String getDocumentType() {
        return documentType;
    }

    public Date getDate() {
        return date;
    }

    public void setId(int documentId) {
        this.documentId = documentId;
    }

    public void setAgentId(int agentId) {
        this.agentId = agentId;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public void setDate(Date date) {
        this.date = date;
    }

}
