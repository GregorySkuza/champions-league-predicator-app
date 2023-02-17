package pl.gskuza.championsleaguepredictorapp.service;

import pl.gskuza.championsleaguepredictorapp.model.Events;
import pl.gskuza.championsleaguepredictorapp.model.FilteredEvents;
import java.io.IOException;
import java.util.List;
public interface EventsService {
    List<Events> getAllEvents();
    void saveEvents(String filePath) throws IOException;
    void deleteAllEvents();

}
