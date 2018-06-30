package com.capellasun.hasgo.data;

import java.util.List;

public class TagData {

  private String message;
  private Entity tagged;
  private Entity tagger;
  private List<Entity> playerStatuses;

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public Entity getTagged() {
    return tagged;
  }

  public void setTagged(Entity tagged) {
    this.tagged = tagged;
  }

  public Entity getTagger() {
    return tagger;
  }

  public void setTagger(Entity tagger) {
    this.tagger = tagger;
  }

  public List<Entity> getPlayerStatuses() {
    return playerStatuses;
  }

  public void setPlayerStatuses(List<Entity> playerStatuses) {
    this.playerStatuses = playerStatuses;
  }

}
