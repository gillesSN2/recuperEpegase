package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.VteChargementFraisDTO;
import com.yewi.yewicore.recuperation.service.VteChargementFraisService;
import com.yewi.yewicore.recuperation.vo.VteChargementFraisQueryVO;
import com.yewi.yewicore.recuperation.vo.VteChargementFraisUpdateVO;
import com.yewi.yewicore.recuperation.vo.VteChargementFraisVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/vteChargementFrais")
public class VteChargementFraisController {

    @Autowired
    private VteChargementFraisService vteChargementFraisService;

    @PostMapping
    public String save(@Valid @RequestBody VteChargementFraisVO vO) {
        return vteChargementFraisService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        vteChargementFraisService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody VteChargementFraisUpdateVO vO) {
        vteChargementFraisService.update(id, vO);
    }

    @GetMapping("/{id}")
    public VteChargementFraisDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return vteChargementFraisService.getById(id);
    }

    @GetMapping
    public Page<VteChargementFraisDTO> query(@Valid VteChargementFraisQueryVO vO) {
        return vteChargementFraisService.query(vO);
    }
}
