<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>

<h:panelGrid columns="3" columnClasses="clos20g,clos60g,clos20g" width="100%" border="0">
    <h:column><h:outputText value="NOTE 1:"/></h:column>
    <h:column><h:outputText value="Dettes garanties par des suretés réelles"/></h:column>
    <h:column>
        <h:selectOneRadio dir="left" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.selectedExo.execptN1}">
            <f:selectItem itemLabel="A" itemValue="0"/>
            <f:selectItem itemLabel="N/A" itemValue="1"/>
        </h:selectOneRadio>
    </h:column>
    <h:column><h:outputText value="NOTE 2:"/></h:column>
    <h:column><h:outputText value="Informations obligatoires"/></h:column>
    <h:column>
        <h:selectOneRadio dir="left" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.selectedExo.execptN2}">
            <f:selectItem itemLabel="A" itemValue="0"/>
            <f:selectItem itemLabel="N/A" itemValue="1"/>
        </h:selectOneRadio>
    </h:column>
    <h:column><h:outputText value="NOTE 3A:"/></h:column>
    <h:column><h:outputText value="Immobilisation brute"/></h:column>
    <h:column>
        <h:selectOneRadio dir="left" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.selectedExo.execptN3A}">
            <f:selectItem itemLabel="A" itemValue="0"/>
            <f:selectItem itemLabel="N/A" itemValue="1"/>
        </h:selectOneRadio>
    </h:column>
    <h:column><h:outputText value="NOTE 3B:"/></h:column>
    <h:column><h:outputText value="Biens pris en location acquisition"/></h:column>
    <h:column>
        <h:selectOneRadio dir="left" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.selectedExo.execptN3B}">
            <f:selectItem itemLabel="A" itemValue="0"/>
            <f:selectItem itemLabel="N/A" itemValue="1"/>
        </h:selectOneRadio>
    </h:column>
    <h:column><h:outputText value="NOTE 3C:"/></h:column>
    <h:column><h:outputText value="Immobilisations: Amortissements"/></h:column>
    <h:column>
        <h:selectOneRadio dir="left" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.selectedExo.execptN3C}">
            <f:selectItem itemLabel="A" itemValue="0"/>
            <f:selectItem itemLabel="N/A" itemValue="1"/>
        </h:selectOneRadio>
    </h:column>
    <h:column><h:outputText value=""/></h:column>
    <h:column><h:outputText value=""/></h:column>
    <h:column><h:outputText value=""/></h:column>
    <h:column><h:outputText value="NOTE 3D:"/></h:column>
    <h:column><h:outputText value="Immobilisations: plus-values et moins value de cession"/></h:column>
    <h:column>
        <h:selectOneRadio dir="left" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.selectedExo.execptN3D}">
            <f:selectItem itemLabel="A" itemValue="0"/>
            <f:selectItem itemLabel="N/A" itemValue="1"/>
        </h:selectOneRadio>
    </h:column>
    <h:column><h:outputText value=""/></h:column>
    <h:column><h:outputText value=""/></h:column>
    <h:column><h:outputText value=""/></h:column>
    <h:column><h:outputText value="NOTE 3E:"/></h:column>
    <h:column><h:outputText value="Informations sur les réévaluations effectuées par l'entité"/></h:column>
    <h:column>
        <h:selectOneRadio dir="left" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.selectedExo.execptN3E}">
            <f:selectItem itemLabel="A" itemValue="0"/>
            <f:selectItem itemLabel="N/A" itemValue="1"/>
        </h:selectOneRadio>
    </h:column>
    <h:column><h:outputText value=""/></h:column>
    <h:column><h:outputText value=""/></h:column>
    <h:column><h:outputText value=""/></h:column>
    <h:column><h:outputText value="NOTE 4:"/></h:column>
    <h:column><h:outputText value="Immobilisations financières"/></h:column>
    <h:column>
        <h:selectOneRadio dir="left" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.selectedExo.execptN4}">
            <f:selectItem itemLabel="A" itemValue="0"/>
            <f:selectItem itemLabel="N/A" itemValue="1"/>
        </h:selectOneRadio>
    </h:column>
    <h:column><h:outputText value="NOTE 5:"/></h:column>
    <h:column><h:outputText value="Actif circulant et dettes circulantes HAO"/></h:column>
    <h:column>
        <h:selectOneRadio dir="left" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.selectedExo.execptN5}">
            <f:selectItem itemLabel="A" itemValue="0"/>
            <f:selectItem itemLabel="N/A" itemValue="1"/>
        </h:selectOneRadio>
    </h:column>
    <h:column><h:outputText value="NOTE 6:"/></h:column>
    <h:column><h:outputText value="Stocks et encours"/></h:column>
    <h:column>
        <h:selectOneRadio dir="left" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.selectedExo.execptN6}">
            <f:selectItem itemLabel="A" itemValue="0"/>
            <f:selectItem itemLabel="N/A" itemValue="1"/>
        </h:selectOneRadio>
    </h:column>
    <h:column><h:outputText value="NOTE 7:"/></h:column>
    <h:column><h:outputText value="Clients produits à recevoir"/></h:column>
    <h:column>
        <h:selectOneRadio dir="left" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.selectedExo.execptN7}">
            <f:selectItem itemLabel="A" itemValue="0"/>
            <f:selectItem itemLabel="N/A" itemValue="1"/>
        </h:selectOneRadio>
    </h:column>
    <h:column><h:outputText value="NOTE 8:"/></h:column>
    <h:column><h:outputText value="Autres créances"/></h:column>
    <h:column>
        <h:selectOneRadio dir="left" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.selectedExo.execptN8}">
            <f:selectItem itemLabel="A" itemValue="0"/>
            <f:selectItem itemLabel="N/A" itemValue="1"/>
        </h:selectOneRadio>
    </h:column>
    <h:column><h:outputText value=""/></h:column>
    <h:column><h:outputText value=""/></h:column>
    <h:column><h:outputText value=""/></h:column>
    <h:column><h:outputText value="NOTE 8A:"/></h:column>
    <h:column><h:outputText value="Tableau d'éclatement des charges immobilisées et des provisions par charges à répartir"/></h:column>
    <h:column>
        <h:selectOneRadio dir="left" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.selectedExo.execptN8A}">
            <f:selectItem itemLabel="A" itemValue="0"/>
            <f:selectItem itemLabel="N/A" itemValue="1"/>
        </h:selectOneRadio>
    </h:column>
    <h:column><h:outputText value=""/></h:column>
    <h:column><h:outputText value=""/></h:column>
    <h:column><h:outputText value=""/></h:column>
    <h:column><h:outputText value="NOTE 9:"/></h:column>
    <h:column><h:outputText value="Titres de placement"/></h:column>
    <h:column>
        <h:selectOneRadio dir="left" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.selectedExo.execptN9}">
            <f:selectItem itemLabel="A" itemValue="0"/>
            <f:selectItem itemLabel="N/A" itemValue="1"/>
        </h:selectOneRadio>
    </h:column>
    <h:column><h:outputText value="NOTE 10:"/></h:column>
    <h:column><h:outputText value="Valeurs à encaisser"/></h:column>
    <h:column>
        <h:selectOneRadio dir="left" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.selectedExo.execptN10}">
            <f:selectItem itemLabel="A" itemValue="0"/>
            <f:selectItem itemLabel="N/A" itemValue="1"/>
        </h:selectOneRadio>
    </h:column>
    <h:column><h:outputText value="NOTE 11:"/></h:column>
    <h:column><h:outputText value="Disponibilités"/></h:column>
    <h:column>
        <h:selectOneRadio dir="left" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.selectedExo.execptN11}">
            <f:selectItem itemLabel="A" itemValue="0"/>
            <f:selectItem itemLabel="N/A" itemValue="1"/>
        </h:selectOneRadio>
    </h:column>
    <h:column><h:outputText value="NOTE 12:"/></h:column>
    <h:column><h:outputText value="Ecarts de conversion et transferts de charges"/></h:column>
    <h:column>
        <h:selectOneRadio dir="left" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.selectedExo.execptN12}">
            <f:selectItem itemLabel="A" itemValue="0"/>
            <f:selectItem itemLabel="N/A" itemValue="1"/>
        </h:selectOneRadio>
    </h:column>
    <h:column><h:outputText value="NOTE 13:"/></h:column>
    <h:column><h:outputText value="Capital: valeur nominale des actions ou part"/></h:column>
    <h:column>
        <h:selectOneRadio dir="left" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.selectedExo.execptN13}">
            <f:selectItem itemLabel="A" itemValue="0"/>
            <f:selectItem itemLabel="N/A" itemValue="1"/>
        </h:selectOneRadio>
    </h:column>
    <h:column><h:outputText value="NOTE 14:"/></h:column>
    <h:column><h:outputText value="Primes et réserves"/></h:column>
    <h:column>
        <h:selectOneRadio dir="left" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.selectedExo.execptN14}">
            <f:selectItem itemLabel="A" itemValue="0"/>
            <f:selectItem itemLabel="N/A" itemValue="1"/>
        </h:selectOneRadio>
    </h:column>
    <h:column><h:outputText value="NOTE 15A:"/></h:column>
    <h:column><h:outputText value="Subventions et provisions règlementées"/></h:column>
    <h:column>
        <h:selectOneRadio dir="left" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.selectedExo.execptN15A}">
            <f:selectItem itemLabel="A" itemValue="0"/>
            <f:selectItem itemLabel="N/A" itemValue="1"/>
        </h:selectOneRadio>
    </h:column>
    <h:column><h:outputText value="NOTE 15B:"/></h:column>
    <h:column><h:outputText value="Autres fonds propres"/></h:column>
    <h:column>
        <h:selectOneRadio dir="left" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.selectedExo.execptN15B}">
            <f:selectItem itemLabel="A" itemValue="0"/>
            <f:selectItem itemLabel="N/A" itemValue="1"/>
        </h:selectOneRadio>
    </h:column>
    <h:column><h:outputText value="NOTE 16A:"/></h:column>
    <h:column><h:outputText value="Dettes financières et ressources assimilées"/></h:column>
    <h:column>
        <h:selectOneRadio dir="left" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.selectedExo.execptN16A}">
            <f:selectItem itemLabel="A" itemValue="0"/>
            <f:selectItem itemLabel="N/A" itemValue="1"/>
        </h:selectOneRadio>
    </h:column>
    <h:column><h:outputText value=""/></h:column>
    <h:column><h:outputText value=""/></h:column>
    <h:column><h:outputText value=""/></h:column>
    <h:column><h:outputText value="NOTE 16B:"/></h:column>
    <h:column><h:outputText value="Engagements de retraite et avantages assimilés (méthode actuarielle)"/></h:column>
    <h:column>
        <h:selectOneRadio dir="left" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.selectedExo.execptN16B}">
            <f:selectItem itemLabel="A" itemValue="0"/>
            <f:selectItem itemLabel="N/A" itemValue="1"/>
        </h:selectOneRadio>
    </h:column>
    <h:column><h:outputText value=""/></h:column>
    <h:column><h:outputText value=""/></h:column>
    <h:column><h:outputText value=""/></h:column>
    <h:column><h:outputText value="NOTE 16B bis:"/></h:column>
    <h:column><h:outputText value="Engagements de retraite et avantages assimilés (méthode actuarielle)"/></h:column>
    <h:column>
        <h:selectOneRadio dir="left" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.selectedExo.execptN16BB}">
            <f:selectItem itemLabel="A" itemValue="0"/>
            <f:selectItem itemLabel="N/A" itemValue="1"/>
        </h:selectOneRadio>
    </h:column>
    <h:column><h:outputText value=""/></h:column>
    <h:column><h:outputText value=""/></h:column>
    <h:column><h:outputText value=""/></h:column>
    <h:column><h:outputText value="NOTE 16C:"/></h:column>
    <h:column><h:outputText value="Actifs et passifs éventuels"/></h:column>
    <h:column>
        <h:selectOneRadio dir="left" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.selectedExo.execptN16C}">
            <f:selectItem itemLabel="A" itemValue="0"/>
            <f:selectItem itemLabel="N/A" itemValue="1"/>
        </h:selectOneRadio>
    </h:column>
    <h:column><h:outputText value="NOTE 17:"/></h:column>
    <h:column><h:outputText value="Fournisseurs d'exploitation"/></h:column>
    <h:column>
        <h:selectOneRadio dir="left" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.selectedExo.execptN17}">
            <f:selectItem itemLabel="A" itemValue="0"/>
            <f:selectItem itemLabel="N/A" itemValue="1"/>
        </h:selectOneRadio>
    </h:column>
    <h:column><h:outputText value="NOTE 18:"/></h:column>
    <h:column><h:outputText value="Dettes fiscales et sociales"/></h:column>
    <h:column>
        <h:selectOneRadio dir="left" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.selectedExo.execptN18}">
            <f:selectItem itemLabel="A" itemValue="0"/>
            <f:selectItem itemLabel="N/A" itemValue="1"/>
        </h:selectOneRadio>
    </h:column>
    <h:column><h:outputText value=""/></h:column>
    <h:column><h:outputText value=""/></h:column>
    <h:column><h:outputText value=""/></h:column>
    <h:column><h:outputText value="NOTE 19:"/></h:column>
    <h:column><h:outputText value="Autres dettes et provisions pour risques à court terme"/></h:column>
    <h:column>
        <h:selectOneRadio dir="left" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.selectedExo.execptN19}">
            <f:selectItem itemLabel="A" itemValue="0"/>
            <f:selectItem itemLabel="N/A" itemValue="1"/>
        </h:selectOneRadio>
    </h:column>
    <h:column><h:outputText value=""/></h:column>
    <h:column><h:outputText value=""/></h:column>
    <h:column><h:outputText value=""/></h:column>
    <h:column><h:outputText value="NOTE 20:"/></h:column>
    <h:column><h:outputText value="Banques, crédit d'escompte et de trésorerie"/></h:column>
    <h:column>
        <h:selectOneRadio dir="left" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.selectedExo.execptN20}">
            <f:selectItem itemLabel="A" itemValue="0"/>
            <f:selectItem itemLabel="N/A" itemValue="1"/>
        </h:selectOneRadio>
    </h:column>
    <h:column><h:outputText value="NOTE 21:"/></h:column>
    <h:column><h:outputText value="Chiffre d'affaire et autres produits"/></h:column>
    <h:column>
        <h:selectOneRadio dir="left" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.selectedExo.execptN21}">
            <f:selectItem itemLabel="A" itemValue="0"/>
            <f:selectItem itemLabel="N/A" itemValue="1"/>
        </h:selectOneRadio>
    </h:column>
    <h:column><h:outputText value="NOTE 22:"/></h:column>
    <h:column><h:outputText value="Achats"/></h:column>
    <h:column>
        <h:selectOneRadio dir="left" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.selectedExo.execptN22}">
            <f:selectItem itemLabel="A" itemValue="0"/>
            <f:selectItem itemLabel="N/A" itemValue="1"/>
        </h:selectOneRadio>
    </h:column>
    <h:column><h:outputText value="NOTE 23:"/></h:column>
    <h:column><h:outputText value="Transports"/></h:column>
    <h:column>
        <h:selectOneRadio dir="left" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.selectedExo.execptN23}">
            <f:selectItem itemLabel="A" itemValue="0"/>
            <f:selectItem itemLabel="N/A" itemValue="1"/>
        </h:selectOneRadio>
    </h:column>
    <h:column><h:outputText value="NOTE 24:"/></h:column>
    <h:column><h:outputText value="Services extérieurs"/></h:column>
    <h:column>
        <h:selectOneRadio dir="left" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.selectedExo.execptN24}">
            <f:selectItem itemLabel="A" itemValue="0"/>
            <f:selectItem itemLabel="N/A" itemValue="1"/>
        </h:selectOneRadio>
    </h:column>
    <h:column><h:outputText value="NOTE 25:"/></h:column>
    <h:column><h:outputText value="Imppots et taxes"/></h:column>
    <h:column>
        <h:selectOneRadio dir="left" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.selectedExo.execptN25}">
            <f:selectItem itemLabel="A" itemValue="0"/>
            <f:selectItem itemLabel="N/A" itemValue="1"/>
        </h:selectOneRadio>
    </h:column>
    <h:column><h:outputText value="NOTE 26:"/></h:column>
    <h:column><h:outputText value="Autres charges"/></h:column>
    <h:column>
        <h:selectOneRadio dir="left" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.selectedExo.execptN26}">
            <f:selectItem itemLabel="A" itemValue="0"/>
            <f:selectItem itemLabel="N/A" itemValue="1"/>
        </h:selectOneRadio>
    </h:column>
    <h:column><h:outputText value="NOTE 27A:"/></h:column>
    <h:column><h:outputText value="Charges de personnels"/></h:column>
    <h:column>
        <h:selectOneRadio dir="left" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.selectedExo.execptN27A}">
            <f:selectItem itemLabel="A" itemValue="0"/>
            <f:selectItem itemLabel="N/A" itemValue="1"/>
        </h:selectOneRadio>
    </h:column>
    <h:column><h:outputText value=""/></h:column>
    <h:column><h:outputText value=""/></h:column>
    <h:column><h:outputText value=""/></h:column>
    <h:column><h:outputText value="NOTE 27B:"/></h:column>
    <h:column><h:outputText value="Effectifs, masse salariale et personel extérieur"/></h:column>
    <h:column>
        <h:selectOneRadio dir="left" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.selectedExo.execptN27B}">
            <f:selectItem itemLabel="A" itemValue="0"/>
            <f:selectItem itemLabel="N/A" itemValue="1"/>
        </h:selectOneRadio>
    </h:column>
    <h:column><h:outputText value=""/></h:column>
    <h:column><h:outputText value=""/></h:column>
    <h:column><h:outputText value=""/></h:column>
    <h:column><h:outputText value="NOTE 28:"/></h:column>
    <h:column><h:outputText value="Provisions et dépréciations inscrites au bilan"/></h:column>
    <h:column>
        <h:selectOneRadio dir="left" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.selectedExo.execptN28}">
            <f:selectItem itemLabel="A" itemValue="0"/>
            <f:selectItem itemLabel="N/A" itemValue="1"/>
        </h:selectOneRadio>
    </h:column>
    <h:column><h:outputText value="NOTE 29:"/></h:column>
    <h:column><h:outputText value="Charges et revenus financiers"/></h:column>
    <h:column>
        <h:selectOneRadio dir="left" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.selectedExo.execptN29}">
            <f:selectItem itemLabel="A" itemValue="0"/>
            <f:selectItem itemLabel="N/A" itemValue="1"/>
        </h:selectOneRadio>
    </h:column>
    <h:column><h:outputText value="NOTE 30:"/></h:column>
    <h:column><h:outputText value="Autres charges et produits HAO"/></h:column>
    <h:column>
        <h:selectOneRadio dir="left" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.selectedExo.execptN30}">
            <f:selectItem itemLabel="A" itemValue="0"/>
            <f:selectItem itemLabel="N/A" itemValue="1"/>
        </h:selectOneRadio>
    </h:column>
    <h:column><h:outputText value=""/></h:column>
    <h:column><h:outputText value=""/></h:column>
    <h:column><h:outputText value=""/></h:column>
    <h:column><h:outputText value="NOTE 31:"/></h:column>
    <h:column><h:outputText value="Répartition du résultat et autres éléments caractéristiques des cinq derniers exercices"/></h:column>
    <h:column>
        <h:selectOneRadio dir="left" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.selectedExo.execptN31}">
            <f:selectItem itemLabel="A" itemValue="0"/>
            <f:selectItem itemLabel="N/A" itemValue="1"/>
        </h:selectOneRadio>
    </h:column>
    <h:column><h:outputText value=""/></h:column>
    <h:column><h:outputText value=""/></h:column>
    <h:column><h:outputText value=""/></h:column>
    <h:column><h:outputText value="NOTE 32:"/></h:column>
    <h:column><h:outputText value="Production de l'exercicie"/></h:column>
    <h:column>
        <h:selectOneRadio dir="left" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.selectedExo.execptN32}">
            <f:selectItem itemLabel="A" itemValue="0"/>
            <f:selectItem itemLabel="N/A" itemValue="1"/>
        </h:selectOneRadio>
    </h:column>
    <h:column><h:outputText value="NOTE 33:"/></h:column>
    <h:column><h:outputText value="Achats destinés à la production"/></h:column>
    <h:column>
        <h:selectOneRadio dir="left" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.selectedExo.execptN33}">
            <f:selectItem itemLabel="A" itemValue="0"/>
            <f:selectItem itemLabel="N/A" itemValue="1"/>
        </h:selectOneRadio>
    </h:column>
    <h:column><h:outputText value=""/></h:column>
    <h:column><h:outputText value=""/></h:column>
    <h:column><h:outputText value=""/></h:column>
    <h:column><h:outputText value="NOTE 34:"/></h:column>
    <h:column><h:outputText value="Fiche de synthèse des principaux indicateurs financiers"/></h:column>
    <h:column>
        <h:selectOneRadio dir="left" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.selectedExo.execptN34}">
            <f:selectItem itemLabel="A" itemValue="0"/>
            <f:selectItem itemLabel="N/A" itemValue="1"/>
        </h:selectOneRadio>
    </h:column>
    <h:column><h:outputText value=""/></h:column>
    <h:column><h:outputText value=""/></h:column>
    <h:column><h:outputText value=""/></h:column>
    <h:column><h:outputText value="NOTE 35:"/></h:column>
    <h:column><h:outputText value="Liste des informations sociales, environementales et sociétables à fournir"/></h:column>
    <h:column>
        <h:selectOneRadio dir="left" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.selectedExo.execptN35}">
            <f:selectItem itemLabel="A" itemValue="0"/>
            <f:selectItem itemLabel="N/A" itemValue="1"/>
        </h:selectOneRadio>
    </h:column>
    <h:column><h:outputText value=""/></h:column>
    <h:column><h:outputText value=""/></h:column>
    <h:column><h:outputText value=""/></h:column>
    <h:column><h:outputText value="NOTE 36:"/></h:column>
    <h:column><h:outputText value="Tables des codes"/></h:column>
    <h:column>
        <h:selectOneRadio dir="left" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.selectedExo.execptN36}">
            <f:selectItem itemLabel="A" itemValue="0"/>
            <f:selectItem itemLabel="N/A" itemValue="1"/>
        </h:selectOneRadio>
    </h:column>
    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.selecFiscalite!='SYSCOHADA_GA'}"><h:outputText value="NOTE 37:"/></h:column>
    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.selecFiscalite!='SYSCOHADA_GA'}"><h:outputText value="Détermination impots sur le résultat"/></h:column>
    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.selecFiscalite!='SYSCOHADA_GA'}">
        <h:selectOneRadio dir="left" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.selectedExo.execptN37}">
            <f:selectItem itemLabel="A" itemValue="0"/>
            <f:selectItem itemLabel="N/A" itemValue="1"/>
        </h:selectOneRadio>
    </h:column>
    <h:column><h:outputText value=""/></h:column>
    <h:column><h:outputText value=""/></h:column>
    <h:column><h:outputText value=""/></h:column>
    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.selecFiscalite=='SYSCOHADA_GA'}"><h:outputText value="NOTE 37:"/></h:column>
    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.selecFiscalite=='SYSCOHADA_GA'}"><h:outputText value="Etat des provisions et déprec. non déductibles figurant au bilan"/></h:column>
    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.selecFiscalite=='SYSCOHADA_GA'}">
        <h:selectOneRadio dir="left" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.selectedExo.execptN38}">
            <f:selectItem itemLabel="A" itemValue="0"/>
            <f:selectItem itemLabel="N/A" itemValue="1"/>
        </h:selectOneRadio>
    </h:column>
    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.selecFiscalite=='SYSCOHADA_GA'}"><h:outputText value="NOTE 38:"/></h:column>
    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.selecFiscalite=='SYSCOHADA_GA'}"><h:outputText value="Résultat mis à disposition et affectés dans l`exercice"/></h:column>
    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.selecFiscalite=='SYSCOHADA_GA'}">
        <h:selectOneRadio dir="left" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.selectedExo.execptN38}">
            <f:selectItem itemLabel="A" itemValue="0"/>
            <f:selectItem itemLabel="N/A" itemValue="1"/>
        </h:selectOneRadio>
    </h:column>
    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.selecFiscalite=='SYSCOHADA_GA'}"><h:outputText value="NOTE 39:"/></h:column>
    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.selecFiscalite=='SYSCOHADA_GA'}"><h:outputText value="Détermination du résultat fiscal"/></h:column>
    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.selecFiscalite=='SYSCOHADA_GA'}">
        <h:selectOneRadio dir="left" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.selectedExo.execptN39}">
            <f:selectItem itemLabel="A" itemValue="0"/>
            <f:selectItem itemLabel="N/A" itemValue="1"/>
        </h:selectOneRadio>
    </h:column>
    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.selecFiscalite=='SYSCOHADA_GA'}"><h:outputText value="NOTE 40:"/></h:column>
    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.selecFiscalite=='SYSCOHADA_GA'}"><h:outputText value="Détermination de l`impôt sur les sociétés à payer"/></h:column>
    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.selecFiscalite=='SYSCOHADA_GA'}">
        <h:selectOneRadio dir="left" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.selectedExo.execptN40}">
            <f:selectItem itemLabel="A" itemValue="0"/>
            <f:selectItem itemLabel="N/A" itemValue="1"/>
        </h:selectOneRadio>
    </h:column>
    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.selecFiscalite=='SYSCOHADA_GA'}"><h:outputText value="NOTE 41:"/></h:column>
    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.selecFiscalite=='SYSCOHADA_GA'}"><h:outputText value="Taxes sur le chiffre d`affaires"/></h:column>
    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.selecFiscalite=='SYSCOHADA_GA'}">
        <h:selectOneRadio dir="left" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.selectedExo.execptN41}">
            <f:selectItem itemLabel="A" itemValue="0"/>
            <f:selectItem itemLabel="N/A" itemValue="1"/>
        </h:selectOneRadio>
    </h:column>
    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.selecFiscalite=='SYSCOHADA_GA'}"><h:outputText value="NOTE 42:"/></h:column>
    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.selecFiscalite=='SYSCOHADA_GA'}"><h:outputText value="Chiffres d`affaire réalisés avec l`etat"/></h:column>
    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.selecFiscalite=='SYSCOHADA_GA'}">
        <h:selectOneRadio dir="left" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.selectedExo.execptN42}">
            <f:selectItem itemLabel="A" itemValue="0"/>
            <f:selectItem itemLabel="N/A" itemValue="1"/>
        </h:selectOneRadio>
    </h:column>
    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.selecFiscalite=='SYSCOHADA_GA'}"><h:outputText value="NOTE 43:"/></h:column>
    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.selecFiscalite=='SYSCOHADA_GA'}"><h:outputText value="Taxes sur la valeur ajoutée et droits d`accises payés pour le compte de tiers"/></h:column>
    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.selecFiscalite=='SYSCOHADA_GA'}">
        <h:selectOneRadio dir="left" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.selectedExo.execptN43}">
            <f:selectItem itemLabel="A" itemValue="0"/>
            <f:selectItem itemLabel="N/A" itemValue="1"/>
        </h:selectOneRadio>
    </h:column>
    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.selecFiscalite=='SYSCOHADA_GA'}"><h:outputText value="NOTE 44:"/></h:column>
    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.selecFiscalite=='SYSCOHADA_GA'}"><h:outputText value="Précopmpte impôt sur les sociétés (secteur forestier)"/></h:column>
    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.selecFiscalite=='SYSCOHADA_GA'}">
        <h:selectOneRadio dir="left" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.selectedExo.execptN44}">
            <f:selectItem itemLabel="A" itemValue="0"/>
            <f:selectItem itemLabel="N/A" itemValue="1"/>
        </h:selectOneRadio>
    </h:column>
    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.selecFiscalite=='SYSCOHADA_GA'}"><h:outputText value="NOTE 45:"/></h:column>
    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.selecFiscalite=='SYSCOHADA_GA'}"><h:outputText value="Impôts sur les salaires"/></h:column>
    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.selecFiscalite=='SYSCOHADA_GA'}">
        <h:selectOneRadio dir="left" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.selectedExo.execptN45}">
            <f:selectItem itemLabel="A" itemValue="0"/>
            <f:selectItem itemLabel="N/A" itemValue="1"/>
        </h:selectOneRadio>
    </h:column>
    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.selecFiscalite=='SYSCOHADA_GA'}"><h:outputText value="NOTE 46:"/></h:column>
    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.selecFiscalite=='SYSCOHADA_GA'}"><h:outputText value="Détail des loyers versées"/></h:column>
    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.selecFiscalite=='SYSCOHADA_GA'}">
        <h:selectOneRadio dir="left" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.selectedExo.execptN46}">
            <f:selectItem itemLabel="A" itemValue="0"/>
            <f:selectItem itemLabel="N/A" itemValue="1"/>
        </h:selectOneRadio>
    </h:column>
    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.selecFiscalite=='SYSCOHADA_GA'}"><h:outputText value="NOTE 47:"/></h:column>
    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.selecFiscalite=='SYSCOHADA_GA'}"><h:outputText value="Détail des loyers encaissés"/></h:column>
    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.selecFiscalite=='SYSCOHADA_GA'}">
        <h:selectOneRadio dir="left" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.selectedExo.execptN47}">
            <f:selectItem itemLabel="A" itemValue="0"/>
            <f:selectItem itemLabel="N/A" itemValue="1"/>
        </h:selectOneRadio>
    </h:column>
    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.selecFiscalite=='SYSCOHADA_GA'}"><h:outputText value="NOTE 48:"/></h:column>
    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.selecFiscalite=='SYSCOHADA_GA'}"><h:outputText value="Détail des loyers comptabilisés"/></h:column>
    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.selecFiscalite=='SYSCOHADA_GA'}">
        <h:selectOneRadio dir="left" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.selectedExo.execptN48}">
            <f:selectItem itemLabel="A" itemValue="0"/>
            <f:selectItem itemLabel="N/A" itemValue="1"/>
        </h:selectOneRadio>
    </h:column>
    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.selecFiscalite=='SYSCOHADA_GA'}"><h:outputText value="NOTE 49:"/></h:column>
    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.selecFiscalite=='SYSCOHADA_GA'}"><h:outputText value="Fiche immobilière constructions foncières"/></h:column>
    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.selecFiscalite=='SYSCOHADA_GA'}">
        <h:selectOneRadio dir="left" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.selectedExo.execptN49}">
            <f:selectItem itemLabel="A" itemValue="0"/>
            <f:selectItem itemLabel="N/A" itemValue="1"/>
        </h:selectOneRadio>
    </h:column>
    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.selecFiscalite=='SYSCOHADA_GA'}"><h:outputText value="NOTE 50:"/></h:column>
    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.selecFiscalite=='SYSCOHADA_GA'}"><h:outputText value="Contribution des patentes et licences"/></h:column>
    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.selecFiscalite=='SYSCOHADA_GA'}">
        <h:selectOneRadio dir="left" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.selectedExo.execptN50}">
            <f:selectItem itemLabel="A" itemValue="0"/>
            <f:selectItem itemLabel="N/A" itemValue="1"/>
        </h:selectOneRadio>
    </h:column>
    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.selecFiscalite=='SYSCOHADA_GA'}"><h:outputText value="NOTE 51:"/></h:column>
    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.selecFiscalite=='SYSCOHADA_GA'}"><h:outputText value="Contribution des patentes et licences (à annexer à la DSF)"/></h:column>
    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.selecFiscalite=='SYSCOHADA_GA'}">
        <h:selectOneRadio dir="left" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.selectedExo.execptN51}">
            <f:selectItem itemLabel="A" itemValue="0"/>
            <f:selectItem itemLabel="N/A" itemValue="1"/>
        </h:selectOneRadio>
    </h:column>
</h:panelGrid>
<h:panelGrid  width="100%">
    <br> <br>
    <center>
        <h:commandButton value="Valider" styleClass="exp_lienmenu" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.majExercice}"/>
    </center>
</h:panelGrid>

