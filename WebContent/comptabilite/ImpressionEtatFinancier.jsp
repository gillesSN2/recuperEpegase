<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>


<f:subview id="etatFinancierExploitation">

    <a4j:form id="etatFinExp">

        <center>
            <h2>
                <h:outputText value="ETATS FINANCIERS (EXPLOITATION) - EXERCICE: #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.selectedExo.execpt_id} : #{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strzonefiscale}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.choixRacine==0}" styleClass="titre"/>
                <h:outputText value="ETATS FINANCIERS (EXPLOITATION) - EXERCICE: #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.selectedExo.execpt_id} : #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.selecFiscalite}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.choixRacine!=0}" styleClass="titre"/>&nbsp;&nbsp;
                <h:commandButton title="Permutter la fiscalité des états financiers" image="/images/permutter.jpeg" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.permutterMesracines}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.choixRacine!=0}" onclick="javascript:Richfaces.showModalPanel('modAttente');" />
            </h2>
        </center>

        <h:panelGrid id="panelGeneral" width="100%">
            <h:panelGrid columns="2" id="panelBoutonEf">
                <h:panelGrid columns="7" styleClass="recherche">
                    <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.var_tableau_selectionne}" style="width:250px;">
                        <f:selectItem itemLabel="Sélectionnez tableau" itemValue=""/>
                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.lesTableauxItems}"/>
                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.selectionEtatFinancier}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="etatFinExpPG,etatFinExp,panelGeneral,panelBoutonEf,entete,resultatDiv,tableResultat,resultatTab,modAttente"/>
                    </h:selectOneMenu>
                    <h:panelGrid styleClass="recherche" columns="2">
                        <h:outputText value="Tableau en cours" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&(bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrModifLiasse<=1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.menucompta.imp&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.testAffImprimer&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.cptTabNom.tablisType==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.afficheValider)==false}"/>
                        <a4j:commandButton value="Calcul tableau sélectionné" style="width:100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&(bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrModifLiasse<=1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.menucompta.imp&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.testAffImprimer&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.cptTabNom.tablisType==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.afficheValider)==true}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.calculTableaux}" onclick="if (!confirm('Etes-vous sur de vouloir exécuter/enregistrer le tableau en cours?')) return false;javascript:Richfaces.showModalPanel('panelBarProg');" oncomplete="javascript:Richfaces.hideModalPanel('panelBarProg');" reRender="modAttente,panelBarProg,etatFinExpPG,progressPanel,barprg,resultatDiv"/>
                        <a4j:commandButton title="Imprimer le tableau en cours" image="/images/print.png" rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.menucompta.imp&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.testAffImprimer)==true}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.initImpressionLiasseEnCours}" reRender="panelImp,formModalImp,panchoixdoc,panelMail"/>
                    </h:panelGrid>
                    <h:panelGrid styleClass="recherche"  columns="2" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.selecFiscalite!='SYSCOHADA'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.selecFiscalite!='SYSCOHADA_GA'}">
                        <h:outputText value="Tableaux Bilan, CR, Tafire" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&(bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrModifLiasse<=1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.menucompta.imp&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.testAffImprimer&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.cptTabNom.tablisType==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.afficheValider)==false}"/>
                        <a4j:commandButton value="Calcul Bilan, CR, Tafire" style="width:100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&(bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrModifLiasse<=1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.menucompta.imp&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.testAffImprimer&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.cptTabNom.tablisType==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.afficheValider)==true}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.calculerBilan}" onclick="if (!confirm('Etes-vous sur de vouloir exécuter/enregistrer les tableaux sélectionnés?')) return false;javascript:Richfaces.showModalPanel('panelBarProg');" oncomplete="javascript:Richfaces.hideModalPanel('panelBarProg');" reRender="modAttente,panelBarProg,etatFinExpPG,progressPanel,barprg,resultatDiv"/>
                        <a4j:commandButton title="Imprimer bilan, CR, et Tafire (Portait)" image="/images/print.png" rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.menucompta.imp&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.testAffImprimer)==true}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.initImpressionLiasseBilanCrTafire}" reRender="panelImp,formModalImp,panchoixdoc,panelMail"/>
                    </h:panelGrid>
                    <h:panelGrid styleClass="recherche"  columns="2" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.selecFiscalite=='SYSCOHADA'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.selecFiscalite=='SYSCOHADA_GA'}">
                        <h:outputText value="Tableaux Bilan, CR, Flux" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&(bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrModifLiasse<=1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.menucompta.imp&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.testAffImprimer&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.cptTabNom.tablisType==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.afficheValider)==false}"/>
                        <a4j:commandButton value="Calcul Bilan, CR, Flux" style="width:100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&(bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrModifLiasse<=1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.menucompta.imp&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.testAffImprimer&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.cptTabNom.tablisType==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.afficheValider)==true}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.calculerBilan}" onclick="if (!confirm('Etes-vous sur de vouloir exécuter/enregistrer les tableaux sélectionnés?')) return false;javascript:Richfaces.showModalPanel('panelBarProg');" oncomplete="javascript:Richfaces.hideModalPanel('panelBarProg');" reRender="modAttente,panelBarProg,etatFinExpPG,progressPanel,barprg,resultatDiv"/>
                        <a4j:commandButton title="Imprimer bilan, CR, et Flux (Portrait)" image="/images/print.png" rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.menucompta.imp&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.testAffImprimer)==true}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.initImpressionLiasseBilanCrTafire}" reRender="panelImp,formModalImp,panchoixdoc,panelMail"/>
                    </h:panelGrid>
                    <h:panelGrid styleClass="recherche"  columns="3" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.selecFiscalite!='SYSCOHADA'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.selecFiscalite!='SYSCOHADA_GA'}">
                        <h:outputText value="Tableaux complémentaires et annexes" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&(bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrModifLiasse<=1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.menucompta.imp&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.testAffImprimer&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.cptTabNom.tablisType==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.afficheValider)==false}"/>
                        <a4j:commandButton value="Calcul tableaux et annexes" style="width:100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&(bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrModifLiasse<=1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.menucompta.imp&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.testAffImprimer&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.cptTabNom.tablisType==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.afficheValider)==true}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.calculerTableauxAnnexes}" onclick="if (!confirm('Etes-vous sur de vouloir exécuter/enregistrer les tableaux sélectionnés?')) return false;javascript:Richfaces.showModalPanel('panelBarProg');" oncomplete="javascript:Richfaces.hideModalPanel('panelBarProg');" reRender="modAttente,panelBarProg,etatFinExpPG,progressPanel,barprg,resultatDiv"/>
                        <a4j:commandButton title="Imprimer la liasse complète" image="/images/print.png" rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.menucompta.imp&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.testAffImprimer)==true}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.initImpressionLiasseComplete}" reRender="panelImp,formModalImp,panchoixdoc,panelMail"/>
                        <a4j:commandButton title="Imprimer les tableaux complémentaires (Paysage)" image="/images/print.png" rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.menucompta.imp&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.testAffImprimer)==true}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.initImpressionLiasseTableaux}" reRender="panelImp,formModalImp,panchoixdoc,panelMail"/>
                    </h:panelGrid>
                    <h:panelGrid styleClass="recherche"  columns="4" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.selecFiscalite=='SYSCOHADA'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.selecFiscalite=='SYSCOHADA_GA'}">
                        <h:outputText value="Notes explicatives" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&(bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrModifLiasse<=1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.menucompta.imp&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.testAffImprimer&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.cptTabNom.tablisType==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.afficheValider)==false}"/>
                        <a4j:commandButton value="Calcul des notes explicatives" style="width:100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&(bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrModifLiasse<=1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.menucompta.imp&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.testAffImprimer&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.cptTabNom.tablisType==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.afficheValider)==true}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.calculerTableauxAnnexes}" onclick="if (!confirm('Etes-vous sur de vouloir exécuter/enregistrer les tableaux sélectionnés?')) return false;javascript:Richfaces.showModalPanel('panelBarProg');" oncomplete="javascript:Richfaces.hideModalPanel('panelBarProg');" reRender="modAttente,panelBarProg,etatFinExpPG,progressPanel,barprg,resultatDiv"/>
                        <a4j:commandButton title="Imprimer les pages 1 à  5 et les notes explicatives 01 & 02 (Portrait)" image="/images/print.png" rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.menucompta.imp&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.testAffImprimer)==true}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.initImpressionNotesExplicatives01}" reRender="panelImp,formModalImp,panchoixdoc,panelMail"/>
                        <a4j:commandButton title="Imprimer les notes explicatives 03=>24, 27B=>33 (Paysage)" image="/images/print.png" rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.menucompta.imp&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.testAffImprimer)==true}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.initImpressionNotesExplicatives02}" reRender="panelImp,formModalImp,panchoixdoc,panelMail"/>
                        <a4j:commandButton title="Imprimer les notes explicatives 25, 26, 27A, 34, 35, 36 (Portrait)" image="/images/print.png" rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.menucompta.imp&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.testAffImprimer)==true}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.initImpressionNotesExplicatives03}" reRender="panelImp,formModalImp,panchoixdoc,panelMail"/>
                    </h:panelGrid>
                    <h:panelGrid styleClass="recherche"  columns="4" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.selecFiscalite=='SYSCOHADA_GA'}">
                        <h:outputText value="D.S.F." rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&(bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrModifLiasse<=1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.menucompta.imp&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.testAffImprimer&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.cptTabNom.tablisType==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.afficheValider)==false}"/>
                        <a4j:commandButton value="Calcul DSF" style="width:100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&(bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrModifLiasse<=1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.menucompta.imp&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.testAffImprimer&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.cptTabNom.tablisType==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.afficheValider)==true}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.calculerTableauxDSF}" onclick="if (!confirm('Etes-vous sur de vouloir exécuter/enregistrer les tableaux sélectionnés?')) return false;javascript:Richfaces.showModalPanel('panelBarProg');" oncomplete="javascript:Richfaces.hideModalPanel('panelBarProg');" reRender="modAttente,panelBarProg,etatFinExpPG,progressPanel,barprg,resultatDiv"/>
                        <a4j:commandButton title="Imprimer la DSF (Paysage)" image="/images/print.png" rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.menucompta.imp&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.testAffImprimer)==true}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.initImpressionDSF}" reRender="panelImp,formModalImp,panchoixdoc,panelMail"/>
                    </h:panelGrid>
                </h:panelGrid>
                <h:panelGrid columns="9" styleClass="recherche">
                    <a4j:commandButton image="/images/actualiser.png" title="Actualiser le tableau en cours" rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.menucompta.imp&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.testAffImprimer)==true}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.selectionEtatFinancierSuite}" onclick="javascript:Richfaces.showModalPanel('modAttente');" reRender="modAttente,panelGeneral,panelBarProg,etatFinExpPG,progressPanel,barprg,resultatDiv"/>
                    <a4j:commandButton image="/images/modifier.png" title="Modifier le tableau sélectionné"   rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&(bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrModifLiasse==1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.menucompta.maj&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.testAffImprimer&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.cptTabNom.tablisType==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.afficheValider)==true}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.modifieTableaux}" onclick="if (!confirm('Etes-vous sur de vouloir modifier le tableau en cours?')) return false;javascript:Richfaces.showModalPanel('modAttente');" reRender="modAttente,panelGeneral,panelBarProg,etatFinExpPG,progressPanel,barprg,resultatDiv"/>
                    <a4j:commandButton image="/images/supprimer.png" title="Supprimer le tableau sélectionné" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&(bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrModifLiasse<=1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.menucompta.sup&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.testAffImprimer&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.cptTabNom.tablisType==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.afficheValider)==true}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.supprimeTableaux}" onclick="if (!confirm('Etes-vous sur de vouloir supprimer le tableau en cours?')) return false;javascript:Richfaces.showModalPanel('modAttente');" reRender="modAttente,panelGeneral,panelBarProg,etatFinExpPG,progressPanel,barprg,resultatDiv"/>
                    <a4j:commandButton image="/images/duplicate.png" title="Dupliquer le tableau sélectionné à partir de N-1" style="height:28px;width:28px" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&(bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrModifLiasse<=1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.menucompta.dup&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.testAffImprimer&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.afficheValider)==true}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.duppliqueTableaux}" onclick="if (!confirm('Etes-vous sur de vouloir Dupliquer le tableau en cours à partir de N-1?')) return false;javascript:Richfaces.showModalPanel('modAttente');" reRender="modAttente,panelGeneral,panelBarProg,etatFinExpPG,progressPanel,barprg,resultatDiv"/>
                    <a4j:commandButton image="/images/detail.png" title="Détail des formules du tableau en cours" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.menucompta.imp&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.testAffImprimer)==true}" oncomplete="javascript:Richfaces.showModalPanel('panelFormule');" reRender="panelFormule"/>
                    <h:commandButton image="/images/configuration.png" title="Mise à jour des formules de tous les tableaux" style="height:28px;width:28px" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.majFormules}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.afficheValider}" onclick="if (!confirm('Etes-vous sur de vouloir mettre à jour les formules des tableaux?')) return false;javascript:Richfaces.showModalPanel('modAttente');"/>
                    <a4j:commandButton image="/images/parametre.png" title="Contrôle des comptes utilisés" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.afficheValider}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.controleComptes}" onclick="if (!confirm('Etes-vous sur de vouloir contrôler le tableau en cours?')) return false;javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelErreur"/>
                    <h:commandButton image="/images/transferer.png" title="Exporter la liasse complète" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.afficheValider}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.exporterLiasse}" onclick="if (!confirm('Etes-vous sur de vouloir exporter les liasses au format XML?')) return false;javascript:Richfaces.showModalPanel('modAttente');"/>
                    <h:column id="idFichier" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.afficheFichierExport}">
                            <a type="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.fichierMine}" href="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.fichierUrl}" download="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.nomFichier}" title="Télécharger document"><img src="images/download.png" alt="télécharger"></a>
                    </h:column>
                </h:panelGrid>
            </h:panelGrid>

            <h:panelGrid  width="100%" style="max-height:100%;border:1px solid black" id="entete">
                <h:panelGrid columns="6" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.cptTabNom.tablisType==0||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.cptTabNom.tablisType==5)&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.afficheValider}" style="border:0px solid green;margin-top:1px;height:50px;width:100%" styleClass="col">
                    <h:outputText value="Date de Début"/>
                    <rich:calendar  inputSize="8" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.dateDebCalcul}"  style="background-color:white;" locale="FR"   enableManualInput="true" datePattern="dd/MM/yyyy"  />
                    <h:outputText value="Date de Fin"/>
                    <rich:calendar  inputSize="8" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.dateFinCalcul}" style="background-color:white;" locale="FR"   enableManualInput="true" datePattern="dd/MM/yyyy" />
                    <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.var_tableau_selectionne=='BP'}">
                        <h:outputText value="Comment est le résultat (CH)?"/>
                        <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.var_resultatAffecte}">
                            <f:selectItem itemLabel="En instance d'affectation (Comptes 12 N)" itemValue="0"/>
                            <f:selectItem itemLabel="Totalement affecté (BP=CH + BP=CI N-1)" itemValue="1"/>
                            <f:selectItem itemLabel="Partiellement affecté (Compte 121 + 129 N)" itemValue="2"/>
                            <f:selectItem itemLabel="RAN N (Compte 12 N + BP=CJ)" itemValue="3"/>
                            <f:selectItem itemLabel="RAN N (Compte 12 N - Compte 13 N)" itemValue="4"/>
                            <f:selectItem itemLabel="Formule personnelle" itemValue="5"/>
                        </h:selectOneMenu>
                    </h:panelGroup>
                    <h:panelGroup>
                        <h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.var_jrxsit}"/> <h:outputText value="Inclure journaux de situation"/><br>
                        <h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.var_jrxrsv}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrJrxReserve==0}"/> <h:outputText value="Inclure journaux privés" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrJrxReserve==0}"/>
                    </h:panelGroup>
                </h:panelGrid>

                <t:div id="resultatDiv" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.cptTabNom.tablis_id!=0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.cptTabNom.tablisType==0}" style="overflow-x:scroll;width:100%;max-height:100%;" >
                    <rich:tabPanel switchType="client" immediate="true"  style="width:100%;border:0px;">
                        <rich:tab label="Tableau">
                            <jsp:include flush="true" page="ImpressionEtatFinancier_Type0.jsp"/>
                        </rich:tab>
                        <rich:tab label="Notes explicatives" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.afficheNote}">
                            <rich:editor theme="advanced" plugins="safari,spellchecker,pagebreak,style,layer,table,save,advhr,advimage,advlink,iespell,inlinepopups,insertdatetime,preview,media,searchreplace,print,contextmenu,paste,directionality,fullscreen,noneditable,visualchars,nonbreaking,xhtmlxtras,template" viewMode="visual" style="width:100%;background:white;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.notesExplicatives}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.selectedExo.execptLiasse}">
                                <jsp:include flush="true" page="../css/tdt.jsp"/>
                            </rich:editor>
                            <br>
                            <center>
                                <a4j:commandButton image="/images/valider_big.png" title="Enregistrer le note explicative" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.saveNoteExplicative}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente"/>
                            </center>
                            <br>
                        </rich:tab>

                    </rich:tabPanel>
                </t:div>

                <h:panelGrid width="100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.cptTabNom.tablisType==2}" style="margin-top:1px;">
                    <jsp:include flush="true" page="ImpressionEtatFinancier_Type2.jsp"/>
                </h:panelGrid>

                <h:panelGrid  width="100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.cptTabNom.tablisType==3}" style="margin-top:1px;" >
                    <jsp:include flush="true" page="ImpressionEtatFinancier_Type3.jsp"/>
                </h:panelGrid>

                <h:panelGrid width="100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.cptTabNom.tablisType==4}" style="margin-top:1px;">
                    <jsp:include flush="true" page="ImpressionEtatFinancier_Type4.jsp"/>
                </h:panelGrid>

                <h:panelGrid width="100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.cptTabNom.tablisType==6}" style="margin-top:1px;">
                    <jsp:include flush="true" page="ImpressionEtatFinancier_Type6.jsp"/>
                </h:panelGrid>

            </h:panelGrid>

        </h:panelGrid>
    </a4j:form>

    <rich:modalPanel domElementAttachment="parent"   headerClass="headerPanel" id="panelBarProg" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);"  width="500" height="80" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.var_showBarProg}">
        <f:facet name="header"><h:outputText value="Calcul du tableau en cours..."/></f:facet>
        <center>
            <a4j:form >
                <br>
                <a4j:outputPanel id="progressPanel">
                    <rich:progressBar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.var_currentValue}" style="width:90%" interval="300" enabled="true" minValue="-1" maxValue="100" id="barprg">
                        <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.tabResultats.tabresNomFr} (#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.tabResultats.tabresReference}:#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.colonneEnCours} #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.elementEnCours}) #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.var_currentValue} % "/>
                    </rich:progressBar>
                </a4j:outputPanel>
            </a4j:form>
        </center>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"  headerClass="headerPanel" id="panelFormule"style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);"  width="600" height="250">
        <center>
            <f:facet name="header"><h:outputText value="Détail des formules du tableau"/></f:facet>
            <f:facet name="controls">
                <h:panelGroup>
                    <h:graphicImage value="/images/close.gif" id="hidelink1For"/>
                    <rich:componentControl for="panelFormule" attachTo="hidelink1For" operation="hide" event="onclick"/>
                </h:panelGroup>
            </f:facet>
            <a4j:form id="formModalFor" target="_blank">
                <h:panelGrid  width="100%" >
                    <h:panelGrid  width="100%" style="border:solid 0px black;background-color:white;">
                        <f:facet name="header"><h:outputText value="Format"/></f:facet>
                        <br>
                        <h:panelGrid  width="100%" columns="8" style="height:80px">
                            <h:commandButton image="/images/imp_print.png" onmouseover="this.src='images/imp_print_big.png'" onmouseout="this.src='images/imp_print.png'" value="PRT" title="Impression directe" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.imprimerForPRT}"onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.menucompta.imp}"/>
                            <h:commandButton image="/images/imp_apercu.png" onmouseover="this.src='images/imp_apercu_big.png'" onmouseout="this.src='images/imp_apercu.png'" value="JRV" title="Aperçu avant impression" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.imprimerForJRV}"onclick="javascript:Richfaces.showModalPanel('modAttenteImp');"/>
                            <h:commandButton image="/images/imp_reader.png" onmouseover="this.src='images/imp_reader_big.png'" onmouseout="this.src='images/imp_reader.png'" value="PDF" title="Format PDF" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.imprimerForPDF}"onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.menucompta.imp}"/>
                            <h:commandButton image="/images/imp_openOffice.png" onmouseover="this.src='images/imp_openOffice_big.png'" onmouseout="this.src='images/imp_openOffice.png'" value="ODT" title="Format OpenOffice" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.imprimerForODT}"onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.menucompta.imp}"/>
                            <h:commandButton image="/images/imp_excel.png" onmouseover="this.src='images/imp_excel_big.png'" onmouseout="this.src='images/imp_excel.png'" value="XLS" title="Tableur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.imprimerForXLS}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.menucompta.imp}"/>
                            <h:commandButton image="/images/imp_word.png" onmouseover="this.src='images/imp_word_big.png'" onmouseout="this.src='images/imp_word.png'" value="DOC" title="Traitement de texte" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.imprimerForDOC}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.menucompta.imp}"/>
                            <h:commandButton image="/images/imp_html.png" onmouseover="this.src='images/imp_html_big.png'" onmouseout="this.src='images/imp_html.png'" value="HTML" title="Export HTML" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.imprimerForHTML}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.menucompta.imp}"/>
                            <h:commandButton image="/images/imp_xml.png" onmouseover="this.src='images/imp_xml_big.png'" onmouseout="this.src='images/imp_xml.png'" value="XML" title="Export XML" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.imprimerForXML}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.menucompta.imp}"/>
                        </h:panelGrid>
                        <br>
                    </h:panelGrid>
                </h:panelGrid>
            </a4j:form>
        </center>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"   headerClass="headerPanel" id="panelImp" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="600" height="300" autosized="true" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.showModalPanelPrint}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.showModalPanelPrint}" var="prt">
            <f:facet name="header"><h:outputText value="Impression"/></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.closeImpression}" image="/images/close.gif" styleClass="hidelink" reRender="panelImp" id="hideImp">
                        <rich:componentControl for="panelImp" attachTo="hideImp" operation="hide" event="onclick"/>
                    </a4j:commandButton>
                </a4j:form>
            </f:facet>
            <a4j:form id="formModalImp" target="_blank">
                <h:panelGrid  width="100%" >
                    <h:panelGrid  width="100%" style="border:solid 1px black;background-color:white;">
                        <f:facet name="header"><h:outputText value="Format"/></f:facet>
                        <br>
                        <h:panelGrid  width="100%" columns="9" style="height:80px">
                            <h:commandButton image="/images/imp_print.png" onmouseover="this.src='images/imp_print_big.png'" onmouseout="this.src='images/imp_print.png'" value="PRT" title="Impression directe" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.imprimerPRT}"onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.menucompta.imp}"/>
                            <h:commandButton image="/images/imp_apercu.png" onmouseover="this.src='images/imp_apercu_big.png'" onmouseout="this.src='images/imp_apercu.png'" value="JRV" title="Aperçu avant impression" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.imprimerJRV}"onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" />
                            <h:commandButton image="/images/imp_reader.png" onmouseover="this.src='images/imp_reader_big.png'" onmouseout="this.src='images/imp_reader.png'" value="PDF" title="Format PDF" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.imprimerPDF}"onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.menucompta.imp}"/>
                            <h:commandButton image="/images/imp_openOffice.png" onmouseover="this.src='images/imp_openOffice_big.png'" onmouseout="this.src='images/imp_openOffice.png'" value="ODT" title="Format OpenOffice" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.imprimerODT}"onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.menucompta.imp}"/>
                            <h:commandButton image="/images/imp_excel.png" onmouseover="this.src='images/imp_excel_big.png'" onmouseout="this.src='images/imp_excel.png'" value="XLS" title="Tableur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.imprimerXLS}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.menucompta.imp}"/>
                            <h:commandButton image="/images/imp_word.png" onmouseover="this.src='images/imp_word_big.png'" onmouseout="this.src='images/imp_word.png'" value="DOC" title="Traitement de texte" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.imprimerDOC}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.menucompta.imp}"/>
                            <h:commandButton image="/images/imp_html.png" onmouseover="this.src='images/imp_html_big.png'" onmouseout="this.src='images/imp_html.png'" value="HTML" title="Export HTML" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.imprimerHTML}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.menucompta.imp}"/>
                            <h:commandButton image="/images/imp_xml.png" onmouseover="this.src='images/imp_xml_big.png'" onmouseout="this.src='images/imp_xml.png'" value="XML" title="Export XML" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.imprimerXML}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.menucompta.imp}"/>
                            <h:commandButton image="/images/imp_mail.png" onmouseover="this.src='images/imp_mail_big.png'" onmouseout="this.src='images/imp_mail.png'" value="MAIL" title="Envoie MAIL" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.envoieMAIL}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.menucompta.imp}" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                        </h:panelGrid>
                        <br>
                    </h:panelGrid>
                    <h:panelGrid  width="100%"  id="panelMail" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.affMail}">
                        <h:panelGrid  width="100%"  style="border:solid 1px black;background-color:white;" columns="2" columnClasses="clos20,clos80">
                            <h:column></h:column>
                            <h:column></h:column>
                            <h:column><h:outputText value="Emetteur:" style="text-decoration:underline;"/></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.impEmetteur}" >
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.utilPrint.lesbalEmetteursItems}"/>
                                </h:selectOneMenu >
                            </h:column>
                            <h:column><h:outputText value="Destinataire:" style="text-decoration:underline;"/></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.impDestinataire}" >
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.utilPrint.lesbalDestinatairesItems}"/>
                                    <f:selectItem itemLabel="" itemValue=""/>
                                </h:selectOneMenu >
                            </h:column>
                            <h:column></h:column>
                            <h:column></h:column>
                            <h:column><h:outputText value="Copie à (CC):"/></h:column>
                            <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.impDestinataireCC}"/></h:column>
                            <h:column><h:outputText value="Copie cachée (CCI):"/></h:column>
                            <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.impDestinataireCCI}"/></h:column>
                        </h:panelGrid>
                        <h:panelGrid  width="100%" style="text-align:center;">
                            <h:commandButton image="/images/mail_envoie.png" title="Envoyer mail" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.imprimerMAIL}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.affMail}" id="print" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                        </h:panelGrid>
                    </h:panelGrid>
                </h:panelGrid>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"  id="panelEcritureDetail" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="1200" height="650" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.showModalPanelDetailCalcul}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.showModalPanelDetailCalcul}" var="bcp">
            <f:facet name="header"><h:outputText value="Détail du poste #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.tabResultats.tabresLibFr} : #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.tabResultats.tabresReference}"/></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.fermerDetailLigne}" image="/images/close.gif" styleClass="hidelink" reRender="panelEcritureDetail">
                        <rich:componentControl for="panelEcritureDetail" attachTo="hideImp" operation="hide" event="onclick"/>
                    </a4j:commandButton>
                </a4j:form>
            </f:facet>
            <h:panelGrid width="100%">
                <rich:extendedDataTable id="tabletabformule" height="90px"  activeClass="active-row" noDataLabel=" "  footerClass="bard"headerClass="headerTab" styleClass="bg"  width="100%" border="0"  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.lesFormules}" var="formule">
                    <rich:column width="20%" sortable="false" sortBy="#{formule.tabfor_id}" sortOrder="ASCENDING">
                        <f:facet name="header" ><h:outputText value="Type"/></f:facet>
                        <h:outputText value="#{formule.var_sens}" />
                    </rich:column >
                    <rich:column width="80%" sortable="false">
                        <f:facet name="header" ><h:outputText value="FORMULE"/></f:facet>
                        <h:outputText value="#{formule.tabforFormule}" />
                    </rich:column >
                </rich:extendedDataTable>
            </h:panelGrid>
            <br>
            <a4j:form id="formModalEcritureDetail">
                <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" id="scrollTable" maxPages="20"align="left" for="tableCompte"/>
                <rich:extendedDataTable rows="100" id="tableCompte" footerClass="bard" headerClass="headerTab" enableContextMenu="true" activeClass="active-row" border="0" rowClasses="rows1,rows2,rowsd" noDataLabel=" " width="100%" height="450px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.dataModelEcrituresDetail}" var="balance">
                    <rich:column label="N° Compte" sortable="false" width="100px">
                        <f:facet name="header"><h:outputText  value="Compte" /></f:facet>
                        <h:outputText value="#{balance.ecrBalCompte}" style="#{balance.gras}"/>
                    </rich:column>
                    <rich:column label="Libellé compte" sortable="false" width="350px">
                        <f:facet name="header"><h:outputText  value="Libellé compte" /></f:facet>
                        <h:outputText value="#{balance.ecrBalLibelle}" style="#{balance.gras}"/>
                    </rich:column>
                    <rich:column label="Débit" sortable="false" width="100px" style="text-align:right;">
                        <f:facet name="header"><h:outputText  value="Débit AN" /></f:facet>
                        <h:outputText value="#{balance.ecrDebitAN}" rendered="#{balance.ecrDebitAN!=0}" style="#{balance.gras}">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                        </h:outputText>
                    </rich:column>
                    <rich:column label="Crédit" sortable="false" width="120px" style="text-align:right;">
                        <f:facet name="header"><h:outputText  value="Crédit AN" /></f:facet>
                        <h:outputText value="#{balance.ecrCreditAN}" rendered="#{balance.ecrCreditAN!=0}" style="#{balance.gras}">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                        </h:outputText>
                    </rich:column>
                    <rich:column label="Débit" sortable="false" width="120px" style="text-align:right;">
                        <f:facet name="header"><h:outputText  value="Débit Mvts" /></f:facet>
                        <h:outputText value="#{balance.ecrDebitMVTS}" rendered="#{balance.ecrDebitMVTS!=0}" style="#{balance.gras}">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                        </h:outputText>
                    </rich:column>
                    <rich:column label="Crédit" sortable="false" width="120px" style="text-align:right;">
                        <f:facet name="header"><h:outputText  value="Crédit Mvts" /></f:facet>
                        <h:outputText value="#{balance.ecrCreditMVTS}" rendered="#{balance.ecrCreditMVTS!=0}" style="#{balance.gras}">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                        </h:outputText>
                    </rich:column>
                    <rich:column label="Débit" sortable="false" width="120px" style="text-align:right;">
                        <f:facet name="header"><h:outputText  value="Débit Solde" /></f:facet>
                        <h:outputText value="#{balance.ecrDebitSOLDE}" rendered="#{balance.ecrDebitSOLDE!=0}" style="#{balance.gras}">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                        </h:outputText>
                    </rich:column>
                    <rich:column label="Crédit" sortable="false" width="120px" style="text-align:right;">
                        <f:facet name="header"><h:outputText  value="Crédit Solde" /></f:facet>
                        <h:outputText value="#{balance.ecrCreditSOLDE}" rendered="#{balance.ecrCreditSOLDE!=0}" style="#{balance.gras}">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                        </h:outputText>
                    </rich:column>
                </rich:extendedDataTable>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"  id="panelErreur" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="1100" height="600" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.showModalPanelErreur}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.showModalPanelErreur}" var="err">
            <f:facet name="header"><h:outputText value="Liste des erreurs des tableaux"/></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.fermerControleComptes}" image="/images/close.gif" styleClass="hidelink" reRender="panelErreur">
                        <rich:componentControl for="panelErreur" attachTo="hideImp" operation="hide" event="onclick"/>
                    </a4j:commandButton>
                </a4j:form>
            </f:facet>
            <br>
            <a4j:form id="formModalErreur">
                <rich:extendedDataTable rows="100" id="tableFormule" footerClass="bard" headerClass="headerTab" enableContextMenu="true" activeClass="active-row" border="0" rowClasses="rows1,rows2,rowsd" noDataLabel=" " width="100%" height="200px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.dataModelFormules}" var="formule">
                    <rich:column label="Formule" sortable="false" width="100%">
                        <f:facet name="header"><h:outputText  value="Formules utilisées dans les tableaux" /></f:facet>
                        <h:outputText value="#{formule}"/>
                    </rich:column>
                </rich:extendedDataTable>
                <br>
                <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" id="scrollTable" maxPages="20"align="left" for="tableErreur"/>
                <rich:extendedDataTable rows="100" id="tableErreur" footerClass="bard" headerClass="headerTab" enableContextMenu="true" activeClass="active-row" border="0" rowClasses="rows1,rows2,rowsd" noDataLabel=" " width="100%" height="300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.dataModelErreur}" var="err">
                    <rich:column label="N° Compte" sortable="false" width="100px">
                        <f:facet name="header"><h:outputText  value="Compte" /></f:facet>
                        <h:outputText value="#{err.plcCompte}"/>
                    </rich:column>
                    <rich:column label="Libellé compte" sortable="false" width="350px">
                        <f:facet name="header"><h:outputText  value="Libellé compte" /></f:facet>
                        <h:outputText value="#{err.plcLibelleCpteFR}"/>
                    </rich:column>
                    <rich:column label="Observation" sortable="false" width="500px">
                        <f:facet name="header"><h:outputText  value="Observation" /></f:facet>
                        <h:outputText value="#{err.plcLibelleCpteUK}"/>
                    </rich:column>
                </rich:extendedDataTable>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

</f:subview>
