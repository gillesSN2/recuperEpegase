package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.CmmPlanAnalytiqueRepartitionDTO;
import com.yewi.yewicore.recuperation.service.CmmPlanAnalytiqueRepartitionService;
import com.yewi.yewicore.recuperation.vo.CmmPlanAnalytiqueRepartitionQueryVO;
import com.yewi.yewicore.recuperation.vo.CmmPlanAnalytiqueRepartitionUpdateVO;
import com.yewi.yewicore.recuperation.vo.CmmPlanAnalytiqueRepartitionVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/cmmPlanAnalytiqueRepartition")
public class CmmPlanAnalytiqueRepartitionController {

    @Autowired
    private CmmPlanAnalytiqueRepartitionService cmmPlanAnalytiqueRepartitionService;

    @PostMapping
    public String save(@Valid @RequestBody CmmPlanAnalytiqueRepartitionVO vO) {
        return cmmPlanAnalytiqueRepartitionService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        cmmPlanAnalytiqueRepartitionService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody CmmPlanAnalytiqueRepartitionUpdateVO vO) {
        cmmPlanAnalytiqueRepartitionService.update(id, vO);
    }

    @GetMapping("/{id}")
    public CmmPlanAnalytiqueRepartitionDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return cmmPlanAnalytiqueRepartitionService.getById(id);
    }

    @GetMapping
    public Page<CmmPlanAnalytiqueRepartitionDTO> query(@Valid CmmPlanAnalytiqueRepartitionQueryVO vO) {
        return cmmPlanAnalytiqueRepartitionService.query(vO);
    }
}
