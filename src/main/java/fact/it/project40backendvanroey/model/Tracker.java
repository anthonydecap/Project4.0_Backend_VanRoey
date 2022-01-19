package fact.it.project40backendvanroey.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Tracker {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int trackerID;

    private String name;

    private boolean status;

    public Tracker () {

    }

    public Tracker(String name, boolean status) {
        this.name = name;
        this.status = status;
    }

    public int getTrackerID() {
        return trackerID;
    }

    public void setTrackerID(int trackerID) {
        this.trackerID = trackerID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
