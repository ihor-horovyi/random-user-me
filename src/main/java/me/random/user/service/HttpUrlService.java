package me.random.user.service;

import java.io.IOException;
import java.net.URL;

public interface HttpUrlService<T> {

    T sendGet(URL url) throws IOException;

}
