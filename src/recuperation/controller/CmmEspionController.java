package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.CmmEspionDTO;
import com.yewi.yewicore.recuperation.service.CmmEspionService;
import com.yewi.yewicore.recuperation.vo.CmmEspionQueryVO;
import com.yewi.yewicore.recuperation.vo.CmmEspionUpdateVO;
import com.yewi.yewicore.recuperation.vo.CmmEspionVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/cmmEspion")
public class CmmEspionController {

    @Autowired
    private CmmEspionService cmmEspionService;

    @PostMapping
    public String save(@Valid @RequestBody CmmEspionVO vO) {
        return cmmEspionService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        cmmEspionService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody CmmEspionUpdateVO vO) {
        cmmEspionService.update(id, vO);
    }

    @GetMapping("/{id}")
    public CmmEspionDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return cmmEspionService.getById(id);
    }

    @GetMapping
    public Page<CmmEspionDTO> query(@Valid CmmEspionQueryVO vO) {
        return cmmEspionService.query(vO);
    }
}
