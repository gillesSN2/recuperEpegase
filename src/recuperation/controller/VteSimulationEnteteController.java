package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.VteSimulationEnteteDTO;
import com.yewi.yewicore.recuperation.service.VteSimulationEnteteService;
import com.yewi.yewicore.recuperation.vo.VteSimulationEnteteQueryVO;
import com.yewi.yewicore.recuperation.vo.VteSimulationEnteteUpdateVO;
import com.yewi.yewicore.recuperation.vo.VteSimulationEnteteVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/vteSimulationEntete")
public class VteSimulationEnteteController {

    @Autowired
    private VteSimulationEnteteService vteSimulationEnteteService;

    @PostMapping
    public String save(@Valid @RequestBody VteSimulationEnteteVO vO) {
        return vteSimulationEnteteService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        vteSimulationEnteteService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody VteSimulationEnteteUpdateVO vO) {
        vteSimulationEnteteService.update(id, vO);
    }

    @GetMapping("/{id}")
    public VteSimulationEnteteDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return vteSimulationEnteteService.getById(id);
    }

    @GetMapping
    public Page<VteSimulationEnteteDTO> query(@Valid VteSimulationEnteteQueryVO vO) {
        return vteSimulationEnteteService.query(vO);
    }
}
