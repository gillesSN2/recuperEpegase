package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.PrcCaracteristiqueDTO;
import com.yewi.yewicore.recuperation.service.PrcCaracteristiqueService;
import com.yewi.yewicore.recuperation.vo.PrcCaracteristiqueQueryVO;
import com.yewi.yewicore.recuperation.vo.PrcCaracteristiqueUpdateVO;
import com.yewi.yewicore.recuperation.vo.PrcCaracteristiqueVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/prcCaracteristique")
public class PrcCaracteristiqueController {

    @Autowired
    private PrcCaracteristiqueService prcCaracteristiqueService;

    @PostMapping
    public String save(@Valid @RequestBody PrcCaracteristiqueVO vO) {
        return prcCaracteristiqueService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        prcCaracteristiqueService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody PrcCaracteristiqueUpdateVO vO) {
        prcCaracteristiqueService.update(id, vO);
    }

    @GetMapping("/{id}")
    public PrcCaracteristiqueDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return prcCaracteristiqueService.getById(id);
    }

    @GetMapping
    public Page<PrcCaracteristiqueDTO> query(@Valid PrcCaracteristiqueQueryVO vO) {
        return prcCaracteristiqueService.query(vO);
    }
}
