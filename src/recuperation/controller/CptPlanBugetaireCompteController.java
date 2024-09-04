package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.CptPlanBugetaireCompteDTO;
import com.yewi.yewicore.recuperation.service.CptPlanBugetaireCompteService;
import com.yewi.yewicore.recuperation.vo.CptPlanBugetaireCompteQueryVO;
import com.yewi.yewicore.recuperation.vo.CptPlanBugetaireCompteUpdateVO;
import com.yewi.yewicore.recuperation.vo.CptPlanBugetaireCompteVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/cptPlanBugetaireCompte")
public class CptPlanBugetaireCompteController {

    @Autowired
    private CptPlanBugetaireCompteService cptPlanBugetaireCompteService;

    @PostMapping
    public String save(@Valid @RequestBody CptPlanBugetaireCompteVO vO) {
        return cptPlanBugetaireCompteService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        cptPlanBugetaireCompteService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody CptPlanBugetaireCompteUpdateVO vO) {
        cptPlanBugetaireCompteService.update(id, vO);
    }

    @GetMapping("/{id}")
    public CptPlanBugetaireCompteDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return cptPlanBugetaireCompteService.getById(id);
    }

    @GetMapping
    public Page<CptPlanBugetaireCompteDTO> query(@Valid CptPlanBugetaireCompteQueryVO vO) {
        return cptPlanBugetaireCompteService.query(vO);
    }
}
