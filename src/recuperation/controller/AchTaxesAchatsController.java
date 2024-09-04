package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.AchTaxesAchatsDTO;
import com.yewi.yewicore.recuperation.service.AchTaxesAchatsService;
import com.yewi.yewicore.recuperation.vo.AchTaxesAchatsQueryVO;
import com.yewi.yewicore.recuperation.vo.AchTaxesAchatsUpdateVO;
import com.yewi.yewicore.recuperation.vo.AchTaxesAchatsVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/achTaxesAchats")
public class AchTaxesAchatsController {

    @Autowired
    private AchTaxesAchatsService achTaxesAchatsService;

    @PostMapping
    public String save(@Valid @RequestBody AchTaxesAchatsVO vO) {
        return achTaxesAchatsService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        achTaxesAchatsService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody AchTaxesAchatsUpdateVO vO) {
        achTaxesAchatsService.update(id, vO);
    }

    @GetMapping("/{id}")
    public AchTaxesAchatsDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return achTaxesAchatsService.getById(id);
    }

    @GetMapping
    public Page<AchTaxesAchatsDTO> query(@Valid AchTaxesAchatsQueryVO vO) {
        return achTaxesAchatsService.query(vO);
    }
}
