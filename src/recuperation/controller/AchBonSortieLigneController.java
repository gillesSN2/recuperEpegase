package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.AchBonSortieLigneDTO;
import com.yewi.yewicore.recuperation.service.AchBonSortieLigneService;
import com.yewi.yewicore.recuperation.vo.AchBonSortieLigneQueryVO;
import com.yewi.yewicore.recuperation.vo.AchBonSortieLigneUpdateVO;
import com.yewi.yewicore.recuperation.vo.AchBonSortieLigneVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/achBonSortieLigne")
public class AchBonSortieLigneController {

    @Autowired
    private AchBonSortieLigneService achBonSortieLigneService;

    @PostMapping
    public String save(@Valid @RequestBody AchBonSortieLigneVO vO) {
        return achBonSortieLigneService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        achBonSortieLigneService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody AchBonSortieLigneUpdateVO vO) {
        achBonSortieLigneService.update(id, vO);
    }

    @GetMapping("/{id}")
    public AchBonSortieLigneDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return achBonSortieLigneService.getById(id);
    }

    @GetMapping
    public Page<AchBonSortieLigneDTO> query(@Valid AchBonSortieLigneQueryVO vO) {
        return achBonSortieLigneService.query(vO);
    }
}
