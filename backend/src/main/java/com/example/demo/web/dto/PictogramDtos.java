package com.example.demo.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.List;

/**
 * PUBLIC_INTERFACE
 * DTOs for creating and updating pictograms.
 */
public class PictogramDtos {

    public static class CreatePictogramRequest {
        @NotBlank
        @Size(max = 120)
        public String title;

        @Size(max = 512)
        public String description;

        @NotBlank
        @Size(max = 64)
        public String ownerId;

        public List<@Size(max = 512) String> assetUrls;
    }

    public static class UpdatePictogramRequest {
        @Size(max = 120)
        public String title;

        @Size(max = 512)
        public String description;

        public List<@Size(max = 512) String> assetUrls;
    }
}
