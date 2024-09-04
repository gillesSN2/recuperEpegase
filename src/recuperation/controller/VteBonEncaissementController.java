package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.VteBonEncaissementDTO;
import com.yewi.yewicore.recuperation.service.VteBonEncaissementService;
import com.yewi.yewicore.recuperation.vo.VteBonEncaissementQueryVO;
import com.yewi.yewicore.recuperation.vo.VteBonEncaissementUpdateVO;
import com.yewi.yewicore.recuperation.vo.VteBonEncaissementVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/vteBonEncaissement")
public class VteBonEncaissementController {

    @Autowired
    private VteBonEncaissementService vteBonEncaissementService;

    @PostMapping
    public String save(@Valid @RequestBody VteBonEncaissementVO vO) {
        return vteBonEncaissementService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        vteBonEncaissementService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody VteBonEncaissementUpdateVO vO) {
        vteBonEncaissementService.update(id, vO);
    }

    @GetMapping("/{id}")
    public VteBonEncaissementDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return vteBonEncaissementService.getById(id);
    }

    @GetMapping
    public Page<VteBonEncaissementDTO> query(@Valid VteBonEncaissementQueryVO vO) {
        return vteBonEncaissementService.query(vO);
    }
}
