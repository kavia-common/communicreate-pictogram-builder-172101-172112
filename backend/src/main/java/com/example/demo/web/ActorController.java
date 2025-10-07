package com.example.demo.web;

import com.example.demo.domain.Actor;
import com.example.demo.repository.ActorRepository;
import com.example.demo.web.dto.ActorDtos.CreateActorRequest;
import com.example.demo.web.dto.ActorDtos.UpdateActorRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * PUBLIC_INTERFACE
 * ActorController provides CRUD endpoints for actors.
 */
@RestController
@RequestMapping("/api/actors")
@Tag(name = "Actors")
public class ActorController {

    private final ActorRepository repository;

    public ActorController(ActorRepository repository) {
        this.repository = repository;
    }

    // PUBLIC_INTERFACE
    @GetMapping
    @Operation(summary = "List actors", description = "Returns all actors for the specified owner")
    public List<Actor> list(@RequestParam String ownerId) {
        return repository.findAllByOwnerId(ownerId);
    }

    // PUBLIC_INTERFACE
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Create actor", description = "Creates a new actor")
    public Actor create(@Valid @RequestBody CreateActorRequest req) {
        // Enforce uniqueness by owner+name at application level too
        repository.findByOwnerIdAndName(req.ownerId, req.name).ifPresent(a -> {
            throw new DuplicateKeyException("Actor with same name already exists for this owner.");
        });
        Actor actor = new Actor(req.name, req.photoUrl, req.colorHex, req.ownerId);
        return repository.save(actor);
    }

    // PUBLIC_INTERFACE
    @GetMapping("/{id}")
    @Operation(summary = "Get actor", description = "Gets a single actor by id")
    public Actor get(@PathVariable String id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Actor not found"));
    }

    // PUBLIC_INTERFACE
    @PutMapping("/{id}")
    @Operation(summary = "Update actor", description = "Updates an actor by id")
    public Actor update(@PathVariable String id, @Valid @RequestBody UpdateActorRequest req) {
        Actor existing = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Actor not found"));
        if (req.name != null && !req.name.isBlank()) existing.setName(req.name);
        if (req.photoUrl != null) existing.setPhotoUrl(req.photoUrl);
        if (req.colorHex != null) existing.setColorHex(req.colorHex);
        return repository.save(existing);
    }

    // PUBLIC_INTERFACE
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Delete actor", description = "Deletes an actor by id")
    public void delete(@PathVariable String id) {
        repository.deleteById(id);
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    private static class ResourceNotFoundException extends RuntimeException {
        ResourceNotFoundException(String m) { super(m); }
    }
}
