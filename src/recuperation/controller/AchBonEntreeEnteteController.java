package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.AchBonEntreeEnteteDTO;
import com.yewi.yewicore.recuperation.service.AchBonEntreeEnteteService;
import com.yewi.yewicore.recuperation.vo.AchBonEntreeEnteteQueryVO;
import com.yewi.yewicore.recuperation.vo.AchBonEntreeEnteteUpdateVO;
import com.yewi.yewicore.recuperation.vo.AchBonEntreeEnteteVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/achBonEntreeEntete")
public class AchBonEntreeEnteteController {

    @Autowired
    private AchBonEntreeEnteteService achBonEntreeEnteteService;

    @PostMapping
    public String save(@Valid @RequestBody AchBonEntreeEnteteVO vO) {
        return achBonEntreeEnteteService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        achBonEntreeEnteteService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody AchBonEntreeEnteteUpdateVO vO) {
        achBonEntreeEnteteService.update(id, vO);
    }

    @GetMapping("/{id}")
    public AchBonEntreeEnteteDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return achBonEntreeEnteteService.getById(id);
    }

    @GetMapping
    public Page<AchBonEntreeEnteteDTO> query(@Valid AchBonEntreeEnteteQueryVO vO) {
        return achBonEntreeEnteteService.query(vO);
    }
}
