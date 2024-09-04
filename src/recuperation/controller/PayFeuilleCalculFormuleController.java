package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.PayFeuilleCalculFormuleDTO;
import com.yewi.yewicore.recuperation.service.PayFeuilleCalculFormuleService;
import com.yewi.yewicore.recuperation.vo.PayFeuilleCalculFormuleQueryVO;
import com.yewi.yewicore.recuperation.vo.PayFeuilleCalculFormuleUpdateVO;
import com.yewi.yewicore.recuperation.vo.PayFeuilleCalculFormuleVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/payFeuilleCalculFormule")
public class PayFeuilleCalculFormuleController {

    @Autowired
    private PayFeuilleCalculFormuleService payFeuilleCalculFormuleService;

    @PostMapping
    public String save(@Valid @RequestBody PayFeuilleCalculFormuleVO vO) {
        return payFeuilleCalculFormuleService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        payFeuilleCalculFormuleService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody PayFeuilleCalculFormuleUpdateVO vO) {
        payFeuilleCalculFormuleService.update(id, vO);
    }

    @GetMapping("/{id}")
    public PayFeuilleCalculFormuleDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return payFeuilleCalculFormuleService.getById(id);
    }

    @GetMapping
    public Page<PayFeuilleCalculFormuleDTO> query(@Valid PayFeuilleCalculFormuleQueryVO vO) {
        return payFeuilleCalculFormuleService.query(vO);
    }
}
