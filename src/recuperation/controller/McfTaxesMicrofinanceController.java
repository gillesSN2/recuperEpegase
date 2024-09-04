package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.McfTaxesMicrofinanceDTO;
import com.yewi.yewicore.recuperation.service.McfTaxesMicrofinanceService;
import com.yewi.yewicore.recuperation.vo.McfTaxesMicrofinanceQueryVO;
import com.yewi.yewicore.recuperation.vo.McfTaxesMicrofinanceUpdateVO;
import com.yewi.yewicore.recuperation.vo.McfTaxesMicrofinanceVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/mcfTaxesMicrofinance")
public class McfTaxesMicrofinanceController {

    @Autowired
    private McfTaxesMicrofinanceService mcfTaxesMicrofinanceService;

    @PostMapping
    public String save(@Valid @RequestBody McfTaxesMicrofinanceVO vO) {
        return mcfTaxesMicrofinanceService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        mcfTaxesMicrofinanceService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody McfTaxesMicrofinanceUpdateVO vO) {
        mcfTaxesMicrofinanceService.update(id, vO);
    }

    @GetMapping("/{id}")
    public McfTaxesMicrofinanceDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return mcfTaxesMicrofinanceService.getById(id);
    }

    @GetMapping
    public Page<McfTaxesMicrofinanceDTO> query(@Valid McfTaxesMicrofinanceQueryVO vO) {
        return mcfTaxesMicrofinanceService.query(vO);
    }
}
