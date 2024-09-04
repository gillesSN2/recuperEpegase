package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.CptBudgetDTO;
import com.yewi.yewicore.recuperation.service.CptBudgetService;
import com.yewi.yewicore.recuperation.vo.CptBudgetQueryVO;
import com.yewi.yewicore.recuperation.vo.CptBudgetUpdateVO;
import com.yewi.yewicore.recuperation.vo.CptBudgetVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/cptBudget")
public class CptBudgetController {

    @Autowired
    private CptBudgetService cptBudgetService;

    @PostMapping
    public String save(@Valid @RequestBody CptBudgetVO vO) {
        return cptBudgetService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        cptBudgetService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody CptBudgetUpdateVO vO) {
        cptBudgetService.update(id, vO);
    }

    @GetMapping("/{id}")
    public CptBudgetDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return cptBudgetService.getById(id);
    }

    @GetMapping
    public Page<CptBudgetDTO> query(@Valid CptBudgetQueryVO vO) {
        return cptBudgetService.query(vO);
    }
}
