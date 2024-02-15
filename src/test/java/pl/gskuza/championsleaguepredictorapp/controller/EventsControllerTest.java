package pl.gskuza.championsleaguepredictorapp.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import pl.gskuza.championsleaguepredictorapp.model.Events;
import pl.gskuza.championsleaguepredictorapp.model.EventsContainer;
import pl.gskuza.championsleaguepredictorapp.model.FilteredEvents;
import pl.gskuza.championsleaguepredictorapp.service.EventsServiceImpl;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@ExtendWith(MockitoExtension.class)
@WebMvcTest(controllers = EventsController.class)
class EventsControllerTest {
    @MockBean
    private EventsServiceImpl eventsService;
    @Mock
    private ObjectMapper objectMapper;
    @Autowired
    private MockMvc mockMvc;
    @InjectMocks
    private EventsController eventsController;

    @BeforeEach
    void setUp() {
        eventsService = mock(EventsServiceImpl.class);
        objectMapper = mock(ObjectMapper.class);
        eventsController = new EventsController(eventsService, objectMapper);
    }
    @Test
    @DisplayName("Should retrieve item from JSON")
    void testGetItemFromJson() throws Exception {
        // Given
        EventsContainer expectedEventsContainer = new EventsContainer();
        // When
        String json = new String(Files.readAllBytes(Paths.get("src/main/resources/BE_data.json")));
        // Then
        mockMvc.perform(get("/api/events/json/events")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }
    @Test
    @DisplayName("Should retrieve all events")
    public void testGetAllEvents() {
        // Given
        List<Events> expectedEventsList = List.of();
        when(eventsService.getAllEvents()).thenReturn(expectedEventsList);
        // When
        List<Events> result = eventsController.getAllEvents();
        // Then
        assertEquals(expectedEventsList, result);
        verify(eventsService).getAllEvents();
    }
    @Test
    @DisplayName("Should save events to JSON")
    public void testSaveEvents() throws IOException {
        // When
        eventsController.saveEvents();
        // Then
        verify(eventsService).saveEvents(eq("src/main/resources/BE_data.json"));
    }
    @Test
    @DisplayName("Should delete all events")
    public void testDeleteAllEvents() {
        // When
        ResponseEntity<?> responseEntity = eventsController.deleteAllEvents();
        // Then
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        verify(eventsService).deleteAllEvents();
    }
    @Test
    @DisplayName("Should retrieve filtered events")
    public void testGetFilteredEvents() throws IOException {
        // Given
        int actualNumberOfEvents = 5;
        List<FilteredEvents> mockFilteredEvents = List.of(new FilteredEvents(), new FilteredEvents());
        when(eventsService.getFilteredEvents(actualNumberOfEvents)).thenReturn(mockFilteredEvents);
        // When
        List<FilteredEvents> result = eventsController.getFilteredEvents(actualNumberOfEvents);
        // Then
        assertEquals(mockFilteredEvents, result);
    }
}
