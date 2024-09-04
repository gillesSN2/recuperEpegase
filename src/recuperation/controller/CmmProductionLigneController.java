package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.CmmProductionLigneDTO;
import com.yewi.yewicore.recuperation.service.CmmProductionLigneService;
import com.yewi.yewicore.recuperation.vo.CmmProductionLigneQueryVO;
import com.yewi.yewicore.recuperation.vo.CmmProductionLigneUpdateVO;
import com.yewi.yewicore.recuperation.vo.CmmProductionLigneVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/cmmProductionLigne")
public class CmmProductionLigneController {

    @Autowired
    private CmmProductionLigneService cmmProductionLigneService;

    @PostMapping
    public String save(@Valid @RequestBody CmmProductionLigneVO vO) {
        return cmmProductionLigneService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        cmmProductionLigneService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody CmmProductionLigneUpdateVO vO) {
        cmmProductionLigneService.update(id, vO);
    }

    @GetMapping("/{id}")
    public CmmProductionLigneDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return cmmProductionLigneService.getById(id);
    }

    @GetMapping
    public Page<CmmProductionLigneDTO> query(@Valid CmmProductionLigneQueryVO vO) {
        return cmmProductionLigneService.query(vO);
    }
}
