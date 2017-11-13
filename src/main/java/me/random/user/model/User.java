package me.random.user.model;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import me.random.user.formatter.JsonDataDeserializer;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@ToString
@EqualsAndHashCode(of = {"id"})
public class User implements Serializable {

    private Gender gender;

    private Name name;

    private Location location;

    private String email;

    private Login login;

    @JsonAdapter(JsonDataDeserializer.class)
    private LocalDateTime dob;

    @JsonAdapter(JsonDataDeserializer.class)
    private LocalDateTime registered;

    private String phone;

    private String cell;

    private Id id;

    private Picture picture;

    private String nat;

    @Getter
    @AllArgsConstructor
    public enum Gender {
        @SerializedName("male") MALE("male"),
        @SerializedName("female") FEMALE("female");

        private String value;
    }
}
