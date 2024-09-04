package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.AchFactureLigneDTO;
import com.yewi.yewicore.recuperation.service.AchFactureLigneService;
import com.yewi.yewicore.recuperation.vo.AchFactureLigneQueryVO;
import com.yewi.yewicore.recuperation.vo.AchFactureLigneUpdateVO;
import com.yewi.yewicore.recuperation.vo.AchFactureLigneVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/achFactureLigne")
public class AchFactureLigneController {

    @Autowired
    private AchFactureLigneService achFactureLigneService;

    @PostMapping
    public String save(@Valid @RequestBody AchFactureLigneVO vO) {
        return achFactureLigneService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        achFactureLigneService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody AchFactureLigneUpdateVO vO) {
        achFactureLigneService.update(id, vO);
    }

    @GetMapping("/{id}")
    public AchFactureLigneDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return achFactureLigneService.getById(id);
    }

    @GetMapping
    public Page<AchFactureLigneDTO> query(@Valid AchFactureLigneQueryVO vO) {
        return achFactureLigneService.query(vO);
    }
}
