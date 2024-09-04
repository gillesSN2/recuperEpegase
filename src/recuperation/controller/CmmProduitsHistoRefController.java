package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.CmmProduitsHistoRefDTO;
import com.yewi.yewicore.recuperation.service.CmmProduitsHistoRefService;
import com.yewi.yewicore.recuperation.vo.CmmProduitsHistoRefQueryVO;
import com.yewi.yewicore.recuperation.vo.CmmProduitsHistoRefUpdateVO;
import com.yewi.yewicore.recuperation.vo.CmmProduitsHistoRefVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/cmmProduitsHistoRef")
public class CmmProduitsHistoRefController {

    @Autowired
    private CmmProduitsHistoRefService cmmProduitsHistoRefService;

    @PostMapping
    public String save(@Valid @RequestBody CmmProduitsHistoRefVO vO) {
        return cmmProduitsHistoRefService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        cmmProduitsHistoRefService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody CmmProduitsHistoRefUpdateVO vO) {
        cmmProduitsHistoRefService.update(id, vO);
    }

    @GetMapping("/{id}")
    public CmmProduitsHistoRefDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return cmmProduitsHistoRefService.getById(id);
    }

    @GetMapping
    public Page<CmmProduitsHistoRefDTO> query(@Valid CmmProduitsHistoRefQueryVO vO) {
        return cmmProduitsHistoRefService.query(vO);
    }
}
