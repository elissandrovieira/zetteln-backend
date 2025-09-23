package com.zetteln.backend.dto;

import com.zetteln.backend.entity.Note;
import com.zetteln.backend.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class VaultDTO {

    private Long id;
    private User user;
    private String name;
    private LocalDateTime createdAt;
    private List<Note> notes;
}
