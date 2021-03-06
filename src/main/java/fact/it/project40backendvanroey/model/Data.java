package fact.it.project40backendvanroey.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Data {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int dataID;

    @Transient
    private int visitorID;

    @Transient
    private int trackerID;

    private LocalDateTime time;

    @ManyToOne
    private Tracker tracker;

    @ManyToOne Visitor visitor;

    public Data() {
    }

    public Data(int trackerID, int visitorID, LocalDateTime time) {
        this.time = time;
    }

    public int getDataID() {
        return dataID;
    }

    public void setDataID(int dataID) {
        this.dataID = dataID;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public Tracker getTracker() {
        return tracker;
    }

    public void setTracker(Tracker tracker) {

        this.tracker = tracker;
        this.trackerID = tracker.getTrackerID();
    }

    public Visitor getVisitor() {
        return visitor;
    }

    public void setVisitor(Visitor visitor) {

        this.visitor = visitor;
        this.visitorID = visitor.getVisitorID();
    }

    public int getVisitorID() {
        return visitorID;
    }

    public void setVisitorID(int visitorID) {
        this.visitorID = visitorID;
    }

    public int getTrackerID() {
        return trackerID;
    }

    public void setTrackerID(int trackerID) {
        this.trackerID = trackerID;
    }
}
