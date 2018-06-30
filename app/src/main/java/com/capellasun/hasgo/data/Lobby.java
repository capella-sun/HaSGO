package com.capellasun.hasgo.data;

import java.util.ArrayList;
import java.util.List;

public abstract class Lobby {

  private List<Entity> players;
  private Region playingRegion;
  private String lobbyId;
  private Game currentGame;

  public Lobby() {
    players = new ArrayList<>();
    playingRegion = new EmptyRegion();
    lobbyId = "";
  }

  public abstract void close();

  /**
   * Ends the game and notifies {@code game} to stop running.
   * @param game The game to end
   * @see <a href="https://stackoverflow.com/questions/4044726/how-to-set-a-timer-in-java">https://stackoverflow.com/questions/4044726/how-to-set-a-timer-in-java</a>
   */
  public abstract void endGame(Game game);
  public abstract Game createNewGame();
  public abstract void addPlayer(Entity player);
  public abstract void kickPlayer(Entity player);

  public List<Entity> getPlayers() {
    return players;
  }

  public void setPlayers(List<Entity> players) {
    this.players = players;
  }

  public Region getPlayingRegion() {
    return playingRegion;
  }

  public void setPlayingRegion(Region playingRegion) {
    this.playingRegion = playingRegion;
  }

  public String getLobbyId() {
    return lobbyId;
  }

  public void setLobbyId(String lobbyId) {
    this.lobbyId = lobbyId;
  }

  public Game getCurrentGame() {
    return currentGame;
  }

  public void setCurrentGame(Game currentGame) {
    this.currentGame = currentGame;
  }
}
