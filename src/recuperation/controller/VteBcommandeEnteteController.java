package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.VteBcommandeEnteteDTO;
import com.yewi.yewicore.recuperation.service.VteBcommandeEnteteService;
import com.yewi.yewicore.recuperation.vo.VteBcommandeEnteteQueryVO;
import com.yewi.yewicore.recuperation.vo.VteBcommandeEnteteUpdateVO;
import com.yewi.yewicore.recuperation.vo.VteBcommandeEnteteVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/vteBcommandeEntete")
public class VteBcommandeEnteteController {

    @Autowired
    private VteBcommandeEnteteService vteBcommandeEnteteService;

    @PostMapping
    public String save(@Valid @RequestBody VteBcommandeEnteteVO vO) {
        return vteBcommandeEnteteService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        vteBcommandeEnteteService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody VteBcommandeEnteteUpdateVO vO) {
        vteBcommandeEnteteService.update(id, vO);
    }

    @GetMapping("/{id}")
    public VteBcommandeEnteteDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return vteBcommandeEnteteService.getById(id);
    }

    @GetMapping
    public Page<VteBcommandeEnteteDTO> query(@Valid VteBcommandeEnteteQueryVO vO) {
        return vteBcommandeEnteteService.query(vO);
    }
}
