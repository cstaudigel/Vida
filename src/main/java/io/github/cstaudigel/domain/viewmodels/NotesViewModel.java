package io.github.cstaudigel.domain.viewmodels;

import io.github.cstaudigel.domain.models.Note;

import java.util.List;

public class NotesViewModel {

    List<Note> notes;

    public NotesViewModel(List<Note> notes) {
        this.notes = notes;
    }

    public List<Note> getNotes() {
        return notes;
    }

    public void setNotes(List<Note> notes) {
        this.notes = notes;
    }
}
