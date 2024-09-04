package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.CptPlanComptableDTO;
import com.yewi.yewicore.recuperation.service.CptPlanComptableService;
import com.yewi.yewicore.recuperation.vo.CptPlanComptableQueryVO;
import com.yewi.yewicore.recuperation.vo.CptPlanComptableUpdateVO;
import com.yewi.yewicore.recuperation.vo.CptPlanComptableVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/cptPlanComptable")
public class CptPlanComptableController {

    @Autowired
    private CptPlanComptableService cptPlanComptableService;

    @PostMapping
    public String save(@Valid @RequestBody CptPlanComptableVO vO) {
        return cptPlanComptableService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        cptPlanComptableService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody CptPlanComptableUpdateVO vO) {
        cptPlanComptableService.update(id, vO);
    }

    @GetMapping("/{id}")
    public CptPlanComptableDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return cptPlanComptableService.getById(id);
    }

    @GetMapping
    public Page<CptPlanComptableDTO> query(@Valid CptPlanComptableQueryVO vO) {
        return cptPlanComptableService.query(vO);
    }
}
