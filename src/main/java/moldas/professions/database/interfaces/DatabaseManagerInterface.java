package moldas.professions.database.interfaces;

import java.sql.Connection;

public interface DatabaseManagerInterface {
    Boolean createDatabase();
    Connection getConnection();
    Boolean createPlayerdataTable();
}
