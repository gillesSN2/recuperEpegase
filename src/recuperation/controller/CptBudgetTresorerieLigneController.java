package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.CptBudgetTresorerieLigneDTO;
import com.yewi.yewicore.recuperation.service.CptBudgetTresorerieLigneService;
import com.yewi.yewicore.recuperation.vo.CptBudgetTresorerieLigneQueryVO;
import com.yewi.yewicore.recuperation.vo.CptBudgetTresorerieLigneUpdateVO;
import com.yewi.yewicore.recuperation.vo.CptBudgetTresorerieLigneVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/cptBudgetTresorerieLigne")
public class CptBudgetTresorerieLigneController {

    @Autowired
    private CptBudgetTresorerieLigneService cptBudgetTresorerieLigneService;

    @PostMapping
    public String save(@Valid @RequestBody CptBudgetTresorerieLigneVO vO) {
        return cptBudgetTresorerieLigneService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        cptBudgetTresorerieLigneService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody CptBudgetTresorerieLigneUpdateVO vO) {
        cptBudgetTresorerieLigneService.update(id, vO);
    }

    @GetMapping("/{id}")
    public CptBudgetTresorerieLigneDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return cptBudgetTresorerieLigneService.getById(id);
    }

    @GetMapping
    public Page<CptBudgetTresorerieLigneDTO> query(@Valid CptBudgetTresorerieLigneQueryVO vO) {
        return cptBudgetTresorerieLigneService.query(vO);
    }
}
