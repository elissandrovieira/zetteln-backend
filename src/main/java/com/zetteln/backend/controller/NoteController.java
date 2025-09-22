package com.zetteln.backend.controller;

import com.zetteln.backend.entity.Note;
import com.zetteln.backend.service.NoteService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public List<Note> GetByUserId(@PathVariable Long userId) {
        return noteService.GetByUserId(userId);
    }
}
