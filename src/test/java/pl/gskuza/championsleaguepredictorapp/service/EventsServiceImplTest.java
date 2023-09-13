package pl.gskuza.championsleaguepredictorapp.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pl.gskuza.championsleaguepredictorapp.model.Competitor;
import pl.gskuza.championsleaguepredictorapp.model.Events;
import pl.gskuza.championsleaguepredictorapp.model.EventsContainer;
import pl.gskuza.championsleaguepredictorapp.model.FilteredEvents;
import pl.gskuza.championsleaguepredictorapp.repo.CompetitorRepository;
import pl.gskuza.championsleaguepredictorapp.repo.EventsRepository;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

class EventsServiceImplTest {
    private EventsRepository eventsRepository;
    private CompetitorRepository competitorRepository;
    private ObjectMapper objectMapper;
    private EventsServiceImpl eventsService;

    @BeforeEach
    void setUp() {
        eventsRepository = mock(EventsRepository.class);
        competitorRepository = mock(CompetitorRepository.class);
        objectMapper = mock(ObjectMapper.class);
        eventsService = new EventsServiceImpl(eventsRepository, objectMapper, competitorRepository);
    }

    @Test
    @DisplayName("Should retrieve all events")
    void testGetAllEvents() {
        // Given
        List<Events> mockEventsList = new ArrayList<>();
        when(eventsRepository.findAll()).thenReturn(mockEventsList);

        // When
        List<Events> result = eventsService.getAllEvents();

        // Then
        assertEquals(mockEventsList, result);
    }

    @Test
    @DisplayName("Should save events")
    void testSaveEvents() throws IOException {
        // Given
        String filePath = "testFilePath.json";
        EventsContainer mockEventsContainer = new EventsContainer();
        List<Events> mockEvents = new ArrayList<>();
        mockEventsContainer.setEvents(mockEvents);

        when(objectMapper.readValue(any(File.class), eq(EventsContainer.class))).thenReturn(mockEventsContainer);

        // When
        eventsService.saveEvents(filePath);

        // Then
        verify(eventsRepository, times(1)).saveAll(mockEvents);
    }

    @Test
    @DisplayName("Should delete all events")
    void testDeleteAllEvents() {
        // When
        eventsService.deleteAllEvents();

        // Then
        verify(eventsRepository, times(1)).deleteAll();
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
        Set<String> result = eventsService.saveCompetitorNames();

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
        Set<String> result = eventsService.saveCompetitorNames();

        // Then
        Set<String> expectedNames = new HashSet<>(competitorNames);
        verify(competitorRepository, times(1)).saveAll(anyList());
        assertEquals(expectedNames, result);
    }

    @Test
    void testGetAllCompetitors() {
        //Given
        List<Competitor> expectedCompetitors = List.of(new Competitor("Competitor1"), new Competitor("Competitor2"));

        when(competitorRepository.findAll()).thenReturn(expectedCompetitors);

        // When
        List<Competitor> actualCompetitors = eventsService.getAllCompetitors();

        // Then
        assertEquals(expectedCompetitors.size(), actualCompetitors.size());
        assertTrue(actualCompetitors.containsAll(expectedCompetitors));
    }

    @Test
    @DisplayName("Should filter and return events")
    public void testGetFilteredEvents() throws IOException {
        // Given
        int numberOfEvents = 5;
        //Simulation of the data from JSon
        EventsContainer mockEventsContainer = new EventsContainer();
        List<Events> mockEvents = List.of(new Events(/* ... Event 1 ... */), new Events(/* ... Event 2 ... */), new Events(/* ... Event 3 ... */), new Events(/* ... Event 4 ... */), new Events(/* ... Event 5 ... */));
        mockEventsContainer.setEvents(mockEvents);

        when(objectMapper.readValue(any(File.class), eq(EventsContainer.class))).thenReturn(mockEventsContainer);

        // When
        List<FilteredEvents> filteredEvents = eventsService.getFilteredEvents(numberOfEvents);

        // Then
        assertNotNull(filteredEvents);
        assertEquals(numberOfEvents, filteredEvents.size());
    }
}
