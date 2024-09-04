package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.MedPharmacieEnteteDTO;
import com.yewi.yewicore.recuperation.service.MedPharmacieEnteteService;
import com.yewi.yewicore.recuperation.vo.MedPharmacieEnteteQueryVO;
import com.yewi.yewicore.recuperation.vo.MedPharmacieEnteteUpdateVO;
import com.yewi.yewicore.recuperation.vo.MedPharmacieEnteteVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/medPharmacieEntete")
public class MedPharmacieEnteteController {

    @Autowired
    private MedPharmacieEnteteService medPharmacieEnteteService;

    @PostMapping
    public String save(@Valid @RequestBody MedPharmacieEnteteVO vO) {
        return medPharmacieEnteteService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        medPharmacieEnteteService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody MedPharmacieEnteteUpdateVO vO) {
        medPharmacieEnteteService.update(id, vO);
    }

    @GetMapping("/{id}")
    public MedPharmacieEnteteDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return medPharmacieEnteteService.getById(id);
    }

    @GetMapping
    public Page<MedPharmacieEnteteDTO> query(@Valid MedPharmacieEnteteQueryVO vO) {
        return medPharmacieEnteteService.query(vO);
    }
}
