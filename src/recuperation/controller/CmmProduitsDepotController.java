package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.CmmProduitsDepotDTO;
import com.yewi.yewicore.recuperation.service.CmmProduitsDepotService;
import com.yewi.yewicore.recuperation.vo.CmmProduitsDepotQueryVO;
import com.yewi.yewicore.recuperation.vo.CmmProduitsDepotUpdateVO;
import com.yewi.yewicore.recuperation.vo.CmmProduitsDepotVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/cmmProduitsDepot")
public class CmmProduitsDepotController {

    @Autowired
    private CmmProduitsDepotService cmmProduitsDepotService;

    @PostMapping
    public String save(@Valid @RequestBody CmmProduitsDepotVO vO) {
        return cmmProduitsDepotService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        cmmProduitsDepotService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody CmmProduitsDepotUpdateVO vO) {
        cmmProduitsDepotService.update(id, vO);
    }

    @GetMapping("/{id}")
    public CmmProduitsDepotDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return cmmProduitsDepotService.getById(id);
    }

    @GetMapping
    public Page<CmmProduitsDepotDTO> query(@Valid CmmProduitsDepotQueryVO vO) {
        return cmmProduitsDepotService.query(vO);
    }
}
