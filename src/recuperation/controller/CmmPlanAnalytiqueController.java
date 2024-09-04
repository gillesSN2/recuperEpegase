package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.CmmPlanAnalytiqueDTO;
import com.yewi.yewicore.recuperation.service.CmmPlanAnalytiqueService;
import com.yewi.yewicore.recuperation.vo.CmmPlanAnalytiqueQueryVO;
import com.yewi.yewicore.recuperation.vo.CmmPlanAnalytiqueUpdateVO;
import com.yewi.yewicore.recuperation.vo.CmmPlanAnalytiqueVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/cmmPlanAnalytique")
public class CmmPlanAnalytiqueController {

    @Autowired
    private CmmPlanAnalytiqueService cmmPlanAnalytiqueService;

    @PostMapping
    public String save(@Valid @RequestBody CmmPlanAnalytiqueVO vO) {
        return cmmPlanAnalytiqueService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        cmmPlanAnalytiqueService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody CmmPlanAnalytiqueUpdateVO vO) {
        cmmPlanAnalytiqueService.update(id, vO);
    }

    @GetMapping("/{id}")
    public CmmPlanAnalytiqueDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return cmmPlanAnalytiqueService.getById(id);
    }

    @GetMapping
    public Page<CmmPlanAnalytiqueDTO> query(@Valid CmmPlanAnalytiqueQueryVO vO) {
        return cmmPlanAnalytiqueService.query(vO);
    }
}
