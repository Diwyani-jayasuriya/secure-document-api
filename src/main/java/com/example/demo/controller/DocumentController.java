package com.example.demo.controller;

import com.example.demo.entity.Document;
import com.example.demo.service.DocumentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/documents")
public class DocumentController {

    private final DocumentService documentService;

    public DocumentController(DocumentService documentService) {
        this.documentService = documentService;
    }

    @PostMapping("/user/{userId}")
    public Document createDocument(@RequestBody Document document, @PathVariable Long userId) {
        return documentService.createDocument(document, userId);
    }

    @GetMapping
    public List<Document> getAllDocuments() {
        return documentService.getAllDocuments();
    }

    @GetMapping("/user/{userId}")
    public List<Document> getDocumentsByUser(@PathVariable Long userId) {
        return documentService.getDocumentsByUser(userId);
    }

    @DeleteMapping("/{id}")
    public String deleteDocument(@PathVariable Long id) {
        documentService.deleteDocument(id);
        return "Document deleted successfully!";
    }
}