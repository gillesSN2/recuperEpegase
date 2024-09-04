package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.AchBonDecaissementDTO;
import com.yewi.yewicore.recuperation.service.AchBonDecaissementService;
import com.yewi.yewicore.recuperation.vo.AchBonDecaissementQueryVO;
import com.yewi.yewicore.recuperation.vo.AchBonDecaissementUpdateVO;
import com.yewi.yewicore.recuperation.vo.AchBonDecaissementVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/achBonDecaissement")
public class AchBonDecaissementController {

    @Autowired
    private AchBonDecaissementService achBonDecaissementService;

    @PostMapping
    public String save(@Valid @RequestBody AchBonDecaissementVO vO) {
        return achBonDecaissementService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        achBonDecaissementService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody AchBonDecaissementUpdateVO vO) {
        achBonDecaissementService.update(id, vO);
    }

    @GetMapping("/{id}")
    public AchBonDecaissementDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return achBonDecaissementService.getById(id);
    }

    @GetMapping
    public Page<AchBonDecaissementDTO> query(@Valid AchBonDecaissementQueryVO vO) {
        return achBonDecaissementService.query(vO);
    }
}
