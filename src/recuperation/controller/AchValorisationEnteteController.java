package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.AchValorisationEnteteDTO;
import com.yewi.yewicore.recuperation.service.AchValorisationEnteteService;
import com.yewi.yewicore.recuperation.vo.AchValorisationEnteteQueryVO;
import com.yewi.yewicore.recuperation.vo.AchValorisationEnteteUpdateVO;
import com.yewi.yewicore.recuperation.vo.AchValorisationEnteteVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/achValorisationEntete")
public class AchValorisationEnteteController {

    @Autowired
    private AchValorisationEnteteService achValorisationEnteteService;

    @PostMapping
    public String save(@Valid @RequestBody AchValorisationEnteteVO vO) {
        return achValorisationEnteteService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        achValorisationEnteteService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody AchValorisationEnteteUpdateVO vO) {
        achValorisationEnteteService.update(id, vO);
    }

    @GetMapping("/{id}")
    public AchValorisationEnteteDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return achValorisationEnteteService.getById(id);
    }

    @GetMapping
    public Page<AchValorisationEnteteDTO> query(@Valid AchValorisationEnteteQueryVO vO) {
        return achValorisationEnteteService.query(vO);
    }
}
