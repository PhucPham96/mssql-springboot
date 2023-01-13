package com.example.springbootmssql.service;

import com.example.springbootmssql.dto.request.CreateTutorialRequestDTO;
import com.example.springbootmssql.dto.response.CreateTutorialResponseDTO;
import com.example.springbootmssql.model.Tutorial;
import com.example.springbootmssql.repository.TutorialRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TutorialService {

    private final TutorialRepository tutorialRepository;

    public ResponseEntity<CreateTutorialResponseDTO> createTutorial(CreateTutorialRequestDTO requestDTO) {
        Tutorial tutorial = new Tutorial();
        tutorial.setDescription(requestDTO.getDescription());
        tutorial.setPublished(Boolean.valueOf(requestDTO.getPublished()));
        tutorial.setTitle(requestDTO.getTitle());
        tutorial = tutorialRepository.save(tutorial);
        CreateTutorialResponseDTO createTutorialResponseDTO = CreateTutorialResponseDTO.builder()
                .id(tutorial.getId().toString())
                .title(tutorial.getTitle())
                .description(tutorial.getDescription())
                .published(tutorial.getPublished().toString())
                .build();
        return ResponseEntity.ok(createTutorialResponseDTO);
    }
}
