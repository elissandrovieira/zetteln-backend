package com.zetteln.backend.service;

import com.zetteln.backend.entity.Note;
import com.zetteln.backend.repository.NoteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NoteService {

    private NoteRepository noteRepository;

    public NoteService(NoteRepository noteRepository) {

        this.noteRepository = noteRepository;
    }

    public List<Note> GetAll() {
        return noteRepository.findAll();
    }

    public List<Note> GetByUserId(Long userId) {
        return noteRepository.findByVault_User_Id(userId);
    }

    public List<Note> GetByUserAndVaultId(Long userId, Long vaultId) {
        return noteRepository.findByVault_User_IdAndVault_Id(userId, vaultId);
    }

    public Note CreateNote(Note note) {
        return noteRepository.save(note);
    }

    public Note UpdateNote(Long id, Note note) {
        if (noteRepository.existsById(id)){
            note.setId(id);
            return noteRepository.save(note);
        }
        return null;
    }

    public void DeleteNote(Long id) {
        noteRepository.deleteById(id);
    }
}
