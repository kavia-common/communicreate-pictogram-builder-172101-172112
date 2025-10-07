package com.example.demo.domain;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

/**
 * PUBLIC_INTERFACE
 * Actor represents a person commonly referenced in pictograms (e.g., child, parent, teacher).
 */
@Document(collection = "actors")
@CompoundIndex(name = "owner_name_idx", def = "{'ownerId': 1, 'name': 1}", unique = true)
public class Actor {

    @Id
    private String id;

    @NotBlank
    @Size(max = 64)
    @Indexed
    private String name;

    @Size(max = 256)
    private String photoUrl;

    @Size(max = 24)
    private String colorHex;

    @NotBlank
    @Size(max = 64)
    @Indexed
    private String ownerId;

    @CreatedDate
    private Instant createdAt;

    @LastModifiedDate
    private Instant updatedAt;

    public Actor() {}

    public Actor(String name, String photoUrl, String colorHex, String ownerId) {
        this.name = name;
        this.photoUrl = photoUrl;
        this.colorHex = colorHex;
        this.ownerId = ownerId;
    }

    // Getters and setters
    public String getId() { return id; }
    public String getName() { return name; }
    public String getPhotoUrl() { return photoUrl; }
    public String getColorHex() { return colorHex; }
    public String getOwnerId() { return ownerId; }
    public Instant getCreatedAt() { return createdAt; }
    public Instant getUpdatedAt() { return updatedAt; }

    public void setId(String id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setPhotoUrl(String photoUrl) { this.photoUrl = photoUrl; }
    public void setColorHex(String colorHex) { this.colorHex = colorHex; }
    public void setOwnerId(String ownerId) { this.ownerId = ownerId; }
    public void setCreatedAt(Instant createdAt) { this.createdAt = createdAt; }
    public void setUpdatedAt(Instant updatedAt) { this.updatedAt = updatedAt; }
}
