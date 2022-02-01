package fact.it.project40backendvanroey.controller;

import fact.it.project40backendvanroey.model.Company;
import fact.it.project40backendvanroey.model.Data;
import fact.it.project40backendvanroey.model.Visitor;
import fact.it.project40backendvanroey.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class DataController {

    @Autowired
    private DataRepository dataRepository;

    @Autowired
    private VisitorRepository visitorRepository;

    @Autowired
    private TrackerRepository trackerRepository;

    @GetMapping("/data")
    public List<Data> getAllData() {
        List<Data> list = dataRepository.findAll();
        list.forEach((data) -> data.setVisitorID(data.getVisitor().getVisitorID()));
        list.forEach((data) -> data.setTrackerID(data.getTracker().getTrackerID()));

        return list;
    }

    @GetMapping("/data/{id}")
    public Data getDataByDataID(@PathVariable int id){
        Data data = dataRepository.findDataByDataID(id);
        data.setVisitorID(data.getVisitor().getVisitorID());
        data.setTrackerID(data.getTracker().getTrackerID());
        return data;
    }

    @PostMapping("/data")
    public Data addData(@RequestBody Data data){
        data.setTracker(trackerRepository.findTrackerByTrackerID(data.getTrackerID()));
        data.setVisitor(visitorRepository.findVisitorByVisitorID(data.getVisitorID()));
        dataRepository.save(data);
        return data;
    }
}
