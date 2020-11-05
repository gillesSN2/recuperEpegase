<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="medicentetegene">

    <a4j:form>
        <rich:hotKey key="return" handler="return true;"/>

        <center>
            <h2>
                <h:outputText value="CONSULTATIONS GENERALES" style="color:green;"/>&nbsp;&nbsp;&nbsp;
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.infirmerie}"><h:outputText value="Site:"/></h:column>
                <h:column id="idSelSite" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.infirmerie}">
                    <h:selectOneMenu style="width:200px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.inpSite}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrSite==null||bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrSite==''}">
                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.mesSitesItems}" />
                    </h:selectOneMenu>
                    <h:inputText style="width:200px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrSite}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrSite!=null&&bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrSite!=''}" readonly="true" disabled="true"/>
                </h:column>
            </h2>
        </center>

        <h:panelGrid  columns="1" width="100%" id="document" >
            <h:panelGrid  id="panCtrl"  styleClass="recherche"  width="100%">
                <h:panelGrid columns="9" width="100%">
                    <a4j:commandButton title="Plus de critères..." image="/images/rechercher.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.moreSearch}" reRender="panCtrl" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.var_more_search}"/>
                    <a4j:commandButton title="Moins de critères..." image="/images/rechercher.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.moreSearch}" reRender="panCtrl" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.var_more_search}"/>
                    <h:column><h:outputText value="N°"/></h:column>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.inpNum}" size="5"/></h:column>
                    <h:column>
                        <h:selectOneMenu id="idSerie" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.inpSerie}" style="width:100px;">
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.mesSerieUserItem}" />
                        </h:selectOneMenu>
                    </h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.infirmerie==false}">
                        <h:selectOneMenu id="idFamille" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.inpFam}" style="width:150px;">
                            <f:selectItem itemLabel="Toutes Catégories" itemValue="100"/>
                            <f:selectItems  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.mesCategoriesItems}"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column>
                        <h:selectOneMenu id="idEtat" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.inpEtat}" style="width:100px;">
                            <f:selectItem itemLabel="Tous Etats" itemValue="100"/>
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.mesEtatsItems}"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column>
                        <h:selectOneMenu id="idPeriode" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.periode}" style="width:150px;" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.var_more_search}">
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.mesPeriodesItems}"/>
                        </h:selectOneMenu>
                        <h:selectOneMenu id="idActivite" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.inpActivite}" style="width:150px;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.var_more_search&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.tActivite}">
                            <f:selectItem itemLabel="Toutes Activités" itemValue="100"/>
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.mesActivitesItems}" />
                        </h:selectOneMenu>
                    </h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.var_affiche_service}">
                        <h:selectOneMenu id="idService" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.inpService}" style="width:150px;">
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.mesServicesItems}" />
                        </h:selectOneMenu>
                    </h:column>
                    <h:column>
                        <a4j:commandButton id="idValRecherche" value="RECHERCHER" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.executerRequete}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelBouton,table,scrollTable,pnlgrttotal,idSelSite"/>
                        <rich:hotKey key="return"  handler="#{rich:element('idValRecherche')}.click()" />
                    </h:column>
                </h:panelGrid>
                <h:panelGrid id="panDest" columns="8" width="100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.var_more_search}">
                    <h:column><h:outputText value="Nom:"/></h:column>
                    <h:column><h:inputText style="width:100px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.inpNomPatient}" /></h:column>
                    <h:column><h:outputText value="Prénom:"/></h:column>
                    <h:column><h:inputText style="width:100px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.inpPrenomPatient}"/></h:column>
                    <h:column><h:outputText value="Dossier entrée:"/></h:column>
                    <h:column><h:inputText style="width:100px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.inpDossier}"/></h:column>
                    <h:column><h:outputText value="Téléphone:"/></h:column>
                    <h:column><h:inputText style="width:100px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.inpTel}"/></h:column>
                    <h:column><h:outputText value="C.I./Sécu.:"/></h:column>
                    <h:column><h:inputText style="width:100px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.inpCi}"/></h:column>
                    <h:column><h:outputText value="Société:"/></h:column>
                    <h:column><h:inputText style="width:100px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.inpSociete}"/></h:column>
                    <h:column><h:outputText value="Assurance/IPM:"/></h:column>
                    <h:column><h:inputText style="width:100px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.inpAssurance}"/></h:column>
                    <h:column><h:outputText value="Mutuelle/Complémentaire:"/></h:column>
                    <h:column><h:inputText style="width:100px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.inpComplementaire}"/></h:column>
                    <h:column><h:outputText value="N° Contrat/Mat.:"/></h:column>
                    <h:column><h:inputText style="width:100px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.inpContrat}"/></h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.var_affiche_protocole}"><h:outputText value="Protocole"/></h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.var_affiche_protocole}"><h:inputText style="width:100px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.inpProtocole}"/></h:column>
                    <h:column><h:outputText value="Du:"/></h:column>
                    <h:column><rich:calendar inputStyle="width:100px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.inpDu}"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" /></h:column>
                    <h:column><h:outputText value="Au:"/></h:column>
                    <h:column><rich:calendar inputStyle="width:100px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.inpAu}"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" /></h:column>
                    <h:column><h:outputText value="Mèdecin:"/></h:column>
                    <h:column>
                        <h:inputText style="width:100px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.inpMedecin}">
                            <rich:toolTip followMouse="true" direction="top-right" showDelay="1000" value="chaine = Recherche qui commence... / *chaine = Recherche qui contient... / * = Recherche tous les responsables" style="background-color:#FFF8D4;"/>
                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.rechercheMedecin}" reRender="panCtrl,panDest,panelListeResponsable,formModalListeResponsable" oncomplete="javascript:Richfaces.showModalPanel('panelListeResponsable');"/>
                        </h:inputText>
                    </h:column>
                </h:panelGrid>
            </h:panelGrid>
        </h:panelGrid>

        <h:panelGrid id="panelBouton" columns="19" width="500px" style="height:34px">
            <a4j:commandButton title="Ajouter nouvelle consultation" image="/images/ajouter.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.ajoutDocument}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.menumedical.add}" onclick="javascript:Richfaces.showModalPanel('modAttente');" reRender="modAttente,idSubView"/>
            <a4j:commandButton title="Modifier consultation sélectionnée" image="/images/modifier.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.modifDocument}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.visibiliteBton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationEnteteGene.csgEtat==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.menumedical.maj}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView"/>
            <a4j:commandButton title="Consulter" image="/images/detail.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultDocument}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.visibiliteBton}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView"/>
            <a4j:commandButton title="Supprimer la consultation sélectionnée uniquement si en cours" image="/images/supprimer.png"  onclick="if (!confirm('Etes-vous sur de vouloir supprimer cet élément?')) return false"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.supprimerDocument}" reRender="table,pangrpVisbt,intpTTCL,intpRGLMTL,intpSOLDL,panelBouton" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.visibiliteBton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationEnteteGene.csgEtat==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.menumedical.sup}"/>
            <a4j:commandButton title="Supprimer la consultation sélectionnée (forcé)" image="/images/bombe.png"  onclick="if (!confirm('Etes-vous sur de vouloir supprimer cet élément?')) return false"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.supprimerForcerDocument}" reRender="table,pangrpVisbt,intpTTCL,intpRGLMTL,intpSOLDL,panelBouton" rendered="#{false&&bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrid==6&&bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.visibiliteBton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.menumedical.sup}"/>
            <a4j:commandButton title="Annuler la consultation sélectionnée (Avoir) uniquement si validée" image="/images/annuler_big.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.visibiliteBton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationEnteteGene.csgEtat==1&&(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationEnteteGene.csgRegPatient==0||bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrMedicalAvoir==1)&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.menumedical.sup}" onclick="if (!confirm('Etes-vous sur de vouloir annuler ce document (transformer en avoir) ?')) return false;javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.annulerDocument}" reRender="panelAnnuler"/>
            <a4j:commandButton title="imprimer" image="/images/print.png" oncomplete="javascript:Richfaces.showModalPanel('panelImp');" reRender="panelImp,formModalImp,panchoixdoc,optionMail" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.initImpression}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.visibiliteBton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.menumedical.imp}"/>
            <a4j:commandButton title="Grapher" image="/images/grapheur.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.visibiliteBton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.menumedical.imp}" reRender="panelGraph,formModalGraph,container"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.initGrapheur}"/>
            <a4j:commandButton title="Imputer la série" image="/images/boussole.png" oncomplete="javascript:Richfaces.showModalPanel('panelimpSerie');" reRender="panelimpSerie" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.accesImputSerie}" rendered="#{false&&bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationEnteteGene.csgSerie=='X'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.visibiliteBton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.menumedical.clo}"/>
            <a4j:commandButton title="Changer le motif ou le service ou le médecin de la consultation sélectionnée" style="height:22px;width:22px" image="/images/permutter.jpeg" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.visibiliteBton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationEnteteGene.csgEtat==1&&(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationEnteteGene.csgRegPatient==0||bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrMedicalAvoir==1)&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.menumedical.maj}" onclick="if (!confirm('Etes-vous sur de vouloir changer le motif ou service ou le médecin ?')) return false;javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.changerService}" reRender="panelChangerService"/>
            <a4j:commandButton title="Dupliquer la consultation sélectionnée" image="/images/duplicate.png"  onclick="if (!confirm('Etes-vous sur de vouloir dupliquer ce document ?')) return false;javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.duppliquerDocument}" reRender="modAttente,table,pangrpVisbt,intpTTCL,intpRGLMTL,intpSOLDL" rendered="#{false&&bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.visibiliteBton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.menumedical.dup}"/>
            <a4j:commandButton title="Paiement (Bon d'encaissement) du document sélectionné" image="/images/bonCaisse.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.visibiliteBton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.menumedical.maj&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationEnteteGene.csgEtat==1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.var_affiche_be}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.payeDocumentBonEncaissement}" reRender="panelPaye,panelBouton" />
            <a4j:commandButton title="Paiement (direct) du document sélectionné" image="/images/dollar.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.visibiliteBton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.menumedical.maj&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationEnteteGene.csgEtat==1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.var_affiche_dollar}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.payeXDocumentRecu}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelPayeXDoc,panelBouton" />
            <a4j:commandButton title="Historique des règlements du document sélectionné" image="/images/histoPaiement.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.visibiliteBton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.menumedical.maj&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationEnteteGene.csgEtat>=1}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.histoReglement}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelHistoReglement" />
            <a4j:commandButton title="Valider le document sélectionné" image="/images/valDoc.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.usersChrono.usrchrValidation==2&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.visibiliteBton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationEnteteGene.csgEtat==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.menumedical.maj}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.valideDocument}" onclick="if (!confirm('Etes-vous sur de vouloir valider ce document ?')) return false" reRender="panelBouton,table"/>
            <a4j:commandButton title="Dé-Valider le document sélectionné" image="/images/deValDoc.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationEnteteGene.csgDateTransfert==null&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.usersChrono.usrchrDeValidation==1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.visibiliteBton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationEnteteGene.csgEtat==1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.menumedical.maj}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.deValideDocument}" onclick="if (!confirm('Etes-vous sur de vouloir dé-valider ce document ?')) return false" reRender="panelBouton,table"/>
            <a4j:commandButton title="Ajouter une consultation même patient" image="/images/consultation.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.duppliquerDocument}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.visibiliteBton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationEnteteGene.csgEtat==1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.menumedical.maj}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView"/>
            <a4j:commandButton title="Ajouter un laboratoire même patient" image="/images/laboratoire.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.ajouterLaboratoireConsultation}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.visibiliteBton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationEnteteGene.csgEtat==1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.menumedical.maj}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView"/>
            <a4j:commandButton title="Configuration présentation liste" image="/images/configuration.png" style="height:26px;width:26px" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrConfigListe==1}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.memoriseConfigListeEntete}" onclick="if (!confirm('Etes-vous sur de vouloir enregistrer cette présentation ?')) return false"/>
        </h:panelGrid>

        <center>
            <div style="overflow:scroll;max-height:100%;width:100%;border:solid 0px green;">
                <a4j:region renderRegionOnly="false">
                    <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" page="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.pageIndex}" reRender="table" id="scrollTable" maxPages="20"align="left" for="table"/>
                    <rich:extendedDataTable rows="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.var_nb_max}" style="max-height:100%" styleClass="bg" id="table" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="180%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.datamodelDocument}"  var="var" activeRowKey="true" rowKeyVar="rkv" selection="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.simpleSelectionEntete}" sortMode="multi" selectionMode="single" tableState="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.configListeEntete}" binding="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.extDTable}">
                        <a4j:support eventsQueue="maQueue" event="onselectionchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.selectionConsultation}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelBouton"/>
                        <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.visualisationLigne}" reRender="idSubView,panelBouton"/>
                        <rich:column label="N° Dossier patient" sortable="true" sortBy="#{var.patients.patDossier}" >
                            <f:facet name="header"><h:outputText  value="N° Dossier" /></f:facet>
                            <h:outputText value="#{var.patients.patDossier}" title="#{var.patients.patDossier}"/>
                        </rich:column>
                        <rich:column label="N° Consul." sortable="true" sortBy="#{var.csgNum}" >
                            <f:facet name="header"><h:outputText  value="N° Consult." /></f:facet>
                            <h:outputText value="#{var.csgNum}" title="#{var.csgNum}"/>
                        </rich:column>
                        <rich:column label="Date" sortable="true" sortBy="#{var.csgDate}" width="70px" sortOrder="ASCENDING">
                            <f:facet name="header"><h:outputText  value="Date" /></f:facet>
                            <h:outputText value="#{var.csgDate}" title="#{var.csgDate}">
                                <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                            </h:outputText>
                        </rich:column>
                        <rich:column label="Série" sortable="true" sortBy="#{var.csgSerie}" style="text-align:center;" width="40px">
                            <f:facet name="header"><h:outputText  value="S." /></f:facet>
                            <h:outputText value="#{var.csgSerie}" title="#{var.csgSerie}"/>
                        </rich:column>
                        <rich:column label="Prise en charge" sortable="true" sortBy="#{var.csgPecCnamgs}" width="50px" style="text-align:right;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.optionMedical.cnamgs=='1'&&bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strcodepays=='0077'}">
                            <f:facet name="header"><h:outputText  value="Pec" /></f:facet>
                            <h:outputText value="#{var.csgPecCnamgs}" rendered="#{var.csgPecCnamgs!=0}" style="text-align:right;" title="#{var.csgPecCnamgs}" />
                        </rich:column>
                        <rich:column label="Famille tarification" sortable="true" sortBy="#{var.libelleFamille}" width="90px" style="text-align:center;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.infirmerie==false}">
                            <f:facet name="header"><h:outputText  value="Tar." /></f:facet>
                            <h:outputText value="#{var.libelleFamille}" title="#{var.libelleFamille}"/>
                        </rich:column>
                        <rich:column label="Etat" sortable="true" sortBy="#{var.csgEtat}" width="50px" style="text-align:center;">
                            <f:facet name="header"><h:outputText  value="Etat" /></f:facet>
                            <h:outputText value="#{var.libelleEta}" title="#{var.libelleEta}   #{var.csgMotifAnnule}"/>
                        </rich:column>
                        <rich:column label="Motif entrée" sortable="true" sortBy="#{var.entree}" width="50px">
                            <f:facet name="header"><h:outputText  value="Ent." /></f:facet>
                            <h:outputText value="#{var.entree}" title="#{var.entree}"/>
                        </rich:column>
                        <rich:column label="Nature" sortable="true" sortBy="#{var.patPorte}" width="40px" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.infirmerie}">
                            <f:facet name="header" ><h:outputText value="Nature"/></f:facet>
                            <h:outputText value="#{var.patients.patPorte}" title="#{var.patients.patPorte}"/>
                        </rich:column>
                        <rich:column label="Patient" sortable="true" sortBy="#{var.csgNomPatient}" width="200px">
                            <f:facet name="header"><h:outputText  value="Patient"  /></f:facet>
                            <h:outputText  value="#{var.csgNomPatient} (#{var.csgCivilite})" title="#{var.csgNomPatient}"/>
                        </rich:column>
                        <rich:column label="Objet" sortable="true" sortBy="#{var.csgObjet}" width="150px" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.infirmerie}">
                            <f:facet name="header" ><h:outputText value="Objet"/></f:facet>
                            <h:outputText value="#{var.csgObjet}" title="#{var.csgObjet}"/>
                        </rich:column>
                        <rich:column label="Service" sortable="true" sortBy="#{var.csgService}" width="200px" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.var_affiche_service}">
                            <f:facet name="header"><h:outputText  value="Service"  /></f:facet>
                            <h:outputText  value="#{var.csgService}" title="#{var.csgService}"/>
                        </rich:column>
                        <rich:column label="Part Patient" sortable="true" sortBy="#{var.totalPatient}" style="text-align:right;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.infirmerie==false}">
                            <f:facet name="header"><h:outputText  value="P.Patient"  /></f:facet>
                            <h:outputText  value="#{var.totalPatient}" rendered="#{var.totalPatient!=0}" title="#{var.totalPatient}">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:outputText>
                        </rich:column>
                        <rich:column label="Reg. Patient" sortable="true" sortBy="#{var.csgRegPatient}" style="text-align:right;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.infirmerie==false}">
                            <f:facet name="header"><h:outputText  value="R.Patient"/></f:facet>
                            <h:outputText  value="#{var.csgRegPatient}" rendered="#{var.csgRegPatient!=0}" title="#{var.csgRegPatient}">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:outputText>
                        </rich:column>
                        <rich:column label="Solde Patient" sortable="true" sortBy="#{var.csgRegTiers}" style="text-align:right;color:red" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.infirmerie==false}">
                            <f:facet name="header"><h:outputText value="S.Patient"/></f:facet>
                            <h:outputText  value="#{var.var_reliquat}" rendered="#{var.var_reliquat!=0}" title="#{var.var_reliquat}">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:outputText>
                        </rich:column>
                        <rich:column label="Part Tiers" sortable="true" sortBy="#{var.totalTiers}" style="text-align:right;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.infirmerie==false}">
                            <f:facet name="header"><h:outputText  value="P.Tiers"/></f:facet>
                            <h:outputText  value="#{var.totalTiers}" rendered="#{var.totalTiers!=0}" title="#{var.totalTiers}">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:outputText>
                        </rich:column>
                        <rich:column label="Reg. Tiers" sortable="true" sortBy="#{var.csgRegTiers}" style="text-align:right;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.infirmerie==false}">
                            <f:facet name="header"><h:outputText value="R.Tiers"/></f:facet>
                            <h:outputText  value="#{var.csgRegTiers}" rendered="#{var.csgRegTiers!=0}" title="#{var.csgRegTiers}">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:outputText>
                        </rich:column>
                        <rich:column label="Motif entrée" sortable="true" sortBy="#{var.csgEntree}" width="200px">
                            <f:facet name="header"><h:outputText value="Entrée"/></f:facet>
                            <h:outputText  value="#{var.csgEntree}" title="#{var.csgEntree}"/>
                        </rich:column>
                        <rich:column label="Pathologie" sortable="true" sortBy="#{var.csgPathologie}" width="150px" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.infirmerie}">
                            <f:facet name="header" ><h:outputText value="Pathologie"/></f:facet>
                            <h:outputText value="#{var.csgPathologie}" title="#{var.csgPathologie}"/>
                        </rich:column>
                        <rich:column label="Mèdecin" sortable="true" sortBy="#{var.csgMedecin}" width="200px">
                            <f:facet name="header"><h:outputText  value="Mèdecin"/></f:facet>
                            <h:outputText  value="#{var.csgMedecin}" title="#{var.csgMedecin}"/>
                        </rich:column>
                        <rich:column label="Protocle" sortable="true" sortBy="#{var.csgProtocole}" width="200px" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.var_affiche_protocole}">
                            <f:facet name="header"><h:outputText value="Protocole"/></f:facet>
                            <h:outputText  value="#{var.csgProtocole}" title="#{var.csgProtocole}"/>
                        </rich:column>
                        <rich:column label="Bon de commande" sortable="true" sortBy="#{var.csgNumBc}" width="100px">
                            <f:facet name="header"><h:outputText  value="N° BC"/></f:facet>
                            <h:outputText  value="#{var.csgNumBc}" title="#{var.csgNumBc}"/>
                        </rich:column>
                    </rich:extendedDataTable>
                </a4j:region>
            </div>
        </center>
        <br/>
        <h:panelGrid id="pnlgrttotal" columns="4" styleClass="recherche" width="100%">
            <h:panelGrid columns="2" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.infirmerie==false}">
                <h:outputText value="Total Patient" />
                <h:inputText  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.totalPatient}" style="width:100%;text-align:right;" readonly="true">
                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                </h:inputText>
                <h:outputText value="Total Tiers" />
                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.totalTiers}" style="width:100%;text-align:right;" readonly="true">
                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                </h:inputText>
            </h:panelGrid>
            <h:panelGrid columns="2" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.infirmerie==false}">
                <h:outputText value="Réglements Patients " />
                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.regPatient}" style="width:100%;text-align:right;" readonly="true">
                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                </h:inputText>
                <h:outputText  value="Réglements Tiers" />
                <h:inputText  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.regTiers}" style="width:100%;text-align:right;" readonly="true">
                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                </h:inputText>
            </h:panelGrid>
            <h:panelGrid columns="2" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.infirmerie==false}">
                <h:outputText  value="Solde Patient" />
                <h:inputText  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.soldePatient}" style="width:100%;text-align:right;color:red" readonly="true">
                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                </h:inputText>
                <h:outputText value="Solde Tiers" />
                <h:inputText  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.soldeTiers}" style="width:100%;text-align:right;color:red" readonly="true">
                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                </h:inputText>
            </h:panelGrid>
            <h:panelGrid columns="1">
                <h:outputText value="(Total liste : #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.var_nb_ligne})" />
            </h:panelGrid>
        </h:panelGrid>

    </a4j:form>


    <rich:modalPanel domElementAttachment="parent"  id="panelImp" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="650" height="400" autosized="true" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.showModalPanelPrint}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.showModalPanelPrint}" var="prt">
            <jsp:include flush="true" page="/commun/impressionExploitation.jsp"/>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"  id="panelGraph" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="500" height="300" autosized="true" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.showModalPanelGraph}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.showModalPanelGraph}" var="grp">
            <f:facet name="header"><h:outputText value="Paramêtre du graphique"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.fermerGrapheur}" image="/images/close.gif" styleClass="hidelink" reRender="panelGraph"/>
                </a4j:form>
            </f:facet>
            <a4j:form id="formModalGraph">
                <rich:hotKey key="return" handler="return false;"/>
                <rich:panel  style="width:100%;">
                    <h:panelGrid  columns="2" style="width:100%;">
                        <h:column><h:outputText value="Type valeur:"/></h:column>
                        <h:column rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.infirmerie}">
                            <h:selectOneMenu style="width:180px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.valQteGraph}" >
                                <f:selectItem itemLabel="En valeur" itemValue="0"/>
                                <f:selectItem itemLabel="en quantité" itemValue="1"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.hideModele}" reRender="idResultat"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.infirmerie}">
                            <h:selectOneMenu style="width:180px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.valQteGraph}" >
                                <f:selectItem itemLabel="en quantité" itemValue="1"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.hideModele}" reRender="idResultat"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Analyse:"/></h:column>
                        <h:column rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.infirmerie}">
                            <h:selectOneMenu style="width:180px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.modeGraph}">
                                <f:selectItem itemLabel="en global" itemValue="0"/>
                                <f:selectItem itemLabel="par mèdecin" itemValue="1"/>
                                <f:selectItem itemLabel="par prescripteur" itemValue="2"/>
                                <f:selectItem itemLabel="par patient" itemValue="3"/>
                                <f:selectItem itemLabel="par assurance" itemValue="4"/>
                                <f:selectItem itemLabel="par complémentaire" itemValue="5"/>
                                <f:selectItem itemLabel="par société" itemValue="6"/>
                                <f:selectItem itemLabel="par motif entrée" itemValue="7"/>
                                <f:selectItem itemLabel="par protocole" itemValue="8"/>
                                <f:selectItem itemLabel="par pathologie" itemValue="9"/>
                                <f:selectItem itemLabel="par service" itemValue="10"/>
                                <f:selectItem itemLabel="par actes" itemValue="20"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.hideModele}" reRender="idResultat"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.infirmerie}">
                            <h:selectOneMenu style="width:180px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.modeGraph}">
                                <f:selectItem itemLabel="en global" itemValue="0"/>
                                <f:selectItem itemLabel="par mèdecin" itemValue="1"/>
                                <f:selectItem itemLabel="par patient" itemValue="3"/>
                                <f:selectItem itemLabel="par motif entrée" itemValue="7"/>
                                <f:selectItem itemLabel="par actes" itemValue="20"/>
                                <f:selectItem itemLabel="par pharmacie" itemValue="21"/>
                                <f:selectItem itemLabel="par ordonnance" itemValue="22"/>
                                <f:selectItem itemLabel="par laboratoire" itemValue="23"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.hideModele}" reRender="idResultat"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Regroupement par:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:180px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.timeDecoupage}">
                                <f:selectItem itemLabel="jour" itemValue="0"/>
                                <f:selectItem itemLabel="mois" itemValue="1"/>
                                <f:selectItem itemLabel="trimestre" itemValue="2"/>
                                <f:selectItem itemLabel="semestre" itemValue="3"/>
                                <f:selectItem itemLabel="année" itemValue="4"/>
                                <f:selectItem itemLabel="tranche horaire" itemValue="5"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.hideModele}" reRender="idResultat"/>
                            </h:selectOneMenu>
                        </h:column>
                    </h:panelGrid>
                </rich:panel>
                <br/>
                <h:panelGroup id="idResultat">
                    <center>
                        <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.grapher}" value="Calcul graphique"  onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idResultat"/>
                        <br/><br/>
                        <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.showModele}">
                            <jsp:include flush="true" page="/commun/impressionGraphiqueModele.jsp"/>
                        </h:panelGroup>
                    </center>
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"  id="panelimpSerie" width="900" height="350" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.showModalPanelImput}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.showModalPanelImput}" var="imp">
            <f:facet name="header"><h:outputText value="Imputation série"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.annuleImputSerie}" image="/images/close.gif" styleClass="hidelink" id="hidelinkImput" reRender="panelimpSerie"/>
                    <rich:componentControl for="panelAjt" attachTo="hidelinkImput" operation="hide" event="onclick"/>
                </a4j:form>
            </f:facet>
            <a4j:form >
                <rich:hotKey key="return" handler="return false;"/>
                <rich:panel  style="width:100%;">
                    <jsp:include flush="true" page="/medical/ConsultationGeneCommun.jsp"/>
                    <h:panelGrid  columns="2" style="width:100%;">
                        <h:column><h:outputText value="Série imputée:" style="text-decoration:underline;"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:180px" id="serieimput"  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.var_imput_serie}" >
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.mesSeriesUsersItem}"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" reRender="serieimput"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Catégorie:" style="text-decoration:underline;"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:180px" id="catimput" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.var_imput_cat}">
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.mesPecItem}"/>
                            </h:selectOneMenu>
                        </h:column>
                    </h:panelGrid>
                </rich:panel>
                <h:panelGroup id="ppgrp">
                    <center>
                        <h:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.miseajourImput}"/>
                    </center>
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"  id="panelChangerService" width="900" height="350" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.showModalPanelChangerService}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.showModalPanelChangerService}" var="chs">
            <f:facet name="header"><h:outputText value="Change Motif, Service, Médecin"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.annulerChangerService}" image="/images/close.gif" styleClass="hidelink" id="hidelinkChg" reRender="panelChangerService"/>
                    <rich:componentControl for="panelChg" attachTo="hidelinkChg" operation="hide" event="onclick"/>
                </a4j:form>
            </f:facet>
            <a4j:form >
                <rich:hotKey key="return" handler="return false;"/>
                <h:panelGrid  style="width:100%;">
                    <jsp:include flush="true" page="/medical/ConsultationGeneCommun.jsp"/>
                    <h:panelGrid  columns="2" columnClasses="clos30,clos70" style="width:100%;" styleClass="recherche">
                        <h:column><h:outputText value="Ancien motif:"/></h:column>
                        <h:column><h:inputText style="width:100%" readonly="true" disabled="true" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationEnteteGene.csgEntree}"/></h:column>
                        <h:column><h:outputText value="Nouveau motif:" style="text-decoration:underline;"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.nouveauMotif}" >
                                <f:selectItem itemLabel="Sélectionner un motif" itemValue=""/>
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.mesMotifEntreeItems}"/>
                            </h:selectOneMenu>
                        </h:column>
                    </h:panelGrid>
                    <h:panelGrid  columns="2" columnClasses="clos30,clos70" style="width:100%;" styleClass="recherche">
                        <h:column><h:outputText value="Ancien service:"/></h:column>
                        <h:column><h:inputText style="width:100%" readonly="true" disabled="true" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationEnteteGene.csgService}"/></h:column>
                        <h:column><h:outputText value="Nouveau service:" style="text-decoration:underline;"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.nouveauService}" >
                                <f:selectItem itemLabel="Sélectionner un service" itemValue=""/>
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.mesServicesItems}"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.chargerMedecinService}" reRender="idNewMedecin"/>
                            </h:selectOneMenu>
                        </h:column>
                    </h:panelGrid>
                    <h:panelGrid  columns="2" columnClasses="clos30,clos70" style="width:100%;" styleClass="recherche">
                        <h:column><h:outputText value="Ancien médecin:"/></h:column>
                        <h:column><h:inputText style="width:100%" readonly="true" disabled="true" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.ancienMedecin}"/></h:column>
                        <h:column><h:outputText value="Nouveau médecin:" style="text-decoration:underline;"/></h:column>
                        <h:column>
                            <h:selectOneMenu id="idNewMedecin" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.nouveauMedecin}" >
                                <f:selectItem itemLabel="Sélectionner un médecin" itemValue="0"/>
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.mesMedecinsItem}"/>
                            </h:selectOneMenu>
                        </h:column>
                    </h:panelGrid>
                </h:panelGrid>
                <h:panelGroup>
                    <center>
                        <h:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.validerChangerService}"/>
                    </center>
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"  id="panelPaye" width="800" height="400" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.showModalPanelPaye}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.showModalPanelPaye}" var="pay">
            <f:facet name="header"><h:outputText value="Bon d'encaissement du document"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.annulePaye}" image="/images/close.gif" styleClass="hidelink" reRender="panelPaye"/>
                </a4j:form>
            </f:facet>
            <a4j:form >
                <rich:hotKey key="return" handler="return false;"/>
                <jsp:include flush="true" page="/medical/ConsultationGeneCommun.jsp"/>
                <h:panelGrid id="firstgridd"  width="100%" columns="4" columnClasses="clos15,clos35,clos15,clos35" styleClass="fichefournisseur">
                    <h:column><h:outputText value="Date:"/></h:column>
                    <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.var_date_trf}"  inputSize="8"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.var_aff_action}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrDateCai==0}"/></h:column>
                    <h:column><h:outputText value="N°:"/></h:column>
                    <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationEnteteGene.csgNum}" readonly="true"/></h:column>
                    <h:column><h:outputText value="Série:"/></h:column>
                    <h:column>
                        <h:panelGroup>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationEnteteGene.csgSerie}" size="2" readonly="true"/>
                            <h:outputText value="Devise:"/>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strdevise}" size="3" readonly="true"/>
                        </h:panelGroup>
                    </h:column>
                    <h:column><h:outputText value="Patient:"/></h:column>
                    <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationEnteteGene.csgNomPatient}" readonly="true"/></h:column>
                    <h:column> <h:outputText value="Mode de règlement:"/></h:column>
                    <h:column>
                        <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationEnteteGene.csgTypeReg}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.var_verouxModReg}">
                            <f:selectItem itemLabel="Paiement total" itemValue="0"/>
                            <f:selectItem itemLabel="Paiement partiel" itemValue="4"/>
                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.chargerModReg}" reRender="firstgridd,colMontInput"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column><h:outputText value="Caisse:" style="text-decoration:underline;"/></h:column>
                    <h:column>
                        <h:selectOneMenu id="bnqajt" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.var_inputCaisse}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.var_aff_action}">
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.mesCaissesSeriesItems}"/>
                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.choixCaisseXReglementBencaissement}" reRender="firstgridd,idBnq1,idBnq2,idChq1,idChq2,idChq3,idChq4"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:outputText value="Montant du bon:"/>
                    <h:column id="colMontInput">
                        <h:inputText style="width:100%;text-align:center;font-weight:bold;font-size:50px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.montantElmTotBonEnc}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.var_affichMontant}" onkeypress="return scanToucheChiffre(event)">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            <a4j:support eventsQueue="maQueue" event="onchange" reRender="panelPaye" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.verifBonEncaissement}"/>
                        </h:inputText>
                    </h:column>
                    <h:column><h:outputText value="Net à payer:"/></h:column>
                    <h:column>
                        <h:inputText style="width:100%;text-align:right" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.var_netAPayer}" disabled="true">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                        </h:inputText>
                    </h:column>
                    <h:column><h:outputText value="Type règlement:"/></h:column>
                    <h:column>
                        <h:selectOneMenu id="idTypeRegBe" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.var_type_reg}" style="width:100%;">
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.mesTypeReglementsCaisse}"/>
                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.choixTypeReglementBencaissement}" reRender="firstgridd,idBnq1,idBnq2,idChq1,idChq2,idChq3,idChq4,idLg1,idLg2,ppgrp"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column id="idBnq1" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.var_affiche_banque&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.var_affiche_banque_destination}"><h:outputText value="Banque destination:" style="text-decoration:underline;" /></h:column>
                    <h:column id="idBnq2" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.var_affiche_banque&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.var_affiche_banque_destination}">
                        <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.var_banque_destination}">
                            <f:selectItem itemLabel="Inconnue" itemValue=""/>
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.mesBanquesItems}"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column id="idChq1" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.var_affiche_banque}"><h:outputText value="Banque du tireur:"/></h:column>
                    <h:column id="idChq2" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.var_affiche_banque}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.var_banque_tireur}" maxlength="50" style="text-transform:uppercase"/></h:column>
                    <h:column id="idChq3" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.var_affiche_banque}"><h:outputText value="N° chèque ou bordereau:"/></h:column>
                    <h:column id="idChq4" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.var_affiche_banque}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.var_num_cheque}" maxlength="50"/></h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationEnteteGene.csgTypeReg==4}"><h:outputText value="Echéance reliquat:"/></h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationEnteteGene.csgTypeReg==4}"><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationEnteteGene.csgEcheanceReliquat}" inputSize="8"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.var_verouxModReg}"/></h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationEnteteGene.csgTypeReg==4}"><h:outputText value="Numéro Piéce tiers"/></h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationEnteteGene.csgTypeReg==4}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationEnteteGene.csgNumPieceTiers}" maxlength="20" style="width:100%"/></h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.var_affiche_lettre}"><h:outputText id="idLg1" value="Lettre de garantie:" style="text-decoration:underline;"/></h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.var_affiche_lettre}">
                        <h:selectOneMenu id="idLg2" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.numLettreGarantie}">
                            <f:selectItem itemLabel="Inconnue" itemValue=""/>
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.mesLettresGarantiesItems}"/>
                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.verifValide}" reRender="firstgridd,ppgrp,idLg3,idLg4"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.var_affiche_lettre&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.reliquatPatient!=0}"><h:outputText id="idLg3" value="A LA CHARGE DU PATIENT:" style="color:red"/></h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.var_affiche_lettre&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.reliquatPatient!=0}">
                        <h:inputText id="idLg4" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.reliquatPatient}" style="color:red;text-align:center;width:100%;font-weight:bold;font-size:50px" readonly="true" disabled="true">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                        </h:inputText>
                    </h:column>
                </h:panelGrid>
                <h:panelGroup id="ppgrp">
                    <center>
                        <br><br>
                        <a4j:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.miseajourPaye}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.var_affiche_valide}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelPaye,panelBouton,modMessageCommun"/>
                        <br>
                        <h:panelGroup rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.var_affiche_valide}" style="margin-left:50px;">
                            <h:graphicImage url="/images/Warning.png"  style="width:25px;height;"/>
                            <h:outputText value="Le montant du bon est supérieur au solde du document" style="color:red;" />
                        </h:panelGroup>
                    </center>
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"  id="panelPayeXDoc" width="1100" height="450" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.showModalPanelReglement}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.showModalPanelReglement}" var="pay">
            <f:facet name="header"><h:outputText value="Règlement direct des documents"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.fermerXReglement}" image="/images/close.gif" styleClass="hidelink" reRender="panelPayeXDoc"/>
                </a4j:form>
            </f:facet>
            <a4j:form id="formPayeXDoc">
                <rich:hotKey key="return" handler="return false;"/>
                <h:panelGrid id="panelGlobal" width="100%">
                    <jsp:include flush="true" page="/medical/ConsultationGeneCommun.jsp"/>
                    <h:panelGrid id="firstgridd"  width="100%" columns="4" columnClasses="clos15,clos35,clos15,clos35">
                        <h:column><h:outputText value="Date:"/></h:column>
                        <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.var_date_trf}"  inputSize="8"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.var_aff_action}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrDateCai==0}"/></h:column>
                        <h:column><h:outputText value="Caisse exécutrice:"/></h:column>
                        <h:column>
                            <h:selectOneMenu id="bnqajt" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.var_inputCaisse}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.var_aff_action}">
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.mesCaissesSeriesItems}" />
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.choixCaisseXReglement}" reRender="panelGlobal"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Type règlement:"/></h:column>
                        <h:column>
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.var_type_reg}" style="width:100%;">
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.mesTypeReglementsCaisse}"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.choixTypeReglement}" reRender="firstgridd,panelGlobal,bnqajt,idEncais2,idImp1,idImp2,table,idBnq1,idBnq2,idEcart3,idLg1,idLg2,ppgrp"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText id="idImp1" value="Impression: (#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.nomRepMod})" style="text-decoration:underline;"/></h:column>
                        <h:column>
                            <h:selectOneMenu id="idImp2" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.var_modele_trf}">
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.mesModesleRecus}"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText id="idBnq1" value="Banque destination:" style="text-decoration:underline;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.var_affiche_banque&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.var_affiche_banque_destination}"/></h:column>
                        <h:column>
                            <h:selectOneMenu id="idBnq2" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.var_banque_destination}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.var_affiche_banque&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.var_affiche_banque_destination}">
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.mesBanquesItems}"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:outputText value=""/>
                        <h:outputText value=""/>
                        <h:column> <h:outputText value="Mode de règlement:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationEnteteGene.csgTypeReg}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.var_verouxModReg}">
                                <f:selectItem itemLabel="Paiement total" itemValue="0"/>
                                <f:selectItem itemLabel="Paiement partiel" itemValue="4"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.chargerModReg}" reRender="firstgridd"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText id="idLg1" value="Lettre de garantie:" style="text-decoration:underline;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.var_affiche_lettre}"/></h:column>
                        <h:column>
                            <h:selectOneMenu id="idLg2" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.numLettreGarantie}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.var_affiche_lettre}">
                                <f:selectItem itemLabel="Inconnue" itemValue=""/>
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.mesLettresGarantiesItems}"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.verifValide}" reRender="firstgridd,ppgrp,idLg3,idLg4"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.var_affiche_lettre&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.reliquatPatient!=0}"><h:outputText id="idLg3" value="A LA CHARGE DU PATIENT:" style="color:red"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.var_affiche_lettre&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.reliquatPatient!=0}">
                            <h:inputText id="idLg4" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.reliquatPatient}" style="color:red;text-align:center;width:100%;font-weight:bold;font-size:50px" readonly="true" disabled="true">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:outputText value="Montant règlement:"/>
                        <h:column>
                            <h:inputText style="width:100%;text-align:center;font-weight:bold;font-size:50px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.montantElmTotBonEnc}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.var_affichMontant}" onkeypress="return scanToucheChiffre(event)">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.verifValide}" reRender="panelGlobal,ppgrp,idEcart0,idEcart1,idEcart2,idEcart3"/>
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Net à payer:"/></h:column>
                        <h:column>
                            <h:inputText id="idNetPayer" style="width:100%;text-align:right" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.var_netAPayer}" disabled="true">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Observations:"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.var_objet}" maxlength="50" style="width:50%;"/>
                        </h:column>
                    </h:panelGrid>
                    <h:panelGrid id="idEncais2" width="100%" columns="4" columnClasses="clos15,clos35,clos15,clos35" styleClass="fichefournisseur" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.var_affiche_banque}">
                        <h:column><h:outputText value="Banque du tireur:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.var_banque_tireur}" maxlength="50" style="text-transform:uppercase"/></h:column>
                        <h:column><h:outputText value="N° chèque ou bordereau:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.var_num_cheque}" maxlength="50"/></h:column>
                    </h:panelGrid>
                    <h:panelGrid id="idEcart3" width="100%" columns="4" columnClasses="clos15,clos35,clos15,clos35" styleClass="fichefournisseur" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.varTypeReg==0}">
                        <h:column><h:outputText value="Montant timbre:"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.val_timbre}" style="text-align:right;" disabled="true">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Total dû (réglement + timbre)"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.totalPayerTimbre}" style="text-align:right;" disabled="true">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                    </h:panelGrid>
                    <h:panelGroup id="ppgrp">
                        <center>
                            <br><br>
                            <h:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.validerXreglement}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.var_affiche_valide}" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                            <br>
                            <h:panelGroup rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.var_affiche_valide}" style="margin-left:50px;">
                                <h:graphicImage url="/images/Warning.png"  style="width:25px;height;"/>
                                <h:outputText value="Le montant du bon est supérieur au solde du document" style="color:red;" />
                            </h:panelGroup>
                        </center>
                    </h:panelGroup>
                </h:panelGrid>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"  id="panelHistoReglement" width="1000" height="500" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.showModalPanelHistoReglement}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.showModalPanelHistoReglement}" var="his">
            <f:facet name="header"><h:outputText value="Historique des règlements"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.fermerHistoReglement}" image="/images/close.gif" styleClass="hidelink" reRender="panelHistoReglement"/>
                </a4j:form>
            </f:facet>
            <a4j:form >
                <rich:hotKey key="return" handler="return false;"/>
                <h:panelGrid  style="width:100%;">
                    <jsp:include flush="true" page="/medical/ConsultationGeneCommun.jsp"/>
                    <h:panelGrid styleClass="fichefournisseur" width="100%" columns="6" columnClasses="clos12d,clos21g,clos12d,clos21g,clos12d,clos21g">
                        <h:column><h:outputText value="Total Patient:"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationEnteteGene.csgTotPatient}" style="text-align:right;width:100%"  readonly="true" disabled="true">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Total Tiers:"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.var_tot_tiers}" style="text-align:right;width:100%" readonly="true" disabled="true">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Total Général:"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationEnteteGene.csgTotGeneral}" style="text-align:right;width:95%"  readonly="true" disabled="true">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Règlement Patient:"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationEnteteGene.csgRegPatient}" style="text-align:right;width:100%"  readonly="true" disabled="true">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Règlement Tiers:"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationEnteteGene.csgRegTiers}" style="text-align:right;width:100%" readonly="true" disabled="true">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Solde Général:"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.var_solde}" style="text-align:right;width:95%"  readonly="true" disabled="true">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                    </h:panelGrid>
                    <br>
                    <a4j:region renderRegionOnly="false">
                        <rich:extendedDataTable height="350px" width="100%" border="0" headerClass="headerTab" activeClass="active-row" noDataLabel=" " style="margin-top:10px;border:solid 0px green;cursor:pointer;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.datamodelRecu}"  var="recu"  sortMode="multi">
                            <jsp:include flush="true" page="/commun/listeReglementDocument.jsp"/>
                        </rich:extendedDataTable>
                    </a4j:region>
                </h:panelGrid>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"  id="panelAnnuler" width="900" height="350" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.showModalPanelAnnuler}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.showModalPanelAnnuler}" var="ser">
            <f:facet name="header"><h:outputText value="Annulation Consultation"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.annuleAnnulation}" image="/images/close.gif" styleClass="hidelink" reRender="panelAnnuler"/>
                </a4j:form>
            </f:facet>
            <a4j:form >
                <rich:hotKey key="return" handler="return false;"/>
                <rich:panel  style="width:100%;">
                    <jsp:include flush="true" page="/medical/ConsultationGeneCommun.jsp"/>
                    <h:panelGrid  columns="2" style="width:100%;">
                        <h:column><h:outputText value="Date annulation:"/></h:column>
                        <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationEnteteGene.csgDateAnnule}"  inputSize="8" enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrDateCai==0}"/></h:column>
                        <h:column><h:outputText value="Caisse exécutrice:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.var_inputCaisse}">
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.mesCaissesSeriesItems}" />
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Motif annulation:"/></h:column>
                        <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationEnteteGene.csgMotifAnnule}" maxlength="50"/></h:column>
                    </h:panelGrid>
                </rich:panel>
                <h:panelGroup id="ppgrp">
                    <center>
                        <h:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.miseajourAnnuler}" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                    </center>
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


</f:subview>
