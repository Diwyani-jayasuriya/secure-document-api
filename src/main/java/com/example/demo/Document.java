package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "documents")
public class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    private String description;

    private String fileType;

    // Document එක අයිති User ව සම්බන්ධ කරන Relationship එක
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User owner;
}