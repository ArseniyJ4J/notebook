package pay.travel.testtask.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import pay.travel.testtask.interfaces.impls.NoteBook;
import pay.travel.testtask.objects.Note;
import java.io.IOException;

public class MainController {

    private NoteBook noteBook = new NoteBook();

    @FXML
    public Button btnFirstAddNote;
    @FXML
    public TableView tableNoteBook;
    @FXML
    public TableColumn<Note, String> columnDateCreation;
    @FXML
    public TableColumn<Note, String> columnNote;

    private Parent fxmlAdd;
    private FXMLLoader fxmlLoader = new FXMLLoader();
    private AddNodeController addNodeController;
    private Stage addNoteStage;


    public void addNote(ActionEvent actionEvent) {
        if (addNoteStage == null) {
            addNodeController.setNoteBook(noteBook);
            addNoteStage = new Stage();
            addNoteStage.setTitle("Add Node");
            addNoteStage.setMinHeight(200);
            addNoteStage.setMinWidth(400);
            addNoteStage.setResizable(false);
            addNoteStage.setScene(new Scene(fxmlAdd));
            addNoteStage.initModality(Modality.WINDOW_MODAL);
            addNoteStage.initOwner(((Node) actionEvent.getSource()).getScene().getWindow());
        }
        addNoteStage.showAndWait();
    }


    @FXML
    private void initialize() {
        this.columnNote.setCellValueFactory(new PropertyValueFactory<Note, String>("description"));
        this.columnDateCreation.setCellValueFactory(new PropertyValueFactory<Note, String>("creationDate"));
        tableNoteBook.setItems(noteBook.getNoteList());
        try {
            fxmlLoader.setLocation(getClass().getResource("/fxml/addNote.fxml"));
            fxmlAdd = fxmlLoader.load();
            addNodeController = fxmlLoader.getController();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
