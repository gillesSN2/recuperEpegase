package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.MedConventionMedicalDTO;
import com.yewi.yewicore.recuperation.service.MedConventionMedicalService;
import com.yewi.yewicore.recuperation.vo.MedConventionMedicalQueryVO;
import com.yewi.yewicore.recuperation.vo.MedConventionMedicalUpdateVO;
import com.yewi.yewicore.recuperation.vo.MedConventionMedicalVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/medConventionMedical")
public class MedConventionMedicalController {

    @Autowired
    private MedConventionMedicalService medConventionMedicalService;

    @PostMapping
    public String save(@Valid @RequestBody MedConventionMedicalVO vO) {
        return medConventionMedicalService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        medConventionMedicalService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody MedConventionMedicalUpdateVO vO) {
        medConventionMedicalService.update(id, vO);
    }

    @GetMapping("/{id}")
    public MedConventionMedicalDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return medConventionMedicalService.getById(id);
    }

    @GetMapping
    public Page<MedConventionMedicalDTO> query(@Valid MedConventionMedicalQueryVO vO) {
        return medConventionMedicalService.query(vO);
    }
}
