package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.AchFamillesProduitsAchatsDTO;
import com.yewi.yewicore.recuperation.service.AchFamillesProduitsAchatsService;
import com.yewi.yewicore.recuperation.vo.AchFamillesProduitsAchatsQueryVO;
import com.yewi.yewicore.recuperation.vo.AchFamillesProduitsAchatsUpdateVO;
import com.yewi.yewicore.recuperation.vo.AchFamillesProduitsAchatsVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/achFamillesProduitsAchats")
public class AchFamillesProduitsAchatsController {

    @Autowired
    private AchFamillesProduitsAchatsService achFamillesProduitsAchatsService;

    @PostMapping
    public String save(@Valid @RequestBody AchFamillesProduitsAchatsVO vO) {
        return achFamillesProduitsAchatsService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        achFamillesProduitsAchatsService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody AchFamillesProduitsAchatsUpdateVO vO) {
        achFamillesProduitsAchatsService.update(id, vO);
    }

    @GetMapping("/{id}")
    public AchFamillesProduitsAchatsDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return achFamillesProduitsAchatsService.getById(id);
    }

    @GetMapping
    public Page<AchFamillesProduitsAchatsDTO> query(@Valid AchFamillesProduitsAchatsQueryVO vO) {
        return achFamillesProduitsAchatsService.query(vO);
    }
}
