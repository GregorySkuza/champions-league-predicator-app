package pl.gskuza.championsleaguepredictorapp.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
@JsonPropertyOrder({
        "sport_event_id",
        "start_date",
        "sport_name",
        "competition_name",
        "competition_id",
        "season_name",
        "competitors",
        "venue",
        "probability_home_team_winner",
        "probability_draw",
        "probability_away_team_winner"
})
public class Events implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
    private Long eventsId;
    @JsonProperty("sport_event_id")
    private String sportEventId;
    @JsonProperty("start_date")
    private String startDate;
    @JsonProperty("sport_name")
    private String sportName;
    @JsonProperty("competition_name")
    private String competitionName;
    @JsonProperty("competition_id")
    private String competitionId;
    @JsonProperty("season_name")
    private String seasonName;
    @OneToMany(cascade = {CascadeType.ALL})
    @JsonProperty("competitors")
    private List<Competitor> competitors;
    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn
    @JsonProperty("venue")
    private Venue venue;
    @JsonProperty("probability_home_team_winner")
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private double probabilityHomeTeamWinner;
    @JsonProperty("probability_draw")
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private double probabilityDraw;
    @JsonProperty("probability_away_team_winner")
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private double probabilityAwayTeamWinner;
    public Events() {
    }
    public Events(Long eventsId, String sportEventId, String startDate, String sportName, String competitionName, String competitionId, String seasonName,
                  List<Competitor> competitors, Venue venue, double probabilityHomeTeamWinner, double probabilityDraw, double probabilityAwayTeamWinner) {
        this.sportEventId = sportEventId;
        this.startDate = startDate;
        this.sportName = sportName;
        this.competitionName = competitionName;
        this.competitionId = competitionId;
        this.seasonName = seasonName;
        this.competitors = competitors;
        this.venue = venue;
        this.probabilityHomeTeamWinner = probabilityHomeTeamWinner;
        this.probabilityDraw = probabilityDraw;
        this.probabilityAwayTeamWinner = probabilityAwayTeamWinner;
    }
    public Events(String sportEventId, List<String> competitorNames) {
        this.sportEventId = sportEventId;
        this.competitors = new ArrayList<>();
        for (String name : competitorNames) {
            this.competitors.add(new Competitor(name));
        }
    }
    public Long getEventsId() {
        return eventsId;
    }

    public void setEventsId(Long eventsId) {
        this.eventsId = eventsId;
    }
    @JsonProperty("sport_event_id")
    public String getSportEventId() {
        return sportEventId;
    }
    @JsonProperty("sport_event_id")
    public void setSportEventId(String sportEventId) {
        this.sportEventId = sportEventId;
    }
    @JsonProperty("start_date")
    public String getStartDate() {
        return startDate;
    }
    @JsonProperty("start_date")
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }
    @JsonProperty("sport_name")
    public String getSportName() {
        return sportName;
    }
    @JsonProperty("sport_name")
    public void setSportName(String sportName) {
        this.sportName = sportName;
    }
    @JsonProperty("competition_name")
    public String getCompetitionName() {
        return competitionName;
    }
    @JsonProperty("competition_name")
    public void setCompetitionName(String competitionName) {
        this.competitionName = competitionName;
    }
    @JsonProperty("competition_id")
    public String getCompetitionId() {
        return competitionId;
    }
    @JsonProperty("competition_id")
    public void setCompetitionId(String competitionId) {
        this.competitionId = competitionId;
    }
    @JsonProperty("season_name")
    public String getSeasonName() {
        return seasonName;
    }
    @JsonProperty("season_name")
    public void setSeasonName(String seasonName) {
        this.seasonName = seasonName;
    }
    @JsonProperty("competitors")
    public List<Competitor> getCompetitors() {return competitors; }
    @JsonProperty("competitors")
    public void setCompetitors(List<Competitor> competitors) {
    this.competitors = competitors;
}
    @JsonProperty("venue")
    public Venue getVenue() {
        return venue;
    }
    @JsonProperty("venue")
    public void setVenue(Venue venue) {
        this.venue = venue;
    }
    @JsonProperty("probability_home_team_winner")
    public double getProbabilityHomeTeamWinner() {
        return probabilityHomeTeamWinner;
    }
    @JsonProperty("probability_home_team_winner")
    public void setProbabilityHomeTeamWinner(double probabilityHomeTeamWinner) {
        this.probabilityHomeTeamWinner = probabilityHomeTeamWinner;
    }
    @JsonProperty("probability_draw")
    public double getProbabilityDraw() {
        return probabilityDraw;
    }
    @JsonProperty("probability_draw")
    public void setProbabilityDraw(double probabilityDraw) {
        this.probabilityDraw = probabilityDraw;
    }
    @JsonProperty("probability_away_team_winner")
    public double getProbabilityAwayTeamWinner() {
        return probabilityAwayTeamWinner;
    }
    @JsonProperty("probability_away_team_winner")
    public void setProbabilityAwayTeamWinner(double probabilityAwayTeamWinner) {
        this.probabilityAwayTeamWinner = probabilityAwayTeamWinner;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Events events = (Events) o;
        return Double.compare(events.probabilityHomeTeamWinner, probabilityHomeTeamWinner) == 0 && Double.compare(events.probabilityDraw, probabilityDraw) == 0 && Double.compare(events.probabilityAwayTeamWinner, probabilityAwayTeamWinner) == 0 && Objects.equals(eventsId, events.eventsId) && Objects.equals(sportEventId, events.sportEventId) && Objects.equals(startDate, events.startDate) && Objects.equals(sportName, events.sportName) && Objects.equals(competitionName, events.competitionName) && Objects.equals(competitionId, events.competitionId) && Objects.equals(seasonName, events.seasonName) && Objects.equals(competitors, events.competitors) && Objects.equals(venue, events.venue);
    }
    @Override
    public int hashCode() {
        return Objects.hash(eventsId, sportEventId, startDate, sportName, competitionName, competitionId, seasonName, competitors, venue, probabilityHomeTeamWinner, probabilityDraw, probabilityAwayTeamWinner);
    }
    @Override
    public String toString() {
        return "Events{" +
                "eventsId=" + eventsId +
                ", sportEventId='" + sportEventId + '\'' +
                ", startDate=" + startDate +
                ", sportName='" + sportName + '\'' +
                ", competitionName='" + competitionName + '\'' +
                ", competitionId='" + competitionId + '\'' +
                ", seasonName='" + seasonName + '\'' +
                //", competitors=" + competitors +
                ", venue=" + venue +
                ", probabilityHomeTeamWinner=" + probabilityHomeTeamWinner +
                ", probabilityDraw=" + probabilityDraw +
                ", probabilityAwayTeamWinner=" + probabilityAwayTeamWinner +
                '}';
    }
}

