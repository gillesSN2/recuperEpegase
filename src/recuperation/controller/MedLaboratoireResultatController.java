package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.MedLaboratoireResultatDTO;
import com.yewi.yewicore.recuperation.service.MedLaboratoireResultatService;
import com.yewi.yewicore.recuperation.vo.MedLaboratoireResultatQueryVO;
import com.yewi.yewicore.recuperation.vo.MedLaboratoireResultatUpdateVO;
import com.yewi.yewicore.recuperation.vo.MedLaboratoireResultatVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/medLaboratoireResultat")
public class MedLaboratoireResultatController {

    @Autowired
    private MedLaboratoireResultatService medLaboratoireResultatService;

    @PostMapping
    public String save(@Valid @RequestBody MedLaboratoireResultatVO vO) {
        return medLaboratoireResultatService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        medLaboratoireResultatService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody MedLaboratoireResultatUpdateVO vO) {
        medLaboratoireResultatService.update(id, vO);
    }

    @GetMapping("/{id}")
    public MedLaboratoireResultatDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return medLaboratoireResultatService.getById(id);
    }

    @GetMapping
    public Page<MedLaboratoireResultatDTO> query(@Valid MedLaboratoireResultatQueryVO vO) {
        return medLaboratoireResultatService.query(vO);
    }
}
