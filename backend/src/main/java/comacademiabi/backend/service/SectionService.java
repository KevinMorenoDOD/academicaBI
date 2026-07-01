package comacademiabi.backend.service;

import comacademiabi.backend.model.Section;
import comacademiabi.backend.repository.SectionRepository;
import org.springframework.stereotype.Service;

@Service
public class SectionService {

    private final SectionRepository sectionRepository;

    public SectionService(SectionRepository sectionRepository) {
        this.sectionRepository = sectionRepository;
    }

    public Section createSection(Section section) {
        Section saved = sectionRepository.save(section);
        return saved;
    }

    public Section getSectionById(int id) {
        Section section = sectionRepository.findById(id).orElseThrow(() -> new RuntimeException("section not found by id: " + id));
        return section;
    }

    public Section updateSection(Section section) {
        Section sectionUpdated = sectionRepository.findById(section.getId()).orElseThrow(() -> new RuntimeException("section not found by id: " + section.getId()));

        sectionUpdated.setCourse(section.getCourse());
        sectionUpdated.setPeriod(section.getPeriod());
        sectionUpdated.setProfessor(section.getProfessor());
        sectionUpdated.setGroupCode(section.getGroupCode());
        sectionUpdated.setMaxCapacity(section.getMaxCapacity());
        Section saved = sectionRepository.save(sectionUpdated);

        return saved;
    }
}
