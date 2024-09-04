package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.AchFabricationLigneAchatsDTO;
import com.yewi.yewicore.recuperation.service.AchFabricationLigneAchatsService;
import com.yewi.yewicore.recuperation.vo.AchFabricationLigneAchatsQueryVO;
import com.yewi.yewicore.recuperation.vo.AchFabricationLigneAchatsUpdateVO;
import com.yewi.yewicore.recuperation.vo.AchFabricationLigneAchatsVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/achFabricationLigneAchats")
public class AchFabricationLigneAchatsController {

    @Autowired
    private AchFabricationLigneAchatsService achFabricationLigneAchatsService;

    @PostMapping
    public String save(@Valid @RequestBody AchFabricationLigneAchatsVO vO) {
        return achFabricationLigneAchatsService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        achFabricationLigneAchatsService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody AchFabricationLigneAchatsUpdateVO vO) {
        achFabricationLigneAchatsService.update(id, vO);
    }

    @GetMapping("/{id}")
    public AchFabricationLigneAchatsDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return achFabricationLigneAchatsService.getById(id);
    }

    @GetMapping
    public Page<AchFabricationLigneAchatsDTO> query(@Valid AchFabricationLigneAchatsQueryVO vO) {
        return achFabricationLigneAchatsService.query(vO);
    }
}
