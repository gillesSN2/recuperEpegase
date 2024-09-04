package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.AchBonSortieEnteteDTO;
import com.yewi.yewicore.recuperation.service.AchBonSortieEnteteService;
import com.yewi.yewicore.recuperation.vo.AchBonSortieEnteteQueryVO;
import com.yewi.yewicore.recuperation.vo.AchBonSortieEnteteUpdateVO;
import com.yewi.yewicore.recuperation.vo.AchBonSortieEnteteVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/achBonSortieEntete")
public class AchBonSortieEnteteController {

    @Autowired
    private AchBonSortieEnteteService achBonSortieEnteteService;

    @PostMapping
    public String save(@Valid @RequestBody AchBonSortieEnteteVO vO) {
        return achBonSortieEnteteService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        achBonSortieEnteteService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody AchBonSortieEnteteUpdateVO vO) {
        achBonSortieEnteteService.update(id, vO);
    }

    @GetMapping("/{id}")
    public AchBonSortieEnteteDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return achBonSortieEnteteService.getById(id);
    }

    @GetMapping
    public Page<AchBonSortieEnteteDTO> query(@Valid AchBonSortieEnteteQueryVO vO) {
        return achBonSortieEnteteService.query(vO);
    }
}
