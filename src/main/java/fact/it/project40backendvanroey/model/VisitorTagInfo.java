package fact.it.project40backendvanroey.model;

public class VisitorTagInfo {
    private String visitorName;
    private String visitorLastname;
    private String visitorEmail;
    private String tagAddress;
    private String tagStatus;

    public VisitorTagInfo() {
    }

    public VisitorTagInfo(String visitorName, String visitorLastname, String visitorEmail, String tagAddress, String tagStatus) {
        this.visitorName = visitorName;
        this.visitorLastname = visitorLastname;
        this.visitorEmail = visitorEmail;
        this.tagAddress = tagAddress;
        this.tagStatus = tagStatus;
    }

    public String getVisitorName() {
        return visitorName;
    }

    public void setVisitorName(String visitorName) {
        this.visitorName = visitorName;
    }

    public String getVisitorLastname() {
        return visitorLastname;
    }

    public void setVisitorLastname(String visitorLastname) {
        this.visitorLastname = visitorLastname;
    }

    public String getVisitorEmail() {
        return visitorEmail;
    }

    public void setVisitorEmail(String visitorEmail) {
        this.visitorEmail = visitorEmail;
    }

    public String getTagAddress() {
        return tagAddress;
    }

    public void setTagAddress(String tagAddress) {
        this.tagAddress = tagAddress;
    }

    public String getTagStatus() {
        return tagStatus;
    }

    public void setTagStatus(String tagStatus) {
        this.tagStatus = tagStatus;
    }
}
