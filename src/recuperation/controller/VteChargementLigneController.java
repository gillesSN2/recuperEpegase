package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.VteChargementLigneDTO;
import com.yewi.yewicore.recuperation.service.VteChargementLigneService;
import com.yewi.yewicore.recuperation.vo.VteChargementLigneQueryVO;
import com.yewi.yewicore.recuperation.vo.VteChargementLigneUpdateVO;
import com.yewi.yewicore.recuperation.vo.VteChargementLigneVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/vteChargementLigne")
public class VteChargementLigneController {

    @Autowired
    private VteChargementLigneService vteChargementLigneService;

    @PostMapping
    public String save(@Valid @RequestBody VteChargementLigneVO vO) {
        return vteChargementLigneService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        vteChargementLigneService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody VteChargementLigneUpdateVO vO) {
        vteChargementLigneService.update(id, vO);
    }

    @GetMapping("/{id}")
    public VteChargementLigneDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return vteChargementLigneService.getById(id);
    }

    @GetMapping
    public Page<VteChargementLigneDTO> query(@Valid VteChargementLigneQueryVO vO) {
        return vteChargementLigneService.query(vO);
    }
}
