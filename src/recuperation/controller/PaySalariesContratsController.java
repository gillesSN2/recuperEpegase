package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.PaySalariesContratsDTO;
import com.yewi.yewicore.recuperation.service.PaySalariesContratsService;
import com.yewi.yewicore.recuperation.vo.PaySalariesContratsQueryVO;
import com.yewi.yewicore.recuperation.vo.PaySalariesContratsUpdateVO;
import com.yewi.yewicore.recuperation.vo.PaySalariesContratsVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/paySalariesContrats")
public class PaySalariesContratsController {

    @Autowired
    private PaySalariesContratsService paySalariesContratsService;

    @PostMapping
    public String save(@Valid @RequestBody PaySalariesContratsVO vO) {
        return paySalariesContratsService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        paySalariesContratsService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody PaySalariesContratsUpdateVO vO) {
        paySalariesContratsService.update(id, vO);
    }

    @GetMapping("/{id}")
    public PaySalariesContratsDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return paySalariesContratsService.getById(id);
    }

    @GetMapping
    public Page<PaySalariesContratsDTO> query(@Valid PaySalariesContratsQueryVO vO) {
        return paySalariesContratsService.query(vO);
    }
}
