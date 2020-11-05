<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>


<f:subview id="paillaseentete">

    <a4j:form>
        <rich:hotKey key="return" handler="return true;"/>

        <center> <h2><h:outputText value="GESTION DE LA PAILLASSE" style="color:green;"/></h2></center>

        <h:panelGrid  columns="1" width="100%" id="document" >
            <h:panelGrid  id="panCtrl"  styleClass="recherche"  width="100%">
                <h:panelGrid columns="13" width="100%">
                    <a4j:commandButton title="Plus de critères..." image="/images/rechercher.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.moreSearchPaillasse}" reRender="panCtrl" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.var_more_search}"/>
                    <a4j:commandButton title="Moins de critères..." image="/images/rechercher.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.moreSearchPaillasse}" reRender="panCtrl" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.var_more_search}"/>
                    <h:column><h:outputText value="N°"/></h:column>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.inpNum}" size="5"/></h:column>
                    <h:column><h:outputText value="Nom"/></h:column>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.inpNomPatient}" size="10"/></h:column>
                    <h:column><h:outputText value="Prénom"/></h:column>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.inpPrenomPatient}" size="10"/></h:column>
                    <h:column>
                        <h:selectOneMenu id="idEtat" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.inpEtat}" style="width:100px;">
                            <f:selectItem itemLabel="Analyse en cours + effectuée" itemValue="11"/>
                            <f:selectItem itemLabel="Analyse cloturée" itemValue="4"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column>
                        <h:selectOneMenu id="idPeriode" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.periode}" style="width:150px;" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.var_more_search}">
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.mesPeriodesItems}"/>
                        </h:selectOneMenu>
                        <h:selectOneMenu id="idActivite" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.inpActivite}" style="width:150px;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.var_more_search&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.tActivite}">
                            <f:selectItem itemLabel="Toutes Activités" itemValue="100"/>
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.mesActivitesItems}" />
                        </h:selectOneMenu>
                    </h:column>
                    <h:column>
                        <h:selectOneMenu id="idLaboratoire" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.inpService}" style="width:150px;">
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.mesLaboratoiresItems}" />
                        </h:selectOneMenu>
                    </h:column>
                    <h:column>
                        <a4j:commandButton id="idValRecherche" value="RECHERCHER" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.executerRequetePaillasse}" onclick="javascript:Richfaces.showModalPanel('modAttente');" reRender="modAttente,panelBouton,table,scrollTable,pnlgrttotal"/>
                        <rich:hotKey key="return"  handler="#{rich:element('idValRecherche')}.click()" />
                    </h:column>
                </h:panelGrid>
                <h:panelGrid id="panDest" columns="8" width="100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.var_more_search}">
                    <h:column><h:outputText value="Mèdecin:"/></h:column>
                    <h:column>
                        <h:inputText style="width:100px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.inpMedecin}">
                            <rich:toolTip followMouse="true" direction="top-right" showDelay="1000" value="chaine = Recherche qui commence... / *chaine = Recherche qui contient... / * = Recherche tous les responsables" style="background-color:#FFF8D4;"/>
                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.rechercheMedecin}" reRender="panCtrl,panDest,panelListeResponsable,formModalListeResponsable" oncomplete="javascript:Richfaces.showModalPanel('panelListeResponsable');"/>
                        </h:inputText>
                    </h:column>
                    <h:column><h:outputText value="Protocole:"/></h:column>
                    <h:column><h:inputText style="width:100px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.inpProtocole}"/></h:column>
                    <h:column><h:outputText value="Du:"/></h:column>
                    <h:column><rich:calendar inputStyle="width:100px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.inpDu}"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" /></h:column>
                    <h:column><h:outputText value="Au:"/></h:column>
                    <h:column><rich:calendar inputStyle="width:100px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.inpAu}"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" /></h:column>
                </h:panelGrid>
            </h:panelGrid>
        </h:panelGrid>

        <h:panelGrid id="panelBouton" columns="9" width="400px" style="height:34px">
            <a4j:commandButton title="Détail patient sélectionnée" image="/images/tiers.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.detailPatient}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.visibiliteBton&&(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.laboratoireEntete.labAnonyme==false)}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView"/>
            <a4j:commandButton title="Détail prélévement" image="/images/laboratoire.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.detailPrelevement}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.visibiliteBton&&(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.laboratoireEntete.labAnonyme==false)}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView"/>
            <a4j:commandButton title="Modifier ligne sélectionnée" image="/images/modifier.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.modifResultat}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.visibiliteBton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.laboratoireLigne.labligEtat<=1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.menumedical.maj}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView"/>
            <a4j:commandButton title="Consulter" image="/images/detail.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.consultResultat}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.visibiliteBton}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView"/>
            <a4j:commandButton title="Valider la ligne sélectionnée" image="/images/valDoc.png" rendered="#{false&&bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.usersChrono.usrchrValidation==2&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.visibiliteBton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.laboratoireLigne.labligEtat==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.menumedical.maj}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.valideResultat}" onclick="if (!confirm('Etes-vous sur de vouloir valider cette ligne ?')) return false" reRender="panelBouton,table"/>
            <a4j:commandButton title="Dé-Valider la ligne sélectionnée" image="/images/deValDoc.png" rendered="#{false&&bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.laboratoireEntete.labDateTransfert==null&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.usersChrono.usrchrDeValidation==1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.visibiliteBton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.laboratoireLigne.labligEtat==1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.menumedical.maj}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.deValideResultat}" onclick="if (!confirm('Etes-vous sur de vouloir dé-valider cette ligne ?')) return false" reRender="panelBouton,table"/>
            <a4j:commandButton title="imprimer Résultat" image="/images/print.png" oncomplete="javascript:Richfaces.showModalPanel('panelImp');" reRender="panelImp,formModalImp,panchoixdoc,optionMail" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.initImpression}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.visibiliteBton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.menumedical.imp}"/>
            <a4j:commandButton title="Retenir facture sélectionnée" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.laboratoireEntete.labNum}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.detailFacture}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.visibiliteBton}" reRender="table,scrollTable"/>
            <a4j:commandButton title="Cloturer" image="/images/lock.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.usersChrono.usrchrValidation==2||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.usersChrono.usrchrValidation==4)&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.visibiliteBton&&(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.laboratoireEntete.labEtat==1||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.laboratoireEntete.labEtat==5||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.laboratoireEntete.labEtat==6)&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.laboratoireEntete.labCloture==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.menumedical.maj}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.clotureResultat}" onclick="if (!confirm('Etes-vous sur de vouloir cloturer une analyse ?')) return false" reRender="panelCloture"/>
            <a4j:commandButton title="Dé-Cloturer" image="/images/unlock.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.usersChrono.usrchrValidation==2||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.usersChrono.usrchrValidation==4)&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.visibiliteBton&&(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.laboratoireEntete.labEtat==1||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.laboratoireEntete.labEtat==5||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.laboratoireEntete.labEtat==6)&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.laboratoireEntete.labCloture==1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.menumedical.maj}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.deClotureResultat}" onclick="if (!confirm('Etes-vous sur de vouloir dé-cloturer une analyse ?')) return false" reRender="panelDeCloture"/>
            <a4j:commandButton title="Configuration présentation liste" image="/images/configuration.png" style="height:26px;width:26px" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrConfigListe==1}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.memoriseConfigListeEntete}" onclick="if (!confirm('Etes-vous sur de vouloir enregistrer cette présentation ?')) return false"/>
        </h:panelGrid>

        <center>
            <div style="overflow:scroll;max-height:100%;width:100%;border:solid 0px green;">
                <a4j:region renderRegionOnly="false">
                    <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" page="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.pageIndex}" reRender="table" id="scrollTable" maxPages="20"align="left" for="table"/>
                    <rich:extendedDataTable groupingColumn="idNum" rows="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.var_nb_max}" style="max-height:100%" styleClass="bg" id="table" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="130%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.dataModelLaboratoire}"  var="var" activeRowKey="true" rowKeyVar="rkv" selection="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.simpleSelectionEntete}" sortMode="multi" selectionMode="single" tableState="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.configListeEntete}" binding="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.extDTable}">
                        <a4j:support eventsQueue="maQueue" event="onselectionchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.selectionExamen}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelBouton,pnlgrttotal,idResExam"/>
                        <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.visualisationExamen}" reRender="idSubView,panelBouton,pnlgrttotal,idResExam"/>
                        <rich:column id="idNum" label="N° Facture" sortable="true" sortBy="#{var.laboratoireEntete.labNum}" >
                            <f:facet name="header"><h:outputText  value="N°" /></f:facet>
                            <h:outputText value="#{var.laboratoireEntete.labNum}" title="#{var.laboratoireEntete.labNum}"/>
                        </rich:column>
                        <rich:column label="Date facture" sortable="true" sortBy="#{var.laboratoireEntete.labDate}" width="70px">
                            <f:facet name="header"><h:outputText  value="Date" /></f:facet>
                            <h:outputText value="#{var.laboratoireEntete.labDate}" title="#{var.laboratoireEntete.labDate}">
                                <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                            </h:outputText>
                        </rich:column>
                        <rich:column id="idEtat" label="Etat" sortable="true" sortBy="#{var.libelle_etat}" width="90px" style="text-align:center;">
                            <f:facet name="header"><h:outputText  value="Etat" /></f:facet>
                            <h:outputText value="#{var.libelle_etat}"  title="#{var.libelle_etat}   #{var.laboratoireEntete.labMotifAnnule}"/>
                        </rich:column>
                        <rich:column label="Patient" sortable="true" sortBy="#{var.laboratoireEntete.nom_anonyme}" width="250px">
                            <f:facet name="header"><h:outputText  value="Patient"  /></f:facet>
                            <h:outputText  value="#{var.laboratoireEntete.nom_anonyme} (#{var.laboratoireEntete.labCivilite})" title="#{var.laboratoireEntete.nom_anonyme}"/>
                        </rich:column>
                        <rich:column label="Code produit" sortable="true" sortBy="#{var.labligProduit}" width="100px">
                            <f:facet name="header"><h:outputText value="Code"/></f:facet>
                            <h:outputText  value="#{var.labligProduit}" title="#{var.labligProduit}"/>
                        </rich:column>
                        <rich:column label="Libellé" sortable="true" sortBy="#{var.labligLibelle}" width="200px">
                            <f:facet name="header"><h:outputText value="Libellé"/></f:facet>
                            <h:outputText  value="#{var.labligLibelle}" title="#{var.labligLibelle}"/>
                        </rich:column>
                        <rich:column id="idResExam" label="Résultat examen" sortable="true" sortBy="#{var.resultatExamenNumerique}" width="80px">
                            <f:facet name="header"><h:outputText value="Résultat"/></f:facet>
                            <h:inputText value="#{var.resultatExamenNumerique}" rendered="#{var.typeExamen==1||var.typeExamen==11}" disabled="#{var.ouvertureZone==false}" style="width:90%">
                                <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.saveResultatDirect}" reRender="idEtat,idResExam,idAnalEffect"/>
                            </h:inputText>
                            <h:inputText value="#{var.resultatExamenDate}" rendered="#{var.typeExamen==2}" disabled="#{var.ouvertureZone==false}" style="width:90%">
                                <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.saveResultatDirect}" reRender="idEtat,idResExam,idAnalEffect"/>
                            </h:inputText>
                            <h:inputText value="#{var.resultatExamenTexte}" rendered="#{var.typeExamen==4||var.typeExamen==9||var.typeExamen==10}" disabled="#{var.ouvertureZone==false}" style="width:90%">
                                <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.saveResultatDirect}" reRender="idEtat,idResExam,idAnalEffect"/>
                            </h:inputText>
                        </rich:column>
                        <rich:column id="idAnalEffect" label="Date analyse effectuée" sortable="true" sortBy="#{var.labligDateRealisee}" width="70px">
                            <f:facet name="header"><h:outputText  value="Analyse" /></f:facet>
                            <h:outputText value="#{var.labligDateRealisee}" title="#{var.labligDateRealisee}">
                                <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                            </h:outputText>
                        </rich:column>
                        <rich:column label="Date prélèvement" sortable="true" sortBy="#{var.laboratoireEntete.labDatePrelevement}" width="70px" sortOrder="ASCENDING">
                            <f:facet name="header"><h:outputText  value="Prélèv." /></f:facet>
                            <h:outputText value="#{var.laboratoireEntete.labDatePrelevement}" title="#{var.laboratoireEntete.labDatePrelevement}">
                                <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                            </h:outputText>
                        </rich:column>
                        <rich:column label="Date résultat prévue" sortable="true" sortBy="#{var.laboratoireEntete.labDateResultat}" width="70px">
                            <f:facet name="header"><h:outputText  value="Dte.Rés." /></f:facet>
                            <h:outputText value="#{var.laboratoireEntete.labDateResultat}" title="#{var.laboratoireEntete.labDateResultat}">
                                <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                            </h:outputText>
                        </rich:column>
                        <rich:column label="Famille" sortable="true" sortBy="#{var.labligFamille}" width="150px">
                            <f:facet name="header"><h:outputText value="Famille"/></f:facet>
                            <h:outputText  value="#{var.labligFamille}" title="#{var.labligFamille}"/>
                        </rich:column>
                        <rich:column label="Appareil" sortable="true" sortBy="#{var.labligAppareil}" width="150px">
                            <f:facet name="header"><h:outputText value="Appareil"/></f:facet>
                            <h:outputText  value="#{var.labligAppareil}" title="#{var.labligAppareil}"/>
                        </rich:column>
                    </rich:extendedDataTable>
                </a4j:region>
            </div>
        </center>
        <br/>
        <h:panelGrid id="pnlgrttotal" columns="4" styleClass="recherche" width="100%">
            <h:panelGrid columns="1">
                <h:outputText value="(Total liste : #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.var_nb_ligne})" />
            </h:panelGrid>
        </h:panelGrid>

    </a4j:form>


    <rich:modalPanel domElementAttachment="parent" id="panelCloture" width="900" height="500" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.showModalPanelCloture}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.showModalPanelCloture}" var="cot">
            <f:facet name="header"><h:outputText value="Cloture du dossier"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.fermerCloture}" image="/images/close.gif" styleClass="hidelink" id="hidelinkImput" reRender="panelCloture"/>
                </a4j:form>
            </f:facet>
            <a4j:form >
                <rich:hotKey key="return" handler="return false;"/>
                <rich:panel  style="width:100%;">
                    <h:panelGrid width="100%">
                        <rich:editor theme="advanced" plugins="safari,spellchecker,pagebreak,style,layer,table,save,advhr,advimage,advlink,iespell,inlinepopups,insertdatetime,preview,media,searchreplace,print,contextmenu,paste,directionality,fullscreen,noneditable,visualchars,nonbreaking,xhtmlxtras,template" viewMode="visual" style="width:100%;background:white;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.laboratoireEntete.labCommentaire}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.var_action=='3'}">
                            <jsp:include flush="true" page="../css/tdt.jsp"/>
                        </rich:editor>
                    </h:panelGrid>
                    <h:panelGrid  columns="2" style="width:100%;">
                        <h:column><h:outputText value="Responsable:" style="text-decoration:underline;"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.laboratoireEntete.labNomResultat}" style="text-align:right" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.var_action=='3'}"/></h:column>
                    </h:panelGrid>
                </rich:panel>
                <h:panelGroup id="idValide">
                    <center>
                        <a4j:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.valideCloture}" reRender="panelCloture,panelBouton,table,scrollTable"/>
                    </center>
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent" id="panelDeCloture" width="900" height="250" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.showModalPanelDeCloture}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.showModalPanelDeCloture}" var="cot">
            <f:facet name="header"><h:outputText value="Dé-Cloture du dossier"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.fermerDeCloture}" image="/images/close.gif" styleClass="hidelink" id="hidelinkImput" reRender="panelDeCloture"/>
                </a4j:form>
            </f:facet>
            <a4j:form >
                <rich:hotKey key="return" handler="return false;"/>
                <rich:panel  style="width:100%;">
                    <h:panelGrid  columns="2" style="width:100%;">
                        <h:column><h:outputText value="Motif de la décloture:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.laboratoireEntete.labMotifDecloture}" style="text-align:right" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.var_action=='3'}"/></h:column>
                    </h:panelGrid>
                </rich:panel>
                <h:panelGroup id="idValide">
                    <center>
                        <a4j:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.valideDeCloture}" reRender="panelDeCloture,panelBouton,table,scrollTable"/>
                    </center>
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"  id="panelImp" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="650" height="400" autosized="true" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.showModalPanelPrint}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.showModalPanelPrint}" var="prt">
            <jsp:include flush="true" page="/commun/impressionExploitation.jsp"/>
        </c:if>
    </rich:modalPanel>


</f:subview>
