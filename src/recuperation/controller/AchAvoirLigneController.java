package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.AchAvoirLigneDTO;
import com.yewi.yewicore.recuperation.service.AchAvoirLigneService;
import com.yewi.yewicore.recuperation.vo.AchAvoirLigneQueryVO;
import com.yewi.yewicore.recuperation.vo.AchAvoirLigneUpdateVO;
import com.yewi.yewicore.recuperation.vo.AchAvoirLigneVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/achAvoirLigne")
public class AchAvoirLigneController {

    @Autowired
    private AchAvoirLigneService achAvoirLigneService;

    @PostMapping
    public String save(@Valid @RequestBody AchAvoirLigneVO vO) {
        return achAvoirLigneService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        achAvoirLigneService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody AchAvoirLigneUpdateVO vO) {
        achAvoirLigneService.update(id, vO);
    }

    @GetMapping("/{id}")
    public AchAvoirLigneDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return achAvoirLigneService.getById(id);
    }

    @GetMapping
    public Page<AchAvoirLigneDTO> query(@Valid AchAvoirLigneQueryVO vO) {
        return achAvoirLigneService.query(vO);
    }
}
