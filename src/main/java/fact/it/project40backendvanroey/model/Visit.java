package fact.it.project40backendvanroey.model;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Visit {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int visitID;

    private int CompanyID;

    private String email;

    private LocalDateTime date;

    private boolean status;

    @OneToMany(mappedBy="visit")
    private List<Visitor> visitors;

    public Visit() {
    }

    public Visit(int companyID, String email, LocalDateTime date, boolean status) {
        CompanyID = companyID;
        this.email = email;
        this.date = date;
        this.status = status;
    }

    public int getVisitID() {
        return visitID;
    }

    public void setVisitID(int visitID) {
        this.visitID = visitID;
    }

    public int getCompanyID() {
        return CompanyID;
    }

    public void setCompanyID(int companyID) {
        CompanyID = companyID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
