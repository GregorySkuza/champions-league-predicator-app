package pl.gskuza.championsleaguepredictorapp.controller;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import pl.gskuza.championsleaguepredictorapp.model.Competitor;
import pl.gskuza.championsleaguepredictorapp.service.CompetitorsServiceImpl;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(controllers = CompetitorsController.class)
public class CompetitorsControllerTest {
    @MockBean
    private CompetitorsServiceImpl competitorsServiceImpl;
    @Mock
    private ObjectMapper objectMapper;
    @InjectMocks
    private CompetitorsController competitorsController;
    @BeforeEach
    void setUp() {
        competitorsServiceImpl = mock(CompetitorsServiceImpl.class);
        objectMapper = mock(ObjectMapper.class);
        competitorsController = new CompetitorsController(competitorsServiceImpl, objectMapper);
    }
    @Test
    @DisplayName("Should retrieve competitor names")
    public void testGetCompetitorNames() throws IOException {
        // Given
        Set<String> expectedCompetitorNames = Set.of(/*...*/);
        when(competitorsServiceImpl.getCompetitorNames()).thenReturn(expectedCompetitorNames);
        // When
        Set<String> result = competitorsController.getCompetitorNames();
        // Then
        assertEquals(expectedCompetitorNames, result);
        verify(competitorsServiceImpl, times(1)).getCompetitorNames();
    }
    @Test
    @DisplayName("Should retrieve all competitors")
    public void testGetAllCompetitors() {
        // Given
        List<Competitor> mockCompetitors = List.of(new Competitor(), new Competitor());
        when(competitorsServiceImpl.getAllCompetitors()).thenReturn(mockCompetitors);

        // When
        List<Competitor> result = competitorsController.getAllCompetitors();

        // Then
        assertEquals(mockCompetitors, result);
    }
    @Test
    @DisplayName("Should save competitor names and return a set")
    public void testSaveCompetitorNames() throws IOException {
        // Given
        Set<String> mockCompetitorNames = Set.of("Competitor1", "Competitor2");
        when(competitorsServiceImpl.saveCompetitorNames()).thenReturn(mockCompetitorNames);
        // When
        Set<String> result = competitorsController.saveCompetitorNames();
        // Then
        assertEquals(mockCompetitorNames, result);
    }
}
