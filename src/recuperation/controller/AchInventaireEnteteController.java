package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.AchInventaireEnteteDTO;
import com.yewi.yewicore.recuperation.service.AchInventaireEnteteService;
import com.yewi.yewicore.recuperation.vo.AchInventaireEnteteQueryVO;
import com.yewi.yewicore.recuperation.vo.AchInventaireEnteteUpdateVO;
import com.yewi.yewicore.recuperation.vo.AchInventaireEnteteVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/achInventaireEntete")
public class AchInventaireEnteteController {

    @Autowired
    private AchInventaireEnteteService achInventaireEnteteService;

    @PostMapping
    public String save(@Valid @RequestBody AchInventaireEnteteVO vO) {
        return achInventaireEnteteService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        achInventaireEnteteService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody AchInventaireEnteteUpdateVO vO) {
        achInventaireEnteteService.update(id, vO);
    }

    @GetMapping("/{id}")
    public AchInventaireEnteteDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return achInventaireEnteteService.getById(id);
    }

    @GetMapping
    public Page<AchInventaireEnteteDTO> query(@Valid AchInventaireEnteteQueryVO vO) {
        return achInventaireEnteteService.query(vO);
    }
}
