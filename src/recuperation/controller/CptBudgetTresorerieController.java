package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.CptBudgetTresorerieDTO;
import com.yewi.yewicore.recuperation.service.CptBudgetTresorerieService;
import com.yewi.yewicore.recuperation.vo.CptBudgetTresorerieQueryVO;
import com.yewi.yewicore.recuperation.vo.CptBudgetTresorerieUpdateVO;
import com.yewi.yewicore.recuperation.vo.CptBudgetTresorerieVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/cptBudgetTresorerie")
public class CptBudgetTresorerieController {

    @Autowired
    private CptBudgetTresorerieService cptBudgetTresorerieService;

    @PostMapping
    public String save(@Valid @RequestBody CptBudgetTresorerieVO vO) {
        return cptBudgetTresorerieService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        cptBudgetTresorerieService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody CptBudgetTresorerieUpdateVO vO) {
        cptBudgetTresorerieService.update(id, vO);
    }

    @GetMapping("/{id}")
    public CptBudgetTresorerieDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return cptBudgetTresorerieService.getById(id);
    }

    @GetMapping
    public Page<CptBudgetTresorerieDTO> query(@Valid CptBudgetTresorerieQueryVO vO) {
        return cptBudgetTresorerieService.query(vO);
    }
}
