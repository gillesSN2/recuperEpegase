package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.AchExercicesAchatsDTO;
import com.yewi.yewicore.recuperation.service.AchExercicesAchatsService;
import com.yewi.yewicore.recuperation.vo.AchExercicesAchatsQueryVO;
import com.yewi.yewicore.recuperation.vo.AchExercicesAchatsUpdateVO;
import com.yewi.yewicore.recuperation.vo.AchExercicesAchatsVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/achExercicesAchats")
public class AchExercicesAchatsController {

    @Autowired
    private AchExercicesAchatsService achExercicesAchatsService;

    @PostMapping
    public String save(@Valid @RequestBody AchExercicesAchatsVO vO) {
        return achExercicesAchatsService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        achExercicesAchatsService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody AchExercicesAchatsUpdateVO vO) {
        achExercicesAchatsService.update(id, vO);
    }

    @GetMapping("/{id}")
    public AchExercicesAchatsDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return achExercicesAchatsService.getById(id);
    }

    @GetMapping
    public Page<AchExercicesAchatsDTO> query(@Valid AchExercicesAchatsQueryVO vO) {
        return achExercicesAchatsService.query(vO);
    }
}
