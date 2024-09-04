package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.CmmProduitsFraisDTO;
import com.yewi.yewicore.recuperation.service.CmmProduitsFraisService;
import com.yewi.yewicore.recuperation.vo.CmmProduitsFraisQueryVO;
import com.yewi.yewicore.recuperation.vo.CmmProduitsFraisUpdateVO;
import com.yewi.yewicore.recuperation.vo.CmmProduitsFraisVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/cmmProduitsFrais")
public class CmmProduitsFraisController {

    @Autowired
    private CmmProduitsFraisService cmmProduitsFraisService;

    @PostMapping
    public String save(@Valid @RequestBody CmmProduitsFraisVO vO) {
        return cmmProduitsFraisService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        cmmProduitsFraisService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody CmmProduitsFraisUpdateVO vO) {
        cmmProduitsFraisService.update(id, vO);
    }

    @GetMapping("/{id}")
    public CmmProduitsFraisDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return cmmProduitsFraisService.getById(id);
    }

    @GetMapping
    public Page<CmmProduitsFraisDTO> query(@Valid CmmProduitsFraisQueryVO vO) {
        return cmmProduitsFraisService.query(vO);
    }
}
