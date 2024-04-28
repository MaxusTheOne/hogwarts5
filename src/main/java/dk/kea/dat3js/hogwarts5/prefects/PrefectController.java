package dk.kea.dat3js.hogwarts5.prefects;

import dk.kea.dat3js.hogwarts5.students.StudentResponseDTO;
import dk.kea.dat3js.hogwarts5.students.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/prefects")
public class PrefectController {

    private final StudentService studentService;

    public PrefectController(StudentService studentService) {
        this.studentService = studentService;
    }

    // Make student a prefect
    @PostMapping("/{id}")
    public StudentResponseDTO makePrefect(@PathVariable int id) {
        return studentService.makePrefect(id);
    }

    // Return student, if student is a prefect
    @GetMapping("/{id}")
    public StudentResponseDTO getPrefect(@PathVariable int id) {
        return studentService.getPrefect(id);
    }

    // Get all prefects
    @GetMapping
    public List<StudentResponseDTO> getAllPrefects() {
        return studentService.getAllPrefects();
    }

    // Get all prefects from a house
    @GetMapping("/house/{house}")
    public List<StudentResponseDTO> getPrefectsFromHouse(@PathVariable String house) {
        return studentService.getPrefectsFromHouse(house);
    }

    // Why is this not a patch method?
    // Remove student as prefect
    @DeleteMapping("/{id}")
    public StudentResponseDTO removePrefect(@PathVariable int id) {
        return studentService.removePrefect(id);
    }
}
