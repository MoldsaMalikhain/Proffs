package moldas.professions;

import com.google.gson.Gson;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PlayerDataHandler {

    private final static String FILE_NAME = "file.json";
    private final Gson GSON = new Gson();
    private Map<Long, Record> records = new HashMap<>();

    public Record addRecord(long id,String FIO, String bornDate, int numbers, String address, long timeCreateFields)
            throws CloneNotSupportedException {
        records.put(id, new Record(id, FIO, bornDate, numbers, address, timeCreateFields));
        return getRecord(id);
    }

    public Record updateRecord(long id, String FIO, String bornDate, int numbers, String address)
            throws CloneNotSupportedException {
        return addRecord(id, FIO, bornDate, numbers, address, 0);
    }

    public Record getRecord(long id) throws CloneNotSupportedException {
        return records.containsKey(id) ? (Record) records.get(id).clone() : null;
    }

    public void removeRecord(long id) {
        records.remove(id);
    }

    public Collection<Record> allRecords() {
        return records.values();
        // если по какой-то причине нужен имено лист
        //return records.values().stream().collect(Collectors.toList());
    }

    public void store() throws IOException {
        fileWriter(GSON.toJson(records));
    }

    public PlayerDataHandler read() throws IOException {
        this.records = GSON.fromJson(fileReader(), Map.class);
        return this;
    }

    private void fileWriter(String json) throws IOException {
        Files.write(Paths.get(FILE_NAME), json.getBytes());
    }

    private String fileReader() throws IOException {
        try (Stream<String> stream = Files.lines(Paths.get(FILE_NAME), Charset.defaultCharset())) {
            return stream.collect(Collectors.joining("\r\n"));
        }
    }

}
