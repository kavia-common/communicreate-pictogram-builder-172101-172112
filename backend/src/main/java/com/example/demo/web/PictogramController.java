package com.example.demo.web;

import com.example.demo.domain.Pictogram;
import com.example.demo.repository.PictogramRepository;
import com.example.demo.web.dto.PictogramDtos.CreatePictogramRequest;
import com.example.demo.web.dto.PictogramDtos.UpdatePictogramRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * PUBLIC_INTERFACE
 * PictogramController provides CRUD endpoints for pictograms.
 */
@RestController
@RequestMapping("/api/pictograms")
@Tag(name = "Pictograms")
public class PictogramController {

    private final PictogramRepository repository;

    public PictogramController(PictogramRepository repository) {
        this.repository = repository;
    }

    // PUBLIC_INTERFACE
    @GetMapping
    @Operation(summary = "List pictograms", description = "Returns all pictograms for the specified owner")
    public List<Pictogram> list(@RequestParam String ownerId) {
        return repository.findAllByOwnerId(ownerId);
    }

    // PUBLIC_INTERFACE
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Create pictogram", description = "Creates a new pictogram")
    public Pictogram create(@Valid @RequestBody CreatePictogramRequest req) {
        repository.findByOwnerIdAndTitle(req.ownerId, req.title).ifPresent(p -> {
            throw new DuplicateKeyException("Pictogram with same title already exists for this owner.");
        });
        Pictogram p = new Pictogram(req.title, req.description, req.ownerId, req.assetUrls);
        return repository.save(p);
    }

    // PUBLIC_INTERFACE
    @GetMapping("/{id}")
    @Operation(summary = "Get pictogram", description = "Gets a single pictogram by id")
    public Pictogram get(@PathVariable String id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Pictogram not found"));
    }

    // PUBLIC_INTERFACE
    @PutMapping("/{id}")
    @Operation(summary = "Update pictogram", description = "Updates a pictogram by id")
    public Pictogram update(@PathVariable String id, @Valid @RequestBody UpdatePictogramRequest req) {
        Pictogram existing = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Pictogram not found"));
        if (req.title != null && !req.title.isBlank()) existing.setTitle(req.title);
        if (req.description != null) existing.setDescription(req.description);
        if (req.assetUrls != null) existing.setAssetUrls(req.assetUrls);
        return repository.save(existing);
    }

    // PUBLIC_INTERFACE
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Delete pictogram", description = "Deletes a pictogram by id")
    public void delete(@PathVariable String id) {
        repository.deleteById(id);
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    private static class ResourceNotFoundException extends RuntimeException {
        ResourceNotFoundException(String m) { super(m); }
    }
}
