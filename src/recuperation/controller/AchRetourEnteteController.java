package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.AchRetourEnteteDTO;
import com.yewi.yewicore.recuperation.service.AchRetourEnteteService;
import com.yewi.yewicore.recuperation.vo.AchRetourEnteteQueryVO;
import com.yewi.yewicore.recuperation.vo.AchRetourEnteteUpdateVO;
import com.yewi.yewicore.recuperation.vo.AchRetourEnteteVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/achRetourEntete")
public class AchRetourEnteteController {

    @Autowired
    private AchRetourEnteteService achRetourEnteteService;

    @PostMapping
    public String save(@Valid @RequestBody AchRetourEnteteVO vO) {
        return achRetourEnteteService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        achRetourEnteteService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody AchRetourEnteteUpdateVO vO) {
        achRetourEnteteService.update(id, vO);
    }

    @GetMapping("/{id}")
    public AchRetourEnteteDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return achRetourEnteteService.getById(id);
    }

    @GetMapping
    public Page<AchRetourEnteteDTO> query(@Valid AchRetourEnteteQueryVO vO) {
        return achRetourEnteteService.query(vO);
    }
}
