package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.CmmReunionPresenceDTO;
import com.yewi.yewicore.recuperation.service.CmmReunionPresenceService;
import com.yewi.yewicore.recuperation.vo.CmmReunionPresenceQueryVO;
import com.yewi.yewicore.recuperation.vo.CmmReunionPresenceUpdateVO;
import com.yewi.yewicore.recuperation.vo.CmmReunionPresenceVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/cmmReunionPresence")
public class CmmReunionPresenceController {

    @Autowired
    private CmmReunionPresenceService cmmReunionPresenceService;

    @PostMapping
    public String save(@Valid @RequestBody CmmReunionPresenceVO vO) {
        return cmmReunionPresenceService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        cmmReunionPresenceService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody CmmReunionPresenceUpdateVO vO) {
        cmmReunionPresenceService.update(id, vO);
    }

    @GetMapping("/{id}")
    public CmmReunionPresenceDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return cmmReunionPresenceService.getById(id);
    }

    @GetMapping
    public Page<CmmReunionPresenceDTO> query(@Valid CmmReunionPresenceQueryVO vO) {
        return cmmReunionPresenceService.query(vO);
    }
}
