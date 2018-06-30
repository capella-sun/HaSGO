package com.capellasun.hasgo.data;

public abstract class Game {

  private GameThread gameThread;

  public abstract void start();
  public abstract void endGame();

  public GameThread getGameThread() {
    return gameThread;
  }

  protected void setGameThread(GameThread gameThread) {
    this.gameThread = gameThread;
  }
}
