package pl.gskuza.championsleaguepredictorapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Objects;
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EventsContainer extends Events{
    @JsonIgnore
    private Long eventsContainerId;
    @JsonProperty("Events")
    public List<Events> events;
    public EventsContainer() {
    }
    public EventsContainer(Long eventsContainerId, List<Events> events) {
        this.events = events;
        this.eventsContainerId = eventsContainerId;
    }
    public Long getEventsContainerId() {
        return eventsContainerId;
    }
    public void setEventsContainerId(Long eventsContainerId) {
        this.eventsContainerId = eventsContainerId;
    }

    public List<Events> getEvents() {
        return events;
    }
    public void setEvents(List<Events> events) {
        this.events = events;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        EventsContainer container = (EventsContainer) o;
        return Objects.equals(eventsContainerId, container.eventsContainerId) && Objects.equals(events, container.events);
    }
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), eventsContainerId, events);
    }
}
