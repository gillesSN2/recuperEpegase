package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.ZonesDTO;
import com.yewi.yewicore.recuperation.service.ZonesService;
import com.yewi.yewicore.recuperation.vo.ZonesQueryVO;
import com.yewi.yewicore.recuperation.vo.ZonesUpdateVO;
import com.yewi.yewicore.recuperation.vo.ZonesVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/zones")
public class ZonesController {

    @Autowired
    private ZonesService zonesService;

    @PostMapping
    public String save(@Valid @RequestBody ZonesVO vO) {
        return zonesService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        zonesService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody ZonesUpdateVO vO) {
        zonesService.update(id, vO);
    }

    @GetMapping("/{id}")
    public ZonesDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return zonesService.getById(id);
    }

    @GetMapping
    public Page<ZonesDTO> query(@Valid ZonesQueryVO vO) {
        return zonesService.query(vO);
    }
}
