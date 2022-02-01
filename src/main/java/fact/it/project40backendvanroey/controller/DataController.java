package fact.it.project40backendvanroey.controller;

import fact.it.project40backendvanroey.model.Company;
import fact.it.project40backendvanroey.model.Data;
import fact.it.project40backendvanroey.repository.CompanyRepository;
import fact.it.project40backendvanroey.repository.DataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class DataController {

    @Autowired
    private DataRepository dataRepository;

    @GetMapping("/data")
    public List<Data> getAllData() {
        return dataRepository.findAll();
    }

    @GetMapping("/data/{id}")
    public Data getDataByDataID(@PathVariable int dataID){
        return dataRepository.findDataByDataID(dataID);
    }

    @PostMapping("/data")
    public Data addData(@RequestBody Data data){
        dataRepository.save(data);
        return data;
    }

    @PutMapping("/data")
    public Data updateData(@RequestBody Data data){
        Data retrievedData = dataRepository.findDataByDataID(data.getDataID());
        retrievedData.setTime(data.getTime());
        dataRepository.save(retrievedData);

        return retrievedData;
    }

    @DeleteMapping("/data/{id}")
    public ResponseEntity deleteData(@PathVariable int dataID){
        Data data = dataRepository.findDataByDataID(dataID);

        if(data!=null){
            dataRepository.delete(data);
            return ResponseEntity.ok().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }

}
