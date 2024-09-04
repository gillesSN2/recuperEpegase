package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.MedPatientAntDTO;
import com.yewi.yewicore.recuperation.service.MedPatientAntService;
import com.yewi.yewicore.recuperation.vo.MedPatientAntQueryVO;
import com.yewi.yewicore.recuperation.vo.MedPatientAntUpdateVO;
import com.yewi.yewicore.recuperation.vo.MedPatientAntVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/medPatientAnt")
public class MedPatientAntController {

    @Autowired
    private MedPatientAntService medPatientAntService;

    @PostMapping
    public String save(@Valid @RequestBody MedPatientAntVO vO) {
        return medPatientAntService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        medPatientAntService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody MedPatientAntUpdateVO vO) {
        medPatientAntService.update(id, vO);
    }

    @GetMapping("/{id}")
    public MedPatientAntDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return medPatientAntService.getById(id);
    }

    @GetMapping
    public Page<MedPatientAntDTO> query(@Valid MedPatientAntQueryVO vO) {
        return medPatientAntService.query(vO);
    }
}
