package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.AchFraisLigneDTO;
import com.yewi.yewicore.recuperation.service.AchFraisLigneService;
import com.yewi.yewicore.recuperation.vo.AchFraisLigneQueryVO;
import com.yewi.yewicore.recuperation.vo.AchFraisLigneUpdateVO;
import com.yewi.yewicore.recuperation.vo.AchFraisLigneVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/achFraisLigne")
public class AchFraisLigneController {

    @Autowired
    private AchFraisLigneService achFraisLigneService;

    @PostMapping
    public String save(@Valid @RequestBody AchFraisLigneVO vO) {
        return achFraisLigneService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        achFraisLigneService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody AchFraisLigneUpdateVO vO) {
        achFraisLigneService.update(id, vO);
    }

    @GetMapping("/{id}")
    public AchFraisLigneDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return achFraisLigneService.getById(id);
    }

    @GetMapping
    public Page<AchFraisLigneDTO> query(@Valid AchFraisLigneQueryVO vO) {
        return achFraisLigneService.query(vO);
    }
}
