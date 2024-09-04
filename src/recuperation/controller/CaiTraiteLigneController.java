package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.CaiTraiteLigneDTO;
import com.yewi.yewicore.recuperation.service.CaiTraiteLigneService;
import com.yewi.yewicore.recuperation.vo.CaiTraiteLigneQueryVO;
import com.yewi.yewicore.recuperation.vo.CaiTraiteLigneUpdateVO;
import com.yewi.yewicore.recuperation.vo.CaiTraiteLigneVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/caiTraiteLigne")
public class CaiTraiteLigneController {

    @Autowired
    private CaiTraiteLigneService caiTraiteLigneService;

    @PostMapping
    public String save(@Valid @RequestBody CaiTraiteLigneVO vO) {
        return caiTraiteLigneService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        caiTraiteLigneService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody CaiTraiteLigneUpdateVO vO) {
        caiTraiteLigneService.update(id, vO);
    }

    @GetMapping("/{id}")
    public CaiTraiteLigneDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return caiTraiteLigneService.getById(id);
    }

    @GetMapping
    public Page<CaiTraiteLigneDTO> query(@Valid CaiTraiteLigneQueryVO vO) {
        return caiTraiteLigneService.query(vO);
    }
}
