package com.zetteln.backend.controller;

import com.zetteln.backend.entity.Note;
import com.zetteln.backend.service.NoteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/notes")
public class NoteController {

    private NoteService noteService;

    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @GetMapping
    public List<Note> GetAll() {
        return noteService.GetAll();
    }

    @GetMapping("/{userId}")
    public List<Note> GetByUserId(@PathVariable Long userId, @RequestParam Long vaultId) {
        if (vaultId != null)
            return noteService.GetByUserAndVaultId(userId, vaultId);
        return noteService.GetByUserId(userId);
    }

    @PostMapping
    public Note CreateNote(@RequestBody Note note) {
        return noteService.CreateNote(note);
    }

    @PutMapping("/{id}")
    public Note UpdateNote(@PathVariable Long id, @RequestBody Note note) {
        return noteService.UpdateNote(id, note);
    }

    @DeleteMapping("/{id}")
    public String DeleteNote(@PathVariable Long id) {
        noteService.DeleteNote(id);
        return "Note deleted.";
    }
}
