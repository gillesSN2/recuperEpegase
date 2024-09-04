package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.MedHospitalisationMediDTO;
import com.yewi.yewicore.recuperation.service.MedHospitalisationMediService;
import com.yewi.yewicore.recuperation.vo.MedHospitalisationMediQueryVO;
import com.yewi.yewicore.recuperation.vo.MedHospitalisationMediUpdateVO;
import com.yewi.yewicore.recuperation.vo.MedHospitalisationMediVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/medHospitalisationMedi")
public class MedHospitalisationMediController {

    @Autowired
    private MedHospitalisationMediService medHospitalisationMediService;

    @PostMapping
    public String save(@Valid @RequestBody MedHospitalisationMediVO vO) {
        return medHospitalisationMediService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        medHospitalisationMediService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody MedHospitalisationMediUpdateVO vO) {
        medHospitalisationMediService.update(id, vO);
    }

    @GetMapping("/{id}")
    public MedHospitalisationMediDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return medHospitalisationMediService.getById(id);
    }

    @GetMapping
    public Page<MedHospitalisationMediDTO> query(@Valid MedHospitalisationMediQueryVO vO) {
        return medHospitalisationMediService.query(vO);
    }
}
