package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.AchSommierEnteteDTO;
import com.yewi.yewicore.recuperation.service.AchSommierEnteteService;
import com.yewi.yewicore.recuperation.vo.AchSommierEnteteQueryVO;
import com.yewi.yewicore.recuperation.vo.AchSommierEnteteUpdateVO;
import com.yewi.yewicore.recuperation.vo.AchSommierEnteteVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/achSommierEntete")
public class AchSommierEnteteController {

    @Autowired
    private AchSommierEnteteService achSommierEnteteService;

    @PostMapping
    public String save(@Valid @RequestBody AchSommierEnteteVO vO) {
        return achSommierEnteteService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        achSommierEnteteService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody AchSommierEnteteUpdateVO vO) {
        achSommierEnteteService.update(id, vO);
    }

    @GetMapping("/{id}")
    public AchSommierEnteteDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return achSommierEnteteService.getById(id);
    }

    @GetMapping
    public Page<AchSommierEnteteDTO> query(@Valid AchSommierEnteteQueryVO vO) {
        return achSommierEnteteService.query(vO);
    }
}
