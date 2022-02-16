package fact.it.project40backendvanroey.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Visit {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int visitID;

    @Transient
    private int companyID;

    private String email;

    private LocalDateTime date;

    private boolean status;

    @ManyToOne
    private Company company;

    public Visit() {
    }

    public Visit(String email, LocalDateTime date, boolean status) {
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

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
        setCompanyID(company.getCompanyID());
    }

    public int getCompanyID() {
        return companyID;
    }

    public void setCompanyID(int companyID) {
        this.companyID = companyID;
    }
}
