package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.MedHospitalisationPrestDTO;
import com.yewi.yewicore.recuperation.service.MedHospitalisationPrestService;
import com.yewi.yewicore.recuperation.vo.MedHospitalisationPrestQueryVO;
import com.yewi.yewicore.recuperation.vo.MedHospitalisationPrestUpdateVO;
import com.yewi.yewicore.recuperation.vo.MedHospitalisationPrestVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/medHospitalisationPrest")
public class MedHospitalisationPrestController {

    @Autowired
    private MedHospitalisationPrestService medHospitalisationPrestService;

    @PostMapping
    public String save(@Valid @RequestBody MedHospitalisationPrestVO vO) {
        return medHospitalisationPrestService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        medHospitalisationPrestService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody MedHospitalisationPrestUpdateVO vO) {
        medHospitalisationPrestService.update(id, vO);
    }

    @GetMapping("/{id}")
    public MedHospitalisationPrestDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return medHospitalisationPrestService.getById(id);
    }

    @GetMapping
    public Page<MedHospitalisationPrestDTO> query(@Valid MedHospitalisationPrestQueryVO vO) {
        return medHospitalisationPrestService.query(vO);
    }
}
