package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.VteBretourEnteteDTO;
import com.yewi.yewicore.recuperation.service.VteBretourEnteteService;
import com.yewi.yewicore.recuperation.vo.VteBretourEnteteQueryVO;
import com.yewi.yewicore.recuperation.vo.VteBretourEnteteUpdateVO;
import com.yewi.yewicore.recuperation.vo.VteBretourEnteteVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/vteBretourEntete")
public class VteBretourEnteteController {

    @Autowired
    private VteBretourEnteteService vteBretourEnteteService;

    @PostMapping
    public String save(@Valid @RequestBody VteBretourEnteteVO vO) {
        return vteBretourEnteteService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        vteBretourEnteteService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody VteBretourEnteteUpdateVO vO) {
        vteBretourEnteteService.update(id, vO);
    }

    @GetMapping("/{id}")
    public VteBretourEnteteDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return vteBretourEnteteService.getById(id);
    }

    @GetMapping
    public Page<VteBretourEnteteDTO> query(@Valid VteBretourEnteteQueryVO vO) {
        return vteBretourEnteteService.query(vO);
    }
}
