package com.example.demo.domain;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;
import java.util.List;
import java.util.Map;

/**
 * PUBLIC_INTERFACE
 * Template represents a reusable pictogram template with customizable fields.
 */
@Document(collection = "templates")
@CompoundIndex(name = "owner_name_idx", def = "{'ownerId': 1, 'name': 1}", unique = true)
public class Template {

    @Id
    private String id;

    @NotBlank
    @Size(max = 64)
    private String name;

    @Size(max = 512)
    private String description;

    private List<String> assetUrls;

    private Map<String, String> defaultAttributes;

    @NotBlank
    @Size(max = 64)
    private String ownerId;

    @CreatedDate
    private Instant createdAt;

    @LastModifiedDate
    private Instant updatedAt;

    public Template() {}

    // Constructor with fields
    public Template(String name, String description, List<String> assetUrls, 
                   Map<String, String> defaultAttributes, String ownerId) {
        this.name = name;
        this.description = description;
        this.assetUrls = assetUrls;
        this.defaultAttributes = defaultAttributes;
        this.ownerId = ownerId;
    }

    // Getters and setters
    public String getId() { return id; }
    public String getName() { return name; }
    public String getDescription() { return description; }
    public List<String> getAssetUrls() { return assetUrls; }
    public Map<String, String> getDefaultAttributes() { return defaultAttributes; }
    public String getOwnerId() { return ownerId; }
    public Instant getCreatedAt() { return createdAt; }
    public Instant getUpdatedAt() { return updatedAt; }

    public void setId(String id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setDescription(String description) { this.description = description; }
    public void setAssetUrls(List<String> assetUrls) { this.assetUrls = assetUrls; }
    public void setDefaultAttributes(Map<String, String> defaultAttributes) { this.defaultAttributes = defaultAttributes; }
    public void setOwnerId(String ownerId) { this.ownerId = ownerId; }
    public void setCreatedAt(Instant createdAt) { this.createdAt = createdAt; }
    public void setUpdatedAt(Instant updatedAt) { this.updatedAt = updatedAt; }
}
