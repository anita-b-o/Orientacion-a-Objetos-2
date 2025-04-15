package ar.edu.info.unlp.RedSocial;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private String screenName;
    private List<Component> tweets;

    public Usuario(String screenName) {
        this.screenName = screenName;
    }

    public String getScreenName() {
        return screenName;
    }

    public void Tweetear(String text) {
        if (!text.isEmpty() && text.length() <= 280) {
            Tweet twt = new Tweet(text);
            tweets.add()
        }
    }
}
