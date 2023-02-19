package pl.gskuza.championsleaguepredictorapp.service;
import pl.gskuza.championsleaguepredictorapp.model.Competitor;
import pl.gskuza.championsleaguepredictorapp.model.Events;
import pl.gskuza.championsleaguepredictorapp.model.FilteredEvents;
import java.io.IOException;
import java.util.List;
import java.util.Set;
public interface EventsService {
    List<Events> getAllEvents();
    void saveEvents(String filePath) throws IOException;
    void deleteAllEvents();
    Set<String> getCompetitorNames() throws IOException;
    Set<String> saveCompetitorNames() throws IOException;
    List<Competitor> getAllCompetitors();
    List<FilteredEvents> getFilteredEvents(int numberOfEvents) throws IOException;
}
