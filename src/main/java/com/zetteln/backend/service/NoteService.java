package com.zetteln.backend.service;

import com.zetteln.backend.entity.Note;
import com.zetteln.backend.repository.NoteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteService {

    private NoteRepository noteRepository;

    public NoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    public List<Note> GetAll() { return noteRepository.findAll(); }
}
