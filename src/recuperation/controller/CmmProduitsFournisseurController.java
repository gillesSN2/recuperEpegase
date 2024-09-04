package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.CmmProduitsFournisseurDTO;
import com.yewi.yewicore.recuperation.service.CmmProduitsFournisseurService;
import com.yewi.yewicore.recuperation.vo.CmmProduitsFournisseurQueryVO;
import com.yewi.yewicore.recuperation.vo.CmmProduitsFournisseurUpdateVO;
import com.yewi.yewicore.recuperation.vo.CmmProduitsFournisseurVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/cmmProduitsFournisseur")
public class CmmProduitsFournisseurController {

    @Autowired
    private CmmProduitsFournisseurService cmmProduitsFournisseurService;

    @PostMapping
    public String save(@Valid @RequestBody CmmProduitsFournisseurVO vO) {
        return cmmProduitsFournisseurService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        cmmProduitsFournisseurService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody CmmProduitsFournisseurUpdateVO vO) {
        cmmProduitsFournisseurService.update(id, vO);
    }

    @GetMapping("/{id}")
    public CmmProduitsFournisseurDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return cmmProduitsFournisseurService.getById(id);
    }

    @GetMapping
    public Page<CmmProduitsFournisseurDTO> query(@Valid CmmProduitsFournisseurQueryVO vO) {
        return cmmProduitsFournisseurService.query(vO);
    }
}
