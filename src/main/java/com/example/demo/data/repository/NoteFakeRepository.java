package com.example.demo.data.repository;

import com.example.demo.data.entity.Note;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

@Component
public class NoteFakeRepository {
    private List<Note> notes = new ArrayList<>();

    public Note createNote (Note note){
        note.setId(UUID.randomUUID());
        this.notes.add(note);
        return note;
    }

    public List<Note> findAllnotes() {
        return this.notes;
    }

    public void deleteByIdNote(long id) {
        UUID targetUUID = new UUID(id, 0); // Створюємо UUID на основі переданого long id
        Iterator<Note> iterator = notes.iterator();
        while (iterator.hasNext()) {
            Note note = iterator.next();
            if (note.getId().equals(targetUUID)) {
                iterator.remove();
                return;
            }
        }
        throw new IllegalArgumentException("Note with id " + id + " does not exist");
    }

    public void updateNote(Note note) {
        UUID targetUUID = note.getId();
        for (Note existingNote : notes) {
            if (existingNote.getId().equals(targetUUID)) {
                existingNote.setTitle(note.getTitle());
                existingNote.setContent(note.getContent());
                return;
            }
        }
        throw new IllegalArgumentException("Note with id " + targetUUID + " does not exist");
    }

    public Note getByIdNote(long id) {
        UUID targetUUID = new UUID(id, 0);
        for (Note note : notes) {
            if (note.getId().equals(targetUUID)) {
                return note;
            }
        }
        throw new IllegalArgumentException("Note with id " + id + " does not exist");
    }

}
