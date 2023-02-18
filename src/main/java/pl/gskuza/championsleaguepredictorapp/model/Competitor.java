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
        "country",
        "country_code",
        "abbreviation",
        "qualifier",
        "gender"
})
@Entity
public class Competitor implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
    private Long competitorId;
    @JsonProperty("id")
    private String id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("country")
    private String country;
    @JsonProperty("country_code")
    private String countryCode;
    @JsonProperty("abbreviation")
    private String abbreviation;
    @JsonProperty("qualifier")
    private String qualifier;
    @JsonProperty("gender")
    private String gender;
    public Competitor() {
    }
    public Competitor(Long competitorId, String id, String name, String country, String countryCode, String abbreviation,
                      String qualifier, String gender) {
        this.competitorId = competitorId;
        this.id=id;
        this.name = name;
        this.country = country;
        this.countryCode = countryCode;
        this.abbreviation = abbreviation;
        this.qualifier = qualifier;
        this.gender = gender;
    }
    public Competitor(String name) {
        this.name=name;
    }
    public Long getCompetitorId() {
        return competitorId;
    }
    public void setCompetitorId(Long id) {
        this.competitorId = id;
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
    @JsonProperty("country")
    public String getCountry() {
        return country;
    }
    @JsonProperty("country")
    public void setCountry(String country) {
        this.country = country;
    }
    @JsonProperty("country_code")
    public String getCountryCode() {
        return countryCode;
    }
    @JsonProperty("country_code")
    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }
    @JsonProperty("abbreviation")
    public String getAbbreviation() {
        return abbreviation;
    }
    @JsonProperty("abbreviation")
    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }
    @JsonProperty("qualifier")
    public String getQualifier() {
        return qualifier;
    }
    @JsonProperty("qualifier")
    public void setQualifier(String qualifier) {
        this.qualifier = qualifier;
    }
    @JsonProperty("gender")
    public String getGender() {
        return gender;
    }
    @JsonProperty("gender")
    public void setGender(String gender) {
        this.gender = gender;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Competitor that = (Competitor) o;
        return Objects.equals(competitorId, that.competitorId) && Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(country, that.country) && Objects.equals(countryCode, that.countryCode) && Objects.equals(abbreviation, that.abbreviation) && Objects.equals(qualifier, that.qualifier) && Objects.equals(gender, that.gender);
    }
    @Override
    public int hashCode() {
        return Objects.hash(competitorId, id, name, country, countryCode, abbreviation, qualifier, gender);
    }
    @Override
    public String toString() {
        return "Competitor{" +
                "competitorId=" + competitorId +
                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", countryCode='" + countryCode + '\'' +
                ", abbreviation='" + abbreviation + '\'' +
                ", qualifier='" + qualifier + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}
