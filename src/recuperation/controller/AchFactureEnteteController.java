package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.AchFactureEnteteDTO;
import com.yewi.yewicore.recuperation.service.AchFactureEnteteService;
import com.yewi.yewicore.recuperation.vo.AchFactureEnteteQueryVO;
import com.yewi.yewicore.recuperation.vo.AchFactureEnteteUpdateVO;
import com.yewi.yewicore.recuperation.vo.AchFactureEnteteVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/achFactureEntete")
public class AchFactureEnteteController {

    @Autowired
    private AchFactureEnteteService achFactureEnteteService;

    @PostMapping
    public String save(@Valid @RequestBody AchFactureEnteteVO vO) {
        return achFactureEnteteService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        achFactureEnteteService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody AchFactureEnteteUpdateVO vO) {
        achFactureEnteteService.update(id, vO);
    }

    @GetMapping("/{id}")
    public AchFactureEnteteDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return achFactureEnteteService.getById(id);
    }

    @GetMapping
    public Page<AchFactureEnteteDTO> query(@Valid AchFactureEnteteQueryVO vO) {
        return achFactureEnteteService.query(vO);
    }
}
