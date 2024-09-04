package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.MedExercicesMedicalDTO;
import com.yewi.yewicore.recuperation.service.MedExercicesMedicalService;
import com.yewi.yewicore.recuperation.vo.MedExercicesMedicalQueryVO;
import com.yewi.yewicore.recuperation.vo.MedExercicesMedicalUpdateVO;
import com.yewi.yewicore.recuperation.vo.MedExercicesMedicalVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/medExercicesMedical")
public class MedExercicesMedicalController {

    @Autowired
    private MedExercicesMedicalService medExercicesMedicalService;

    @PostMapping
    public String save(@Valid @RequestBody MedExercicesMedicalVO vO) {
        return medExercicesMedicalService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        medExercicesMedicalService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody MedExercicesMedicalUpdateVO vO) {
        medExercicesMedicalService.update(id, vO);
    }

    @GetMapping("/{id}")
    public MedExercicesMedicalDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return medExercicesMedicalService.getById(id);
    }

    @GetMapping
    public Page<MedExercicesMedicalDTO> query(@Valid MedExercicesMedicalQueryVO vO) {
        return medExercicesMedicalService.query(vO);
    }
}
