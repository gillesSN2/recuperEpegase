package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.PaySalariesCongesDTO;
import com.yewi.yewicore.recuperation.service.PaySalariesCongesService;
import com.yewi.yewicore.recuperation.vo.PaySalariesCongesQueryVO;
import com.yewi.yewicore.recuperation.vo.PaySalariesCongesUpdateVO;
import com.yewi.yewicore.recuperation.vo.PaySalariesCongesVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/paySalariesConges")
public class PaySalariesCongesController {

    @Autowired
    private PaySalariesCongesService paySalariesCongesService;

    @PostMapping
    public String save(@Valid @RequestBody PaySalariesCongesVO vO) {
        return paySalariesCongesService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        paySalariesCongesService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody PaySalariesCongesUpdateVO vO) {
        paySalariesCongesService.update(id, vO);
    }

    @GetMapping("/{id}")
    public PaySalariesCongesDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return paySalariesCongesService.getById(id);
    }

    @GetMapping
    public Page<PaySalariesCongesDTO> query(@Valid PaySalariesCongesQueryVO vO) {
        return paySalariesCongesService.query(vO);
    }
}
