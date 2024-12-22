package ru.example.hw.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "notes")
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = " header", nullable = false)
    private String header;
    @Column(name = "text", nullable = false)
    private String text;
    @Column(name = "created_date", nullable = false, columnDefinition = "TIMESTAMP")
    private LocalDateTime createdDate;

    public Note() {
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Note{" +
                "id=" + id +
                ", header='" + header + '\'' +
                ", text='" + text + '\'' +
                ", createdDate=" + createdDate +
                '}';
    }
}
