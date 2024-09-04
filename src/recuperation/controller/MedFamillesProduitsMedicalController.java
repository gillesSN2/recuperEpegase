package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.MedFamillesProduitsMedicalDTO;
import com.yewi.yewicore.recuperation.service.MedFamillesProduitsMedicalService;
import com.yewi.yewicore.recuperation.vo.MedFamillesProduitsMedicalQueryVO;
import com.yewi.yewicore.recuperation.vo.MedFamillesProduitsMedicalUpdateVO;
import com.yewi.yewicore.recuperation.vo.MedFamillesProduitsMedicalVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/medFamillesProduitsMedical")
public class MedFamillesProduitsMedicalController {

    @Autowired
    private MedFamillesProduitsMedicalService medFamillesProduitsMedicalService;

    @PostMapping
    public String save(@Valid @RequestBody MedFamillesProduitsMedicalVO vO) {
        return medFamillesProduitsMedicalService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        medFamillesProduitsMedicalService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody MedFamillesProduitsMedicalUpdateVO vO) {
        medFamillesProduitsMedicalService.update(id, vO);
    }

    @GetMapping("/{id}")
    public MedFamillesProduitsMedicalDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return medFamillesProduitsMedicalService.getById(id);
    }

    @GetMapping
    public Page<MedFamillesProduitsMedicalDTO> query(@Valid MedFamillesProduitsMedicalQueryVO vO) {
        return medFamillesProduitsMedicalService.query(vO);
    }
}
