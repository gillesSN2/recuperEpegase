package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.AchBonEntreeLigneDTO;
import com.yewi.yewicore.recuperation.service.AchBonEntreeLigneService;
import com.yewi.yewicore.recuperation.vo.AchBonEntreeLigneQueryVO;
import com.yewi.yewicore.recuperation.vo.AchBonEntreeLigneUpdateVO;
import com.yewi.yewicore.recuperation.vo.AchBonEntreeLigneVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/achBonEntreeLigne")
public class AchBonEntreeLigneController {

    @Autowired
    private AchBonEntreeLigneService achBonEntreeLigneService;

    @PostMapping
    public String save(@Valid @RequestBody AchBonEntreeLigneVO vO) {
        return achBonEntreeLigneService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        achBonEntreeLigneService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody AchBonEntreeLigneUpdateVO vO) {
        achBonEntreeLigneService.update(id, vO);
    }

    @GetMapping("/{id}")
    public AchBonEntreeLigneDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return achBonEntreeLigneService.getById(id);
    }

    @GetMapping
    public Page<AchBonEntreeLigneDTO> query(@Valid AchBonEntreeLigneQueryVO vO) {
        return achBonEntreeLigneService.query(vO);
    }
}
