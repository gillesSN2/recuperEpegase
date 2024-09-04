package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.MedTaxesMedicalDTO;
import com.yewi.yewicore.recuperation.service.MedTaxesMedicalService;
import com.yewi.yewicore.recuperation.vo.MedTaxesMedicalQueryVO;
import com.yewi.yewicore.recuperation.vo.MedTaxesMedicalUpdateVO;
import com.yewi.yewicore.recuperation.vo.MedTaxesMedicalVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/medTaxesMedical")
public class MedTaxesMedicalController {

    @Autowired
    private MedTaxesMedicalService medTaxesMedicalService;

    @PostMapping
    public String save(@Valid @RequestBody MedTaxesMedicalVO vO) {
        return medTaxesMedicalService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        medTaxesMedicalService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody MedTaxesMedicalUpdateVO vO) {
        medTaxesMedicalService.update(id, vO);
    }

    @GetMapping("/{id}")
    public MedTaxesMedicalDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return medTaxesMedicalService.getById(id);
    }

    @GetMapping
    public Page<MedTaxesMedicalDTO> query(@Valid MedTaxesMedicalQueryVO vO) {
        return medTaxesMedicalService.query(vO);
    }
}
