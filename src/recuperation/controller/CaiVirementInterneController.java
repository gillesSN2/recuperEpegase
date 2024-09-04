package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.CaiVirementInterneDTO;
import com.yewi.yewicore.recuperation.service.CaiVirementInterneService;
import com.yewi.yewicore.recuperation.vo.CaiVirementInterneQueryVO;
import com.yewi.yewicore.recuperation.vo.CaiVirementInterneUpdateVO;
import com.yewi.yewicore.recuperation.vo.CaiVirementInterneVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/caiVirementInterne")
public class CaiVirementInterneController {

    @Autowired
    private CaiVirementInterneService caiVirementInterneService;

    @PostMapping
    public String save(@Valid @RequestBody CaiVirementInterneVO vO) {
        return caiVirementInterneService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        caiVirementInterneService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody CaiVirementInterneUpdateVO vO) {
        caiVirementInterneService.update(id, vO);
    }

    @GetMapping("/{id}")
    public CaiVirementInterneDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return caiVirementInterneService.getById(id);
    }

    @GetMapping
    public Page<CaiVirementInterneDTO> query(@Valid CaiVirementInterneQueryVO vO) {
        return caiVirementInterneService.query(vO);
    }
}
