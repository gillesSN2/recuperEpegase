package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.CaiCaissesInventaireDTO;
import com.yewi.yewicore.recuperation.service.CaiCaissesInventaireService;
import com.yewi.yewicore.recuperation.vo.CaiCaissesInventaireQueryVO;
import com.yewi.yewicore.recuperation.vo.CaiCaissesInventaireUpdateVO;
import com.yewi.yewicore.recuperation.vo.CaiCaissesInventaireVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/caiCaissesInventaire")
public class CaiCaissesInventaireController {

    @Autowired
    private CaiCaissesInventaireService caiCaissesInventaireService;

    @PostMapping
    public String save(@Valid @RequestBody CaiCaissesInventaireVO vO) {
        return caiCaissesInventaireService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        caiCaissesInventaireService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody CaiCaissesInventaireUpdateVO vO) {
        caiCaissesInventaireService.update(id, vO);
    }

    @GetMapping("/{id}")
    public CaiCaissesInventaireDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return caiCaissesInventaireService.getById(id);
    }

    @GetMapping
    public Page<CaiCaissesInventaireDTO> query(@Valid CaiCaissesInventaireQueryVO vO) {
        return caiCaissesInventaireService.query(vO);
    }
}
