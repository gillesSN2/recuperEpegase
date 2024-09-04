package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.AchCessionLigneDTO;
import com.yewi.yewicore.recuperation.service.AchCessionLigneService;
import com.yewi.yewicore.recuperation.vo.AchCessionLigneQueryVO;
import com.yewi.yewicore.recuperation.vo.AchCessionLigneUpdateVO;
import com.yewi.yewicore.recuperation.vo.AchCessionLigneVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/achCessionLigne")
public class AchCessionLigneController {

    @Autowired
    private AchCessionLigneService achCessionLigneService;

    @PostMapping
    public String save(@Valid @RequestBody AchCessionLigneVO vO) {
        return achCessionLigneService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        achCessionLigneService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody AchCessionLigneUpdateVO vO) {
        achCessionLigneService.update(id, vO);
    }

    @GetMapping("/{id}")
    public AchCessionLigneDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return achCessionLigneService.getById(id);
    }

    @GetMapping
    public Page<AchCessionLigneDTO> query(@Valid AchCessionLigneQueryVO vO) {
        return achCessionLigneService.query(vO);
    }
}
