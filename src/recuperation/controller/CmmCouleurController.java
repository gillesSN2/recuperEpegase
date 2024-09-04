package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.CmmCouleurDTO;
import com.yewi.yewicore.recuperation.service.CmmCouleurService;
import com.yewi.yewicore.recuperation.vo.CmmCouleurQueryVO;
import com.yewi.yewicore.recuperation.vo.CmmCouleurUpdateVO;
import com.yewi.yewicore.recuperation.vo.CmmCouleurVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/cmmCouleur")
public class CmmCouleurController {

    @Autowired
    private CmmCouleurService cmmCouleurService;

    @PostMapping
    public String save(@Valid @RequestBody CmmCouleurVO vO) {
        return cmmCouleurService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        cmmCouleurService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody CmmCouleurUpdateVO vO) {
        cmmCouleurService.update(id, vO);
    }

    @GetMapping("/{id}")
    public CmmCouleurDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return cmmCouleurService.getById(id);
    }

    @GetMapping
    public Page<CmmCouleurDTO> query(@Valid CmmCouleurQueryVO vO) {
        return cmmCouleurService.query(vO);
    }
}
