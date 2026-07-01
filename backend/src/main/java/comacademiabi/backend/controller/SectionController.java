package comacademiabi.backend.controller;

import comacademiabi.backend.model.Section;
import comacademiabi.backend.service.SectionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sections")
public class SectionController {

    private final SectionService sectionService;

    public SectionController(SectionService sectionService) {
        this.sectionService = sectionService;
    }

    @GetMapping
    public ResponseEntity<List<Section>> getAllSections() {
        return ResponseEntity.ok(sectionService.getAllSections());
    }

    @GetMapping("/id/{sectionId}")
    public ResponseEntity<Section> getSectionById(@PathVariable int sectionId) {
        return ResponseEntity.ok(sectionService.getSectionById(sectionId));
    }

    @PostMapping
    public ResponseEntity<Section> createSection(@RequestBody Section section) {
        Section created = sectionService.createSection(section);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping
    public ResponseEntity<Section> updateSection(@RequestBody Section section) {
        return ResponseEntity.ok(sectionService.updateSection(section));
    }
}
