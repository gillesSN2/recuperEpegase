package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.CptEcrituresAnalytiquesDTO;
import com.yewi.yewicore.recuperation.service.CptEcrituresAnalytiquesService;
import com.yewi.yewicore.recuperation.vo.CptEcrituresAnalytiquesQueryVO;
import com.yewi.yewicore.recuperation.vo.CptEcrituresAnalytiquesUpdateVO;
import com.yewi.yewicore.recuperation.vo.CptEcrituresAnalytiquesVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/cptEcrituresAnalytiques")
public class CptEcrituresAnalytiquesController {

    @Autowired
    private CptEcrituresAnalytiquesService cptEcrituresAnalytiquesService;

    @PostMapping
    public String save(@Valid @RequestBody CptEcrituresAnalytiquesVO vO) {
        return cptEcrituresAnalytiquesService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        cptEcrituresAnalytiquesService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody CptEcrituresAnalytiquesUpdateVO vO) {
        cptEcrituresAnalytiquesService.update(id, vO);
    }

    @GetMapping("/{id}")
    public CptEcrituresAnalytiquesDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return cptEcrituresAnalytiquesService.getById(id);
    }

    @GetMapping
    public Page<CptEcrituresAnalytiquesDTO> query(@Valid CptEcrituresAnalytiquesQueryVO vO) {
        return cptEcrituresAnalytiquesService.query(vO);
    }
}
