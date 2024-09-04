package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.MedHospitalisationActesDTO;
import com.yewi.yewicore.recuperation.service.MedHospitalisationActesService;
import com.yewi.yewicore.recuperation.vo.MedHospitalisationActesQueryVO;
import com.yewi.yewicore.recuperation.vo.MedHospitalisationActesUpdateVO;
import com.yewi.yewicore.recuperation.vo.MedHospitalisationActesVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/medHospitalisationActes")
public class MedHospitalisationActesController {

    @Autowired
    private MedHospitalisationActesService medHospitalisationActesService;

    @PostMapping
    public String save(@Valid @RequestBody MedHospitalisationActesVO vO) {
        return medHospitalisationActesService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        medHospitalisationActesService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody MedHospitalisationActesUpdateVO vO) {
        medHospitalisationActesService.update(id, vO);
    }

    @GetMapping("/{id}")
    public MedHospitalisationActesDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return medHospitalisationActesService.getById(id);
    }

    @GetMapping
    public Page<MedHospitalisationActesDTO> query(@Valid MedHospitalisationActesQueryVO vO) {
        return medHospitalisationActesService.query(vO);
    }
}
