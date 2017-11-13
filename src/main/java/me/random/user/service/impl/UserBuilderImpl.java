package me.random.user.service.impl;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import me.random.user.exception.RandomUserGeneratorException;
import me.random.user.model.User;
import me.random.user.service.HttpUrlService;
import me.random.user.service.UserBuilder;
import org.apache.http.client.utils.URIBuilder;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

/**
 * Builder for working with "Random User Generator API" https://randomuser.me/
 *
 * @author ihor.horovyi
 */
public class UserBuilderImpl implements UserBuilder<User> {

    private static final String RANDOM_USER_URL = "https://randomuser.me/api/";
    private static final Type TYPE_USER_LIST = new TypeToken<List<User>>() {}.getType();

    private Gson gson;

    private HttpUrlService<String> httpUrlService;

    private URIBuilder urlBuilder;

    private boolean isAlreadyBuild;

    public UserBuilderImpl() {
        gson = new Gson();
        httpUrlService = new HttpUrlServiceImpl();

        try {
            urlBuilder = new URIBuilder(RANDOM_USER_URL);
        } catch (URISyntaxException e) {
            throw new RandomUserGeneratorException(e.getMessage(), e);
        }
    }

    @Override
    public UserBuilderImpl count(Integer count) {
        this.urlBuilder.addParameter("results", count.toString());
        return this;
    }

    @Override
    public UserBuilderImpl gender(User.Gender gender) {
        this.urlBuilder.addParameter("gender", gender.toString());
        return this;
    }

    @Override
    public UserBuilderImpl password(String password) {
        this.urlBuilder.addParameter("password", password);
        return this;
    }

    @Override
    public UserBuilderImpl seed(String seed) {
        this.urlBuilder.addParameter("seed", seed);
        return this;
    }

    @Override
    public List<User> build() {
        try {
            URI build = this.urlBuilder.build();
            String jsonResult = httpUrlService.sendGet(build.toURL());
            JsonObject jsonObject = new Gson().fromJson(jsonResult, JsonObject.class);
            return gson.fromJson(jsonObject.get("results"), TYPE_USER_LIST);
        } catch (IOException e) {
            throw new RandomUserGeneratorException(e.getMessage(), e);
        } catch (URISyntaxException e) {
            throw new RandomUserGeneratorException(e.getMessage(), e);
        }
    }

}
