package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.CmmReunionActionDTO;
import com.yewi.yewicore.recuperation.service.CmmReunionActionService;
import com.yewi.yewicore.recuperation.vo.CmmReunionActionQueryVO;
import com.yewi.yewicore.recuperation.vo.CmmReunionActionUpdateVO;
import com.yewi.yewicore.recuperation.vo.CmmReunionActionVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/cmmReunionAction")
public class CmmReunionActionController {

    @Autowired
    private CmmReunionActionService cmmReunionActionService;

    @PostMapping
    public String save(@Valid @RequestBody CmmReunionActionVO vO) {
        return cmmReunionActionService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        cmmReunionActionService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody CmmReunionActionUpdateVO vO) {
        cmmReunionActionService.update(id, vO);
    }

    @GetMapping("/{id}")
    public CmmReunionActionDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return cmmReunionActionService.getById(id);
    }

    @GetMapping
    public Page<CmmReunionActionDTO> query(@Valid CmmReunionActionQueryVO vO) {
        return cmmReunionActionService.query(vO);
    }
}
