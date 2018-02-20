package pay.travel.testtask.controllers;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import pay.travel.testtask.interfaces.impls.NoteBook;
import pay.travel.testtask.objects.Note;
import java.util.Date;

public class AddNodeController {

    private NoteBook noteBook;

    @FXML
    private TextField txtCurrentDate;
    @FXML
    public Button btnFinallyAdd;
    @FXML
    public TextArea txtAreaNoteValue;
    @FXML
    public Label lableCurrentDate;

    public void setNoteBook(NoteBook noteBook) {
        this.noteBook = noteBook;
    }

    public void finalyAddNote(ActionEvent actionEvent) {
        Note note = new Note();
        if (txtCurrentDate.getText().equals("")) {
            note.setCreationDate(new Date().toString());
        } else {
            note.setCreationDate(txtCurrentDate.getText());
        }
        note.setDescription(txtAreaNoteValue.getText());
        this.noteBook.add(note);
        txtCurrentDate.clear();
        txtAreaNoteValue.clear();
        Node source = (Node) actionEvent.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.hide();
    }

    @FXML
    private void initialize() {
        addTextLimiter(txtAreaNoteValue, 101);
    }

    private static void addTextLimiter(final TextArea ta, final int maxLength) {
        ta.textProperty().addListener(new ChangeListener<String>() {
            public void changed(final ObservableValue<? extends String> ov, final String oldValue, final String newValue) {
                if (ta.getText().length() > maxLength) {
                    String s = ta.getText().substring(0, maxLength);
                    ta.setText(s);
                }
            }
        });
    }
}
