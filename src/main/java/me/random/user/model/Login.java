package me.random.user.model;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Login {

    @SerializedName("username")
    private String userName;

    private String password;

    private String salt;

    private String md5;

    private String sha1;

    private String sha256;

}
