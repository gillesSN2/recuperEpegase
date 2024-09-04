package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.AchCommandeLigneDTO;
import com.yewi.yewicore.recuperation.service.AchCommandeLigneService;
import com.yewi.yewicore.recuperation.vo.AchCommandeLigneQueryVO;
import com.yewi.yewicore.recuperation.vo.AchCommandeLigneUpdateVO;
import com.yewi.yewicore.recuperation.vo.AchCommandeLigneVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/achCommandeLigne")
public class AchCommandeLigneController {

    @Autowired
    private AchCommandeLigneService achCommandeLigneService;

    @PostMapping
    public String save(@Valid @RequestBody AchCommandeLigneVO vO) {
        return achCommandeLigneService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        achCommandeLigneService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody AchCommandeLigneUpdateVO vO) {
        achCommandeLigneService.update(id, vO);
    }

    @GetMapping("/{id}")
    public AchCommandeLigneDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return achCommandeLigneService.getById(id);
    }

    @GetMapping
    public Page<AchCommandeLigneDTO> query(@Valid AchCommandeLigneQueryVO vO) {
        return achCommandeLigneService.query(vO);
    }
}
