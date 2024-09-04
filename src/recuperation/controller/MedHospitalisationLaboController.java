package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.MedHospitalisationLaboDTO;
import com.yewi.yewicore.recuperation.service.MedHospitalisationLaboService;
import com.yewi.yewicore.recuperation.vo.MedHospitalisationLaboQueryVO;
import com.yewi.yewicore.recuperation.vo.MedHospitalisationLaboUpdateVO;
import com.yewi.yewicore.recuperation.vo.MedHospitalisationLaboVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/medHospitalisationLabo")
public class MedHospitalisationLaboController {

    @Autowired
    private MedHospitalisationLaboService medHospitalisationLaboService;

    @PostMapping
    public String save(@Valid @RequestBody MedHospitalisationLaboVO vO) {
        return medHospitalisationLaboService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        medHospitalisationLaboService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody MedHospitalisationLaboUpdateVO vO) {
        medHospitalisationLaboService.update(id, vO);
    }

    @GetMapping("/{id}")
    public MedHospitalisationLaboDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return medHospitalisationLaboService.getById(id);
    }

    @GetMapping
    public Page<MedHospitalisationLaboDTO> query(@Valid MedHospitalisationLaboQueryVO vO) {
        return medHospitalisationLaboService.query(vO);
    }
}
