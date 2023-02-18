package pl.gskuza.championsleaguepredictorapp.service;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import pl.gskuza.championsleaguepredictorapp.model.Competitor;
import pl.gskuza.championsleaguepredictorapp.model.Events;
import pl.gskuza.championsleaguepredictorapp.model.EventsContainer;
import pl.gskuza.championsleaguepredictorapp.repo.CompetitorRepository;
import pl.gskuza.championsleaguepredictorapp.repo.EventsRepository;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
@Service
public class EventsServiceImpl implements EventsService{
    private final ObjectMapper objectMapper;
    private final EventsRepository eventsRepository;
    private final CompetitorRepository competitorRepository;
    public EventsServiceImpl(EventsRepository eventsRepository, ObjectMapper objectMapper, CompetitorRepository competitorRepository) {
        this.eventsRepository = eventsRepository;
        this.objectMapper=objectMapper;
        this.competitorRepository = competitorRepository;
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
    @Override
    public Set<String> getCompetitorNames() throws IOException {
        EventsContainer events = objectMapper.readValue(new File("src/main/resources/BE_data.json"), EventsContainer.class);
        return events.getEvents().stream()
                .flatMap(event -> event.getCompetitors().stream().map(Competitor::getName))
                .sorted()
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }
    @Override
    public Set<String> saveCompetitorNames() throws IOException {
        EventsContainer events = objectMapper.readValue(new File("src/main/resources/BE_data.json"), EventsContainer.class);
        Set<String> names = events.getEvents().stream()
                .flatMap(event -> event.getCompetitors().stream().map(Competitor::getName))
                .collect(Collectors.toCollection(HashSet::new));

        List<Competitor> entities = names.stream()
                .map(Competitor::new)
                .collect(Collectors.toList());
        competitorRepository.saveAll(entities);
        return names;
    }
    @Override
    public List<Competitor> getAllCompetitors() {
        return competitorRepository.findAll();
    }
}
