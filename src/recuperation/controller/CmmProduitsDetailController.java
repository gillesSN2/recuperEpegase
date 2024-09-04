package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.CmmProduitsDetailDTO;
import com.yewi.yewicore.recuperation.service.CmmProduitsDetailService;
import com.yewi.yewicore.recuperation.vo.CmmProduitsDetailQueryVO;
import com.yewi.yewicore.recuperation.vo.CmmProduitsDetailUpdateVO;
import com.yewi.yewicore.recuperation.vo.CmmProduitsDetailVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/cmmProduitsDetail")
public class CmmProduitsDetailController {

    @Autowired
    private CmmProduitsDetailService cmmProduitsDetailService;

    @PostMapping
    public String save(@Valid @RequestBody CmmProduitsDetailVO vO) {
        return cmmProduitsDetailService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        cmmProduitsDetailService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody CmmProduitsDetailUpdateVO vO) {
        cmmProduitsDetailService.update(id, vO);
    }

    @GetMapping("/{id}")
    public CmmProduitsDetailDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return cmmProduitsDetailService.getById(id);
    }

    @GetMapping
    public Page<CmmProduitsDetailDTO> query(@Valid CmmProduitsDetailQueryVO vO) {
        return cmmProduitsDetailService.query(vO);
    }
}
