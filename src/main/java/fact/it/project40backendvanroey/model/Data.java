package fact.it.project40backendvanroey.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Time;
import java.time.LocalDateTime;

@Entity
public class Data {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int dataID;

    private int trackerID;

    private int visitorTagID;

    private LocalDateTime time;

    public Data() {
    }

    public Data(int trackerID, int visitorTagID, LocalDateTime time) {
        this.trackerID = trackerID;
        this.visitorTagID = visitorTagID;
        this.time = time;
    }

    public int getDataID() {
        return dataID;
    }

    public void setDataID(int dataID) {
        this.dataID = dataID;
    }

    public int getTrackerID() {
        return trackerID;
    }

    public void setTrackerID(int trackerID) {
        this.trackerID = trackerID;
    }

    public int getVisitorTagID() {
        return visitorTagID;
    }

    public void setVisitorTagID(int visitorTagID) {
        this.visitorTagID = visitorTagID;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }
}
