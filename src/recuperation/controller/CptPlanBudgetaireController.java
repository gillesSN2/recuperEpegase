package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.CptPlanBudgetaireDTO;
import com.yewi.yewicore.recuperation.service.CptPlanBudgetaireService;
import com.yewi.yewicore.recuperation.vo.CptPlanBudgetaireQueryVO;
import com.yewi.yewicore.recuperation.vo.CptPlanBudgetaireUpdateVO;
import com.yewi.yewicore.recuperation.vo.CptPlanBudgetaireVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/cptPlanBudgetaire")
public class CptPlanBudgetaireController {

    @Autowired
    private CptPlanBudgetaireService cptPlanBudgetaireService;

    @PostMapping
    public String save(@Valid @RequestBody CptPlanBudgetaireVO vO) {
        return cptPlanBudgetaireService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        cptPlanBudgetaireService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody CptPlanBudgetaireUpdateVO vO) {
        cptPlanBudgetaireService.update(id, vO);
    }

    @GetMapping("/{id}")
    public CptPlanBudgetaireDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return cptPlanBudgetaireService.getById(id);
    }

    @GetMapping
    public Page<CptPlanBudgetaireDTO> query(@Valid CptPlanBudgetaireQueryVO vO) {
        return cptPlanBudgetaireService.query(vO);
    }
}
