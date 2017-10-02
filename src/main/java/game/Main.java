package game;

import game.impl.DrawCardGame;
import game.model.GameCommand;
import game.repository.DrawCardGameFileRepository;
import game.util.Output;

import java.util.Scanner;

/**
 * Created by fred on 9/30/17.
 */
public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        DrawCardGame game = new DrawCardGame();
        DrawCardGameFileRepository repository = new DrawCardGameFileRepository();

        String command = null;
        Output.printHelp();
        while (true) {
            Output.printPrompt(game.getDeck() == null ? "" : game.getDeck().getDeckBriefInfo());
            command = scanner.next();
            switch (command) {
                case "exit" :
                    System.exit(0);
                    break;
                case "show" :
                    Output.printCards(game.getHand());
                    break;
                case "help" :
                    Output.printHelp();
                    break;
                case "newgame" :
                    game = new DrawCardGame();
                    game.init();
                    break;
                case "switch" :
                    if (repository.getDataMap() == null || repository.getDataMap().size() == 0) {
                        System.out.println("no saved game.");
                    } else {
                        Output.printSavedGames(repository);
                        System.out.print("input Id to switch: ");
                        DrawCardGame oldgame = repository.getGameById(scanner.next());
                        if (oldgame != null)  {
                            game = oldgame;
                        }
                    }
                    break;
                case "save" :
                    repository.save(game);
                    break;
                default:
                    try {
                        game.play(GameCommand.valueOf(command));
                    } catch (Exception e) {
                        // e.printStackTrace();
                        System.out.println(command + " not supported");
                    }
            }
        }
    }

}
