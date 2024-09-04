package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.AchDemandeEnteteDTO;
import com.yewi.yewicore.recuperation.service.AchDemandeEnteteService;
import com.yewi.yewicore.recuperation.vo.AchDemandeEnteteQueryVO;
import com.yewi.yewicore.recuperation.vo.AchDemandeEnteteUpdateVO;
import com.yewi.yewicore.recuperation.vo.AchDemandeEnteteVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/achDemandeEntete")
public class AchDemandeEnteteController {

    @Autowired
    private AchDemandeEnteteService achDemandeEnteteService;

    @PostMapping
    public String save(@Valid @RequestBody AchDemandeEnteteVO vO) {
        return achDemandeEnteteService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        achDemandeEnteteService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody AchDemandeEnteteUpdateVO vO) {
        achDemandeEnteteService.update(id, vO);
    }

    @GetMapping("/{id}")
    public AchDemandeEnteteDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return achDemandeEnteteService.getById(id);
    }

    @GetMapping
    public Page<AchDemandeEnteteDTO> query(@Valid AchDemandeEnteteQueryVO vO) {
        return achDemandeEnteteService.query(vO);
    }
}
