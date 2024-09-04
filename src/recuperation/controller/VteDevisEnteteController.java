package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.VteDevisEnteteDTO;
import com.yewi.yewicore.recuperation.service.VteDevisEnteteService;
import com.yewi.yewicore.recuperation.vo.VteDevisEnteteQueryVO;
import com.yewi.yewicore.recuperation.vo.VteDevisEnteteUpdateVO;
import com.yewi.yewicore.recuperation.vo.VteDevisEnteteVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/vteDevisEntete")
public class VteDevisEnteteController {

    @Autowired
    private VteDevisEnteteService vteDevisEnteteService;

    @PostMapping
    public String save(@Valid @RequestBody VteDevisEnteteVO vO) {
        return vteDevisEnteteService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        vteDevisEnteteService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody VteDevisEnteteUpdateVO vO) {
        vteDevisEnteteService.update(id, vO);
    }

    @GetMapping("/{id}")
    public VteDevisEnteteDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return vteDevisEnteteService.getById(id);
    }

    @GetMapping
    public Page<VteDevisEnteteDTO> query(@Valid VteDevisEnteteQueryVO vO) {
        return vteDevisEnteteService.query(vO);
    }
}
