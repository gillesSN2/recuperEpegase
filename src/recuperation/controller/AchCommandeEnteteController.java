package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.AchCommandeEnteteDTO;
import com.yewi.yewicore.recuperation.service.AchCommandeEnteteService;
import com.yewi.yewicore.recuperation.vo.AchCommandeEnteteQueryVO;
import com.yewi.yewicore.recuperation.vo.AchCommandeEnteteUpdateVO;
import com.yewi.yewicore.recuperation.vo.AchCommandeEnteteVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/achCommandeEntete")
public class AchCommandeEnteteController {

    @Autowired
    private AchCommandeEnteteService achCommandeEnteteService;

    @PostMapping
    public String save(@Valid @RequestBody AchCommandeEnteteVO vO) {
        return achCommandeEnteteService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        achCommandeEnteteService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody AchCommandeEnteteUpdateVO vO) {
        achCommandeEnteteService.update(id, vO);
    }

    @GetMapping("/{id}")
    public AchCommandeEnteteDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return achCommandeEnteteService.getById(id);
    }

    @GetMapping
    public Page<AchCommandeEnteteDTO> query(@Valid AchCommandeEnteteQueryVO vO) {
        return achCommandeEnteteService.query(vO);
    }
}
