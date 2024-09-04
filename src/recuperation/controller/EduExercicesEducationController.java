package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.EduExercicesEducationDTO;
import com.yewi.yewicore.recuperation.service.EduExercicesEducationService;
import com.yewi.yewicore.recuperation.vo.EduExercicesEducationQueryVO;
import com.yewi.yewicore.recuperation.vo.EduExercicesEducationUpdateVO;
import com.yewi.yewicore.recuperation.vo.EduExercicesEducationVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/eduExercicesEducation")
public class EduExercicesEducationController {

    @Autowired
    private EduExercicesEducationService eduExercicesEducationService;

    @PostMapping
    public String save(@Valid @RequestBody EduExercicesEducationVO vO) {
        return eduExercicesEducationService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        eduExercicesEducationService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody EduExercicesEducationUpdateVO vO) {
        eduExercicesEducationService.update(id, vO);
    }

    @GetMapping("/{id}")
    public EduExercicesEducationDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return eduExercicesEducationService.getById(id);
    }

    @GetMapping
    public Page<EduExercicesEducationDTO> query(@Valid EduExercicesEducationQueryVO vO) {
        return eduExercicesEducationService.query(vO);
    }
}
