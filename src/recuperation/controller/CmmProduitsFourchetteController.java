package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.CmmProduitsFourchetteDTO;
import com.yewi.yewicore.recuperation.service.CmmProduitsFourchetteService;
import com.yewi.yewicore.recuperation.vo.CmmProduitsFourchetteQueryVO;
import com.yewi.yewicore.recuperation.vo.CmmProduitsFourchetteUpdateVO;
import com.yewi.yewicore.recuperation.vo.CmmProduitsFourchetteVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/cmmProduitsFourchette")
public class CmmProduitsFourchetteController {

    @Autowired
    private CmmProduitsFourchetteService cmmProduitsFourchetteService;

    @PostMapping
    public String save(@Valid @RequestBody CmmProduitsFourchetteVO vO) {
        return cmmProduitsFourchetteService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        cmmProduitsFourchetteService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody CmmProduitsFourchetteUpdateVO vO) {
        cmmProduitsFourchetteService.update(id, vO);
    }

    @GetMapping("/{id}")
    public CmmProduitsFourchetteDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return cmmProduitsFourchetteService.getById(id);
    }

    @GetMapping
    public Page<CmmProduitsFourchetteDTO> query(@Valid CmmProduitsFourchetteQueryVO vO) {
        return cmmProduitsFourchetteService.query(vO);
    }
}
