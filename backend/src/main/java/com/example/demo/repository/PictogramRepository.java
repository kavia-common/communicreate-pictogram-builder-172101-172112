package com.example.demo.repository;

import com.example.demo.domain.Pictogram;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

/**
 * PUBLIC_INTERFACE
 * PictogramRepository provides CRUD access to pictogram documents.
 */
public interface PictogramRepository extends MongoRepository<Pictogram, String> {
    Optional<Pictogram> findByOwnerIdAndTitle(String ownerId, String title);
    List<Pictogram> findAllByOwnerId(String ownerId);
}
