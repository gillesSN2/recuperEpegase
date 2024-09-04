package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.PayBulletinLigneDTO;
import com.yewi.yewicore.recuperation.service.PayBulletinLigneService;
import com.yewi.yewicore.recuperation.vo.PayBulletinLigneQueryVO;
import com.yewi.yewicore.recuperation.vo.PayBulletinLigneUpdateVO;
import com.yewi.yewicore.recuperation.vo.PayBulletinLigneVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/payBulletinLigne")
public class PayBulletinLigneController {

    @Autowired
    private PayBulletinLigneService payBulletinLigneService;

    @PostMapping
    public String save(@Valid @RequestBody PayBulletinLigneVO vO) {
        return payBulletinLigneService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        payBulletinLigneService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody PayBulletinLigneUpdateVO vO) {
        payBulletinLigneService.update(id, vO);
    }

    @GetMapping("/{id}")
    public PayBulletinLigneDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return payBulletinLigneService.getById(id);
    }

    @GetMapping
    public Page<PayBulletinLigneDTO> query(@Valid PayBulletinLigneQueryVO vO) {
        return payBulletinLigneService.query(vO);
    }
}
