package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.AchAvoirEnteteDTO;
import com.yewi.yewicore.recuperation.service.AchAvoirEnteteService;
import com.yewi.yewicore.recuperation.vo.AchAvoirEnteteQueryVO;
import com.yewi.yewicore.recuperation.vo.AchAvoirEnteteUpdateVO;
import com.yewi.yewicore.recuperation.vo.AchAvoirEnteteVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/achAvoirEntete")
public class AchAvoirEnteteController {

    @Autowired
    private AchAvoirEnteteService achAvoirEnteteService;

    @PostMapping
    public String save(@Valid @RequestBody AchAvoirEnteteVO vO) {
        return achAvoirEnteteService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        achAvoirEnteteService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody AchAvoirEnteteUpdateVO vO) {
        achAvoirEnteteService.update(id, vO);
    }

    @GetMapping("/{id}")
    public AchAvoirEnteteDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return achAvoirEnteteService.getById(id);
    }

    @GetMapping
    public Page<AchAvoirEnteteDTO> query(@Valid AchAvoirEnteteQueryVO vO) {
        return achAvoirEnteteService.query(vO);
    }
}
