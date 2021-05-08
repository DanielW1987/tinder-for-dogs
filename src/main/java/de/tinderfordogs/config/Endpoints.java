package de.tinderfordogs.config;

public class Endpoints {

  public static class Rest {
    public static final String DOGS = "/dogs";
    public static final String DOGS_LIKES = "/dogs/likes";
    public static final String DOGS_DISLIKES = "/dogs/dislikes";
  }

  public static class Site {
    public static final String INDEX = "/index";
    public static final String EMPTY_INDEX = "";
    public static final String SLASH_INDEX = "/";
    public static final String LOGIN = "/login";
    public static final String GALLERY = "/gallery";
    public static final String TINDER = "/tinder";
  }
}
