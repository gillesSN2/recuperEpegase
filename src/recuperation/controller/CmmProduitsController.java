package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.CmmProduitsDTO;
import com.yewi.yewicore.recuperation.service.CmmProduitsService;
import com.yewi.yewicore.recuperation.vo.CmmProduitsQueryVO;
import com.yewi.yewicore.recuperation.vo.CmmProduitsUpdateVO;
import com.yewi.yewicore.recuperation.vo.CmmProduitsVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/cmmProduits")
public class CmmProduitsController {

    @Autowired
    private CmmProduitsService cmmProduitsService;

    @PostMapping
    public String save(@Valid @RequestBody CmmProduitsVO vO) {
        return cmmProduitsService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        cmmProduitsService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody CmmProduitsUpdateVO vO) {
        cmmProduitsService.update(id, vO);
    }

    @GetMapping("/{id}")
    public CmmProduitsDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return cmmProduitsService.getById(id);
    }

    @GetMapping
    public Page<CmmProduitsDTO> query(@Valid CmmProduitsQueryVO vO) {
        return cmmProduitsService.query(vO);
    }
}
