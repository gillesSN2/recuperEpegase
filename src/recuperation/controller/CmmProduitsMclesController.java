package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.CmmProduitsMclesDTO;
import com.yewi.yewicore.recuperation.service.CmmProduitsMclesService;
import com.yewi.yewicore.recuperation.vo.CmmProduitsMclesQueryVO;
import com.yewi.yewicore.recuperation.vo.CmmProduitsMclesUpdateVO;
import com.yewi.yewicore.recuperation.vo.CmmProduitsMclesVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/cmmProduitsMcles")
public class CmmProduitsMclesController {

    @Autowired
    private CmmProduitsMclesService cmmProduitsMclesService;

    @PostMapping
    public String save(@Valid @RequestBody CmmProduitsMclesVO vO) {
        return cmmProduitsMclesService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        cmmProduitsMclesService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody CmmProduitsMclesUpdateVO vO) {
        cmmProduitsMclesService.update(id, vO);
    }

    @GetMapping("/{id}")
    public CmmProduitsMclesDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return cmmProduitsMclesService.getById(id);
    }

    @GetMapping
    public Page<CmmProduitsMclesDTO> query(@Valid CmmProduitsMclesQueryVO vO) {
        return cmmProduitsMclesService.query(vO);
    }
}
