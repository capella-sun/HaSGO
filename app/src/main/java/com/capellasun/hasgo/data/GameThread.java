package com.capellasun.hasgo.data;

public abstract class GameThread extends Thread {
  private boolean keepRunning;

  @Override
  public abstract void run();

  public boolean keepRunning() {
    return keepRunning;
  }

  public void keepRunning(boolean keepRunning) {
    this.keepRunning = keepRunning;
  }
}
