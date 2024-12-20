package ru.homework.note.service;

import ru.homework.note.model.Note;

import java.util.List;

public interface NoteService {
    List<Note> getAllNotes();
    Note getNoteById(Long id);
    Note updateNote(Long id, Note noteDetails);
    Note createNote(Note note);
    void deleteNote(Long id);
}
