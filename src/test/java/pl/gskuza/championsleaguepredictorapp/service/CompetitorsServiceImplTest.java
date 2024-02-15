package pl.gskuza.championsleaguepredictorapp.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pl.gskuza.championsleaguepredictorapp.model.Competitor;
import pl.gskuza.championsleaguepredictorapp.model.Events;
import pl.gskuza.championsleaguepredictorapp.model.EventsContainer;
import pl.gskuza.championsleaguepredictorapp.repo.CompetitorRepository;
import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;
public class CompetitorsServiceImplTest {
    private CompetitorRepository competitorRepository;
    private ObjectMapper objectMapper;
    private CompetitorsServiceImpl competitorsService;

    @BeforeEach
    void setUp() {
        competitorRepository = mock(CompetitorRepository.class);
        objectMapper = mock(ObjectMapper.class);
        competitorsService = new CompetitorsServiceImpl(objectMapper,competitorRepository);
    }
    @org.junit.jupiter.api.Test
    void testGetAllCompetitors() {
        //Given
        List<Competitor> expectedCompetitors = List.of(new Competitor("Competitor1"), new Competitor("Competitor2"));

        when(competitorRepository.findAll()).thenReturn(expectedCompetitors);

        // When
        List<Competitor> actualCompetitors = competitorsService.getAllCompetitors();

        // Then
        assertEquals(expectedCompetitors.size(), actualCompetitors.size());
        assertTrue(actualCompetitors.containsAll(expectedCompetitors));
    }
    @Test
    @DisplayName("Should retrieve competitor names")
    void testGetCompetitorNames() throws IOException {
        // Given
        EventsContainer mockEventsContainer = new EventsContainer();
        List<String> competitorNames = List.of("Competitor1", "Competitor2");
        mockEventsContainer.setEvents(List.of(new Events("Event1", competitorNames)));

        when(objectMapper.readValue(any(File.class), eq(EventsContainer.class))).thenReturn(mockEventsContainer);

        // When
        Set<String> result = competitorsService.saveCompetitorNames();

        // Then
        Set<String> expectedNames = new HashSet<>(competitorNames);
        verify(competitorRepository, times(1)).saveAll(anyList());
        assertEquals(expectedNames, result);
    }
    @Test
    @DisplayName("Should save competitor names and return a set")
    void testSaveCompetitorNames() throws IOException {
        // Given
        EventsContainer mockEventsContainer = new EventsContainer();
        List<String> competitorNames = List.of("Competitor1", "Competitor2");
        mockEventsContainer.setEvents(List.of(new Events("Event1", competitorNames)));

        when(objectMapper.readValue(any(File.class), eq(EventsContainer.class))).thenReturn(mockEventsContainer);

        // When
        Set<String> result = competitorsService.saveCompetitorNames();

        // Then
        Set<String> expectedNames = new HashSet<>(competitorNames);
        verify(competitorRepository, times(1)).saveAll(anyList());
        assertEquals(expectedNames, result);
    }
}
