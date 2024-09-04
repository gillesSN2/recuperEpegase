package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.CmmTiersTechniqueDTO;
import com.yewi.yewicore.recuperation.service.CmmTiersTechniqueService;
import com.yewi.yewicore.recuperation.vo.CmmTiersTechniqueQueryVO;
import com.yewi.yewicore.recuperation.vo.CmmTiersTechniqueUpdateVO;
import com.yewi.yewicore.recuperation.vo.CmmTiersTechniqueVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/cmmTiersTechnique")
public class CmmTiersTechniqueController {

    @Autowired
    private CmmTiersTechniqueService cmmTiersTechniqueService;

    @PostMapping
    public String save(@Valid @RequestBody CmmTiersTechniqueVO vO) {
        return cmmTiersTechniqueService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        cmmTiersTechniqueService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody CmmTiersTechniqueUpdateVO vO) {
        cmmTiersTechniqueService.update(id, vO);
    }

    @GetMapping("/{id}")
    public CmmTiersTechniqueDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return cmmTiersTechniqueService.getById(id);
    }

    @GetMapping
    public Page<CmmTiersTechniqueDTO> query(@Valid CmmTiersTechniqueQueryVO vO) {
        return cmmTiersTechniqueService.query(vO);
    }
}
