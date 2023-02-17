package pl.gskuza.championsleaguepredictorapp.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.gskuza.championsleaguepredictorapp.model.Events;
import pl.gskuza.championsleaguepredictorapp.model.EventsContainer;
import pl.gskuza.championsleaguepredictorapp.service.EventsServiceImpl;
import java.io.*;
import java.util.List;

@RestController
@RequestMapping("api/events")
public class EventsController {
    private final ObjectMapper objectMapper;
    private final EventsServiceImpl eventsServiceImpl;

    public EventsController(EventsServiceImpl eventsServiceImpl, ObjectMapper objectMapper) {
        this.eventsServiceImpl = eventsServiceImpl;
        this.objectMapper= objectMapper;
    }

    @GetMapping("/json/events")
    public EventsContainer getItemFromJson() throws IOException {
      return objectMapper.readValue(new File("src/main/resources/BE_data.json"), EventsContainer.class);
    }
    @GetMapping("/get/events")
    public List<Events> getAllEvents() {
        return eventsServiceImpl.getAllEvents();
    }

    @PostMapping("/save/events")
    public void saveEvents() throws IOException {
        eventsServiceImpl.saveEvents("src/main/resources/BE_data.json");
    }
    @DeleteMapping("/delete/all/events")
    public ResponseEntity<?> deleteAllEvents() {
        eventsServiceImpl.deleteAllEvents();
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
