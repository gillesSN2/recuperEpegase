package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.AchSuiviCommandeAchatsDTO;
import com.yewi.yewicore.recuperation.service.AchSuiviCommandeAchatsService;
import com.yewi.yewicore.recuperation.vo.AchSuiviCommandeAchatsQueryVO;
import com.yewi.yewicore.recuperation.vo.AchSuiviCommandeAchatsUpdateVO;
import com.yewi.yewicore.recuperation.vo.AchSuiviCommandeAchatsVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/achSuiviCommandeAchats")
public class AchSuiviCommandeAchatsController {

    @Autowired
    private AchSuiviCommandeAchatsService achSuiviCommandeAchatsService;

    @PostMapping
    public String save(@Valid @RequestBody AchSuiviCommandeAchatsVO vO) {
        return achSuiviCommandeAchatsService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        achSuiviCommandeAchatsService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody AchSuiviCommandeAchatsUpdateVO vO) {
        achSuiviCommandeAchatsService.update(id, vO);
    }

    @GetMapping("/{id}")
    public AchSuiviCommandeAchatsDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return achSuiviCommandeAchatsService.getById(id);
    }

    @GetMapping
    public Page<AchSuiviCommandeAchatsDTO> query(@Valid AchSuiviCommandeAchatsQueryVO vO) {
        return achSuiviCommandeAchatsService.query(vO);
    }
}
