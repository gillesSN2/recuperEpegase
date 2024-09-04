package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.VteBlivraisonEnteteDTO;
import com.yewi.yewicore.recuperation.service.VteBlivraisonEnteteService;
import com.yewi.yewicore.recuperation.vo.VteBlivraisonEnteteQueryVO;
import com.yewi.yewicore.recuperation.vo.VteBlivraisonEnteteUpdateVO;
import com.yewi.yewicore.recuperation.vo.VteBlivraisonEnteteVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/vteBlivraisonEntete")
public class VteBlivraisonEnteteController {

    @Autowired
    private VteBlivraisonEnteteService vteBlivraisonEnteteService;

    @PostMapping
    public String save(@Valid @RequestBody VteBlivraisonEnteteVO vO) {
        return vteBlivraisonEnteteService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        vteBlivraisonEnteteService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody VteBlivraisonEnteteUpdateVO vO) {
        vteBlivraisonEnteteService.update(id, vO);
    }

    @GetMapping("/{id}")
    public VteBlivraisonEnteteDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return vteBlivraisonEnteteService.getById(id);
    }

    @GetMapping
    public Page<VteBlivraisonEnteteDTO> query(@Valid VteBlivraisonEnteteQueryVO vO) {
        return vteBlivraisonEnteteService.query(vO);
    }
}
