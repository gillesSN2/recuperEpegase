package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.CaiCaissesCommercialesDTO;
import com.yewi.yewicore.recuperation.service.CaiCaissesCommercialesService;
import com.yewi.yewicore.recuperation.vo.CaiCaissesCommercialesQueryVO;
import com.yewi.yewicore.recuperation.vo.CaiCaissesCommercialesUpdateVO;
import com.yewi.yewicore.recuperation.vo.CaiCaissesCommercialesVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/caiCaissesCommerciales")
public class CaiCaissesCommercialesController {

    @Autowired
    private CaiCaissesCommercialesService caiCaissesCommercialesService;

    @PostMapping
    public String save(@Valid @RequestBody CaiCaissesCommercialesVO vO) {
        return caiCaissesCommercialesService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        caiCaissesCommercialesService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody CaiCaissesCommercialesUpdateVO vO) {
        caiCaissesCommercialesService.update(id, vO);
    }

    @GetMapping("/{id}")
    public CaiCaissesCommercialesDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return caiCaissesCommercialesService.getById(id);
    }

    @GetMapping
    public Page<CaiCaissesCommercialesDTO> query(@Valid CaiCaissesCommercialesQueryVO vO) {
        return caiCaissesCommercialesService.query(vO);
    }
}
