package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.CmmReunionEnteteDTO;
import com.yewi.yewicore.recuperation.service.CmmReunionEnteteService;
import com.yewi.yewicore.recuperation.vo.CmmReunionEnteteQueryVO;
import com.yewi.yewicore.recuperation.vo.CmmReunionEnteteUpdateVO;
import com.yewi.yewicore.recuperation.vo.CmmReunionEnteteVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/cmmReunionEntete")
public class CmmReunionEnteteController {

    @Autowired
    private CmmReunionEnteteService cmmReunionEnteteService;

    @PostMapping
    public String save(@Valid @RequestBody CmmReunionEnteteVO vO) {
        return cmmReunionEnteteService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        cmmReunionEnteteService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody CmmReunionEnteteUpdateVO vO) {
        cmmReunionEnteteService.update(id, vO);
    }

    @GetMapping("/{id}")
    public CmmReunionEnteteDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return cmmReunionEnteteService.getById(id);
    }

    @GetMapping
    public Page<CmmReunionEnteteDTO> query(@Valid CmmReunionEnteteQueryVO vO) {
        return cmmReunionEnteteService.query(vO);
    }
}
