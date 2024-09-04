package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.AchFormulesAchatsDTO;
import com.yewi.yewicore.recuperation.service.AchFormulesAchatsService;
import com.yewi.yewicore.recuperation.vo.AchFormulesAchatsQueryVO;
import com.yewi.yewicore.recuperation.vo.AchFormulesAchatsUpdateVO;
import com.yewi.yewicore.recuperation.vo.AchFormulesAchatsVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/achFormulesAchats")
public class AchFormulesAchatsController {

    @Autowired
    private AchFormulesAchatsService achFormulesAchatsService;

    @PostMapping
    public String save(@Valid @RequestBody AchFormulesAchatsVO vO) {
        return achFormulesAchatsService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        achFormulesAchatsService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody AchFormulesAchatsUpdateVO vO) {
        achFormulesAchatsService.update(id, vO);
    }

    @GetMapping("/{id}")
    public AchFormulesAchatsDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return achFormulesAchatsService.getById(id);
    }

    @GetMapping
    public Page<AchFormulesAchatsDTO> query(@Valid AchFormulesAchatsQueryVO vO) {
        return achFormulesAchatsService.query(vO);
    }
}
