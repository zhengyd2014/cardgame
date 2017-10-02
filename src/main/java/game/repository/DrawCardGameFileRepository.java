package game.repository;

import game.impl.DrawCardGame;
import game.model.CardGame;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by fred on 10/1/17.
 */
public class DrawCardGameFileRepository implements Repository {

    private String file = "cardgame.txt";
    Map<String, DrawCardGame> dataMap = new HashMap<>();

    public DrawCardGameFileRepository() {
         readFromFile();
    }

    public Map<String, DrawCardGame> getDataMap() {
        return dataMap;
    }

    public DrawCardGame getGameById(String id) {
        return dataMap.get(id);
    }

    @Override
    public void save(CardGame game) {
        DrawCardGame drawCardGame = (DrawCardGame)game;
        dataMap.put(drawCardGame.getDeck().getId(), drawCardGame);
        saveToFile();
    }

    @Override
    public void remove(CardGame game) {
        DrawCardGame drawCardGame = (DrawCardGame)game;
        dataMap.remove(drawCardGame.getDeck().getId());
        saveToFile();
    }

    private void saveToFile() {
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream(file));
            oos.writeObject(dataMap);
            oos.close();
            System.out.println("wrote data to file");
        } catch (Exception e){
            // do nothing
            e.printStackTrace();
        }
    }

    private void readFromFile(){
        ObjectInputStream ois = null;
        try {
            ois= new ObjectInputStream(new FileInputStream(file));
            dataMap = (Map<String, DrawCardGame>)ois.readObject();
            ois.close();
            System.out.println("read data from file");
        } catch (Exception e) {
            // do nothing
            // e.printStackTrace();
        }
    }
}
