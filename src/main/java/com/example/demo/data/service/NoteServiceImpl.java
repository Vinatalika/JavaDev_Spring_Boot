package com.example.demo.data.service;

import com.example.demo.data.entity.Note;
import com.example.demo.data.repository.NoteFakeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class NoteServiceImpl implements NoteService {

    @Autowired
    private NoteFakeRepository noteFakeRepository;

    @Override
    public List<Note> listAll() {
        return noteFakeRepository.findAllnotes();
    }

    @Override
    public Note add(Note note) {
        return noteFakeRepository.createNote(note);
    }

    @Override
    public void deleteById(long id) {
        noteFakeRepository.deleteByIdNote(id);
    }

    @Override
    public void update(Note note) {
        noteFakeRepository.updateNote(note);
    }

    @Override
    public Note getById(long id) {
        return noteFakeRepository.getByIdNote(id);
    }
}
