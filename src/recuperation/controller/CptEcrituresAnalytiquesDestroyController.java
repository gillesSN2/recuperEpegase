package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.CptEcrituresAnalytiquesDestroyDTO;
import com.yewi.yewicore.recuperation.service.CptEcrituresAnalytiquesDestroyService;
import com.yewi.yewicore.recuperation.vo.CptEcrituresAnalytiquesDestroyQueryVO;
import com.yewi.yewicore.recuperation.vo.CptEcrituresAnalytiquesDestroyUpdateVO;
import com.yewi.yewicore.recuperation.vo.CptEcrituresAnalytiquesDestroyVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/cptEcrituresAnalytiquesDestroy")
public class CptEcrituresAnalytiquesDestroyController {

    @Autowired
    private CptEcrituresAnalytiquesDestroyService cptEcrituresAnalytiquesDestroyService;

    @PostMapping
    public String save(@Valid @RequestBody CptEcrituresAnalytiquesDestroyVO vO) {
        return cptEcrituresAnalytiquesDestroyService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        cptEcrituresAnalytiquesDestroyService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody CptEcrituresAnalytiquesDestroyUpdateVO vO) {
        cptEcrituresAnalytiquesDestroyService.update(id, vO);
    }

    @GetMapping("/{id}")
    public CptEcrituresAnalytiquesDestroyDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return cptEcrituresAnalytiquesDestroyService.getById(id);
    }

    @GetMapping
    public Page<CptEcrituresAnalytiquesDestroyDTO> query(@Valid CptEcrituresAnalytiquesDestroyQueryVO vO) {
        return cptEcrituresAnalytiquesDestroyService.query(vO);
    }
}
