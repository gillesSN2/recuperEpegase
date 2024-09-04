package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.VteChargementEnteteDTO;
import com.yewi.yewicore.recuperation.service.VteChargementEnteteService;
import com.yewi.yewicore.recuperation.vo.VteChargementEnteteQueryVO;
import com.yewi.yewicore.recuperation.vo.VteChargementEnteteUpdateVO;
import com.yewi.yewicore.recuperation.vo.VteChargementEnteteVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/vteChargementEntete")
public class VteChargementEnteteController {

    @Autowired
    private VteChargementEnteteService vteChargementEnteteService;

    @PostMapping
    public String save(@Valid @RequestBody VteChargementEnteteVO vO) {
        return vteChargementEnteteService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        vteChargementEnteteService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody VteChargementEnteteUpdateVO vO) {
        vteChargementEnteteService.update(id, vO);
    }

    @GetMapping("/{id}")
    public VteChargementEnteteDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return vteChargementEnteteService.getById(id);
    }

    @GetMapping
    public Page<VteChargementEnteteDTO> query(@Valid VteChargementEnteteQueryVO vO) {
        return vteChargementEnteteService.query(vO);
    }
}
