package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.CmmProduitsServicesDTO;
import com.yewi.yewicore.recuperation.service.CmmProduitsServicesService;
import com.yewi.yewicore.recuperation.vo.CmmProduitsServicesQueryVO;
import com.yewi.yewicore.recuperation.vo.CmmProduitsServicesUpdateVO;
import com.yewi.yewicore.recuperation.vo.CmmProduitsServicesVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/cmmProduitsServices")
public class CmmProduitsServicesController {

    @Autowired
    private CmmProduitsServicesService cmmProduitsServicesService;

    @PostMapping
    public String save(@Valid @RequestBody CmmProduitsServicesVO vO) {
        return cmmProduitsServicesService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        cmmProduitsServicesService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody CmmProduitsServicesUpdateVO vO) {
        cmmProduitsServicesService.update(id, vO);
    }

    @GetMapping("/{id}")
    public CmmProduitsServicesDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return cmmProduitsServicesService.getById(id);
    }

    @GetMapping
    public Page<CmmProduitsServicesDTO> query(@Valid CmmProduitsServicesQueryVO vO) {
        return cmmProduitsServicesService.query(vO);
    }
}
