package com.example.demo.repository;

import com.example.demo.domain.Actor;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

/**
 * PUBLIC_INTERFACE
 * ActorRepository provides CRUD access to actor documents.
 */
public interface ActorRepository extends MongoRepository<Actor, String> {
    Optional<Actor> findByOwnerIdAndName(String ownerId, String name);
    List<Actor> findAllByOwnerId(String ownerId);
}
