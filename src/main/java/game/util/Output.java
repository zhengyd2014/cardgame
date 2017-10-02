package game.util;

import game.impl.DrawCardGame;
import game.impl.DrawCardHand;
import game.model.GameCommand;
import game.repository.DrawCardGameFileRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by fred on 9/30/17.
 */
public class Output {

    public static void printHelp() {
        StringBuilder prompt = new StringBuilder();
        prompt.append("command: \n")
                .append("\t ").append("help").append("      -  print a list of available commands").append("\n")
                .append("\t ").append("exit").append("      -  exit command loop").append("\n")
                .append("\t ").append("show").append("      -  display cards in hand").append("\n")
                .append("\t ").append("switch").append("    -  switch to previous saved games").append("\n")
                .append("\t ").append("save").append("      -  save current game").append("\n")
                .append("\t ").append(GameCommand.drawcard).append("  -  draw one card from deck").append("\n")
                .append("\t ").append(GameCommand.newgame).append("   -  start a new deck").append("\n")
                .append("\t ").append(GameCommand.reshuffle).append("  -  reshuffle the rest of cards in the deck");

        System.out.println(prompt);
    }

    public static void printPrompt(String prefix) {
        System.out.print(prefix + " > ");
    }

    public static void printSavedGames(DrawCardGameFileRepository repository) {
        Map<String, DrawCardGame> map = repository.getDataMap();
        System.out.println("saved games: ");
        for (String key : map.keySet()) {
            DrawCardGame game = map.get(key);
            String info = game.getDeck().getDeckBriefInfo();
            System.out.println("\t" + info);
        }
    }

    public static void printCards(DrawCardHand hand) {
        if (hand == null) {
            return;
        }
        TreeMap<String, Integer> map = new TreeMap<>(new CardValueComparator<>());
        map.putAll(hand.getCardMap());
        System.out.println(hand.getName() + ":");
        int total = 0;
        for (String key : map.keySet()) {
            System.out.println("\t" + key + " : " + map.get(key));
            total += map.get(key);
        }
        System.out.println("total : " + total);
    }
}
