<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>


<f:subview id="officeMessagerie">
    <a4j:form>

        <center> <h2><h:outputText value="GESTION COURRIERS/MAILS" style="color:green;"/></h2></center>

        <h:panelGrid id="pn2" width="100%" border="0">

            <h:panelGrid styleClass="recherche" width="100%" id="idRecherche">
                <h:panelGrid columns="9" width="100%">
                    <a4j:commandButton title="Plus de critères..." image="/images/rechercher.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.moreSearch}" reRender="idRecherche" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.var_more_search}"/>
                    <a4j:commandButton title="Moins de critères..." image="/images/rechercher.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.moreSearch}" reRender="idRecherche" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.var_more_search}"/>
                    <h:panelGrid  columns="2" width="100%">
                        <h:column><h:outputText value="Tiers/Contact"/></h:column>
                        <h:column><h:inputText style="width:90px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.filtre1}"/></h:column>
                        <h:column><h:outputText value="Objet/Corps"/></h:column>
                        <h:column><h:inputText style="width:90px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.filtre2}"/></h:column>
                    </h:panelGrid>
                    <h:column>
                        <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.sens}" style="width:150px">
                            <f:selectItem itemLabel="Tous mouvements" itemValue="99"/>
                            <f:selectItem itemLabel="Mails envoyés" itemValue="0" itemDisabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.internetActif==0}"/>
                            <f:selectItem itemLabel="Mails reçus" itemValue="1" itemDisabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.internetActif==0}"/>
                            <f:selectItem itemLabel="Mails brouillons" itemValue="2" itemDisabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.internetActif==0}"/>
                            <f:selectItem itemLabel="Courriers envoyés" itemValue="3"/>
                            <f:selectItem itemLabel="Courriers reçus" itemValue="4"/>
                            <f:selectItem itemLabel="Notes de service" itemValue="125"/>
                            <f:selectItem itemLabel="Courriers internes reçus" itemValue="126"/>
                            <f:selectItem itemLabel="Corbeille" itemValue="5"/>
                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.effaceRecherche}" reRender="pn2,scrollTable,msg,lesBoutons,idRecherche,idEmetteur,idNature"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column>
                        <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.lecture}" style="width:150px">
                            <f:selectItem itemLabel="Tous Eléments" itemValue="99"/>
                            <f:selectItem itemLabel="Non lus" itemValue="0"/>
                            <f:selectItem itemLabel="Lus" itemValue="1"/>
                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.effaceRecherche}" reRender="scrollTable,msg,lesBoutons"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.var_more_search}">
                        <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.periode}" style="width:150px">
                            <f:selectItem itemLabel="Toutes périodes" itemValue="99"/>
                            <f:selectItem itemLabel="Jour en cours" itemValue="0"/>
                            <f:selectItem itemLabel="Semaine en cours" itemValue="1"/>
                            <f:selectItem itemLabel="Mois en cours" itemValue="2"/>
                            <f:selectItem itemLabel="Trimestre en cours" itemValue="3"/>
                            <f:selectItem itemLabel="Semestre en cours" itemValue="4"/>
                            <f:selectItem itemLabel="Année en cours" itemValue="5"/>
                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.effaceRecherche}" reRender="scrollTable,msg,lesBoutons"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column id="idEmetteur" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.sens=='0'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.sens=='1'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.sens=='2'}">
                        <h:selectOneMenu id="idEmetteurItems" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.var_emetteur}"  style="width:150px">
                            <f:selectItem itemLabel="Tous émetteurs" itemValue="99"/>
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.mesBalEmetteursItems}" />
                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.effaceRecherche}" reRender="scrollTable,msg,lesBoutons"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column id="idNature" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.sens=='3'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.sens=='4'}">
                        <h:selectOneMenu id="idNaturesItems" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.var_nature}"  style="width:150px">
                            <f:selectItem itemLabel="Toutes natures" itemValue=""/>
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.mesNaturesItem}" />
                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.effaceRecherche}" reRender="scrollTable,msg,lesBoutons"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column id="idStructure" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.modeGroupe}">
                        <h:selectOneMenu id="idStructuresItems" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.var_structure}"  style="width:150px">
                            <f:selectItem itemLabel="Toutes structures" itemValue="0"/>
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.mesStructuresItems}" />
                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.effaceRecherche}" reRender="scrollTable,msg,lesBoutons"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column>
                        <a4j:commandButton id="idValRecherche" value="RECHERCHER" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.executerRequete}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,lesBoutons,scrollTable,msg,corps"/>
                        <rich:hotKey key="return"  handler="#{rich:element('idValRecherche')}.click()" />
                    </h:column>
                </h:panelGrid>
                <h:panelGrid id="panDest" columns="8" width="100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.var_more_search}">
                    <h:column>
                        <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.priorite}"  style="width:150px">
                            <f:selectItem itemLabel="Toutes priorités" itemValue="99"/>
                            <f:selectItem itemLabel="Normale" itemValue="0"/>
                            <f:selectItem itemLabel="Importante" itemValue="1"/>
                            <f:selectItem itemLabel="Prioritaire" itemValue="2"/>
                            <f:selectItem itemLabel="Projet" itemValue="3"/>
                            <f:selectItem itemLabel="Réunion" itemValue="4"/>
                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.effaceRecherche}" reRender="scrollTable,msg,lesBoutons"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column><h:outputText value="Du"/></h:column>
                    <h:column><rich:calendar inputStyle="width:100px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.inpDu}"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" /></h:column>
                    <h:column><h:outputText value="Au"/></h:column>
                    <h:column><rich:calendar inputStyle="width:100px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.inpAu}"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" /></h:column>
                    <h:column id="idActiviteRec">
                        <h:selectOneMenu id="idActiviteItems" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.var_activite_rec}"  style="width:150px">
                            <f:selectItem itemLabel="Toutes activités" itemValue=""/>
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.mesActivitesRecItem}" />
                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.effaceRecherche}" reRender="scrollTable,msg,lesBoutons"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column id="idServiceRec">
                        <h:selectOneMenu id="idServceItems" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.var_service_rec}"  style="width:150px">
                            <f:selectItem itemLabel="Tous services" itemValue=""/>
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.mesServicesRecItems}" />
                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.effaceRecherche}" reRender="scrollTable,msg,lesBoutons"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column id="idCreateur">
                        <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.var_users}"  style="width:150px">
                            <f:selectItem itemLabel="Tous créateurs" itemValue="0"/>
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.mesUsersItem}" />
                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.effaceRecherche}" reRender="scrollTable,msg,lesBoutons"/>
                        </h:selectOneMenu>
                    </h:column>
                </h:panelGrid>

            </h:panelGrid>

            <h:panelGrid id="lesBoutons" columns="16"  width="400px" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.optionTiers.saisieCourrier=='0'}">
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.sens=='1'}"><a4j:commandButton image="/images/mail_envoyer_recevoir.png" title="Recevoir Mail" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.envoyerRecevoir}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.internetActif>=1}" onclick="javascript:Richfaces.showModalPanel('panelBarMaj');" oncomplete="javascript:Richfaces.hideModalPanel('panelBarMaj');" reRender="panelBarMaj,scrollTable,msg,lesBoutons,corps"/></h:column>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.sens=='0'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.sens=='2'}"><a4j:commandButton image="/images/mail_nouveau.png" title="Nouveau Mail" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.nouveauMail}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.internetActif>=1}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView"/></h:column>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.mails.maiId!=0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.mails.maiSens<='2'&&(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.sens=='0'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.sens=='1'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.sens=='2')}"><a4j:commandButton image="/images/mail_repondre.png" title="Répondre" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.repondreUnique}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.internetActif>=1}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView"/></h:column>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.mails.maiId!=0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.mails.maiSens<='2'&&(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.sens=='0'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.sens=='1'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.sens=='2')}"><a4j:commandButton image="/images/mail_repondre_multiple.png" title="Répondre à tous" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.repondreTous}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.internetActif>=1}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView"/></h:column>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.mails.maiId!=0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.mails.maiSens<='2'&&(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.sens=='0'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.sens=='1'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.sens=='2')}"><a4j:commandButton image="/images/mail_faire_suivre.png" title="Faire suivre" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.transfererMail}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.internetActif>=1}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView"/></h:column>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.mails.maiId!=0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.mails.maiSens=='0'&&(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.sens=='0'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.sens=='1'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.sens=='2')}"><a4j:commandButton image="/images/actualiser.png" style="width:26px;height:26px;" title="Renvoyer mail" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.renvoyerMail}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.internetActif>=1}" onclick="if (!confirm('Etes vous sur de vouloir renvoyer le mail sélectionné ?')) return false;javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,msg"/></h:column>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.sens=='3'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.sens=='125'}" ><a4j:commandButton image="/images/courrier_nouveau_envoi.png" title="Nouveau Courrier envoyé" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.nouveauCourrierEnvoi}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView"/></h:column>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.sens=='4'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.sens=='126'}" ><a4j:commandButton image="/images/courrier_nouveau_recu.png" title="Nouveau Courrier reçu" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.nouveauCourrierRecu}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView"/></h:column>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.mails.maiId!=0&&(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.mails.maiSens=='3'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.mails.maiSens=='4'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.mails.maiSens=='125'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.mails.maiSens=='126')}"><a4j:commandButton image="/images/modifier.png" title="Modifier courrier" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.modifierDocument}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView"/></h:column>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.mails.maiId!=0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.mails.maiSens<='4'}"><a4j:commandButton image="/images/mail_marque_lu.png" title="Marquer Lu/non Lu" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.marquerLuNonLu}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idLu,idPj,msg,scrollTable,panelDetails"/></h:column>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.mails.maiId!=0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.mails.maiSens<='4'}"><a4j:commandButton image="/images/mail_marque_lu_tout.png" title="Marquer Lu/non Lu (Toute la liste)" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.marquerLuNonLuTout}" onclick="if (!confirm('Etes vous sur de vouloir supprimer le mail sélectionné ?')) return false;javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idLu,idPj,msg,scrollTable,panelDetails"/></h:column>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.mails.maiId!=0&&(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.mails.maiSens<='6'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.mails.maiSens=='125'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.mails.maiSens=='126')}"><a4j:commandButton image="/images/print.png" title="Imprimer" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.imprimerMail}" reRender="panelImp,formModalImp,panchoixdoc,panelMail"/></h:column>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.mails.maiId!=0&&(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.mails.maiSens<='6'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.mails.maiSens=='125'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.mails.maiSens=='126')}"><a4j:commandButton image="/images/supprimer.png" title="Supprimer" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.supprimerMail}" onclick="if (!confirm('Etes vous sur de vouloir supprimer le mail sélectionné ?')) return false" reRender="modAttente,panelDetails,idLu,idPj,msg,scrollTable,panelDetails"/></h:column>
                <h:column><a4j:commandButton value="REJETS" title="Mails rejeter" style="color:red" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.ouvrirMailRejets}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.mailsRejets}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panalRejets"/></h:column>
                <a4j:commandButton image="/images/actualiser.png" title="Récupération des utilisateurs, des salariés et des tiers des structures du groupe" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.synchroniserTiers}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strmaitrecabinet=='2'}" onclick="if (!confirm('Etes vous sur de vouloir synchroniser les tables Utilisateurs, Salariés et Tiers avec les données des Structures du groupe ?')) return false;javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView"/>
                <a4j:commandButton title="Configuration présentation liste" image="/images/configuration.png" style="height:26px;width:26px" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrConfigListe==1}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.memoriseConfigListeEntete}" onclick="if (!confirm('Etes-vous sur de vouloir enregistrer cette présentation ?')) return false"/>
            </h:panelGrid>

            <h:panelGrid id="lesBoutonsSuite" columns="1"  width="100px" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.optionTiers.saisieCourrier=='1'}">
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.mails.maiId!=0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.mails.maiSens<='6'}"><a4j:commandButton image="/images/print.png" title="Imprimer" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.imprimerMail}" reRender="panelImp,formModalImp,panchoixdoc,panelMail"/></h:column>
            </h:panelGrid>

            <h:panelGrid style="border:solid 0px green;" width="100%">
                <a4j:region renderRegionOnly="false">
                    <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" page="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.pageIndex}" reRender="msg" id="scrollTable" maxPages="20" align="left" for="msg"/>
                    <rich:extendedDataTable rows="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.var_nb_max}" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.dataModelLesMails}" id="msg" styleClass="bg" activeClass="active-row" noDataLabel=" " headerClass="headerTab" border="0" height="300px"  width="100%" rowClasses="rows1,rows2,rowsd" var="msg" activeRowKey="true" rowKeyVar="rkv" selection="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.simpleSelectionEntete}" sortMode="multi" selectionMode="single" tableState="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.configListeEntete}" binding="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.extDTable}">
                        <a4j:support eventsQueue="maQueue" event="onselectionchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.selectionMail}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelDetails,lesBoutons,lesBoutonsSuite"/>
                        <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.visualisationLigne}" reRender="idSubView,panelDetails,lesBoutons,lesBoutonsSuite"/>
                        <rich:column width="4%" sortable="true" sortBy="#{msg.maiSens}" label="Sens" style="text-align:center;">
                            <f:facet name="header"><h:outputText value="S."/></f:facet>
                            <h:graphicImage value="#{msg.sens}" rendered="#{msg.maiSens<=4||msg.maiSens==125||msg.maiSens==126}" height="15px" width="15px"/>
                            <a4j:commandButton image="#{msg.sens}" style="height:15px;width:15px;" onclick="if (!confirm('Etes vous sur de vouloir réactiver le mail sélectionné ?')) return false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.reactiverMail}" reRender="msg" rendered="#{msg.maiSens==5||msg.maiSens==6}"/>
                        </rich:column>
                        <rich:column width="4%" sortable="true" sortBy="#{msg.maiType}" label="Type" style="text-align:center;">
                            <f:facet name="header"><h:outputText value="T."/></f:facet>
                            <h:graphicImage value="#{msg.type}" height="15px" width="15px"/>
                        </rich:column>
                        <rich:column width="5%" sortable="true" sortBy="#{msg.statut}" label="Erreur" style="text-align:center;">
                            <f:facet name="header"><h:outputText value="Erreur"/></f:facet>
                            <h:outputText value="#{msg.statut} #{msg.maiId}" style="color:#{msg.color}" title="#{msg.maiStatut}"/>
                        </rich:column>
                        <rich:column  width="9%" sortable="true" sortBy="#{msg.maiDateCreation}" sortOrder="DESCENDING" label="Date/heure">
                            <f:facet name="header"><h:outputText value="Date/heure"/></f:facet>
                            <h:outputText value="#{msg.maiDateCreation}" style="color:#{msg.color}" title="#{msg.maiDateCreation}">
                                <f:convertDateTime pattern="dd/MM/yy HH:mm" locale="fr"/>
                            </h:outputText>
                        </rich:column>
                        <rich:column  width="12%" sortable="true" sortBy="#{msg.maiNum}" label="N°">
                            <f:facet name="header"><h:outputText value="N°"/></f:facet>
                            <h:outputText value="#{msg.maiNum}/#{msg.reference}" style="color:#{msg.color}" title="#{msg.maiNum}:#{msg.reference}"/>
                        </rich:column>
                        <rich:column  width="10%" sortBy="#{msg.maiEmetteur}" sortable="true" label="Emetteur" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.sens=='0'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.sens=='1'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.sens=='2'}">
                            <f:facet name="header"><h:outputText value="Emetteur"/></f:facet>
                            <h:outputText value="#{msg.maiEmetteur}" style="color:#{msg.color}" title="#{msg.maiEmetteur}"/>
                        </rich:column>
                        <rich:column width="10%" sortable="true" sortBy="#{msg.maiNature}" label="Nature" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.sens=='3'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.sens=='4'}">
                            <f:facet name="header"><h:outputText value="Nature"/></f:facet>
                            <h:outputText value="#{msg.maiNature}" style="color:#{msg.color}" title="#{msg.maiNature}"/>
                        </rich:column>
                        <rich:column  width="13%" sortBy="#{msg.maiTiersRs}" sortable="true" label="Tiers">
                            <f:facet name="header"><h:outputText value="Tiers"/></f:facet>
                            <h:outputText value="#{msg.nomTiers}" style="color:#{msg.color}" title="#{msg.nomTiers}"/>
                        </rich:column>
                        <rich:column  width="10%" sortBy="#{msg.maiDestinataire}" sortable="true" label="Destinataire" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.sens=='0'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.sens=='1'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.sens=='2'}">
                            <f:facet name="header"><h:outputText value="Destinataire"/></f:facet>
                            <h:outputText value="#{msg.maiDestinataire}" style="color:#{msg.color}" title="#{msg.maiDestinataire}"/>
                        </rich:column>
                        <rich:column  width="17%" sortBy="#{msg.maiObjet}" sortable="true" label="Objet">
                            <f:facet name="header"><h:outputText value="Objet"/></f:facet>
                            <h:outputText value="#{msg.maiObjet}" style="color:#{msg.color}" title="#{msg.maiObjet}"/>
                        </rich:column>
                        <rich:column  width="6%" sortable="true" sortBy="#{msg.prioriteLib}" label="Prioritaire">
                            <f:facet name="header"><h:outputText value="Priorité"/></f:facet>
                            <h:outputText value="#{msg.prioriteLib}" style="color:#{msg.color}" title="#{msg.prioriteLib}"/>
                        </rich:column>
                        <rich:column  width="4%" sortable="true" sortBy="#{msg.pj}" label="Pièces jointes" style="text-align:center;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.sens=='0'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.sens=='1'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.sens=='2'}">
                            <f:facet name="header"><h:outputText value="PJ"/></f:facet>
                            <h:graphicImage value="#{msg.pj}" height="20px" width="20px" rendered="#{msg.pj!=null}"/>
                        </rich:column>
                        <rich:column  width="4%" sortable="true" sortBy="#{msg.scan}" label="Scan du courrier" style="text-align:center;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.sens=='3'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.sens=='4'}">
                            <f:facet name="header"><h:outputText value="Scan"/></f:facet>
                            <h:graphicImage value="#{msg.scan}" height="20px" width="20px" rendered="#{msg.scan!=null}"/>
                        </rich:column>
                        <rich:column  width="10%" sortable="true" sortBy="#{msg.prioriteLib}" label="Liste des destinataires">
                            <f:facet name="header"><h:outputText value="Destinataires"/></f:facet>
                            <h:outputText value="#{msg.maiListeNomUser}" style="color:#{msg.color}" title="#{msg.maiListeNomUser}"/>
                        </rich:column>
                    </rich:extendedDataTable>
                </a4j:region>
            </h:panelGrid>

            <h:panelGrid id="panelDetails" width="100%">

                <rich:tabPanel switchType="client" immediate="true"  id="panelGlobal" style="border:0px;">

                    <rich:tab id="tabCorps" label="Contenu">
                        <h:panelGrid id="corps" width="100%" styleClass="bg">
                            <rich:editor theme="advanced" plugins="safari,spellchecker,pagebreak,style,layer,table,save,advhr,advimage,advlink,iespell,inlinepopups,insertdatetime,preview,media,searchreplace,print,contextmenu,paste,directionality,fullscreen,noneditable,visualchars,nonbreaking,xhtmlxtras,template" viewMode="visual" style="width:100%;background:white;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.mails.maiCorps}" readonly="true">
                                <jsp:include flush="true" page="../css/tdt.jsp"/>
                            </rich:editor>
                        </h:panelGrid>
                    </rich:tab>

                    <rich:tab id="tabEntete" label="Entete">
                        <h:panelGrid width="100%" columns="2" columnClasses="clos20,clos80">
                            <h:column><h:outputText value="Date:"/></h:column>
                            <h:column><rich:calendar readonly="true" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.mails.maiDateCreation}" datePattern="dd/MM/yy HH:00" inputSize="8"/></h:column>
                            <h:column><h:outputText value="Numéro:"/></h:column>
                            <h:column>
                                <h:inputText size="30" readonly="true" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.mails.maiNum}"/>&nbsp;&nbsp;&nbsp;
                                <h:outputText value="Nature:" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.mails.maiType==1}"/>&nbsp;
                                <h:inputText readonly="true" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.mails.maiNature}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.mails.maiType==1}"/>
                            </h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.mails.maiType==0}"><h:outputText value="Emetteur:"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.mails.maiType==0}"><h:inputText style="width:100%" readonly="true" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.mails.maiEmetteur}"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.typeTiers==0}"><h:outputText value="Tiers:"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.typeTiers==0}"><h:inputText style="width:100%" readonly="true" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.mails.maiTiersRs}"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.typeTiers==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.tiersDivers}"><h:outputText value="Tiers non référencé:"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.typeTiers==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.tiersDivers}"><h:inputText style="width:100%" readonly="true" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.mails.maiTiersDivers}"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.typeTiers==1}"><h:outputText value="Patient:"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.typeTiers==1}"><h:inputText style="width:100%" readonly="true" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.mails.maiPatientNom}"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.typeTiers==2}"><h:outputText value="Agent:"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.typeTiers==2}"><h:inputText style="width:100%" readonly="true" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.mails.maiAgentNom}"/></h:column>
                            <h:column ><h:outputText value="Destinataire:"/></h:column>
                            <h:column><h:inputText style="width:100%" readonly="true" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.mails.maiDestinataire}"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.mails.maiType==0}"><h:outputText value="Ccc:"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.mails.maiType==0}"><h:inputText style="width:100%" readonly="true" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.mails.maiCc}"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.mails.maiType==0}"><h:outputText value="Cci:"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.mails.maiType==0}"><h:inputText style="width:100%" readonly="true" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.mails.maiCci}"/></h:column>
                            <h:column><h:outputText value="Nos Réf.:"/></h:column>
                            <h:column>
                                <h:inputText style="width:60%" readonly="true" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.mails.maiNosRef}"/>&nbsp;&nbsp;&nbsp;
                                <h:outputText value="Priorité:"/>&nbsp;&nbsp;&nbsp;
                                <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.mails.maiPriorite}" style="width:200px" disabled="true">
                                    <f:selectItem itemLabel="Normale" itemValue="0"/>
                                    <f:selectItem itemLabel="Importante" itemValue="1"/>
                                    <f:selectItem itemLabel="Prioritaire" itemValue="2"/>
                                    <f:selectItem itemLabel="Projet" itemValue="3"/>
                                    <f:selectItem itemLabel="Réunion" itemValue="4"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Objet:"/></h:column>
                            <h:column>
                                <h:inputText style="width:60%" readonly="true" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.mails.maiObjet}"/>&nbsp;&nbsp;&nbsp;
                                <h:outputText value="Vos Réf.:"/>&nbsp;
                                <h:inputText style="width:200px" readonly="true" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.mails.maiVosRef}"/>
                            </h:column>
                            <h:column><h:outputText value="Activité:"/></h:column>
                            <h:column><h:inputText style="width:100%" readonly="true" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.mails.maiActivite}"/></h:column>
                            <h:column><h:outputText value="Service:"/></h:column>
                            <h:column><h:inputText style="width:100%" readonly="true" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.mails.maiService}"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.mails.maiErreur}"><h:outputText value="ERREUR ENVOI:" style="color:red"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.mails.maiErreur}"><h:inputText style="width:100%;color:red;" readonly="true" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.mails.maiStatut}"/></h:column>
                        </h:panelGrid>
                    </rich:tab>

                    <rich:tab id="tabPJ" label="P.J." rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.mails.maiType==0}">
                        <a4j:region renderRegionOnly="false">
                            <rich:extendedDataTable styleClass="bg" id="idPj" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.dataModelLesPJ}"  style="border:1px solid green;" activeClass="active-row" noDataLabel=" "  headerClass="headerTab" height="150px" width="100%" var="pj">
                                <rich:column  width="90%" sortable="true"  sortOrder="DESCENDING" label="Acces PJ">
                                    <f:facet name="header"><h:outputText value="Pièces jointes"/></f:facet>
                                    <h:outputText value="#{pj.malpjAcces}" />
                                </rich:column>
                                <rich:column  width="10%" sortable="true" style="text-align:center;">
                                    <f:facet name="header"><h:outputText value="Voir"/></f:facet>
                                    <h:commandButton image="/images/detail.png"  style="height:15px;width:15px;" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.voirPj}"/>
                                </rich:column >
                            </rich:extendedDataTable>
                        </a4j:region>
                    </rich:tab>

                    <rich:tab id="tabScan" label="Scan courrier" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.mails.maiType==1}">
                        <rich:panel  style="width:100%;">
                            <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.typeFichier==0}" var="sc1">
                                <img alt="scan" src="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.urlIpProd}/epegase/imageServlet/${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.urlphotoProd}" width="100%" height="800px"/>
                            </c:if>
                            <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.typeFichier==1}" var="sc2">
                                <object data="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.fichierUrl}" type="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.fichierMine}" width="100%" height="550">
                                    <a href="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.fichierUrl}"></a>
                                </object>
                            </c:if>
                        </rich:panel>
                    </rich:tab>

                    <rich:tab id="tabLu" label="Lecture" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.mails.maiType==0}">
                        <a4j:region renderRegionOnly="false">
                            <rich:extendedDataTable styleClass="bg" id="idLu" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.dataModelLesmailsLus}"  style="border:1px solid green;" activeClass="active-row" noDataLabel=" "  headerClass="headerTab" height="150px" width="100%" var="lu">
                                <rich:column  width="30%" sortable="true"  sortOrder="DESCENDING" label="Acces Mail">
                                    <f:facet name="header"><h:outputText value="User"/></f:facet>
                                    <h:outputText value="#{lu.malluUser}" />
                                </rich:column >
                                <rich:column  width="30%" sortable="true"  label="Date">
                                    <f:facet name="header"><h:outputText value="Date"/></f:facet>
                                    <h:outputText value="#{lu.malluDateLecture}" >
                                        <f:convertDateTime pattern="dd/MM/yy:HH.mm.ss" locale="fr" />
                                    </h:outputText>
                                </rich:column >
                                <rich:column  width="40%" sortable="true"  label="Note">
                                    <f:facet name="header"><h:outputText value="Note"/></f:facet>
                                    <h:inputText readonly="#{(lu.users.usrid==bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.usersLog.usrid)==false}" size="10" value="#{lu.malluNote}" />
                                    &nbsp;<a4j:commandButton reRender="panelDetails" rendered="#{(lu.users.usrid==bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.usersLog.usrid)==true}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.majMailNote}"  image="/images/valider.png"/>
                                </rich:column >
                            </rich:extendedDataTable>
                        </a4j:region>
                    </rich:tab>

                </rich:tabPanel>
            </h:panelGrid>

        </h:panelGrid>

    </a4j:form>


    <rich:modalPanel domElementAttachment="parent"  id="panalVisuPj" width="1100" height="600" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.showModalPanelPj}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.showModalPanelPj}" var="ajtFil" >
            <f:facet name="header"><h:outputText value="Visualisation de la P.J. (#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.fichierMine})"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <h:column>
                        <a type="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.fichierMine}" href="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.fichierUrl}" target="_blank" title="Lire document"><img src="images/detail.png" alt="lecture"></a>
                    </h:column>&nbsp;&nbsp;
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.fermerVisuPj}" image="/images/close.gif" styleClass="hidelink" reRender="panalVisuPj"/>
                </a4j:form>
            </f:facet>
            <a4j:form enctype="multipart/form-data">
                <h:panelGrid width="100%">
                    <object data="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.fichierUrl}" type="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.fichierMine}" width="100%" height="550">
                        <a href="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.fichierUrl}"></a>
                    </object>
                </h:panelGrid>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"  id="panelImp" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="650" height="400" autosized="true" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.showModalPanelPrint}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.showModalPanelPrint}" var="prt">
            <f:facet name="header"><h:outputText value="Impression" style="color:white;"/></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.closeImpression}" image="/images/close.gif" styleClass="hidelink" reRender="panelImp">
                        <rich:componentControl for="panelImp" attachTo="hideImp" operation="hide" event="onclick"/>
                    </a4j:commandButton>
                </a4j:form>
            </f:facet>
            <a4j:form id="formModalImp" target="_blank">
                <center>
                    <h:outputText value="Choisissez un modèle et un format d'Impression"  style="color:green;"/>
                    <br><br>
                </center>
                <h:panelGrid width="100%" id="idGlobale">
                    <h:panelGrid id="panchoixdoc" width="100%" style="border:solid 1px green;">
                        <f:facet name="header"><h:outputText value="Modèle"/></f:facet>
                        <br>
                        <h:selectOneRadio id="choixDoc" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.var_choix_modele}" >
                            <f:selectItem itemLabel="Mail/Courrier séléctionné" itemValue="0"/>
                            <f:selectItem itemLabel="Liste des Mails/Courriers" itemValue="1"/>
                            <a4j:support eventsQueue="maQueue" reRender="panchoixdoc,docSelect1,docSelect2,listeSelect" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.listeDocImp}" />
                        </h:selectOneRadio>
                        <br>
                        <h:selectOneMenu id="docSelect1" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.nomModeleDocument}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.mails.maiType==0&&!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.affListeDoc}">
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.mailImpressionItems}"/>
                        </h:selectOneMenu>
                        <h:selectOneMenu id="docSelect2" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.nomModeleDocument}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.mails.maiType==1&&!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.affListeDoc}">
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.documentImpressionItems}"/>
                        </h:selectOneMenu>
                        <h:selectOneMenu id="listeSelect" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.nomModeleListe}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.affListeDoc}">
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.listeImpressionItems}"/>
                        </h:selectOneMenu>
                    </h:panelGrid>
                    <br>
                    <h:panelGrid  width="100%" style="border:solid 1px green;background-color:white;">
                        <f:facet name="header"><h:outputText value="Format"/></f:facet>
                        <br>
                        <h:panelGrid  width="100%" columns="9" style="height:80px">
                            <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.utilPrint.imprimanteReseau}">
                                <center>
                                    <h:commandButton image="/images/imp_print.png" onmouseover="this.src='images/imp_print_big.png'" onmouseout="this.src='images/imp_print.png'" value="PRT" title="Impression directe (Imprimantes serveur)" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.imprimerPRT}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.localApplication&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.menuoffice.imp}"/>
                                    <h:selectOneMenu id="impSelect" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.utilPrint.monImprimante}">
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.utilPrint.mesImprimantesServeurItems}"/>
                                    </h:selectOneMenu>
                                </center>
                            </h:panelGroup>
                            <h:commandButton image="/images/imp_apercu.png" onmouseover="this.src='images/imp_apercu_big.png'" onmouseout="this.src='images/imp_apercu.png'" value="JRV" title="Aperçu avant impression" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.imprimerJRV}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');"/>
                            <h:commandButton image="/images/imp_reader.png" onmouseover="this.src='images/imp_reader_big.png'" onmouseout="this.src='images/imp_reader.png'" value="PDF" title="Format PDF" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.imprimerPDF}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.menuoffice.imp}"/>
                            <h:commandButton image="/images/imp_openOffice.png" onmouseover="this.src='images/imp_openOffice_big.png'" onmouseout="this.src='images/imp_openOffice.png'" value="ODT" title="Format OpenOffice" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.imprimerODT}"onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.menuoffice.imp}"/>
                            <h:commandButton image="/images/imp_excel.png" onmouseover="this.src='images/imp_excel_big.png'" onmouseout="this.src='images/imp_excel.png'" value="XLS" title="Tableur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.imprimerXLS}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.menuoffice.imp}"/>
                            <h:commandButton image="/images/imp_word.png" onmouseover="this.src='images/imp_word_big.png'" onmouseout="this.src='images/imp_word.png'" value="DOC" title="Traitement de texte" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.imprimerDOC}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.menuoffice.imp}"/>
                            <h:commandButton image="/images/imp_html.png" onmouseover="this.src='images/imp_html_big.png'" onmouseout="this.src='images/imp_html.png'" value="HTML" title="Export HTML" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.imprimerHTML}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.menuoffice.imp}"/>
                            <h:commandButton image="/images/imp_xml.png" onmouseover="this.src='images/imp_xml_big.png'" onmouseout="this.src='images/imp_xml.png'" value="XML" title="Export XML" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.imprimerXML}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.menuoffice.imp}"/>
                            <a4j:commandButton image="/images/imp_mail.png" onmouseover="this.src='images/imp_mail_big.png'" onmouseout="this.src='images/imp_mail.png'" value="MAIL" title="Envoie MAIL" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.envoieMAIL}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.menuoffice.imp}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="idGlobale,modAttente,panelMail"/>
                        </h:panelGrid>
                    </h:panelGrid>
                    <br>
                    <h:panelGrid  width="100%"  id="panelMail" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.affMail}">
                        <h:panelGrid  width="100%"  style="border:solid 1px green;background-color:white;" columns="2" columnClasses="clos20,clos80">
                            <h:column></h:column>
                            <h:column></h:column>
                            <h:column><h:outputText value="Emetteur:" style="text-decoration:underline;"/></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.impEmetteur}" >
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.utilPrint.lesbalEmetteursItems}"/>
                                </h:selectOneMenu >
                            </h:column>
                            <h:column><h:outputText value="Destinataire:" style="text-decoration:underline;"/></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.impDestinataire}" >
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.utilPrint.lesbalDestinatairesItems}"/>
                                    <f:selectItem itemLabel="" itemValue="" />
                                </h:selectOneMenu >
                            </h:column>
                            <h:column></h:column>
                            <h:column></h:column>
                            <h:column><h:outputText value="Copie à (CC):"/></h:column>
                            <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.impDestinataireCC}"/></h:column>
                            <h:column><h:outputText value="Copie cachée (CCI):"/></h:column>
                            <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.impDestinataireCCI}"/></h:column>
                        </h:panelGrid>
                        <h:panelGrid  width="100%" style="text-align:center;">
                            <h:commandButton image="/images/mail_envoie.png" title="Envoyer mail" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.imprimerMAIL}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.affMail}" id="print" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                        </h:panelGrid>
                    </h:panelGrid>
                </h:panelGrid>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"   headerClass="headerPanel" id="panelBarMaj" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="700" height="80" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.var_showBarProg}">
        <f:facet name="header"><h:outputText value="Lecture des Mails ..."/></f:facet>
        <center>
            <a4j:form >
                <br>
                <a4j:outputPanel id="progressPanelMaj">
                    <rich:progressBar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.utilMail.var_currentValueMsg}" style="width:90%" interval="300" enabled="true" minValue="-1" maxValue="100" id="barprg">
                        <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.utilMail.var_infosMsg} (#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.utilMail.var_currentValueMsg}%)"/>
                    </rich:progressBar>
                </a4j:outputPanel>
            </a4j:form>
        </center>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"  id="panalRejets" width="1000" height="650" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.showModalPanelRejets}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.showModalPanelRejets}" var="rej" >
            <f:facet name="header"><h:outputText value="Liste des mails rejetés"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.fermerMailRejets}" image="/images/close.gif" styleClass="hidelink" reRender="panalRejets"/>
                </a4j:form>
            </f:facet>
            <a4j:form>
                <h:panelGrid width="100%">
                    <a4j:region renderRegionOnly="false">
                        <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" id="scrollTable" maxPages="20" align="left" for="msgRejet"/>
                        <rich:extendedDataTable rows="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.var_nb_max}" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.dataModelMailRejets}" id="msgRejet" styleClass="bg" activeClass="active-row" noDataLabel=" " headerClass="headerTab" border="0" height="250px" width="100%" rowClasses="rows1,rows2,rowsd" var="msgRejet">
                            <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.selectionMailRejet}" reRender="corpsRejet"/>
                            <rich:column  width="10%" sortable="true" sortBy="#{msgRejet.mailDateEnvoie}" sortOrder="DESCENDING" label="Date/heure">
                                <f:facet name="header"><h:outputText value="Date/heure"/></f:facet>
                                <h:outputText value="#{msgRejet.mailDateEnvoie}">
                                    <f:convertDateTime pattern="dd/MM/yy HH:mm" locale="fr"/>
                                </h:outputText>
                            </rich:column>
                            <rich:column  width="20%" sortBy="#{msgRejet.mailExpediteur}" sortable="true" label="Emetteur">
                                <f:facet name="header"><h:outputText value="Emetteur"/></f:facet>
                                <h:outputText value="#{msgRejet.mailExpediteur}"/>
                            </rich:column>
                            <rich:column  width="20%" sortBy="#{msgRejet.mailDestinataire}" sortable="true" label="Destinataire">
                                <f:facet name="header"><h:outputText value="Destinataire"/></f:facet>
                                <h:outputText value="#{msgRejet.mailDestinataire}"/>
                            </rich:column>
                            <rich:column  width="50%" sortBy="#{msgRejet.mailSujet}" sortable="true" label="Objet">
                                <f:facet name="header"><h:outputText value="Objet"/></f:facet>
                                <h:outputText value="#{msgRejet.mailSujet}"/>
                            </rich:column>
                        </rich:extendedDataTable>
                    </a4j:region>
                    <h:panelGrid id="corpsRejet" width="100%" styleClass="bg">
                        <rich:editor theme="advanced" plugins="safari,spellchecker,pagebreak,style,layer,table,save,advhr,advimage,advlink,iespell,inlinepopups,insertdatetime,preview,media,searchreplace,print,contextmenu,paste,directionality,fullscreen,noneditable,visualchars,nonbreaking,xhtmlxtras,template" viewMode="visual" style="width:100%;background:white;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.objetMail.mailContent}" readonly="true">
                            <jsp:include flush="true" page="../css/tdt.jsp"/>
                        </rich:editor>
                    </h:panelGrid>
                    <h:column><h:outputText value="Les mails rejetés ne sont pas enregistrés..." style="color:red"/></h:column>
                </h:panelGrid>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

</f:subview>
