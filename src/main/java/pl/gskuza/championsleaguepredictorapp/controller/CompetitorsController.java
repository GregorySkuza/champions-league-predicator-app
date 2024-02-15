package pl.gskuza.championsleaguepredictorapp.controller;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.gskuza.championsleaguepredictorapp.model.Competitor;
import pl.gskuza.championsleaguepredictorapp.service.CompetitorsServiceImpl;
import java.io.IOException;
import java.util.List;
import java.util.Set;
@RestController
@RequestMapping("api/competitors")
public class CompetitorsController {
    private final ObjectMapper objectMapper;
    private final CompetitorsServiceImpl competitorsServiceImpl;
    public CompetitorsController(CompetitorsServiceImpl competitorsServiceImpl, ObjectMapper objectMapper) {
        this.competitorsServiceImpl = competitorsServiceImpl;
        this.objectMapper= objectMapper;
    }
    @GetMapping("/get/json/competitors")
    public Set<String> getCompetitorNames() throws IOException {
        return competitorsServiceImpl.getCompetitorNames();
    }
    @GetMapping("/get/repository/competitors")
    @ResponseBody
    public List<Competitor> getAllCompetitors() {
        return competitorsServiceImpl.getAllCompetitors();
    }
    @PostMapping("/save/competitors")
    public Set<String> saveCompetitorNames() throws IOException {
        return competitorsServiceImpl.saveCompetitorNames();
    }
    @DeleteMapping("/delete/all/events")
    public ResponseEntity<?> deleteAllCompetitors() {
        competitorsServiceImpl.deleteAllCompetitors();
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
