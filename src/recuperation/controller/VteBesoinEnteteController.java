package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.VteBesoinEnteteDTO;
import com.yewi.yewicore.recuperation.service.VteBesoinEnteteService;
import com.yewi.yewicore.recuperation.vo.VteBesoinEnteteQueryVO;
import com.yewi.yewicore.recuperation.vo.VteBesoinEnteteUpdateVO;
import com.yewi.yewicore.recuperation.vo.VteBesoinEnteteVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/vteBesoinEntete")
public class VteBesoinEnteteController {

    @Autowired
    private VteBesoinEnteteService vteBesoinEnteteService;

    @PostMapping
    public String save(@Valid @RequestBody VteBesoinEnteteVO vO) {
        return vteBesoinEnteteService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        vteBesoinEnteteService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody VteBesoinEnteteUpdateVO vO) {
        vteBesoinEnteteService.update(id, vO);
    }

    @GetMapping("/{id}")
    public VteBesoinEnteteDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return vteBesoinEnteteService.getById(id);
    }

    @GetMapping
    public Page<VteBesoinEnteteDTO> query(@Valid VteBesoinEnteteQueryVO vO) {
        return vteBesoinEnteteService.query(vO);
    }
}
