package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.MedHospitalisationEnteteDTO;
import com.yewi.yewicore.recuperation.service.MedHospitalisationEnteteService;
import com.yewi.yewicore.recuperation.vo.MedHospitalisationEnteteQueryVO;
import com.yewi.yewicore.recuperation.vo.MedHospitalisationEnteteUpdateVO;
import com.yewi.yewicore.recuperation.vo.MedHospitalisationEnteteVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/medHospitalisationEntete")
public class MedHospitalisationEnteteController {

    @Autowired
    private MedHospitalisationEnteteService medHospitalisationEnteteService;

    @PostMapping
    public String save(@Valid @RequestBody MedHospitalisationEnteteVO vO) {
        return medHospitalisationEnteteService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        medHospitalisationEnteteService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody MedHospitalisationEnteteUpdateVO vO) {
        medHospitalisationEnteteService.update(id, vO);
    }

    @GetMapping("/{id}")
    public MedHospitalisationEnteteDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return medHospitalisationEnteteService.getById(id);
    }

    @GetMapping
    public Page<MedHospitalisationEnteteDTO> query(@Valid MedHospitalisationEnteteQueryVO vO) {
        return medHospitalisationEnteteService.query(vO);
    }
}
