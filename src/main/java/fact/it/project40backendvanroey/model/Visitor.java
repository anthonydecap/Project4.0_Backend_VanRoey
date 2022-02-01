package fact.it.project40backendvanroey.model;

import javax.persistence.*;

@Entity
public class Visitor {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int visitorID;

    @Transient
    private int visitID;

    @Transient
    private int tagID;

    private String name;

    private String lastname;

    private String email;

    @ManyToOne
    private Visit visit;

    @ManyToOne
    private Tag tag;

    public Visitor() {

    }

    public Visitor(String name, String lastname, String email) {
        this.name = name;
        this.lastname = lastname;
        this.email = email;
    }

    public int getVisitorID() {
        return visitorID;
    }

    public void setVisitorID(int visitorID) {
        this.visitorID = visitorID;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Visit getVisit() {
        return visit;
    }

    public void setVisit(Visit visit) {

        this.visit = visit;
        this.visitID = visit.getVisitID();
    }

    public Tag getTag() {
        return tag;
    }

    public void setTag(Tag tag) {

        this.tag = tag;
        this.tagID = tag.getTagID();
    }

    public int getVisitID() {
        return visitID;
    }

    public void setVisitID(int visitID) {
        this.visitID = visitID;
    }

    public int getTagID() {
        return tagID;
    }

    public void setTagID(int tagID) {
        this.tagID = tagID;
    }
}
