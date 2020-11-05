<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="jc">
    <a4j:form>

        <center><h2><h:outputText value="LISTE DES MOTIFS ENTREES DES CONSULTATIONS" style="color:green;"/></h2></center>

        <h:panelGroup id="panelBouton">
            <a4j:commandButton image="/images/ajouter.png" title="ajouter" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formMotifentreeConsultMedical.chargerPanAdd}"  oncomplete="javascript:Richfaces.showModalPanel('panelAddFormAchats');" reRender="panelAddFormAchats,formulaireajt"></a4j:commandButton> &nbsp; &nbsp;&nbsp;
            <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formMotifentreeConsultMedical.chargerPanAModif}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formMotifentreeConsultMedical.afficheButtModif}" title="modifier" id="boutonModif" image="/images/modifier.png" oncomplete="javascript:Richfaces.showModalPanel('panelModifFormAchats');" reRender="panelModifFormAchats,formulairemod"></a4j:commandButton> &nbsp; &nbsp;&nbsp;
            <a4j:commandButton id="boutonSupp" image="/images/supprimer.png"  title="supprimer"  rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formMotifentreeConsultMedical.afficheButtModif}"   onclick="if (!confirm('Etes-vous sur de vouloir supprimer cet élément?')) return false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formMotifentreeConsultMedical.deleteMotifEntreeMedical}" reRender="panelBouton,mytableau"></a4j:commandButton> &nbsp; &nbsp;&nbsp;
            <a4j:commandButton image="/images/print.png"  title="imprimer" oncomplete="javascript:Richfaces.showModalPanel('panelImp');"></a4j:commandButton>
        </h:panelGroup>
        <br/><br/>
        <a4j:region renderRegionOnly="false">
            <rich:extendedDataTable border="0" id="mytableau" headerClass="headerTab" activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" width="100%" style="max-height:100%;border:solid 0px green;cursor:pointer;"  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formMotifentreeConsultMedical.madatamodel}"  var="mot">
                <a4j:support eventsQueue="maQueue" event="onRowClick"oncomplete="changeColor(this)" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formMotifentreeConsultMedical.confirmer}" reRender="panelBouton,panelModifFormAchats"/>
                <rich:column  width="15%">
                    <f:facet name="header"><h:outputText  value="Code"  /></f:facet>
                    <h:outputText  value="#{mot.mteCode}">
                    </h:outputText>
                </rich:column>
                <rich:column  width="45%">
                    <f:facet name="header"><h:outputText  value="Libellé"  /></f:facet>
                    <h:outputText  value="#{mot.mteLibelle}">
                    </h:outputText>
                </rich:column>
                <rich:column  width="5%">
                    <f:facet name="header"><h:outputText  value="C.G"  /></f:facet>
                    <h:selectBooleanCheckbox value="#{mot.var_conGene}" disabled="true"/>
                </rich:column>
                <rich:column  width="5%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formMotifentreeConsultMedical.infirmerie==true}">
                    <f:facet name="header"><h:outputText  value="VME"  /></f:facet>
                    <h:selectBooleanCheckbox value="#{mot.var_vme}" disabled="true"/>
                </rich:column>
                <rich:column  width="5%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formMotifentreeConsultMedical.infirmerie==true}">
                    <f:facet name="header"><h:outputText  value="VMA"  /></f:facet>
                    <h:selectBooleanCheckbox value="#{mot.var_vma}" disabled="true"/>
                </rich:column>
                <rich:column  width="5%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formMotifentreeConsultMedical.infirmerie==true}">
                    <f:facet name="header"><h:outputText  value="A.T."  /></f:facet>
                    <h:selectBooleanCheckbox value="#{mot.var_at}" disabled="true"/>
                </rich:column>
                <rich:column  width="5%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formMotifentreeConsultMedical.infirmerie==true}">
                    <f:facet name="header"><h:outputText  value="Vac."  /></f:facet>
                    <h:selectBooleanCheckbox value="#{mot.var_vaccin}" disabled="true"/>
                </rich:column>
                <rich:column  width="5%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formMotifentreeConsultMedical.infirmerie==true}">
                    <f:facet name="header"><h:outputText  value="IDR"  /></f:facet>
                    <h:selectBooleanCheckbox value="#{mot.var_tubertest}" disabled="true"/>
                </rich:column>
                <rich:column  width="5%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formMotifentreeConsultMedical.infirmerie==true}">
                    <f:facet name="header"><h:outputText  value="Audio."  /></f:facet>
                    <h:selectBooleanCheckbox value="#{mot.var_audio}" disabled="true"/>
                </rich:column>
                <rich:column  width="5%" rendered="#{false&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formMotifentreeConsultMedical.infirmerie==false}">
                    <f:facet name="header"><h:outputText  value="C.S"  /></f:facet>
                    <h:selectBooleanCheckbox value="#{mot.var_conSpe}" disabled="true"/>
                </rich:column>
                <rich:column  width="5%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formMotifentreeConsultMedical.infirmerie==false}">
                    <f:facet name="header"><h:outputText  value="Lab."/></f:facet>
                    <h:selectBooleanCheckbox value="#{mot.var_lab}" disabled="true"/>
                </rich:column>
                <rich:column  width="10%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formMotifentreeConsultMedical.infirmerie==false}">
                    <f:facet name="header"><h:outputText  value="Tar.Conv.Soc."/></f:facet>
                    <h:selectBooleanCheckbox value="#{mot.var_convSoc}" disabled="true"/>
                </rich:column>
                <rich:column  width="10%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formMotifentreeConsultMedical.infirmerie==false}">
                    <f:facet name="header"><h:outputText  value="Tar.Conv.Assu."/></f:facet>
                    <h:selectBooleanCheckbox value="#{mot.var_convAss}" disabled="true"/>
                </rich:column>
                <rich:column width="5%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formMotifentreeConsultMedical.infirmerie==false}">
                    <f:facet name="header"><h:outputText  value="Eat"  /></f:facet>
                    <h:commandButton image="#{mot.etat}" rendered="#{mot.inactif}" onclick="if (!confirm('Voulez-vous réactiver cet élèment ?')) return false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formMotifentreeConsultMedical.reactiverMotifentreeMedical}" title="Supprimer" style="text-align:right;">
                        <a4j:support eventsQueue="maQueue" reRender="panelBouton,mytableau" event="onclick"/>
                    </h:commandButton>
                </rich:column>
            </rich:extendedDataTable>
        </a4j:region>
        <br/>
        <center>
            <h:commandButton id="idCancel" value="RETOUR"styleClass="exp_lienmenu"action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.retourLigne}"  />
            <rich:hotKey key="esc"  handler="#{rich:element('idCancel')}.click()" />
        </center>
    </a4j:form>



    <rich:modalPanel domElementAttachment="parent"  id="panelAddFormAchats" width="800" height="380"  headerClass="headerPanel" style="border:solid 0px black;background-color:white">
        <f:facet name="header">
            <h:panelGroup><h:outputText value="AJOUT D'UN MOTIF D'ENTREE" /></h:panelGroup>
        </f:facet>
        <f:facet name="controls">
            <h:panelGroup>
                <h:graphicImage value="/images/close.gif" styleClass="hidelink" id="hidelink"/>
                <rich:componentControl for="panelAddFormAchats" attachTo="hidelink" operation="hide" event="onclick"/>
            </h:panelGroup>
        </f:facet>

        <a4j:form id="formulaireajt">
            <h:panelGrid columns="2" columnClasses="clos25,clos75">
                <h:column><h:outputText value="Code:"/></h:column>
                <h:column><h:inputText size="10" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formMotifentreeConsultMedical.motifEntreeMedical.mteCode}" maxlength="4" onkeypress="return scanToucheLettre(event)" style="width:100%;text-transform:uppercase"/></h:column>
                <h:column><h:outputText value="Libellé:"/></h:column>
                <h:column><h:inputText size="45" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formMotifentreeConsultMedical.motifEntreeMedical.mteLibelle}" maxlength="100" onkeypress="return scanToucheLettre(event)" style="width:100%;text-transform:uppercase"/></h:column>
                <h:column><h:outputText value="Actif Consultation Générale:"/></h:column>
                <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formMotifentreeConsultMedical.var_conGene}"/></h:column>

                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formMotifentreeConsultMedical.infirmerie==false&&false}"><h:outputText value="Actif Consultation Spécialisée:"/></h:column>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formMotifentreeConsultMedical.infirmerie==false&&false}"><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formMotifentreeConsultMedical.var_conSpe}"/></h:column>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formMotifentreeConsultMedical.infirmerie==false}"><h:outputText value="Actif Laboratoire/imagerie:"/></h:column>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formMotifentreeConsultMedical.infirmerie==false}"><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formMotifentreeConsultMedical.var_lab}"/></h:column>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formMotifentreeConsultMedical.infirmerie==false}"><h:outputText value="Applicable sur les tarifs conventionnés Sociétés:" style="color:red"/></h:column>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formMotifentreeConsultMedical.infirmerie==false}"><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formMotifentreeConsultMedical.var_convSoc}" style="color:red"/></h:column>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formMotifentreeConsultMedical.infirmerie==false}"><h:outputText value="Applicable sur les tarifs conventionnés Assurances:" style="color:red"/></h:column>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formMotifentreeConsultMedical.infirmerie==false}"><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formMotifentreeConsultMedical.var_convAss}" style="color:red"/></h:column>

                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formMotifentreeConsultMedical.infirmerie==true}"><h:outputText value="Option V.M.E.:"/></h:column>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formMotifentreeConsultMedical.infirmerie==true}"><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formMotifentreeConsultMedical.var_vme}"/></h:column>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formMotifentreeConsultMedical.infirmerie==true}"><h:outputText value="Option V.M.A.:"/></h:column>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formMotifentreeConsultMedical.infirmerie==true}"><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formMotifentreeConsultMedical.var_vma}"/></h:column>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formMotifentreeConsultMedical.infirmerie==true}"><h:outputText value="Option Accident Travail:"/></h:column>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formMotifentreeConsultMedical.infirmerie==true}"><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formMotifentreeConsultMedical.var_at}"/></h:column>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formMotifentreeConsultMedical.infirmerie==true}"><h:outputText value="Option Vaccination:"/></h:column>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formMotifentreeConsultMedical.infirmerie==true}"><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formMotifentreeConsultMedical.var_vaccin}"/></h:column>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formMotifentreeConsultMedical.infirmerie==true}"><h:outputText value="Option IDR (Tubertest):"/></h:column>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formMotifentreeConsultMedical.infirmerie==true}"><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formMotifentreeConsultMedical.var_tubertest}"/></h:column>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formMotifentreeConsultMedical.infirmerie==true}"><h:outputText value="Option Audiométrie:"/></h:column>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formMotifentreeConsultMedical.infirmerie==true}"><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formMotifentreeConsultMedical.var_audio}"/></h:column>
            </h:panelGrid>
            <center>
                <br><br>
                <h:panelGroup>
                    <h:commandButton image="/images/valider_big.png"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formMotifentreeConsultMedical.saveMotifEntreeMedical}"  >
                        <a4j:support eventsQueue="maQueue" event="onclick" reRender="panelAddFormAchats,mytableau"/>
                    </h:commandButton >
                </h:panelGroup>
            </center>
        </a4j:form>
    </rich:modalPanel>



    <!--**********************   Modal panel pour la modification **************************/-->
    <rich:modalPanel domElementAttachment="parent"  id="panelModifFormAchats"  width="800" height="380"   headerClass="headerPanel" style="border:solid 0px black;background-color:white">

        <f:facet name="header">
            <h:panelGroup><h:outputText value="MODIFICATION D'UN MOTIF D'ENTREE"/></h:panelGroup>
        </f:facet>
        <f:facet name="controls">
            <h:panelGroup>
                <h:graphicImage value="/images/close.gif" styleClass="hidelink" id="hidelink21"/>
                <rich:componentControl for="panelModifFormAchats" attachTo="hidelink21" operation="hide" event="onclick"/>
            </h:panelGroup>
        </f:facet>

        <a4j:form id="formulairemod">
            <h:panelGrid columns="2" columnClasses="clos25,clos75">
                <h:column><h:outputText value="Code:"/></h:column>
                <h:column><h:inputText size="10" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formMotifentreeConsultMedical.motifEntreeMedical.mteCode}" maxlength="4" readonly="true"/></h:column>
                <h:column><h:outputText value="Libellé:"/></h:column>
                <h:column><h:inputText size="45" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formMotifentreeConsultMedical.motifEntreeMedical.mteLibelle}" maxlength="100" onkeypress="return scanToucheLettre(event)" style="width:100%;text-transform:uppercase"/></h:column>
                <h:column><h:outputText value="Actif Consultation Générale:"/></h:column>
                <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formMotifentreeConsultMedical.var_conGene}"/></h:column>

                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formMotifentreeConsultMedical.infirmerie==false}"><h:outputText value="Actif Consultation Spécialisée:"/></h:column>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formMotifentreeConsultMedical.infirmerie==false}"><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formMotifentreeConsultMedical.var_conSpe}"/></h:column>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formMotifentreeConsultMedical.infirmerie==false}"><h:outputText value="Actif Laboratoire/immagerie:"/></h:column>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formMotifentreeConsultMedical.infirmerie==false}"><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formMotifentreeConsultMedical.var_lab}"/></h:column>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formMotifentreeConsultMedical.infirmerie==false}"><h:outputText value="Applicable sur les tarifs conventionnés Sociétés:" style="color:red"/></h:column>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formMotifentreeConsultMedical.infirmerie==false}"><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formMotifentreeConsultMedical.var_convSoc}" style="color:red"/></h:column>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formMotifentreeConsultMedical.infirmerie==false}"><h:outputText value="Applicable sur les tarifs conventionnés Assurances:" style="color:red"/></h:column>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formMotifentreeConsultMedical.infirmerie==false}"><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formMotifentreeConsultMedical.var_convAss}" style="color:red"/></h:column>

                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formMotifentreeConsultMedical.infirmerie==true}"><h:outputText value="Option V.M.E.:"/></h:column>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formMotifentreeConsultMedical.infirmerie==true}"><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formMotifentreeConsultMedical.var_vme}"/></h:column>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formMotifentreeConsultMedical.infirmerie==true}"><h:outputText value="Option V.M.A.:"/></h:column>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formMotifentreeConsultMedical.infirmerie==true}"><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formMotifentreeConsultMedical.var_vma}"/></h:column>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formMotifentreeConsultMedical.infirmerie==true}"><h:outputText value="Option Accident Travail:"/></h:column>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formMotifentreeConsultMedical.infirmerie==true}"><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formMotifentreeConsultMedical.var_at}"/></h:column>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formMotifentreeConsultMedical.infirmerie==true}"><h:outputText value="Option Vaccination:"/></h:column>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formMotifentreeConsultMedical.infirmerie==true}"><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formMotifentreeConsultMedical.var_vaccin}"/></h:column>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formMotifentreeConsultMedical.infirmerie==true}"><h:outputText value="Option IDR (Tubertest):"/></h:column>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formMotifentreeConsultMedical.infirmerie==true}"><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formMotifentreeConsultMedical.var_tubertest}"/></h:column>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formMotifentreeConsultMedical.infirmerie==true}"><h:outputText value="Option Audiométrie:"/></h:column>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formMotifentreeConsultMedical.infirmerie==true}"><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formMotifentreeConsultMedical.var_audio}"/></h:column>

                <h:column><h:outputText value="Inactif:"/></h:column>
                <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formMotifentreeConsultMedical.inactifModif}"/></h:column>
            </h:panelGrid>
            <center>
                <br><br>
                <h:panelGroup>
                    <h:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formMotifentreeConsultMedical.upDateMotifEntreeMedical}">
                        <a4j:support eventsQueue="maQueue" event="onclick"  reRender="mytableau"/>
                    </h:commandButton >
                </h:panelGroup>
            </center>
        </a4j:form>
    </rich:modalPanel>


    <!-- debut Modal panel pour impression -->
    <rich:modalPanel domElementAttachment="parent"   headerClass="headerPanel" id="panelImp" style="border:solid 1px black;background-color:white"  width="550" height="200">
        <jsp:include flush="true" page="/commun/impressionParametre.jsp"/>
    </rich:modalPanel>


</f:subview>
