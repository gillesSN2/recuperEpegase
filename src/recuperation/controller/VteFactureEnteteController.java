package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.VteFactureEnteteDTO;
import com.yewi.yewicore.recuperation.service.VteFactureEnteteService;
import com.yewi.yewicore.recuperation.vo.VteFactureEnteteQueryVO;
import com.yewi.yewicore.recuperation.vo.VteFactureEnteteUpdateVO;
import com.yewi.yewicore.recuperation.vo.VteFactureEnteteVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/vteFactureEntete")
public class VteFactureEnteteController {

    @Autowired
    private VteFactureEnteteService vteFactureEnteteService;

    @PostMapping
    public String save(@Valid @RequestBody VteFactureEnteteVO vO) {
        return vteFactureEnteteService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        vteFactureEnteteService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody VteFactureEnteteUpdateVO vO) {
        vteFactureEnteteService.update(id, vO);
    }

    @GetMapping("/{id}")
    public VteFactureEnteteDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return vteFactureEnteteService.getById(id);
    }

    @GetMapping
    public Page<VteFactureEnteteDTO> query(@Valid VteFactureEnteteQueryVO vO) {
        return vteFactureEnteteService.query(vO);
    }
}
