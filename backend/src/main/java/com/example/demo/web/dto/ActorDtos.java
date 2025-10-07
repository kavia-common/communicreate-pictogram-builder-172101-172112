package com.example.demo.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

/**
 * PUBLIC_INTERFACE
 * DTOs for creating and updating actors.
 */
public class ActorDtos {

    public static class CreateActorRequest {
        @NotBlank
        @Size(max = 64)
        public String name;

        @Size(max = 256)
        public String photoUrl;

        @Size(max = 24)
        public String colorHex;

        @NotBlank
        @Size(max = 64)
        public String ownerId;
    }

    public static class UpdateActorRequest {
        @Size(max = 64)
        public String name;

        @Size(max = 256)
        public String photoUrl;

        @Size(max = 24)
        public String colorHex;
    }
}
