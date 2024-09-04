package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.CmmProduitsGrpDTO;
import com.yewi.yewicore.recuperation.service.CmmProduitsGrpService;
import com.yewi.yewicore.recuperation.vo.CmmProduitsGrpQueryVO;
import com.yewi.yewicore.recuperation.vo.CmmProduitsGrpUpdateVO;
import com.yewi.yewicore.recuperation.vo.CmmProduitsGrpVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/cmmProduitsGrp")
public class CmmProduitsGrpController {

    @Autowired
    private CmmProduitsGrpService cmmProduitsGrpService;

    @PostMapping
    public String save(@Valid @RequestBody CmmProduitsGrpVO vO) {
        return cmmProduitsGrpService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        cmmProduitsGrpService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody CmmProduitsGrpUpdateVO vO) {
        cmmProduitsGrpService.update(id, vO);
    }

    @GetMapping("/{id}")
    public CmmProduitsGrpDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return cmmProduitsGrpService.getById(id);
    }

    @GetMapping
    public Page<CmmProduitsGrpDTO> query(@Valid CmmProduitsGrpQueryVO vO) {
        return cmmProduitsGrpService.query(vO);
    }
}
