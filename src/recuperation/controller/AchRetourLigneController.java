package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.AchRetourLigneDTO;
import com.yewi.yewicore.recuperation.service.AchRetourLigneService;
import com.yewi.yewicore.recuperation.vo.AchRetourLigneQueryVO;
import com.yewi.yewicore.recuperation.vo.AchRetourLigneUpdateVO;
import com.yewi.yewicore.recuperation.vo.AchRetourLigneVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/achRetourLigne")
public class AchRetourLigneController {

    @Autowired
    private AchRetourLigneService achRetourLigneService;

    @PostMapping
    public String save(@Valid @RequestBody AchRetourLigneVO vO) {
        return achRetourLigneService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        achRetourLigneService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody AchRetourLigneUpdateVO vO) {
        achRetourLigneService.update(id, vO);
    }

    @GetMapping("/{id}")
    public AchRetourLigneDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return achRetourLigneService.getById(id);
    }

    @GetMapping
    public Page<AchRetourLigneDTO> query(@Valid AchRetourLigneQueryVO vO) {
        return achRetourLigneService.query(vO);
    }
}
