package pay.travel.testtask.interfaces.impls;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import pay.travel.testtask.interfaces.INoteBook;
import pay.travel.testtask.objects.Note;

public class NoteBook implements INoteBook {

    private ObservableList <Note> noteList = FXCollections.observableArrayList();

    public void add(Note note) {
        noteList.add(note);
    }

    public ObservableList<Note> getNoteList() {
        return this.noteList;
    }
}
