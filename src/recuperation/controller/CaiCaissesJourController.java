package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.CaiCaissesJourDTO;
import com.yewi.yewicore.recuperation.service.CaiCaissesJourService;
import com.yewi.yewicore.recuperation.vo.CaiCaissesJourQueryVO;
import com.yewi.yewicore.recuperation.vo.CaiCaissesJourUpdateVO;
import com.yewi.yewicore.recuperation.vo.CaiCaissesJourVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/caiCaissesJour")
public class CaiCaissesJourController {

    @Autowired
    private CaiCaissesJourService caiCaissesJourService;

    @PostMapping
    public String save(@Valid @RequestBody CaiCaissesJourVO vO) {
        return caiCaissesJourService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        caiCaissesJourService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody CaiCaissesJourUpdateVO vO) {
        caiCaissesJourService.update(id, vO);
    }

    @GetMapping("/{id}")
    public CaiCaissesJourDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return caiCaissesJourService.getById(id);
    }

    @GetMapping
    public Page<CaiCaissesJourDTO> query(@Valid CaiCaissesJourQueryVO vO) {
        return caiCaissesJourService.query(vO);
    }
}
