package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.MedPatientProtDTO;
import com.yewi.yewicore.recuperation.service.MedPatientProtService;
import com.yewi.yewicore.recuperation.vo.MedPatientProtQueryVO;
import com.yewi.yewicore.recuperation.vo.MedPatientProtUpdateVO;
import com.yewi.yewicore.recuperation.vo.MedPatientProtVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/medPatientProt")
public class MedPatientProtController {

    @Autowired
    private MedPatientProtService medPatientProtService;

    @PostMapping
    public String save(@Valid @RequestBody MedPatientProtVO vO) {
        return medPatientProtService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        medPatientProtService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody MedPatientProtUpdateVO vO) {
        medPatientProtService.update(id, vO);
    }

    @GetMapping("/{id}")
    public MedPatientProtDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return medPatientProtService.getById(id);
    }

    @GetMapping
    public Page<MedPatientProtDTO> query(@Valid MedPatientProtQueryVO vO) {
        return medPatientProtService.query(vO);
    }
}
