package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.PayFeuilleCalculDTO;
import com.yewi.yewicore.recuperation.service.PayFeuilleCalculService;
import com.yewi.yewicore.recuperation.vo.PayFeuilleCalculQueryVO;
import com.yewi.yewicore.recuperation.vo.PayFeuilleCalculUpdateVO;
import com.yewi.yewicore.recuperation.vo.PayFeuilleCalculVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/payFeuilleCalcul")
public class PayFeuilleCalculController {

    @Autowired
    private PayFeuilleCalculService payFeuilleCalculService;

    @PostMapping
    public String save(@Valid @RequestBody PayFeuilleCalculVO vO) {
        return payFeuilleCalculService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        payFeuilleCalculService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody PayFeuilleCalculUpdateVO vO) {
        payFeuilleCalculService.update(id, vO);
    }

    @GetMapping("/{id}")
    public PayFeuilleCalculDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return payFeuilleCalculService.getById(id);
    }

    @GetMapping
    public Page<PayFeuilleCalculDTO> query(@Valid PayFeuilleCalculQueryVO vO) {
        return payFeuilleCalculService.query(vO);
    }
}
