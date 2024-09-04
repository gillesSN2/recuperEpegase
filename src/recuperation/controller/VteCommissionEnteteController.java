package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.VteCommissionEnteteDTO;
import com.yewi.yewicore.recuperation.service.VteCommissionEnteteService;
import com.yewi.yewicore.recuperation.vo.VteCommissionEnteteQueryVO;
import com.yewi.yewicore.recuperation.vo.VteCommissionEnteteUpdateVO;
import com.yewi.yewicore.recuperation.vo.VteCommissionEnteteVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/vteCommissionEntete")
public class VteCommissionEnteteController {

    @Autowired
    private VteCommissionEnteteService vteCommissionEnteteService;

    @PostMapping
    public String save(@Valid @RequestBody VteCommissionEnteteVO vO) {
        return vteCommissionEnteteService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        vteCommissionEnteteService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody VteCommissionEnteteUpdateVO vO) {
        vteCommissionEnteteService.update(id, vO);
    }

    @GetMapping("/{id}")
    public VteCommissionEnteteDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return vteCommissionEnteteService.getById(id);
    }

    @GetMapping
    public Page<VteCommissionEnteteDTO> query(@Valid VteCommissionEnteteQueryVO vO) {
        return vteCommissionEnteteService.query(vO);
    }
}
