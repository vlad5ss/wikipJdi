package android.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class CountryDto {
    public String country;
    public String name;
    @JsonProperty("_id")
    public Integer id;
    public Coord coord;
}
