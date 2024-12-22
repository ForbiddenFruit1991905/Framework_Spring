package ru.example.hw.service.impl;

import org.springframework.stereotype.Service;

import ru.example.hw.aspects.TrackUserAction;
import ru.example.hw.model.Note;
import ru.example.hw.repository.NoteRepository;
import ru.example.hw.service.NoteService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class NoteServiceImpl implements NoteService {

    private final NoteRepository noteRepository;

    public NoteServiceImpl(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    @Override
    @TrackUserAction
    public List<Note> getAllNotes() {
        return noteRepository.findAll();
    }

    @Override
    @TrackUserAction
    public Note getNoteById(Long id) {
        return noteRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Запись не найдена"));
    }

    @Override
    @TrackUserAction
    public Note updateNote(Long id, Note noteDetails) {
        Optional<Note> optionalNote = noteRepository.findById(id);
        if (optionalNote.isPresent()){
            Note note = optionalNote.get();
            note.setHeader(noteDetails.getHeader());
            note.setText(noteDetails.getText());
            return noteRepository.save(note);
        } else {
            throw  new IllegalArgumentException("Note is not found");
        }
    }

    @Override
    @TrackUserAction
    public Note createNote(Note note) {
        note.setCreatedDate(LocalDateTime.now());
        return noteRepository.save(note);
    }

    @Override
    @TrackUserAction
    public void deleteNote(Long id) {
        noteRepository.deleteById(id);
    }
}
