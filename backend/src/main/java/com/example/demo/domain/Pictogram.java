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
import java.util.List;

/**
 * PUBLIC_INTERFACE
 * Pictogram represents a visual item or a story made of multiple visual blocks.
 */
@Document(collection = "pictograms")
@CompoundIndex(name = "owner_title_idx", def = "{'ownerId': 1, 'title': 1}", unique = true)
public class Pictogram {

    @Id
    private String id;

    @NotBlank
    @Size(max = 120)
    @Indexed
    private String title;

    @Size(max = 512)
    private String description;

    @NotBlank
    @Size(max = 64)
    @Indexed
    private String ownerId;

    private List<String> assetUrls;

    @CreatedDate
    private Instant createdAt;

    @LastModifiedDate
    private Instant updatedAt;

    public Pictogram() {}

    public Pictogram(String title, String description, String ownerId, List<String> assetUrls) {
        this.title = title;
        this.description = description;
        this.ownerId = ownerId;
        this.assetUrls = assetUrls;
    }

    // Getters and setters
    public String getId() { return id; }
    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public String getOwnerId() { return ownerId; }
    public List<String> getAssetUrls() { return assetUrls; }
    public Instant getCreatedAt() { return createdAt; }
    public Instant getUpdatedAt() { return updatedAt; }

    public void setId(String id) { this.id = id; }
    public void setTitle(String title) { this.title = title; }
    public void setDescription(String description) { this.description = description; }
    public void setOwnerId(String ownerId) { this.ownerId = ownerId; }
    public void setAssetUrls(List<String> assetUrls) { this.assetUrls = assetUrls; }
    public void setCreatedAt(Instant createdAt) { this.createdAt = createdAt; }
    public void setUpdatedAt(Instant updatedAt) { this.updatedAt = updatedAt; }
}
