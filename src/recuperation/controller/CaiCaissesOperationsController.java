package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.CaiCaissesOperationsDTO;
import com.yewi.yewicore.recuperation.service.CaiCaissesOperationsService;
import com.yewi.yewicore.recuperation.vo.CaiCaissesOperationsQueryVO;
import com.yewi.yewicore.recuperation.vo.CaiCaissesOperationsUpdateVO;
import com.yewi.yewicore.recuperation.vo.CaiCaissesOperationsVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/caiCaissesOperations")
public class CaiCaissesOperationsController {

    @Autowired
    private CaiCaissesOperationsService caiCaissesOperationsService;

    @PostMapping
    public String save(@Valid @RequestBody CaiCaissesOperationsVO vO) {
        return caiCaissesOperationsService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        caiCaissesOperationsService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody CaiCaissesOperationsUpdateVO vO) {
        caiCaissesOperationsService.update(id, vO);
    }

    @GetMapping("/{id}")
    public CaiCaissesOperationsDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return caiCaissesOperationsService.getById(id);
    }

    @GetMapping
    public Page<CaiCaissesOperationsDTO> query(@Valid CaiCaissesOperationsQueryVO vO) {
        return caiCaissesOperationsService.query(vO);
    }
}
