package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.PaySalariesPointageDTO;
import com.yewi.yewicore.recuperation.service.PaySalariesPointageService;
import com.yewi.yewicore.recuperation.vo.PaySalariesPointageQueryVO;
import com.yewi.yewicore.recuperation.vo.PaySalariesPointageUpdateVO;
import com.yewi.yewicore.recuperation.vo.PaySalariesPointageVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/paySalariesPointage")
public class PaySalariesPointageController {

    @Autowired
    private PaySalariesPointageService paySalariesPointageService;

    @PostMapping
    public String save(@Valid @RequestBody PaySalariesPointageVO vO) {
        return paySalariesPointageService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        paySalariesPointageService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody PaySalariesPointageUpdateVO vO) {
        paySalariesPointageService.update(id, vO);
    }

    @GetMapping("/{id}")
    public PaySalariesPointageDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return paySalariesPointageService.getById(id);
    }

    @GetMapping
    public Page<PaySalariesPointageDTO> query(@Valid PaySalariesPointageQueryVO vO) {
        return paySalariesPointageService.query(vO);
    }
}
