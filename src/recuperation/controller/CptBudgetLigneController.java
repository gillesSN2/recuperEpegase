package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.CptBudgetLigneDTO;
import com.yewi.yewicore.recuperation.service.CptBudgetLigneService;
import com.yewi.yewicore.recuperation.vo.CptBudgetLigneQueryVO;
import com.yewi.yewicore.recuperation.vo.CptBudgetLigneUpdateVO;
import com.yewi.yewicore.recuperation.vo.CptBudgetLigneVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/cptBudgetLigne")
public class CptBudgetLigneController {

    @Autowired
    private CptBudgetLigneService cptBudgetLigneService;

    @PostMapping
    public String save(@Valid @RequestBody CptBudgetLigneVO vO) {
        return cptBudgetLigneService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        cptBudgetLigneService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody CptBudgetLigneUpdateVO vO) {
        cptBudgetLigneService.update(id, vO);
    }

    @GetMapping("/{id}")
    public CptBudgetLigneDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return cptBudgetLigneService.getById(id);
    }

    @GetMapping
    public Page<CptBudgetLigneDTO> query(@Valid CptBudgetLigneQueryVO vO) {
        return cptBudgetLigneService.query(vO);
    }
}
