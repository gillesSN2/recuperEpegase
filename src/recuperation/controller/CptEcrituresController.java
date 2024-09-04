package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.CptEcrituresDTO;
import com.yewi.yewicore.recuperation.service.CptEcrituresService;
import com.yewi.yewicore.recuperation.vo.CptEcrituresQueryVO;
import com.yewi.yewicore.recuperation.vo.CptEcrituresUpdateVO;
import com.yewi.yewicore.recuperation.vo.CptEcrituresVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/cptEcritures")
public class CptEcrituresController {

    @Autowired
    private CptEcrituresService cptEcrituresService;

    @PostMapping
    public String save(@Valid @RequestBody CptEcrituresVO vO) {
        return cptEcrituresService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        cptEcrituresService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody CptEcrituresUpdateVO vO) {
        cptEcrituresService.update(id, vO);
    }

    @GetMapping("/{id}")
    public CptEcrituresDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return cptEcrituresService.getById(id);
    }

    @GetMapping
    public Page<CptEcrituresDTO> query(@Valid CptEcrituresQueryVO vO) {
        return cptEcrituresService.query(vO);
    }
}
