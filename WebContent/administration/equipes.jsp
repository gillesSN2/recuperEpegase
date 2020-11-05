<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="equipe">

    <a4j:form id="orgequipe">

        <center> <h2><h:outputText value="GESTION DES EQUIPES" style="color:green;"/></h2></center>
        <center>
            <h:panelGrid  id="panelBouton" width="200px" columns="4">
                <a4j:commandButton title="Ajouter une équipe" image="/images/ajouter.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formEquipes.ajouterEquipes}" reRender="panelEquipes,panelBouton"/>
                <a4j:commandButton title="Modifier l'équipe" image="/images/modifier.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formEquipes.var_affiche_bouton}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formEquipes.modifierEquipes}" reRender="panelEquipes,panelBouton"/>
                <a4j:commandButton title="Supprimer l'équipe" image="/images/supprimer.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formEquipes.var_affiche_bouton}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formEquipes.supprimerEquipes}" onclick="if (!confirm('Etes-vous sur de vouloir supprimer cet élément?')) return false" reRender="panelBouton,tableEquipe"/>
                <a4j:commandButton title="Imprimer les équipes" image="/images/print.png" oncomplete="javascript:Richfaces.showModalPanel('panelImp');"/>
            </h:panelGrid>
        </center>
        <br>
        <center>
            <a4j:region renderRegionOnly="false">
                <rich:extendedDataTable  activeClass="active-row" id="tableEquipe" noDataLabel=" " headerClass="headerTab"  width="100%" styleClass="bg" style="max-height:100%;border:solid 0px green;cursor:pointer;" border="0" rowClasses="rows1,rows2,rowsd" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formEquipes.datamodelEquipes}" var="equ"  >
                    <a4j:support eventsQueue="maQueue"  event="onRowClick"  reRender="panelBouton" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formEquipes.selectionEquipe}"/>
                    <rich:column sortable="true" sortBy="#{equ.equCode}" width="10%" sortOrder="ASCENDING">
                        <f:facet name="header"><h:outputText value="Code"/></f:facet>
                        <h:outputText  value="#{equ.equCode}"/>
                    </rich:column >
                    <rich:column sortable="true" sortBy="#{equ.equNomFr}" width="20%">
                        <f:facet name="header"><h:outputText value="Equipes"/></f:facet>
                        <h:outputText  value="#{equ.equNomFr}"/>
                    </rich:column >
                    <rich:column sortable="true" sortBy="#{equ.libType}" width="10%">
                        <f:facet name="header"><h:outputText value="Type"/></f:facet>
                        <h:outputText  value="#{equ.libType}"/>
                    </rich:column >
                    <rich:column sortable="true" sortBy="#{equ.equQuart}" width="5%">
                        <f:facet name="header"><h:outputText value="Quart"/></f:facet>
                        <h:outputText  value="#{equ.equQuart}"/>
                    </rich:column >
                    <rich:column sortable="true" sortBy="#{equ.equHeureDebut}" width="8%">
                        <f:facet name="header"><h:outputText value="Début"/></f:facet>
                        <h:outputText  value="#{equ.equHeureDebut} : #{equ.equMinuteDebut}"/>
                    </rich:column >
                    <rich:column sortable="true" sortBy="#{equ.equHeureFin}" width="8%">
                        <f:facet name="header"><h:outputText value="Fin"/></f:facet>
                        <h:outputText  value="#{equ.equHeureFin} : #{equ.equMinuteFin}"/>
                    </rich:column >
                    <rich:column sortable="true" sortBy="#{equ.equNomResponsable}" width="15%">
                        <f:facet name="header"><h:outputText value="Responsable"/></f:facet>
                        <h:outputText value="#{equ.equNomResponsable}"/>
                    </rich:column >
                    <rich:column sortable="true" sortBy="#{equ.equDepot}" width="15%">
                        <f:facet name="header"><h:outputText value="Dépôt"/></f:facet>
                        <h:outputText value="#{equ.equDepot}"/>
                    </rich:column >
                    <rich:column sortable="true" sortBy="#{equ.equCaisse}" width="15%">
                        <f:facet name="header"><h:outputText value="Caisse"/></f:facet>
                        <h:outputText value="#{equ.equCaisse}"/>
                    </rich:column >
                    <rich:column  width="5%" sortable="true" sortBy="#{equ.equInactif}">
                        <f:facet name="header"><h:outputText value="Etat" /></f:facet>
                        <h:commandButton image="#{equ.etat}"  rendered="#{equ.afficheImag}"/>
                    </rich:column>
                </rich:extendedDataTable>
            </a4j:region>
        </center>
        <center>
            <h:commandButton id="idCancel" value="RETOUR"styleClass="exp_lienmenu" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.retourAdminstrationGenerale}" />
            <rich:hotKey key="esc"  handler="#{rich:element('idCancel')}.click()" />
        </center>
    </a4j:form>



    <rich:modalPanel domElementAttachment="parent"   headerClass="headerPanel" id="panelEquipes" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);"  width="500" height="450" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formEquipes.showmodelPanel}">
        <center>
            <f:facet name="header"><h:outputText value="GESTION DES EQUIPES"/></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton id="idCancel" image="/images/close.gif" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formEquipes.annulerEquipes}" styleClass="hidelink" reRender="panelEquipes,panelBouton"/>
                    <rich:hotKey key="esc" handler="#{rich:element('idCancel')}.click()" />
                </a4j:form>
            </f:facet>
            <a4j:form>

                <rich:tabPanel switchType="client" immediate="true" id="panelGlobal" style="border:0px;background-color:white;">

                    <rich:tab id="tabEquipe" label="Equipe">
                        <h:panelGrid columns="2" id="pgrdAjtAct" columnClasses="clos20,clos80">
                            <h:column><h:outputText value="Code:" /></h:column>
                            <h:column id="clnAjtAct">
                                <h:inputText id="AdActCode"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formEquipes.equipes.equCode}" size="7" maxlength="20" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formEquipes.equipes.equId!=0}" onkeypress="return scanToucheLettre(event)" style="width:100%;text-transform:uppercase">
                                    <a4j:support eventsQueue="maQueue" event="onchange"  reRender="pgrdAjtAct,prgoutpAjtAct" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formEquipes.verifielesSaisieCode}"/>
                                </h:inputText>&nbsp;&nbsp;
                                <h:outputText  id="outexistCodeAct" style="color:red;" value="Le code est vide ou existe déjà!" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formEquipes.existeCode}"/>
                            </h:column>
                            <h:column><h:outputText value="Libellé:"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formEquipes.equipes.equNomFr}" onkeypress="return scanToucheLettre(event)" style="width:100%;text-transform:uppercase" maxlength="100">
                                    <a4j:support eventsQueue="maQueue" event="onchange"  reRender="pgrdAjtAct,prgoutpAjtAct" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formEquipes.verifielesSaisieLibelleAct}"/>
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value="Type:" style="text-decoration:underline;"/></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:350px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formEquipes.equipes.equType}">
                                    <f:selectItem itemLabel="Secrétariat" itemValue="3"/>
                                    <f:selectItem itemLabel="Administrative" itemValue="4"/>
                                    <f:selectItem itemLabel="R.H." itemValue="5"/>
                                    <f:selectItem itemLabel="Logistique" itemValue="60"/>
                                    <f:selectItem itemLabel="Production" itemValue="61"/>
                                    <f:selectItem itemLabel="Technique" itemValue="7"/>
                                    <f:selectItem itemLabel="Commerciale" itemValue="80"/>
                                    <f:selectItem itemLabel="Médicale" itemValue="81"/>
                                    <f:selectItem itemLabel="Caissier" itemValue="9"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="N° Quart:"  style="text-decoration:underline;"/></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:350px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formEquipes.equipes.equQuart}">
                                    <f:selectItem itemLabel="1" itemValue="1"/>
                                    <f:selectItem itemLabel="2" itemValue="2"/>
                                    <f:selectItem itemLabel="3" itemValue="3"/>
                                    <f:selectItem itemLabel="4" itemValue="4"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Heure début:"/></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:50px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formEquipes.equipes.equHeureDebut}">
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.mesHeuresGlobalItems}"/>
                                </h:selectOneMenu>&nbsp;&nbsp;&nbsp;
                                <h:outputText value=":"/>&nbsp;
                                <h:selectOneMenu style="width:50px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formEquipes.equipes.equMinuteDebut}">
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.mesMinutesGlobalItems}"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Heure fin:"/></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:50px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formEquipes.equipes.equHeureFin}">
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.mesHeuresGlobalItems}"/>
                                </h:selectOneMenu>&nbsp;&nbsp;&nbsp;
                                <h:outputText value=":"/>&nbsp;
                                <h:selectOneMenu style="width:50px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formEquipes.equipes.equMinuteFin}">
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.mesMinutesGlobalItems}"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Responsable:"  style="text-decoration:underline;"/></h:column>
                            <h:column>
                                <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formEquipes.equipes.equIdResponsable}" style="width:100%;">
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formEquipes.mesResponsable}" />
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Dépôt origine:"  style="text-decoration:underline;"/></h:column>
                            <h:column>
                                <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formEquipes.equipes.equDepotOrigine}" style="width:100%;">
                                    <f:selectItem itemLabel="Sans Dépôt" itemValue="0"/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formEquipes.mesDepotsOrigineItems}" />
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Dépôt travail:"  style="text-decoration:underline;"/></h:column>
                            <h:column>
                                <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formEquipes.equipes.equDepot}" style="width:100%;">
                                    <f:selectItem itemLabel="Sans Dépôt" itemValue="0"/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formEquipes.mesDepotsItems}" />
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Gestion stock:"  style="text-decoration:underline;"/></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:350px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formEquipes.equipes.equStock}">
                                    <f:selectItem itemLabel="Gestion Stock de l'équipe" itemValue="0"/>
                                    <f:selectItem itemLabel="Gestion Stock global" itemValue="1"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Caisse:"  style="text-decoration:underline;"/></h:column>
                            <h:column>
                                <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formEquipes.equipes.equCaisse}" style="width:100%;">
                                    <f:selectItem itemLabel="Sans Caisse" itemValue="0"/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formEquipes.mesCaissesItems}" />
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Inactif:" /></h:column>
                            <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formEquipes.var_inactif}"/></h:column>
                        </h:panelGrid>
                    </rich:tab>

                    <rich:tab id="tabAgents" label="Agents">
                        <h:panelGrid style="width:100%;">
                            <a4j:region renderRegionOnly="false">
                                <rich:extendedDataTable  style="border:solid 0px green;" border="0" id="serieCaisse" width="100%" height="300px" footerClass="bard" activeClass="active-row" headerClass="headerTab" rowClasses="rows1,rows2,rowsd" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formEquipes.dataModelAgents}" var="agt">
                                    <rich:column width="10%" sortable="true">
                                        <f:facet name="header" ><h:outputText value="Sel."/></f:facet>
                                        <h:selectBooleanCheckbox value="#{agt.selectUser}"/>
                                    </rich:column>
                                    <rich:column width="90%" >
                                        <f:facet name="header" ><h:outputText value="Membre de l'équipe"/></f:facet>
                                        <h:outputText value="#{agt.usrPatronyme}"/>
                                    </rich:column>
                                </rich:extendedDataTable>
                            </a4j:region>
                        </h:panelGrid>
                    </rich:tab>

                </rich:tabPanel>

                <h:panelGroup id="prgoutpAjtAct">
                    <br>
                    <center>
                        <a4j:commandButton id="idValide" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formEquipes.saveEquipes}" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formEquipes.existeCode}" reRender="panelEquipes,panelBouton,tableEquipe"/>
                        <rich:hotKey key="return"  handler="#{rich:element('idValide')}.click()" />
                    </center>
                    <br>
                    <center>
                        <h:outputText  id="outpAjtCodLibAct" style="color:red;" value="La saisie du code et du libellé sont obligatoires!" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formEquipes.codelibVide==false}"/>
                    </center>
                </h:panelGroup>

            </a4j:form>
        </center>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"   headerClass="headerPanel" id="panelImp" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="550" height="200">
        <jsp:include flush="true" page="/commun/impressionParametre.jsp"/>
    </rich:modalPanel>


</f:subview>