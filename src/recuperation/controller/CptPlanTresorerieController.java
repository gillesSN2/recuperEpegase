package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.CptPlanTresorerieDTO;
import com.yewi.yewicore.recuperation.service.CptPlanTresorerieService;
import com.yewi.yewicore.recuperation.vo.CptPlanTresorerieQueryVO;
import com.yewi.yewicore.recuperation.vo.CptPlanTresorerieUpdateVO;
import com.yewi.yewicore.recuperation.vo.CptPlanTresorerieVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/cptPlanTresorerie")
public class CptPlanTresorerieController {

    @Autowired
    private CptPlanTresorerieService cptPlanTresorerieService;

    @PostMapping
    public String save(@Valid @RequestBody CptPlanTresorerieVO vO) {
        return cptPlanTresorerieService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        cptPlanTresorerieService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody CptPlanTresorerieUpdateVO vO) {
        cptPlanTresorerieService.update(id, vO);
    }

    @GetMapping("/{id}")
    public CptPlanTresorerieDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return cptPlanTresorerieService.getById(id);
    }

    @GetMapping
    public Page<CptPlanTresorerieDTO> query(@Valid CptPlanTresorerieQueryVO vO) {
        return cptPlanTresorerieService.query(vO);
    }
}
