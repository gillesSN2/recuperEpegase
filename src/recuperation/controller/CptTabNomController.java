package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.CptTabNomDTO;
import com.yewi.yewicore.recuperation.service.CptTabNomService;
import com.yewi.yewicore.recuperation.vo.CptTabNomQueryVO;
import com.yewi.yewicore.recuperation.vo.CptTabNomUpdateVO;
import com.yewi.yewicore.recuperation.vo.CptTabNomVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/cptTabNom")
public class CptTabNomController {

    @Autowired
    private CptTabNomService cptTabNomService;

    @PostMapping
    public String save(@Valid @RequestBody CptTabNomVO vO) {
        return cptTabNomService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        cptTabNomService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody CptTabNomUpdateVO vO) {
        cptTabNomService.update(id, vO);
    }

    @GetMapping("/{id}")
    public CptTabNomDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return cptTabNomService.getById(id);
    }

    @GetMapping
    public Page<CptTabNomDTO> query(@Valid CptTabNomQueryVO vO) {
        return cptTabNomService.query(vO);
    }
}
