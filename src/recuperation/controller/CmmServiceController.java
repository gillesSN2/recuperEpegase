package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.CmmServiceDTO;
import com.yewi.yewicore.recuperation.service.CmmServiceService;
import com.yewi.yewicore.recuperation.vo.CmmServiceQueryVO;
import com.yewi.yewicore.recuperation.vo.CmmServiceUpdateVO;
import com.yewi.yewicore.recuperation.vo.CmmServiceVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/cmmService")
public class CmmServiceController {

    @Autowired
    private CmmServiceService cmmServiceService;

    @PostMapping
    public String save(@Valid @RequestBody CmmServiceVO vO) {
        return cmmServiceService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        cmmServiceService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody CmmServiceUpdateVO vO) {
        cmmServiceService.update(id, vO);
    }

    @GetMapping("/{id}")
    public CmmServiceDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return cmmServiceService.getById(id);
    }

    @GetMapping
    public Page<CmmServiceDTO> query(@Valid CmmServiceQueryVO vO) {
        return cmmServiceService.query(vO);
    }
}
