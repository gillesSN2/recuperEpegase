package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.AchProcessEnteteDTO;
import com.yewi.yewicore.recuperation.service.AchProcessEnteteService;
import com.yewi.yewicore.recuperation.vo.AchProcessEnteteQueryVO;
import com.yewi.yewicore.recuperation.vo.AchProcessEnteteUpdateVO;
import com.yewi.yewicore.recuperation.vo.AchProcessEnteteVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/achProcessEntete")
public class AchProcessEnteteController {

    @Autowired
    private AchProcessEnteteService achProcessEnteteService;

    @PostMapping
    public String save(@Valid @RequestBody AchProcessEnteteVO vO) {
        return achProcessEnteteService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        achProcessEnteteService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody AchProcessEnteteUpdateVO vO) {
        achProcessEnteteService.update(id, vO);
    }

    @GetMapping("/{id}")
    public AchProcessEnteteDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return achProcessEnteteService.getById(id);
    }

    @GetMapping
    public Page<AchProcessEnteteDTO> query(@Valid AchProcessEnteteQueryVO vO) {
        return achProcessEnteteService.query(vO);
    }
}
