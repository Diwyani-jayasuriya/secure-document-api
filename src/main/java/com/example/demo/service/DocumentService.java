package com.example.demo.service;

import com.example.demo.entity.Document;
import com.example.demo.entity.User;
import com.example.demo.repository.DocumentRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DocumentService {

    private final DocumentRepository documentRepository;
    private final UserRepository userRepository;

    public DocumentService(DocumentRepository documentRepository, UserRepository userRepository) {
        this.documentRepository = documentRepository;
        this.userRepository = userRepository;
    }

    public Document createDocument(Document document, Long userId) {
        Optional<User> user = userRepository.findById(userId);
        if (user.isPresent()) {
            document.setOwner(user.get());
            return documentRepository.save(document);
        }
        throw new RuntimeException("User not found!");
    }

    public List<Document> getAllDocuments() {
        return documentRepository.findAll();
    }

    public List<Document> getDocumentsByUser(Long userId) {
        return documentRepository.findByOwnerId(userId);
    }

    public void deleteDocument(Long id) {
        documentRepository.deleteById(id);
    }
}