package fact.it.project40backendvanroey.controller;

import fact.it.project40backendvanroey.model.Tag;
import fact.it.project40backendvanroey.model.Tracker;
import fact.it.project40backendvanroey.repository.TrackerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.sound.midi.Track;
import java.util.List;
import java.util.Optional;

@RestController
public class TrackerController {

    @Autowired
    private TrackerRepository trackerRepository;


    @GetMapping("/trackers")
    public List<Tracker> getTrackers() {
        return trackerRepository.findAll();
    }

    @GetMapping("/trackers/{id}")
    public Tracker getTrackerByTrackerID(@PathVariable int id){
        return trackerRepository.findTrackerByTrackerID(id);
    }

    @GetMapping("/trackers/address/{address}")
    public Tracker getTrackerByAddress(@PathVariable String address){
        return trackerRepository.findTrackerByAddressAndStatus(address,true);
    }

    @PostMapping("/trackers")
    public Tracker addTracker(@RequestBody Tracker tracker){
        trackerRepository.save(tracker);
        return tracker;
    }

    @PutMapping("/trackers")
    public Tracker updateTracker(@RequestBody Tracker tracker){
        Tracker retrievedTracker = trackerRepository.findTrackerByTrackerID(tracker.getTrackerID());

        retrievedTracker.setName(tracker.getName());
        retrievedTracker.setAddress(tracker.getAddress());
        retrievedTracker.setStatus(tracker.isStatus());
        trackerRepository.save(retrievedTracker);

        return retrievedTracker;
    }

    @DeleteMapping("/trackers/{id}")
    public ResponseEntity deleteTracker(@PathVariable int trackerID){
        Tracker tracker = trackerRepository.findTrackerByTrackerID(trackerID);

        if(tracker!=null){
            trackerRepository.delete(tracker);
            return ResponseEntity.ok().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }


}
