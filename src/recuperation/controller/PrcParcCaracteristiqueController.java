package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.PrcParcCaracteristiqueDTO;
import com.yewi.yewicore.recuperation.service.PrcParcCaracteristiqueService;
import com.yewi.yewicore.recuperation.vo.PrcParcCaracteristiqueQueryVO;
import com.yewi.yewicore.recuperation.vo.PrcParcCaracteristiqueUpdateVO;
import com.yewi.yewicore.recuperation.vo.PrcParcCaracteristiqueVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/prcParcCaracteristique")
public class PrcParcCaracteristiqueController {

    @Autowired
    private PrcParcCaracteristiqueService prcParcCaracteristiqueService;

    @PostMapping
    public String save(@Valid @RequestBody PrcParcCaracteristiqueVO vO) {
        return prcParcCaracteristiqueService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        prcParcCaracteristiqueService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody PrcParcCaracteristiqueUpdateVO vO) {
        prcParcCaracteristiqueService.update(id, vO);
    }

    @GetMapping("/{id}")
    public PrcParcCaracteristiqueDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return prcParcCaracteristiqueService.getById(id);
    }

    @GetMapping
    public Page<PrcParcCaracteristiqueDTO> query(@Valid PrcParcCaracteristiqueQueryVO vO) {
        return prcParcCaracteristiqueService.query(vO);
    }
}
