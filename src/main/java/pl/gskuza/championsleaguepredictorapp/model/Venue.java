package pl.gskuza.championsleaguepredictorapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "name",
        "capacity",
        "city_name",
        "country_name",
        "map_coordinates",
        "country_code"
})
@Entity
public class Venue implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
    private Long venueId;
    @JsonProperty("id")
    private String id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("capacity")
    private int capacity;
    @JsonProperty("city_name")
    private String cityName;
    @JsonProperty("country_name")
    private String countryName;
    @JsonProperty("map_coordinates")
    private String mapCoordinates;
    @JsonProperty("country_code")
    private String countryCode;

    public Venue() {
    }

    public Venue(Long venueId, String id, String name, int capacity, String cityName, String countryName,
                 String mapCoordinates, String countryCode) {
        this.venueId = venueId;
        this.id=id;
        this.name = name;
        this.capacity = capacity;
        this.cityName = cityName;
        this.countryName = countryName;
        this.mapCoordinates = mapCoordinates;
        this.countryCode = countryCode;
    }

    public Long getVenueId() {
        return venueId;
    }

    public void setVenueId(Long venueId) {
        this.venueId = venueId;
    }

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("capacity")
    public Integer getCapacity() {
        return capacity;
    }

    @JsonProperty("capacity")
    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    @JsonProperty("city_name")
    public String getCityName() {
        return cityName;
    }

    @JsonProperty("city_name")
    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    @JsonProperty("country_name")
    public String getCountryName() {
        return countryName;
    }

    @JsonProperty("country_name")
    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    @JsonProperty("map_coordinates")
    public String getMapCoordinates() {
        return mapCoordinates;
    }

    @JsonProperty("map_coordinates")
    public void setMapCoordinates(String mapCoordinates) {
        this.mapCoordinates = mapCoordinates;
    }

    @JsonProperty("country_code")
    public String getCountryCode() {
        return countryCode;
    }

    @JsonProperty("country_code")
    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Venue venue = (Venue) o;
        return capacity == venue.capacity && Objects.equals(venueId, venue.venueId) && Objects.equals(id, venue.id) && Objects.equals(name, venue.name) && Objects.equals(cityName, venue.cityName) && Objects.equals(countryName, venue.countryName) && Objects.equals(mapCoordinates, venue.mapCoordinates) && Objects.equals(countryCode, venue.countryCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(venueId, id, name, capacity, cityName, countryName, mapCoordinates, countryCode);
    }

    @Override
    public String toString() {
        return "Venue{" +
                "venueId=" + venueId +
                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", capacity=" + capacity +
                ", cityName='" + cityName + '\'' +
                ", countryName='" + countryName + '\'' +
                ", mapCoordinates='" + mapCoordinates + '\'' +
                ", countryCode='" + countryCode + '\'' +
                '}';
    }
}
