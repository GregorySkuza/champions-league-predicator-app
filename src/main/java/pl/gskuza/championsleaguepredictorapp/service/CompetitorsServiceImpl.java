package pl.gskuza.championsleaguepredictorapp.service;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import pl.gskuza.championsleaguepredictorapp.model.Competitor;
import pl.gskuza.championsleaguepredictorapp.model.EventsContainer;
import pl.gskuza.championsleaguepredictorapp.repo.CompetitorRepository;
import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
@Service
public class CompetitorsServiceImpl implements CompetitorsService {
    private final ObjectMapper objectMapper;
    private final CompetitorRepository competitorRepository;
    public CompetitorsServiceImpl(ObjectMapper objectMapper, CompetitorRepository competitorRepository) {
        this.objectMapper=objectMapper;
        this.competitorRepository = competitorRepository;
    }
    @Override
    public List<Competitor> getAllCompetitors() {
        return competitorRepository.findAll();
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
    public void deleteAllCompetitors() {
        competitorRepository.deleteAll();
    }
}
