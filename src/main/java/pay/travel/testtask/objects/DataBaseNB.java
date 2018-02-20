package pay.travel.testtask.objects;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

public class DataBaseNB {

    private ObservableList<Note> noteList = FXCollections.observableArrayList();


    private String dbPath;

    private Connection connection;

    private Statement statement;

    public DataBaseNB(String dbPath) {
        this.dbPath = dbPath;
    }

    public static void main(String[] args) {
        DataBaseNB baseNB = new DataBaseNB("src/main/resources/dataBase/NB.db");
        baseNB.fillData();
        baseNB.open();
    }

    private void open() {
        try {
            Class.forName("org.sqlite.JDBC");
            String data = String.format("jdbc:sqlite:%s", this.dbPath);
            connection = DriverManager.getConnection(data);
            statement = connection.createStatement();
            statement.execute("CREATE TABLE IF NOT EXISTS 'Notes' ('Note' VARCHAR, 'Date_creation' VARCHAR);");
            statement.execute("DELETE FROM Notes;");
            connection.setAutoCommit(false);
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Notes (Note, Date_creation) VALUES (?, ?);");
            for (Note note : noteList) {
                preparedStatement.setString(1, note.getDescription());
                preparedStatement.setString(2, note.getCreationDate());
                preparedStatement.execute();
            }
            connection.commit();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void fillData() {
        noteList.add(new Note("one", "1"));
        noteList.add(new Note("two", "2"));
        noteList.add(new Note("three", "3"));
        noteList.add(new Note("four", "4"));
        noteList.add(new Note("five", "5"));
        noteList.add(new Note("six", "6"));
        noteList.add(new Note("seven", "7"));
    }
}
