package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.AchCessionEnteteDTO;
import com.yewi.yewicore.recuperation.service.AchCessionEnteteService;
import com.yewi.yewicore.recuperation.vo.AchCessionEnteteQueryVO;
import com.yewi.yewicore.recuperation.vo.AchCessionEnteteUpdateVO;
import com.yewi.yewicore.recuperation.vo.AchCessionEnteteVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/achCessionEntete")
public class AchCessionEnteteController {

    @Autowired
    private AchCessionEnteteService achCessionEnteteService;

    @PostMapping
    public String save(@Valid @RequestBody AchCessionEnteteVO vO) {
        return achCessionEnteteService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        achCessionEnteteService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody AchCessionEnteteUpdateVO vO) {
        achCessionEnteteService.update(id, vO);
    }

    @GetMapping("/{id}")
    public AchCessionEnteteDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return achCessionEnteteService.getById(id);
    }

    @GetMapping
    public Page<AchCessionEnteteDTO> query(@Valid AchCessionEnteteQueryVO vO) {
        return achCessionEnteteService.query(vO);
    }
}
