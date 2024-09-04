package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.PayBulletinSalaireDTO;
import com.yewi.yewicore.recuperation.service.PayBulletinSalaireService;
import com.yewi.yewicore.recuperation.vo.PayBulletinSalaireQueryVO;
import com.yewi.yewicore.recuperation.vo.PayBulletinSalaireUpdateVO;
import com.yewi.yewicore.recuperation.vo.PayBulletinSalaireVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/payBulletinSalaire")
public class PayBulletinSalaireController {

    @Autowired
    private PayBulletinSalaireService payBulletinSalaireService;

    @PostMapping
    public String save(@Valid @RequestBody PayBulletinSalaireVO vO) {
        return payBulletinSalaireService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        payBulletinSalaireService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody PayBulletinSalaireUpdateVO vO) {
        payBulletinSalaireService.update(id, vO);
    }

    @GetMapping("/{id}")
    public PayBulletinSalaireDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return payBulletinSalaireService.getById(id);
    }

    @GetMapping
    public Page<PayBulletinSalaireDTO> query(@Valid PayBulletinSalaireQueryVO vO) {
        return payBulletinSalaireService.query(vO);
    }
}
