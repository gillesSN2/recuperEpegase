package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.CmmProduitsPharmacieDTO;
import com.yewi.yewicore.recuperation.service.CmmProduitsPharmacieService;
import com.yewi.yewicore.recuperation.vo.CmmProduitsPharmacieQueryVO;
import com.yewi.yewicore.recuperation.vo.CmmProduitsPharmacieUpdateVO;
import com.yewi.yewicore.recuperation.vo.CmmProduitsPharmacieVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/cmmProduitsPharmacie")
public class CmmProduitsPharmacieController {

    @Autowired
    private CmmProduitsPharmacieService cmmProduitsPharmacieService;

    @PostMapping
    public String save(@Valid @RequestBody CmmProduitsPharmacieVO vO) {
        return cmmProduitsPharmacieService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        cmmProduitsPharmacieService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody CmmProduitsPharmacieUpdateVO vO) {
        cmmProduitsPharmacieService.update(id, vO);
    }

    @GetMapping("/{id}")
    public CmmProduitsPharmacieDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return cmmProduitsPharmacieService.getById(id);
    }

    @GetMapping
    public Page<CmmProduitsPharmacieDTO> query(@Valid CmmProduitsPharmacieQueryVO vO) {
        return cmmProduitsPharmacieService.query(vO);
    }
}
