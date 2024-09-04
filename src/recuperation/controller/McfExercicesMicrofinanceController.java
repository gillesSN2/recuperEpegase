package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.McfExercicesMicrofinanceDTO;
import com.yewi.yewicore.recuperation.service.McfExercicesMicrofinanceService;
import com.yewi.yewicore.recuperation.vo.McfExercicesMicrofinanceQueryVO;
import com.yewi.yewicore.recuperation.vo.McfExercicesMicrofinanceUpdateVO;
import com.yewi.yewicore.recuperation.vo.McfExercicesMicrofinanceVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/mcfExercicesMicrofinance")
public class McfExercicesMicrofinanceController {

    @Autowired
    private McfExercicesMicrofinanceService mcfExercicesMicrofinanceService;

    @PostMapping
    public String save(@Valid @RequestBody McfExercicesMicrofinanceVO vO) {
        return mcfExercicesMicrofinanceService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        mcfExercicesMicrofinanceService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody McfExercicesMicrofinanceUpdateVO vO) {
        mcfExercicesMicrofinanceService.update(id, vO);
    }

    @GetMapping("/{id}")
    public McfExercicesMicrofinanceDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return mcfExercicesMicrofinanceService.getById(id);
    }

    @GetMapping
    public Page<McfExercicesMicrofinanceDTO> query(@Valid McfExercicesMicrofinanceQueryVO vO) {
        return mcfExercicesMicrofinanceService.query(vO);
    }
}
