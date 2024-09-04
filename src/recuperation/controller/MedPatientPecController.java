package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.MedPatientPecDTO;
import com.yewi.yewicore.recuperation.service.MedPatientPecService;
import com.yewi.yewicore.recuperation.vo.MedPatientPecQueryVO;
import com.yewi.yewicore.recuperation.vo.MedPatientPecUpdateVO;
import com.yewi.yewicore.recuperation.vo.MedPatientPecVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/medPatientPec")
public class MedPatientPecController {

    @Autowired
    private MedPatientPecService medPatientPecService;

    @PostMapping
    public String save(@Valid @RequestBody MedPatientPecVO vO) {
        return medPatientPecService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        medPatientPecService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody MedPatientPecUpdateVO vO) {
        medPatientPecService.update(id, vO);
    }

    @GetMapping("/{id}")
    public MedPatientPecDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return medPatientPecService.getById(id);
    }

    @GetMapping
    public Page<MedPatientPecDTO> query(@Valid MedPatientPecQueryVO vO) {
        return medPatientPecService.query(vO);
    }
}
