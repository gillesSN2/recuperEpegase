package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.CmmProduitsTarifDTO;
import com.yewi.yewicore.recuperation.service.CmmProduitsTarifService;
import com.yewi.yewicore.recuperation.vo.CmmProduitsTarifQueryVO;
import com.yewi.yewicore.recuperation.vo.CmmProduitsTarifUpdateVO;
import com.yewi.yewicore.recuperation.vo.CmmProduitsTarifVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/cmmProduitsTarif")
public class CmmProduitsTarifController {

    @Autowired
    private CmmProduitsTarifService cmmProduitsTarifService;

    @PostMapping
    public String save(@Valid @RequestBody CmmProduitsTarifVO vO) {
        return cmmProduitsTarifService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        cmmProduitsTarifService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody CmmProduitsTarifUpdateVO vO) {
        cmmProduitsTarifService.update(id, vO);
    }

    @GetMapping("/{id}")
    public CmmProduitsTarifDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return cmmProduitsTarifService.getById(id);
    }

    @GetMapping
    public Page<CmmProduitsTarifDTO> query(@Valid CmmProduitsTarifQueryVO vO) {
        return cmmProduitsTarifService.query(vO);
    }
}
