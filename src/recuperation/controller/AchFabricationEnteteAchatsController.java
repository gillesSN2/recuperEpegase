package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.AchFabricationEnteteAchatsDTO;
import com.yewi.yewicore.recuperation.service.AchFabricationEnteteAchatsService;
import com.yewi.yewicore.recuperation.vo.AchFabricationEnteteAchatsQueryVO;
import com.yewi.yewicore.recuperation.vo.AchFabricationEnteteAchatsUpdateVO;
import com.yewi.yewicore.recuperation.vo.AchFabricationEnteteAchatsVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/achFabricationEnteteAchats")
public class AchFabricationEnteteAchatsController {

    @Autowired
    private AchFabricationEnteteAchatsService achFabricationEnteteAchatsService;

    @PostMapping
    public String save(@Valid @RequestBody AchFabricationEnteteAchatsVO vO) {
        return achFabricationEnteteAchatsService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        achFabricationEnteteAchatsService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody AchFabricationEnteteAchatsUpdateVO vO) {
        achFabricationEnteteAchatsService.update(id, vO);
    }

    @GetMapping("/{id}")
    public AchFabricationEnteteAchatsDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return achFabricationEnteteAchatsService.getById(id);
    }

    @GetMapping
    public Page<AchFabricationEnteteAchatsDTO> query(@Valid AchFabricationEnteteAchatsQueryVO vO) {
        return achFabricationEnteteAchatsService.query(vO);
    }
}
