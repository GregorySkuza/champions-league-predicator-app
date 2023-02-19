package pl.gskuza.championsleaguepredictorapp.model;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.List;
    @JsonPropertyOrder({
        "start_date",
        "competitors",
        "venue",
        "result",
        "probability"
    })
    public class FilteredEvents {
    @JsonProperty("start_date")
    private String startDate;
    @JsonProperty("competitors")
    private List<Competitor> competitors;
    @JsonProperty("venue")
    private Venue venue;
    @JsonProperty("probability")
    private double maxProbability;
    @JsonProperty("result")
    private String resultType;
    public FilteredEvents() {
    }
    public FilteredEvents(String startDate, List<Competitor> competitors, Venue venue, double maxProbability, String resultType) {
        this.startDate = startDate;
        this.competitors = competitors;
        this.venue = venue;
        this.maxProbability = maxProbability;
        this.resultType = resultType;
    }
    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public List<Competitor> getCompetitors() {
        return competitors;
    }

    public void setCompetitors(List<Competitor> competitors) {
        this.competitors = competitors;
    }

    public Venue getVenue() {
        return venue;
    }

    public void setVenue(Venue venue) {
        this.venue = venue;
    }

    public void setMaxProbability(double maxProbability) {
        this.maxProbability = maxProbability;
    }

    public String getResultType() {
        return resultType;
    }

    public void setResultType(String resultType) {
        this.resultType = resultType;
    }
}
