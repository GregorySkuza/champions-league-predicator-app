package pl.gskuza.championsleaguepredictorapp.service;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import pl.gskuza.championsleaguepredictorapp.model.Events;
import pl.gskuza.championsleaguepredictorapp.model.EventsContainer;
import pl.gskuza.championsleaguepredictorapp.repo.EventsRepository;
import java.io.File;
import java.io.IOException;
import java.util.*;
@Service
public class EventsServiceImpl implements EventsService{
    private final ObjectMapper objectMapper;
    private final EventsRepository eventsRepository;
    public EventsServiceImpl(EventsRepository eventsRepository, ObjectMapper objectMapper) {
        this.eventsRepository = eventsRepository;
        this.objectMapper=objectMapper;
    }
    @Override
    public List<Events> getAllEvents() {
        return eventsRepository.findAll();
    }
    @Override
    public void saveEvents(String filePath) throws IOException {
        EventsContainer container = objectMapper.readValue(new File(filePath), EventsContainer.class);
        List<Events> events = container.getEvents();
        eventsRepository.saveAll(events);
    }
    @Override
    public void deleteAllEvents() {
         eventsRepository.deleteAll();
    }
}
