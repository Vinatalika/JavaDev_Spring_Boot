package com.example.demo.data.service;

import com.example.demo.data.entity.Note;

import java.util.List;
import java.util.UUID;

public interface NoteService {
    List<Note> listAll();
    Note add (Note note);
    void deleteById(long id);
    void update(Note note);
    Note getById(long id);
}
