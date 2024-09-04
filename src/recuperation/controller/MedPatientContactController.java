package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.MedPatientContactDTO;
import com.yewi.yewicore.recuperation.service.MedPatientContactService;
import com.yewi.yewicore.recuperation.vo.MedPatientContactQueryVO;
import com.yewi.yewicore.recuperation.vo.MedPatientContactUpdateVO;
import com.yewi.yewicore.recuperation.vo.MedPatientContactVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/medPatientContact")
public class MedPatientContactController {

    @Autowired
    private MedPatientContactService medPatientContactService;

    @PostMapping
    public String save(@Valid @RequestBody MedPatientContactVO vO) {
        return medPatientContactService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        medPatientContactService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody MedPatientContactUpdateVO vO) {
        medPatientContactService.update(id, vO);
    }

    @GetMapping("/{id}")
    public MedPatientContactDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return medPatientContactService.getById(id);
    }

    @GetMapping
    public Page<MedPatientContactDTO> query(@Valid MedPatientContactQueryVO vO) {
        return medPatientContactService.query(vO);
    }
}
