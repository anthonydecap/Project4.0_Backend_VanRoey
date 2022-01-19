package fact.it.project40backendvanroey.controller;

import fact.it.project40backendvanroey.model.Tracker;
import fact.it.project40backendvanroey.repository.TrackerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Optional;

@RestController
public class TrackerController {

    @Autowired
    private TrackerRepository trackerRepository;

    @PostConstruct
    public void fillDB(){
        if(trackerRepository.count()==0){
            trackerRepository.save(new Tracker("Security gate", true));
            trackerRepository.save(new Tracker("Smart bord", true));
        }

        //System.out.println(bookRepository.findBookByISBN("687468435454").getTitle());
    }

    @GetMapping("/trackers")
    public List<Tracker> getTrackers(){
        return trackerRepository.findAll();
    }

    @GetMapping("/trackers/{TrackerID}")
    public Optional<Tracker> getBookByTrackerID(@PathVariable int trackerID){
        return trackerRepository.findById(trackerID);
    }
}
