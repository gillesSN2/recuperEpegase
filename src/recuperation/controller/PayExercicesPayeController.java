package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.PayExercicesPayeDTO;
import com.yewi.yewicore.recuperation.service.PayExercicesPayeService;
import com.yewi.yewicore.recuperation.vo.PayExercicesPayeQueryVO;
import com.yewi.yewicore.recuperation.vo.PayExercicesPayeUpdateVO;
import com.yewi.yewicore.recuperation.vo.PayExercicesPayeVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/payExercicesPaye")
public class PayExercicesPayeController {

    @Autowired
    private PayExercicesPayeService payExercicesPayeService;

    @PostMapping
    public String save(@Valid @RequestBody PayExercicesPayeVO vO) {
        return payExercicesPayeService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        payExercicesPayeService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody PayExercicesPayeUpdateVO vO) {
        payExercicesPayeService.update(id, vO);
    }

    @GetMapping("/{id}")
    public PayExercicesPayeDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return payExercicesPayeService.getById(id);
    }

    @GetMapping
    public Page<PayExercicesPayeDTO> query(@Valid PayExercicesPayeQueryVO vO) {
        return payExercicesPayeService.query(vO);
    }
}
