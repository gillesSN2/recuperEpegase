package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.CptJournauxComptablesDTO;
import com.yewi.yewicore.recuperation.service.CptJournauxComptablesService;
import com.yewi.yewicore.recuperation.vo.CptJournauxComptablesQueryVO;
import com.yewi.yewicore.recuperation.vo.CptJournauxComptablesUpdateVO;
import com.yewi.yewicore.recuperation.vo.CptJournauxComptablesVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/cptJournauxComptables")
public class CptJournauxComptablesController {

    @Autowired
    private CptJournauxComptablesService cptJournauxComptablesService;

    @PostMapping
    public String save(@Valid @RequestBody CptJournauxComptablesVO vO) {
        return cptJournauxComptablesService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        cptJournauxComptablesService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody CptJournauxComptablesUpdateVO vO) {
        cptJournauxComptablesService.update(id, vO);
    }

    @GetMapping("/{id}")
    public CptJournauxComptablesDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return cptJournauxComptablesService.getById(id);
    }

    @GetMapping
    public Page<CptJournauxComptablesDTO> query(@Valid CptJournauxComptablesQueryVO vO) {
        return cptJournauxComptablesService.query(vO);
    }
}
