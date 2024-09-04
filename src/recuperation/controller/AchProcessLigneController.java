package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.AchProcessLigneDTO;
import com.yewi.yewicore.recuperation.service.AchProcessLigneService;
import com.yewi.yewicore.recuperation.vo.AchProcessLigneQueryVO;
import com.yewi.yewicore.recuperation.vo.AchProcessLigneUpdateVO;
import com.yewi.yewicore.recuperation.vo.AchProcessLigneVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/achProcessLigne")
public class AchProcessLigneController {

    @Autowired
    private AchProcessLigneService achProcessLigneService;

    @PostMapping
    public String save(@Valid @RequestBody AchProcessLigneVO vO) {
        return achProcessLigneService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        achProcessLigneService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody AchProcessLigneUpdateVO vO) {
        achProcessLigneService.update(id, vO);
    }

    @GetMapping("/{id}")
    public AchProcessLigneDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return achProcessLigneService.getById(id);
    }

    @GetMapping
    public Page<AchProcessLigneDTO> query(@Valid AchProcessLigneQueryVO vO) {
        return achProcessLigneService.query(vO);
    }
}
