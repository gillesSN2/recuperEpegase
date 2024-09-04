package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.AchReceptionEnteteDTO;
import com.yewi.yewicore.recuperation.service.AchReceptionEnteteService;
import com.yewi.yewicore.recuperation.vo.AchReceptionEnteteQueryVO;
import com.yewi.yewicore.recuperation.vo.AchReceptionEnteteUpdateVO;
import com.yewi.yewicore.recuperation.vo.AchReceptionEnteteVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/achReceptionEntete")
public class AchReceptionEnteteController {

    @Autowired
    private AchReceptionEnteteService achReceptionEnteteService;

    @PostMapping
    public String save(@Valid @RequestBody AchReceptionEnteteVO vO) {
        return achReceptionEnteteService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        achReceptionEnteteService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody AchReceptionEnteteUpdateVO vO) {
        achReceptionEnteteService.update(id, vO);
    }

    @GetMapping("/{id}")
    public AchReceptionEnteteDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return achReceptionEnteteService.getById(id);
    }

    @GetMapping
    public Page<AchReceptionEnteteDTO> query(@Valid AchReceptionEnteteQueryVO vO) {
        return achReceptionEnteteService.query(vO);
    }
}
