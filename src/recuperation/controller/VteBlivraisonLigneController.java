package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.VteBlivraisonLigneDTO;
import com.yewi.yewicore.recuperation.service.VteBlivraisonLigneService;
import com.yewi.yewicore.recuperation.vo.VteBlivraisonLigneQueryVO;
import com.yewi.yewicore.recuperation.vo.VteBlivraisonLigneUpdateVO;
import com.yewi.yewicore.recuperation.vo.VteBlivraisonLigneVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/vteBlivraisonLigne")
public class VteBlivraisonLigneController {

    @Autowired
    private VteBlivraisonLigneService vteBlivraisonLigneService;

    @PostMapping
    public String save(@Valid @RequestBody VteBlivraisonLigneVO vO) {
        return vteBlivraisonLigneService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        vteBlivraisonLigneService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody VteBlivraisonLigneUpdateVO vO) {
        vteBlivraisonLigneService.update(id, vO);
    }

    @GetMapping("/{id}")
    public VteBlivraisonLigneDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return vteBlivraisonLigneService.getById(id);
    }

    @GetMapping
    public Page<VteBlivraisonLigneDTO> query(@Valid VteBlivraisonLigneQueryVO vO) {
        return vteBlivraisonLigneService.query(vO);
    }
}
