package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.VteCampagneEnteteDTO;
import com.yewi.yewicore.recuperation.service.VteCampagneEnteteService;
import com.yewi.yewicore.recuperation.vo.VteCampagneEnteteQueryVO;
import com.yewi.yewicore.recuperation.vo.VteCampagneEnteteUpdateVO;
import com.yewi.yewicore.recuperation.vo.VteCampagneEnteteVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/vteCampagneEntete")
public class VteCampagneEnteteController {

    @Autowired
    private VteCampagneEnteteService vteCampagneEnteteService;

    @PostMapping
    public String save(@Valid @RequestBody VteCampagneEnteteVO vO) {
        return vteCampagneEnteteService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        vteCampagneEnteteService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody VteCampagneEnteteUpdateVO vO) {
        vteCampagneEnteteService.update(id, vO);
    }

    @GetMapping("/{id}")
    public VteCampagneEnteteDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return vteCampagneEnteteService.getById(id);
    }

    @GetMapping
    public Page<VteCampagneEnteteDTO> query(@Valid VteCampagneEnteteQueryVO vO) {
        return vteCampagneEnteteService.query(vO);
    }
}
