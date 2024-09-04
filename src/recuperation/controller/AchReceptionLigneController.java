package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.AchReceptionLigneDTO;
import com.yewi.yewicore.recuperation.service.AchReceptionLigneService;
import com.yewi.yewicore.recuperation.vo.AchReceptionLigneQueryVO;
import com.yewi.yewicore.recuperation.vo.AchReceptionLigneUpdateVO;
import com.yewi.yewicore.recuperation.vo.AchReceptionLigneVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/achReceptionLigne")
public class AchReceptionLigneController {

    @Autowired
    private AchReceptionLigneService achReceptionLigneService;

    @PostMapping
    public String save(@Valid @RequestBody AchReceptionLigneVO vO) {
        return achReceptionLigneService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        achReceptionLigneService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody AchReceptionLigneUpdateVO vO) {
        achReceptionLigneService.update(id, vO);
    }

    @GetMapping("/{id}")
    public AchReceptionLigneDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return achReceptionLigneService.getById(id);
    }

    @GetMapping
    public Page<AchReceptionLigneDTO> query(@Valid AchReceptionLigneQueryVO vO) {
        return achReceptionLigneService.query(vO);
    }
}
