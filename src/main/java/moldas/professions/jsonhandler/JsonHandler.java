package moldas.professions.jsonhandler;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.bukkit.entity.Player;

import java.io.*;
import java.nio.file.Path;
import java.util.Date;

public class JsonHandler {
    public void writeTo(Object object, Player player){

    }

    public void write(Object object, Player player, Path path){

    }

    public String[] read(Player player, String[] dataToRead) throws FileNotFoundException, NullPointerException{
        final String filePath = "plugins/Professions/data/" + player.getName() + "/" + player.getName() +".json";
        String[] parsedData = {};
        try{
            FileReader reader = new FileReader(filePath);
            JsonParser jsonParser = new JsonParser();
            JsonObject jsonObject = new JsonObject();

            if(dataToRead.length > 1){

            }
            else if(dataToRead == null){
                System.out.println("Please enter what you need from file");
                return null;
            }
            else if(dataToRead.length == 1){

            }

        }catch(IOException e){
            e.printStackTrace();
        }
        return parsedData;
    }
    public void readFrom(Player player, Path path){

    }
    public void delete(Player player){

    }
    public void createCatalog(final Player player){

        Date d = new Date();
        JsonObject jsonWriter = new JsonObject();

        jsonWriter.addProperty("playerName", player.getName());
        jsonWriter.addProperty("speed", 1);
        jsonWriter.addProperty("harvest", 1);
        jsonWriter.addProperty("health", 20);
        jsonWriter.addProperty("jumps", 1);
        jsonWriter.addProperty("fallingDamage", 1);
        jsonWriter.addProperty("damage", 1);
        jsonWriter.addProperty("armor", 1);
        jsonWriter.addProperty("shiftSpeed", 1);
        jsonWriter.addProperty("shiftSneak", 1);
        jsonWriter.addProperty("timeStamp", d.getDay() + "/" + d.getHours() + "/" + d.getSeconds() + " YY:" + d.getYear() + " MM:" + d.getMonth());

        try{
            File dir = new File("plugins/Professions/" + "data/" + player.getName());
            File f = new File("plugins/Professions/data/" + player.getName() + "/" + player.getName() +".json");

            if(dir.mkdirs()){
                System.out.println("Directory was created");
                dir.mkdirs();
            }
            else{
                System.out.println("Directory already exists");
            }
            if (!f.exists()){
                f.createNewFile();
                FileWriter writer = new FileWriter(f);
                writer.write(String.valueOf(jsonWriter));
                writer.close();

                System.out.print("Successfully created and wrote new Json-file");
                System.out.print("\n JSON obj: " + jsonWriter);
            }
            else{
                System.out.println("File exists");
            }
        } catch(IOException e){
            e.printStackTrace();
            System.out.println("Does not created");
        }
    }
}
