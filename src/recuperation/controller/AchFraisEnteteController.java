package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.AchFraisEnteteDTO;
import com.yewi.yewicore.recuperation.service.AchFraisEnteteService;
import com.yewi.yewicore.recuperation.vo.AchFraisEnteteQueryVO;
import com.yewi.yewicore.recuperation.vo.AchFraisEnteteUpdateVO;
import com.yewi.yewicore.recuperation.vo.AchFraisEnteteVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/achFraisEntete")
public class AchFraisEnteteController {

    @Autowired
    private AchFraisEnteteService achFraisEnteteService;

    @PostMapping
    public String save(@Valid @RequestBody AchFraisEnteteVO vO) {
        return achFraisEnteteService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        achFraisEnteteService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody AchFraisEnteteUpdateVO vO) {
        achFraisEnteteService.update(id, vO);
    }

    @GetMapping("/{id}")
    public AchFraisEnteteDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return achFraisEnteteService.getById(id);
    }

    @GetMapping
    public Page<AchFraisEnteteDTO> query(@Valid AchFraisEnteteQueryVO vO) {
        return achFraisEnteteService.query(vO);
    }
}
