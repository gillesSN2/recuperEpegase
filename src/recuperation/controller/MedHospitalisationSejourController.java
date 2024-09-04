package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.MedHospitalisationSejourDTO;
import com.yewi.yewicore.recuperation.service.MedHospitalisationSejourService;
import com.yewi.yewicore.recuperation.vo.MedHospitalisationSejourQueryVO;
import com.yewi.yewicore.recuperation.vo.MedHospitalisationSejourUpdateVO;
import com.yewi.yewicore.recuperation.vo.MedHospitalisationSejourVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/medHospitalisationSejour")
public class MedHospitalisationSejourController {

    @Autowired
    private MedHospitalisationSejourService medHospitalisationSejourService;

    @PostMapping
    public String save(@Valid @RequestBody MedHospitalisationSejourVO vO) {
        return medHospitalisationSejourService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        medHospitalisationSejourService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody MedHospitalisationSejourUpdateVO vO) {
        medHospitalisationSejourService.update(id, vO);
    }

    @GetMapping("/{id}")
    public MedHospitalisationSejourDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return medHospitalisationSejourService.getById(id);
    }

    @GetMapping
    public Page<MedHospitalisationSejourDTO> query(@Valid MedHospitalisationSejourQueryVO vO) {
        return medHospitalisationSejourService.query(vO);
    }
}
