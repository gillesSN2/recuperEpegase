package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.AchDemandeLigneDTO;
import com.yewi.yewicore.recuperation.service.AchDemandeLigneService;
import com.yewi.yewicore.recuperation.vo.AchDemandeLigneQueryVO;
import com.yewi.yewicore.recuperation.vo.AchDemandeLigneUpdateVO;
import com.yewi.yewicore.recuperation.vo.AchDemandeLigneVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/achDemandeLigne")
public class AchDemandeLigneController {

    @Autowired
    private AchDemandeLigneService achDemandeLigneService;

    @PostMapping
    public String save(@Valid @RequestBody AchDemandeLigneVO vO) {
        return achDemandeLigneService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        achDemandeLigneService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody AchDemandeLigneUpdateVO vO) {
        achDemandeLigneService.update(id, vO);
    }

    @GetMapping("/{id}")
    public AchDemandeLigneDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return achDemandeLigneService.getById(id);
    }

    @GetMapping
    public Page<AchDemandeLigneDTO> query(@Valid AchDemandeLigneQueryVO vO) {
        return achDemandeLigneService.query(vO);
    }
}
