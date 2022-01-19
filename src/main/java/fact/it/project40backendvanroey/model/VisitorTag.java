package fact.it.project40backendvanroey.model;

import javax.persistence.*;

@Entity
public class VisitorTag {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int visitorTagId;
    private int tagId;
    private int visitorId;

    public VisitorTag() {
    }

    public VisitorTag(int tagId, int visitorId) {
        this.tagId = tagId;
        this.visitorId = visitorId;
    }

    public int getVisitorTagId() {
        return visitorTagId;
    }

    public void setVisitorTagId(int visitorTagId) {
        this.visitorTagId = visitorTagId;
    }

    public int getTagId() {
        return tagId;
    }

    public void setTagId(int tagId) {
        this.tagId = tagId;
    }

    public int getVisitorId() {
        return visitorId;
    }

    public void setVisitorId(int visitorId) {
        this.visitorId = visitorId;
    }
}
