package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.VteContratEnteteDTO;
import com.yewi.yewicore.recuperation.service.VteContratEnteteService;
import com.yewi.yewicore.recuperation.vo.VteContratEnteteQueryVO;
import com.yewi.yewicore.recuperation.vo.VteContratEnteteUpdateVO;
import com.yewi.yewicore.recuperation.vo.VteContratEnteteVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/vteContratEntete")
public class VteContratEnteteController {

    @Autowired
    private VteContratEnteteService vteContratEnteteService;

    @PostMapping
    public String save(@Valid @RequestBody VteContratEnteteVO vO) {
        return vteContratEnteteService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        vteContratEnteteService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody VteContratEnteteUpdateVO vO) {
        vteContratEnteteService.update(id, vO);
    }

    @GetMapping("/{id}")
    public VteContratEnteteDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return vteContratEnteteService.getById(id);
    }

    @GetMapping
    public Page<VteContratEnteteDTO> query(@Valid VteContratEnteteQueryVO vO) {
        return vteContratEnteteService.query(vO);
    }
}
