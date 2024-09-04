package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.CmmProductionAtelierDTO;
import com.yewi.yewicore.recuperation.service.CmmProductionAtelierService;
import com.yewi.yewicore.recuperation.vo.CmmProductionAtelierQueryVO;
import com.yewi.yewicore.recuperation.vo.CmmProductionAtelierUpdateVO;
import com.yewi.yewicore.recuperation.vo.CmmProductionAtelierVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/cmmProductionAtelier")
public class CmmProductionAtelierController {

    @Autowired
    private CmmProductionAtelierService cmmProductionAtelierService;

    @PostMapping
    public String save(@Valid @RequestBody CmmProductionAtelierVO vO) {
        return cmmProductionAtelierService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        cmmProductionAtelierService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody CmmProductionAtelierUpdateVO vO) {
        cmmProductionAtelierService.update(id, vO);
    }

    @GetMapping("/{id}")
    public CmmProductionAtelierDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return cmmProductionAtelierService.getById(id);
    }

    @GetMapping
    public Page<CmmProductionAtelierDTO> query(@Valid CmmProductionAtelierQueryVO vO) {
        return cmmProductionAtelierService.query(vO);
    }
}
