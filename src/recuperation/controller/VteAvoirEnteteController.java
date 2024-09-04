package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.VteAvoirEnteteDTO;
import com.yewi.yewicore.recuperation.service.VteAvoirEnteteService;
import com.yewi.yewicore.recuperation.vo.VteAvoirEnteteQueryVO;
import com.yewi.yewicore.recuperation.vo.VteAvoirEnteteUpdateVO;
import com.yewi.yewicore.recuperation.vo.VteAvoirEnteteVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/vteAvoirEntete")
public class VteAvoirEnteteController {

    @Autowired
    private VteAvoirEnteteService vteAvoirEnteteService;

    @PostMapping
    public String save(@Valid @RequestBody VteAvoirEnteteVO vO) {
        return vteAvoirEnteteService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        vteAvoirEnteteService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody VteAvoirEnteteUpdateVO vO) {
        vteAvoirEnteteService.update(id, vO);
    }

    @GetMapping("/{id}")
    public VteAvoirEnteteDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return vteAvoirEnteteService.getById(id);
    }

    @GetMapping
    public Page<VteAvoirEnteteDTO> query(@Valid VteAvoirEnteteQueryVO vO) {
        return vteAvoirEnteteService.query(vO);
    }
}
