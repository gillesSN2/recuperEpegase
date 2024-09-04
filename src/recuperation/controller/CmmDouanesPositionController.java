package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.CmmDouanesPositionDTO;
import com.yewi.yewicore.recuperation.service.CmmDouanesPositionService;
import com.yewi.yewicore.recuperation.vo.CmmDouanesPositionQueryVO;
import com.yewi.yewicore.recuperation.vo.CmmDouanesPositionUpdateVO;
import com.yewi.yewicore.recuperation.vo.CmmDouanesPositionVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/cmmDouanesPosition")
public class CmmDouanesPositionController {

    @Autowired
    private CmmDouanesPositionService cmmDouanesPositionService;

    @PostMapping
    public String save(@Valid @RequestBody CmmDouanesPositionVO vO) {
        return cmmDouanesPositionService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        cmmDouanesPositionService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody CmmDouanesPositionUpdateVO vO) {
        cmmDouanesPositionService.update(id, vO);
    }

    @GetMapping("/{id}")
    public CmmDouanesPositionDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return cmmDouanesPositionService.getById(id);
    }

    @GetMapping
    public Page<CmmDouanesPositionDTO> query(@Valid CmmDouanesPositionQueryVO vO) {
        return cmmDouanesPositionService.query(vO);
    }
}
