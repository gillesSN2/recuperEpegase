package recuperation.dtos;


import lombok.Data;

import java.io.Serializable;

@Data
public class UtilisateursFonctionnalitesesDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long utilisateurId;

    private String fonctionnalitesesCode;

}
