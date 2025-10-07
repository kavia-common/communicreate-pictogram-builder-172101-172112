package com.example.demo.domain;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

/**
 * PUBLIC_INTERFACE
 * Asset represents a media resource (image, icon) used in pictograms.
 */
@Document(collection = "assets")
@CompoundIndex(name = "owner_name_idx", def = "{'ownerId': 1, 'name': 1}", unique = true)
public class Asset {

    @Id
    private String id;

    @NotBlank
    @Size(max = 64)
    private String name;

    @NotBlank
    @Size(max = 512)
    private String url;

    @Size(max = 64)
    private String type;

    private long sizeBytes;

    @NotBlank
    @Size(max = 64)
    private String ownerId;

    @CreatedDate
    private Instant createdAt;

    @LastModifiedDate
    private Instant updatedAt;

    public Asset() {}

    public Asset(String name, String url, String type, long sizeBytes, String ownerId) {
        this.name = name;
        this.url = url;
        this.type = type;
        this.sizeBytes = sizeBytes;
        this.ownerId = ownerId;
    }

    // Getters and setters
    public String getId() { return id; }
    public String getName() { return name; }
    public String getUrl() { return url; }
    public String getType() { return type; }
    public long getSizeBytes() { return sizeBytes; }
    public String getOwnerId() { return ownerId; }
    public Instant getCreatedAt() { return createdAt; }
    public Instant getUpdatedAt() { return updatedAt; }

    public void setId(String id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setUrl(String url) { this.url = url; }
    public void setType(String type) { this.type = type; }
    public void setSizeBytes(long sizeBytes) { this.sizeBytes = sizeBytes; }
    public void setOwnerId(String ownerId) { this.ownerId = ownerId; }
    public void setCreatedAt(Instant createdAt) { this.createdAt = createdAt; }
    public void setUpdatedAt(Instant updatedAt) { this.updatedAt = updatedAt; }
}
