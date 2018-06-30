package com.capellasun.hasgo.data;

public class TagMessageBuilder {

  public static String buildMessage(Entity tagger, Entity tagged) {
    return String.format("%s tagged %s!", tagger, tagged);
  }

}
