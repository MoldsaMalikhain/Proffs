package moldas.professions.jsonhandler;

import com.google.gson.*;
import jdk.nashorn.internal.parser.JSONParser;
import netscape.javascript.JSException;
import org.bukkit.entity.Player;

import java.io.*;
import java.nio.file.Path;
import java.util.Date;

public class JsonHandler {
    public void write(String[] dataToChange, Player player) throws IOException, NullPointerException, JsonIOException{

        final String filePath = "plugins/Professions/data/" + player.getName() + "/" + player.getName() +".json";

        if(dataToChange[0] != null && dataToChange[1] != null){

//            FileReader reader = new FileReader(filePath);
//            JsonParser jsonParser = new JsonParser();
//            JsonObject jsonObject = (JsonObject) jsonParser.parse(reader);
//
//            System.out.println(jsonObject.getAsString());

//            jsonObject.remove(dataToChange[0]);
//            jsonObject.addProperty(dataToChange[0], dataToChange[1]);

//            System.out.println(jsonObject);

//            writer.write(String.valueOf(jsonObject));
//            writer.close();
        }
    }

    public void writeTo(String data, Player player, Path path){

    }

    public boolean read(Player player, String[] dataToRead) throws FileNotFoundException, NullPointerException, JsonIOException{

        final String filePath = "plugins/Professions/data/" + player.getName() + "/" + player.getName() +".json";

        FileReader reader = new FileReader(filePath);
        JsonParser jsonParser = new JsonParser();
        JsonObject jsonObject = (JsonObject) jsonParser.parse(reader);

        System.out.println(jsonObject.getAsString());

        JsonElement data = jsonObject.get(dataToRead[0]);

        if(data == null){
            System.out.println("JSON HANDLER ERROR : No such object in : " + "plugins/Professions/data/" + player.getName() + "/" + player.getName() +".json");
            return false;
        }
        if(data.toString() == dataToRead[1]){
            System.out.println("JSON HANDLER SUCCESS : Read was successfully done from : " + "plugins/Professions/data/" + player.getName() + "/" + player.getName() +".json");
            return true;
        }
//        if(dataToRead.length > 1){
//
//        }
//        else if(dataToRead == null){
//            System.out.println("Please enter what you need from file");
//            return false;
//        }
//        else if(dataToRead.length == 1){
//
//        }

        return true;
    }
    public void readFrom(Player player, Path path){

    }
    public void delete(Player player){

    }
    public void createCatalog(final Player player) throws IOException {

        Date d = new Date();
        JsonObject jsonWriter = new JsonObject();

        jsonWriter.addProperty("playerName", player.getName());
        jsonWriter.addProperty("playerProfession", " ");
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
