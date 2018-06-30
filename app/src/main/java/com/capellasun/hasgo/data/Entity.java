package com.capellasun.hasgo.data;

import java.util.List;

public abstract class Entity {

  private boolean isAdmin;
  private EntityRole role;
  private EntityStatus status;
  private String name;
  /**
   * Lobby the entity is a part of.
   */
  private Lobby lobby;//TODO: Determine whether to hide from Json

  public Entity() {
    isAdmin = false;
  }

  public Entity(EntityRole role) {
    this.role = role;
  }

  public Entity initSeeker() {
    this.role = EntityRole.SEEKER;
    this.status = EntityStatus.SEEKING;
    return this;
  }

  public Entity initHider() {
    this.role = EntityRole.HIDER;
    this.status = EntityStatus.HIDING;
    return this;
  }


    /**
     * Determines if all hiders have been found (duh).
     *
     * Note: Tagging occurs at the {@code Entity} level, not {@code Lobby} level.
     *      Thus, the logic for the endgame scenario caused by all players being found is here,
     *      not in {@code Game} or {@code Lobby} as might seem natural.
     * @return true IFF all hiders have been found
     */
  public abstract boolean allHidersHaveBeenFound();
  public abstract void initEndGame(); //lobby.endGame(lobby.getCurrentGameThread());

  /**
   * Tags a hider and returns {@code TagData} object.
   * @param tagger
   */
  public TagData tag(Entity tagger) {
    this.tag();

    TagData tagData = new TagData();
    tagData.setMessage(TagMessageBuilder.buildMessage(tagger, this));
    tagData.setTagged(this);
    tagData.setTagger(tagger);
    tagData.setPlayerStatuses(lobby.getPlayers());

    if (allHidersHaveBeenFound())
      initEndGame(); // FIXME: Could pass tagData to get the last tag in?

    return tagData;
  }

  private void tag() {
    this.role = EntityRole.SEEKER;
    this.status = EntityStatus.FOUND_AND_SEEKING;
  }

// GETTERS AND SETTERS
  public boolean isAdmin() {
    return isAdmin;
  }

  public void setAdmin(boolean admin) {
    isAdmin = admin;
  }

  public EntityRole getRole() {
    return role;
  }

  public void setRole(EntityRole role) {
    this.role = role;
  }

  public EntityStatus getStatus() {
    return status;
  }

  public void setStatus(EntityStatus status) {
    this.status = status;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Lobby getLobby() {
    return lobby;
  }

  public void setLobby(Lobby lobby) {
    this.lobby = lobby;
  }

  // END GETTERS AND SETTERS
}
