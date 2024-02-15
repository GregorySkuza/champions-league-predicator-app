package pl.gskuza.championsleaguepredictorapp.service;

import pl.gskuza.championsleaguepredictorapp.model.Competitor;
import java.io.IOException;
import java.util.List;
import java.util.Set;
public interface CompetitorsService {
    void deleteAllCompetitors();
    List<Competitor> getAllCompetitors();
    Set<String> getCompetitorNames() throws IOException;
    Set<String> saveCompetitorNames() throws IOException;
}
