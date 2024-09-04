package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.CptEcrituresAnterieurDTO;
import com.yewi.yewicore.recuperation.service.CptEcrituresAnterieurService;
import com.yewi.yewicore.recuperation.vo.CptEcrituresAnterieurQueryVO;
import com.yewi.yewicore.recuperation.vo.CptEcrituresAnterieurUpdateVO;
import com.yewi.yewicore.recuperation.vo.CptEcrituresAnterieurVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/cptEcrituresAnterieur")
public class CptEcrituresAnterieurController {

    @Autowired
    private CptEcrituresAnterieurService cptEcrituresAnterieurService;

    @PostMapping
    public String save(@Valid @RequestBody CptEcrituresAnterieurVO vO) {
        return cptEcrituresAnterieurService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        cptEcrituresAnterieurService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody CptEcrituresAnterieurUpdateVO vO) {
        cptEcrituresAnterieurService.update(id, vO);
    }

    @GetMapping("/{id}")
    public CptEcrituresAnterieurDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return cptEcrituresAnterieurService.getById(id);
    }

    @GetMapping
    public Page<CptEcrituresAnterieurDTO> query(@Valid CptEcrituresAnterieurQueryVO vO) {
        return cptEcrituresAnterieurService.query(vO);
    }
}
