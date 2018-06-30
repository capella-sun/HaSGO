package com.capellasun.hasgo.data;

import java.util.Timer;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

class SampleLobby extends Lobby {

    @Override
    public void close() {

    }

    @Override
    public void endGame(Game game) {
        game.endGame();
    }

    @Override
    public Game createNewGame() {
        return new SampleGame();
    }

    @Override
    public void addPlayer(Entity player) {
        getPlayers().add(player);
    }

    @Override
    public void kickPlayer(Entity player) {
        //TODO: implement a comparable or decide to use reference identity
        getPlayers().remove(player);
    }

    private class SampleGame extends Game {

        private int headStartDuration; // In seconds
        private int gameDuration; //In Minutes
        private final int secondsToMillisecondsFactor = 1000;

        SampleGame() {
            super();
        }

        SampleGame(int headStartDuration, int gameDuration) {
            this.headStartDuration = headStartDuration;
            this.gameDuration = gameDuration;
        }

        @Override
        public void start() {

            //Can make reactive and start actual game once timer ends, disabling any interaction until timer ends.
            // Or, don't show interactions until head start ends.

            //There could be a bug with back button during timer

            System.out.println("Starting Hider's Head Start Timer for " + headStartDuration + " seconds...");
            try {
                Thread.sleep(headStartDuration * secondsToMillisecondsFactor);
                System.out.println("Head Start Finshed! Starting Game now!");
                startGame(gameDuration);
            } catch (InterruptedException e) {
                // TODO: Implement a logging framework
                e.printStackTrace();
            }

        }

        private void startGame(int gameDuration) {
            ExecutorService service = Executors.newSingleThreadExecutor();

            // Excuse the poor practice of a nested class inside a method
            class SampleGameThread extends GameThread {

                @Override
                public void run() {
                    while (this.keepRunning()) {
                        // Reactive Game Functions (tagging, etc.)
                    }

                    // Game End code
                }
            }

            try {
                SampleGameThread thread = new SampleGameThread();
                this.setGameThread(thread);
                Future<?> future = service.submit(thread);

                future.get(gameDuration, TimeUnit.MINUTES);     // attempt the task for gameDuration minutes

                this.endGame();
                System.out.println("Stopped naturally");
            } catch (final InterruptedException e) {
                // The thread was interrupted during sleep, wait or join
            } catch (final TimeoutException e) {
                // Took too long!
                System.out.println("Timed Out!");
            } catch (final ExecutionException e) {
                // An exception from within the Runnable task
                System.out.println("Error within GameThread");
            } finally {
                service.shutdown();
            }


        }

        @Override
        public void endGame() {
            getCurrentGame().getGameThread().keepRunning(false);
            System.out.println("Sent Stop Signal");
        }
    }
}
