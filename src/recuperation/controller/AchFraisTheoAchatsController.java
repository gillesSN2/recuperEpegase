package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.AchFraisTheoAchatsDTO;
import com.yewi.yewicore.recuperation.service.AchFraisTheoAchatsService;
import com.yewi.yewicore.recuperation.vo.AchFraisTheoAchatsQueryVO;
import com.yewi.yewicore.recuperation.vo.AchFraisTheoAchatsUpdateVO;
import com.yewi.yewicore.recuperation.vo.AchFraisTheoAchatsVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/achFraisTheoAchats")
public class AchFraisTheoAchatsController {

    @Autowired
    private AchFraisTheoAchatsService achFraisTheoAchatsService;

    @PostMapping
    public String save(@Valid @RequestBody AchFraisTheoAchatsVO vO) {
        return achFraisTheoAchatsService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        achFraisTheoAchatsService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody AchFraisTheoAchatsUpdateVO vO) {
        achFraisTheoAchatsService.update(id, vO);
    }

    @GetMapping("/{id}")
    public AchFraisTheoAchatsDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return achFraisTheoAchatsService.getById(id);
    }

    @GetMapping
    public Page<AchFraisTheoAchatsDTO> query(@Valid AchFraisTheoAchatsQueryVO vO) {
        return achFraisTheoAchatsService.query(vO);
    }
}
