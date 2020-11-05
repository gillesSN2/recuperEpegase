<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>


<f:subview id="fichesimulation">

    <a4j:form>

        <center><h2><h:outputText id="idTitre" value="SIMULATION DES BULLETINS DE SALAIRE" style="color:green;"/></h2></center>

        <h:panelGrid  columns="1" width="100%" id="recherche" >
            <h:panelGrid id="idRecherche" columns="7" styleClass="recherche" width="100%">
                <h:column><h:outputText value="Salarié:" style="text-decoration:underline;"/></h:column>
                <h:column>
                    <h:inputText id="idSalarie" style="width:200px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.nomSalarie}">
                        <rich:toolTip followMouse="true" direction="top-right" showDelay="1000" value="chaine = Recherche qui commence... / *chaine = Recherche qui contient... / * = Recherche tous les salariés (puis tabuler)" style="background-color:#FFF8D4;"/>
                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.rechercheSalarieContrat}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView,panelListeSalariesContrat,formModalListeSalariesContrat,idSalarie,idRecherche"/>
                    </h:inputText>
                </h:column>
                <h:column><h:outputText value="Montant à atteindre:"/></h:column>
                <h:column>
                    <h:inputText style="width:100px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.montantAtteindre}">
                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                    </h:inputText>
                </h:column>
                <h:column>
                    <a4j:commandButton value="CONTRAT et VARIABLES" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.saisieVariables}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelVariable" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.salariesContrats.salconId!=0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.salaries.salId!=0}"/>
                </h:column>
                <h:column>
                    <a4j:commandButton id="idValRecherche" value="CALCUL SIMULATION" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.calculSimulation}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,recherche,idMois,idAnnee,modMessage" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.salariesContrats.salconId!=0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.salaries.salId!=0}"/>&nbsp;&nbsp;&nbsp;
                </h:column>
                <h:column>
                    <a4j:commandButton title="Imprimer" image="/images/print.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.impressionSimulation}" reRender="panelImpBulletin,formModalImp,panchoixdoc,panelMail" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.menupaye.imp&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.salaries.salId!=0}"/>
                </h:column>
            </h:panelGrid>

            <h:panelGrid  width="100%" id="idMois" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.choixResultat==1}">
                <a4j:region renderRegionOnly="false">
                    <rich:extendedDataTable rows="200" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.dataModelBulletinsLigne}" enableContextMenu="false" var="plan" id="table" border="0" styleClass="bg" style="border:solid 1px green" width="100%" height="450px" footerClass="bard" headerClass="headerTab" rowClasses="rows1,rows2,rowsd" noDataLabel=" " selectedClass="active-row">
                        <rich:column  width="12%" sortable="false">
                            <f:facet name="header"><h:outputText value="Nature" /></f:facet>
                            <h:outputText value= "#{plan.bulligNature} : #{plan.libNature}" style="#{plan.espaceFamille}"/>
                        </rich:column>
                        <rich:column width="8%" sortable="true" sortBy="#{plan.bulligRubrique}" sortOrder="ASCENDING" >
                            <f:facet name="header"><h:outputText value="Code" /></f:facet>
                            <h:outputText value="#{plan.bulligRubrique}" style="#{plan.espaceFamille}"/>
                        </rich:column>
                        <rich:column width="30%" sortable="false" >
                            <f:facet name="header"><h:outputText value="Libellé rubrique"/></f:facet>
                            <h:outputText value="#{plan.bulligLibelle}" style="#{plan.espaceFamille}"/>
                        </rich:column>
                        <rich:column width="10%" sortable="false" style="text-align:right;">
                            <f:facet name="header"><h:outputText value="A-Calcul"/></f:facet>
                            <h:inputText value="#{plan.bulligValColA}" rendered="#{plan.bulligAffColA&&plan.bulligNature!=59&&plan.bulligNature!=69&&plan.bulligNature!=89&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.var_correction==true}" style="#{plan.espaceFamille}"/>
                            <h:outputText value="#{plan.bulligValColA}" rendered="#{plan.bulligAffColA&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.var_correction==false}" style="#{plan.espaceFamille}"/>
                            <a4j:commandButton value="Maj.contrat" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.majSursalaireContrat}" styleClass="hidelink" rendered="#{plan.bulligRubrique=='100030'}" onclick="if (!confirm('Etes-vous sur de vouloir mettre à jour le sursalaire du contrat ?')) return false;"/>
                        </rich:column>
                        <rich:column width="10%" sortable="false" style="text-align:right;">
                            <f:facet name="header"><h:outputText value="B-Base"/></f:facet>
                            <h:inputText value="#{plan.bulligValColB}" rendered="#{plan.bulligAffColB&&plan.bulligNature!=59&&plan.bulligNature!=69&&plan.bulligNature!=89&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.var_correction==true}" style="#{plan.espaceFamille}">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                            <h:outputText value="#{plan.bulligValColB}" rendered="#{plan.bulligAffColB&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.var_correction==false}" style="#{plan.espaceFamille}">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:outputText>
                        </rich:column>
                        <rich:column width="10%" sortable="false" style="text-align:right;">
                            <f:facet name="header"><h:outputText value="C-Taux"/></f:facet>
                            <h:inputText value="#{plan.bulligValColC}" rendered="#{plan.bulligAffColC&&plan.bulligNature!=59&&plan.bulligNature!=69&&plan.bulligNature!=89&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.var_correction==true}" style="#{plan.espaceFamille}"/>
                            <h:outputText value="#{plan.bulligValColC}" rendered="#{plan.bulligAffColC&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.var_correction==false}" style="#{plan.espaceFamille}"/>
                        </rich:column>
                        <rich:column width="10%" sortable="false" style="text-align:right;">
                            <f:facet name="header"><h:outputText value="D-Nb"/></f:facet>
                            <h:inputText value="#{plan.bulligValColD}" rendered="#{plan.bulligAffColD&&plan.bulligNature!=59&&plan.bulligNature!=69&&plan.bulligNature!=89&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.var_correction==true}" style="#{plan.espaceFamille}"/>
                            <h:outputText value="#{plan.bulligValColD}" rendered="#{plan.bulligAffColD&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.var_correction==false}" style="#{plan.espaceFamille}"/>
                        </rich:column>
                        <rich:column width="10%" sortable="false" style="text-align:right;">
                            <f:facet name="header"><h:outputText value="E-Résultat"/></f:facet>
                            <h:inputText value="#{plan.bulligValColE}" rendered="#{plan.bulligAffColE&&plan.bulligNature!=59&&plan.bulligNature!=69&&plan.bulligNature!=89&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.var_correction==true}" style="#{plan.espaceFamille}">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                            <h:outputText value="#{plan.bulligValColE}" rendered="#{plan.bulligAffColE&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.var_correction==false}" style="#{plan.espaceFamille}">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:outputText>
                        </rich:column>
                    </rich:extendedDataTable>
                </a4j:region>
            </h:panelGrid>

            <h:panelGrid  width="100%" id="idAnnee" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.choixResultat==2}">

            </h:panelGrid>

        </h:panelGrid>
    </a4j:form>

    <rich:modalPanel domElementAttachment="parent"  headerClass="headerPanel" id="panelVariable" width="900" height="700" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.showModalPanelVariable}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.showModalPanelVariable}" var="varb">
            <f:facet name="header"><h:outputText value="GESTION DES VARIABLES POUR LA SIMULATION"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton id="idCanVariable" image="/images/close.gif" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.fermerVariables}" styleClass="hidelink" reRender="panelVariable"/>
                    <rich:hotKey key="esc" handler="#{rich:element('idCanVariable')}.click()" />
                </a4j:form>
            </f:facet>
            <a4j:form >
                <h:panelGrid style="width:100%;" id="panVariable">

                    <rich:tabPanel switchType="client" immediate="true"  id="tabPanelsalaries" style="border:0px;">

                        <rich:tab name="variable" label="Variables mensuelles">
                            <jsp:include flush="true" page="/paye/SimulationCommun.jsp" />
                            <a4j:region renderRegionOnly="false">
                                <rich:extendedDataTable rows="200" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.dataModelVariables}" enableContextMenu="false" var="plan" id="table" border="0" styleClass="bg" style="border:solid 1px green" width="100%" height="450px" footerClass="bard" headerClass="headerTab" rowClasses="rows1,rows2,rowsd" noDataLabel=" " selectedClass="active-row">
                                    <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.selectionVariable}" reRender="butt"/>
                                    <rich:column  width="12%" sortable="false">
                                        <f:facet name="header"><h:outputText value="Nature" /></f:facet>
                                        <h:outputText value= "#{plan.planPaye.libelleNature}"/>
                                    </rich:column>
                                    <rich:column width="8%" sortable="false" sortBy="#{plan.salvarCode}" sortOrder="ASCENDING">
                                        <f:facet name="header"><h:outputText value="Code" /></f:facet>
                                        <h:outputText value="#{plan.salvarCode}"/>
                                    </rich:column>
                                    <rich:column width="30%" sortable="false" >
                                        <f:facet name="header"><h:outputText value="Libellé rubrique"/></f:facet>
                                        <h:outputText value="#{plan.planPaye.plpLibelleFR}"/>
                                    </rich:column>
                                    <rich:column width="10%" sortable="false" style="text-align:right;">
                                        <f:facet name="header"><h:outputText value="A-Calcul"/></f:facet>
                                        <h:inputText value="#{plan.salvarValeurColA}" rendered="#{plan.salvarVariableA}" style="width:90%;text-align:right;" onkeypress="return scanToucheChiffre(event)" onblur="if(this.value=='')value=0;"/>
                                    </rich:column>
                                    <rich:column width="10%" sortable="false" style="text-align:right;">
                                        <f:facet name="header"><h:outputText value="B-Base"/></f:facet>
                                        <h:inputText value="#{plan.salvarValeurColB}" rendered="#{plan.salvarVariableB}" style="width:90%;text-align:right;" onkeypress="return scanToucheChiffre(event)" onblur="if(this.value=='')value=0;">
                                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                        </h:inputText>
                                    </rich:column>
                                    <rich:column width="10%" sortable="false" style="text-align:right;">
                                        <f:facet name="header"><h:outputText value="C-Taux"/></f:facet>
                                        <h:inputText value="#{plan.salvarValeurColC}" rendered="#{plan.salvarVariableC}" style="width:90%;text-align:right;" onkeypress="return scanToucheChiffre(event)" onblur="if(this.value=='')value=0;"/>
                                    </rich:column>
                                    <rich:column width="10%" sortable="false" style="text-align:right;">
                                        <f:facet name="header"><h:outputText value="D-Nb"/></f:facet>
                                        <h:inputText value="#{plan.salvarValeurColD}" rendered="#{plan.salvarVariableD}" style="width:90%;text-align:right;" onkeypress="return scanToucheChiffre(event)" onblur="if(this.value=='')value=0;"/>
                                    </rich:column>
                                    <rich:column width="10%" sortable="false" style="text-align:right;">
                                        <f:facet name="header"><h:outputText value="E-Résultat"/></f:facet>
                                        <h:inputText value="#{plan.salvarValeurColE}" rendered="#{plan.salvarVariableE}" style="width:90%;text-align:right;" onkeypress="return scanToucheChiffre(event)" onblur="if(this.value=='')value=0;">
                                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                        </h:inputText>
                                    </rich:column>
                                </rich:extendedDataTable>
                            </a4j:region>
                        </rich:tab>

                        <rich:tab name="elements" label="Elements salariés">
                            <a4j:support eventsQueue="maQueue" event="onlabelclick" reRender="idSitFam,idAnalytique,idPaiement,idEtat"/>
                            <jsp:include flush="true" page="/paye/SimulationCommun.jsp" />
                            <h:panelGrid columns="4" id="idSitFam" styleClass="fichefournisseur" columnClasses="clos15,clos35,clos15,clos35" width="100%" >
                                <h:column><h:outputText value="Genre:"/></h:column>
                                <h:column>
                                    <h:selectOneRadio id="idGenre" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.salariesElements.saleleGenre}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.var_action==3}" style="width:200px">
                                        <f:selectItem itemLabel="Femme" itemValue="0"/>
                                        <f:selectItem itemLabel="Homme" itemValue="1"/>
                                    </h:selectOneRadio>
                                </h:column>
                                <h:column></h:column>
                                <h:column></h:column>
                                <h:column><h:outputText value="Situation matrimoniale:"/></h:column>
                                <h:column>
                                    <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.salariesElements.saleleSitFamille}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.var_action==3}">
                                        <f:selectItem itemLabel="Célibataire" itemValue="0" />
                                        <f:selectItem itemLabel="Marié(e)" itemValue="1" />
                                        <f:selectItem itemLabel="Concubin(e)" itemValue="2" />
                                        <f:selectItem itemLabel="Pacsé(e)" itemValue="3" />
                                        <f:selectItem itemLabel="Divorcé(e)" itemValue="4" />
                                        <f:selectItem itemLabel="Veuf(ve)" itemValue="5" />
                                        <a4j:support eventsQueue="maQeueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.calculNbPartsSimulation}" reRender="idSitFam,idD1,idD2,idD3,idD4,idD5,idD6"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column><h:outputText id="idD1" value="Date (JJ/MM/AAAA)" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.salariesElements.saleleSitFamille>=1}"/></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.salariesElements.saleleSitFamille==0}"></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.salariesElements.saleleSitFamille==1}"><rich:calendar id="idD2"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.salariesElements.saleleDateMarie}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.var_action==3}"/></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.salariesElements.saleleSitFamille==2}"><rich:calendar id="idD3"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.salariesElements.saleleDateConcubinage}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.var_action==3}"/></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.salariesElements.saleleSitFamille==3}"><rich:calendar id="idD4"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.salariesElements.saleleDatePacs}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.var_action==3}"/></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.salariesElements.saleleSitFamille==4}"><rich:calendar id="idD5"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.salariesElements.saleleDateDivorce}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.var_action==3}"/></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.salariesElements.saleleSitFamille==5}"><rich:calendar id="idD6"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.salariesElements.saleleDateVeuf}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.var_action==3}"/></h:column>
                                <h:column><h:outputText value="Nb Enfants:"/></h:column>
                                <h:column>
                                    <h:inputText style="text-align:right;width:100px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.salariesElements.saleleNbEnfant}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.var_action==3}">
                                        <a4j:support eventsQueue="maQeueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.calculNbPartsSimulation}" reRender="idSitFam,idNbEnfant,idNbFemme,nbPartFiscal,idNbpartTrimf,idD1,idD2,idD3,idD4,idD5,idD6"/>
                                    </h:inputText>
                                </h:column>
                                <h:column><h:outputText value="Nb Parts:"/></h:column>
                                <h:column><h:inputText style="text-align:right;width:100px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.salariesElements.saleleNbPartFiscal}" id="nbPartFiscal" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.var_action==3}"/></h:column>
                                <h:column><h:outputText value="Nb Parts TRIMF:" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strcodepays=='0202'}"/></h:column>
                                <h:column><h:inputText style="text-align:right;width:100px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.salariesElements.saleleNbPartTrimf}" id="idNbpartTrimf" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.var_action==3}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strcodepays=='0202'}"/></h:column>
                                <h:column><h:outputText value="Nb Femmes:" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.salariesElements.saleleGenre==1}"/></h:column>
                                <h:column><h:inputText style="text-align:right;width:100px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.salariesElements.saleleNbFemme}" id="idNbFemme" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.var_action==3}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.salariesElements.saleleGenre==1}"/></h:column>
                            </h:panelGrid>
                            <br>
                            <h:panelGrid columns="4" id="idAnalytique" styleClass="fichefournisseur" columnClasses="clos15,clos35,clos15,clos35" width="100%" >
                                <h:column><h:outputText value="Clé 1 répartition:"/></h:column>
                                <h:column>
                                    <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.salariesElements.saleleCle1Anal}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.var_action==3}">
                                        <f:selectItem itemLabel="" itemValue="" />
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.mesClesItems}"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column><h:outputText value="Clé 2 répartition:"/></h:column>
                                <h:column>
                                    <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.salariesElements.saleleCle2Anal}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.var_action==3}">
                                        <f:selectItem itemLabel="" itemValue="" />
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.mesClesItems}"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column><h:outputText value="Activité:"/></h:column>
                                <h:column>
                                    <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.salariesElements.saleleCle2Anal}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.var_action==3}">
                                        <f:selectItem itemLabel="" itemValue="" />
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.mesActivitesItems}"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column><h:outputText value=""/></h:column>
                                <h:column><h:outputText value=""/></h:column>
                            </h:panelGrid>
                            <br>
                            <h:panelGrid width="100%" id="idPaiement" styleClass="fichefournisseur">
                                <h:panelGrid columns="4"  columnClasses="clos15,clos35,clos15,clos35" width="100%">
                                    <h:column><h:outputText value="Mode de paiement:"/></h:column>
                                    <h:column>
                                        <h:selectOneRadio value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.salariesElements.saleleModeReglement}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.var_action==3}">
                                            <f:selectItem itemLabel="Espèce" itemValue="0"/>
                                            <f:selectItem itemLabel="Cheque" itemValue="1"/>
                                            <f:selectItem itemLabel="Virement" itemValue="2"/>
                                            <f:selectItem itemLabel="Carte pré-payée" itemValue="3"/>
                                            <f:selectItem itemLabel="Micro-finance" itemValue="4"/>
                                            <f:selectItem itemLabel="Mobile" itemValue="5" itemDisabled="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.accesOrange}"/>
                                            <f:selectItem itemLabel="Autre" itemValue="9"/>
                                            <a4j:support eventsQueue="maQueue" event="onclick" reRender="panPaiement,idPaiement"/>
                                        </h:selectOneRadio>
                                    </h:column>
                                </h:panelGrid>
                                <h:panelGrid columns="8" id="panPaiement" width="100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.salariesElements.saleleModeReglement==2||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.salariesElements.saleleModeReglement==4}">
                                    <h:column><h:outputText value="Code banque:"/></h:column>
                                    <h:column><h:inputText size="4" maxlength="5" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.salariesElements.saleleNumBanque}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.var_action==3}"/></h:column>
                                    <h:column><h:outputText value="Code guichet:"/></h:column>
                                    <h:column><h:inputText size="4" maxlength="5" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.salariesElements.saleleGuichetBanque}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.var_action==3}"/></h:column>
                                    <h:column><h:outputText value="N° compte:"/></h:column>
                                    <h:column><h:inputText size="12" maxlength="20" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.salariesElements.saleleCompteBanque}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.var_action==3}"/></h:column>
                                    <h:column><h:outputText value="Clé Ctrl:"/></h:column>
                                    <h:column><h:inputText size="2" maxlength="2" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.salariesElements.saleleCleBanque}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.var_action==3}"/></h:column>
                                </h:panelGrid>
                                <h:panelGrid columns="4" columnClasses="clos15,clos35,clos15,clos35" width="100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.salariesElements.saleleModeReglement==2}">
                                    <h:column><h:outputText value="IBAN:"/></h:column>
                                    <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.salariesElements.saleleIban}" maxlength="34" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.var_action==3}"/></h:column>
                                    <h:column><h:outputText value="SWIFT:"/></h:column>
                                    <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.salariesElements.saleleSwift}" maxlength="20" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.var_action==3}"/></h:column>
                                </h:panelGrid>
                                <h:panelGrid columns="2" columnClasses="clos15,clos35,clos15,clos35" width="100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.salariesElements.saleleModeReglement==3}">
                                    <h:column><h:outputText value="Code banque:"/></h:column>
                                    <h:column><h:inputText size="4" maxlength="5" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.salariesElements.saleleNumBanque}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.var_action==3}"/></h:column>
                                    <h:column><h:outputText value="N° carte:"/></h:column>
                                    <h:column><h:inputText size="15" maxlength="20" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.salariesElements.saleleCompteBanque}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.var_action==3}"/></h:column>
                                </h:panelGrid>
                                <h:panelGrid columns="2"columnClasses="clos15,clos35,clos15,clos35"  width="100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.salariesElements.saleleModeReglement==4}">
                                    <h:column><h:outputText value="N° compte du membre:"/></h:column>
                                    <h:column><h:inputText size="15" maxlength="12" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.salariesElements.saleleComptMembre}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.var_action==3}"/></h:column>
                                </h:panelGrid>
                                <h:panelGrid columns="2" columnClasses="clos15,clos35,clos15,clos35" width="100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.salariesElements.saleleModeReglement==5}">
                                    <h:column><h:outputText value="N° téléphone mobile:"/></h:column>
                                    <h:column><h:inputText size="15" maxlength="12" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.salariesElements.saleleCompteBanque}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.var_action==3}"/></h:column>
                                </h:panelGrid>
                            </h:panelGrid>
                            <br>
                            <h:panelGrid columns="4" id="idEtat" styleClass="fichefournisseur" columnClasses="clos15,clos35,clos15,clos35" width="100%" >
                                <h:column><h:outputText value="Etat:"/></h:column>
                                <h:column>
                                    <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.salariesElements.saleleEtat}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.var_action==3}">
                                        <f:selectItem itemLabel="En cours" itemValue="0" />
                                        <f:selectItem itemLabel="En conges" itemValue="1" itemDisabled="true"/>
                                        <f:selectItem itemLabel="Licencié(e)" itemValue="2" />
                                        <f:selectItem itemLabel="Démissionné(e)" itemValue="3" />
                                        <f:selectItem itemLabel="Décédé(e)" itemValue="4" />
                                        <f:selectItem itemLabel="Retraité(e)" itemValue="5" />
                                        <f:selectItem itemLabel="Fin de contrat" itemValue="6" />
                                        <f:selectItem itemLabel="Arrêt ou Suspension" itemValue="7" />
                                        <f:selectItem itemLabel="BULLETIN GELE" itemValue="8" />
                                        <f:selectItem itemLabel="Départ négocié" itemValue="10" />
                                        <a4j:support eventsQueue="maQeueue" event="onchange" reRender="idEtat,idD11,idD12,idD13,idD14"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column></h:column>
                                <h:column></h:column>
                                <h:column><h:outputText id="idD11" value="Date de départ (JJ/MM/AAAA)" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.salariesElements.saleleEtat>=2&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.salariesElements.saleleEtat<=7}"/></h:column>
                                <h:column><rich:calendar id="idD12"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.salariesElements.saleleDateSortie}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.var_action==3}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.salariesElements.saleleEtat>=2&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.salariesElements.saleleEtat<=7}"/></h:column>
                                <h:column><h:outputText id="idD13" value="Motif" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.salariesElements.saleleEtat>=2&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.salariesElements.saleleEtat<=7}"/></h:column>
                                <h:column><h:inputText id="idD14" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.salariesElements.saleleMotifSortie}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.var_action==3}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.salariesElements.saleleEtat>=2&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.salariesElements.saleleEtat<=7}"/></h:column>
                            </h:panelGrid>
                        </rich:tab>

                        <rich:tab name="contrat" label="Contrat">
                            <h:panelGrid width="100%" id="idContrat" columns="4" columnClasses="clos15,clos35,clos15,clos35" styleClass="fichefournisseur">
                                <h:column><h:outputText value="Régime congés:"/></h:column>
                                <h:column><h:inputText style="text-align:right;width:100px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.salariesContrats.salconNbJourCp}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.var_action_contrat==3}"/>&nbsp;&nbsp;<h:outputText value="(Nb jours congés par mois)"/></h:column>
                                <h:column><h:outputText value="Nb jours travail:"/></h:column>
                                <h:column><h:inputText style="text-align:right;width:100px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.salariesContrats.salconNbJourTr}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.var_action_contrat==3}"/>&nbsp;&nbsp;<h:outputText value="(Nb jour de travail par mois)"/></h:column>
                                <h:column><h:outputText value="Véhicule:"/></h:column>
                                <h:column>
                                    <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.salariesContrats.salconVehicule}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.var_action_contrat==3}">
                                        <f:selectItem itemLabel="Sans véhicule" itemValue="0"/>
                                        <f:selectItem itemLabel="Véhicule personnel au forfait" itemValue="1"/>
                                        <f:selectItem itemLabel="Véhicule personnel au Km" itemValue="2"/>
                                        <f:selectItem itemLabel="Véhicule entreprise" itemValue="3"/>
                                        <a4j:support eventsQueue="maQueue" event="onchange" reRender="v0,v1,v2,v3,v4,v5,v6;v7"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column id="v0" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.salariesContrats.salconVehicule==0}"></h:column>
                                <h:column id="v1" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.salariesContrats.salconVehicule==0}"></h:column>
                                <h:column id="v3" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.salariesContrats.salconVehicule==1}"><h:outputText value="Montant remboursé au forfait:"/></h:column>
                                <h:column id="v4" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.salariesContrats.salconVehicule==2}"><h:outputText value="Montant remboursé au Km:"/></h:column>
                                <h:column id="v5" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.salariesContrats.salconVehicule==3}"><h:outputText value="Parc N°:"/></h:column>
                                <h:column id="v6" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.salariesContrats.salconVehicule==1||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.salariesContrats.salconVehicule==2}">
                                    <h:inputText style="width:100%;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.salariesContrats.salconRbmKms}" >
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                                <h:column id="v7" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.salariesContrats.salconVehicule==3}">
                                    <h:selectOneMenu id="idparc" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.salariesContrats.salconParc}" >
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.mesParcItems}" />
                                    </h:selectOneMenu>
                                </h:column>
                            </h:panelGrid>
                            <h:panelGrid columns="4" id="idConvention" styleClass="fichefournisseur" columnClasses="clos15,clos35,clos15,clos35" width="100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.salariesContrats.salconType=='01D'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.salariesContrats.salconType=='01I'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.salariesContrats.salconType=='02D'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.salariesContrats.salconType=='02I'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.salariesContrats.salconType=='03D'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.salariesContrats.salconType=='03I'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.salariesContrats.salconType=='04'}">
                                <h:column><h:outputText value="Niveau emploi:"/></h:column>
                                <h:column>
                                    <h:selectOneMenu id="idniveau" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.var_niveau}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.var_action==3}">
                                        <f:selectItem itemLabel="Sélectionnez Niveau emploi" itemValue="0" />
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.mesNiveauxEmploisItems}" />
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column><h:outputText value="Classement:"/></h:column>
                                <h:column>
                                    <h:selectOneMenu id="idclassement" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.var_classement}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.var_action==3}">
                                        <f:selectItem itemLabel="Sélectionnez Classement" itemValue="0" />
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.mesClassementsItems}" />
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column><h:outputText value="Centre Impôt:"/></h:column>
                                <h:column>
                                    <h:selectOneMenu id="idcentre" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.var_centre}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.var_action==3}">
                                        <f:selectItem itemLabel="Sélectionnez Centre impôt" itemValue="0" />
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.mesCentresImpotsItems}" />
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column></h:column>
                                <h:column></h:column>
                                <h:column><h:outputText value="Convention:"/></h:column>
                                <h:column>
                                    <h:selectOneMenu id="idconvention" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.var_convention}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.var_action==3}">
                                        <f:selectItem itemLabel="Sélectionnez Convention" itemValue="0" />
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.mesConventionsItems}" />
                                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.chargerGrille}" reRender="idgrille"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column><h:outputText value="Catégorie salariale:"/></h:column>
                                <h:column>
                                    <h:selectOneMenu id="idgrille" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.var_grille}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.var_action==3}">
                                        <f:selectItem itemLabel="Sélectionnez Grille" itemValue="0" />
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.mesGrillesItems}" />
                                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.calculGrilleSimulation}" reRender="idgrille,idContrat0,idContrat1"/>
                                    </h:selectOneMenu>
                                </h:column>
                            </h:panelGrid>
                            <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.salariesContrats.salconType=='05'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.salariesContrats.salconType=='11'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.salariesContrats.salconType=='13'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.salariesContrats.salconType=='14'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.salariesContrats.salconType=='15'}" var="ctr0">
                                <h:panelGrid id="idContrat0" styleClass="fichefournisseur"  width="100%">
                                    <h:panelGrid columns="4" styleClass="fichefournisseur" columnClasses="clos35d,clos15,clos35d,clos15" width="100%">
                                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.var_forfaitPrestataire}"><h:outputText value="Forfait:" style="text-align:right;"/></h:column>
                                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.var_forfaitPrestataire}">
                                            <h:inputText style="width:200px;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.salariesContrats.salconBase}" >
                                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                            </h:inputText>
                                        </h:column>
                                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.var_redement}"><h:outputText value="Prime Rendement:" style="text-align:right;"/></h:column>
                                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.var_redement}">
                                            <h:inputText style="width:200px;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.salariesContrats.salconPrimeRendement}" >
                                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                            </h:inputText>
                                        </h:column>
                                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.var_responsbilite}"><h:outputText value="Prime Responsabilité:" style="text-align:right;"/></h:column>
                                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.var_responsbilite}">
                                            <h:inputText style="width:200px;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.salariesContrats.salconPrimeResponsabilite}" >
                                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                            </h:inputText>
                                        </h:column>
                                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.var_fonction}"><h:outputText value="Prime Fonction:" style="text-align:right;"/></h:column>
                                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.var_fonction}">
                                            <h:inputText style="width:200px;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.salariesContrats.salconPrimeFonction}" >
                                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                            </h:inputText>
                                        </h:column>
                                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.var_deplacement}"><h:outputText value="Indemnité Déplacement:" style="text-align:right;"/></h:column>
                                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.var_deplacement}">
                                            <h:inputText style="width:200px;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.salariesContrats.salconIndemniteDeplacement}" >
                                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                            </h:inputText>
                                        </h:column>
                                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.var_kilometre}"><h:outputText value="Indemnité Kilométrique:" style="text-align:right;"/></h:column>
                                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.var_kilometre}">
                                            <h:inputText style="width:200px;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.salariesContrats.salconIndemniteKilometrique}" >
                                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                            </h:inputText>
                                        </h:column>
                                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.var_salissure}"><h:outputText value="Indemnité de salissure:" style="text-align:right;"/></h:column>
                                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.var_salissure}">
                                            <h:inputText style="width:200px;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.salariesContrats.salconIndemniteSalissure}" >
                                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                            </h:inputText>
                                        </h:column>
                                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.var_representation}"><h:outputText value="Indemnité de représentation:" style="text-align:right;"/></h:column>
                                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.var_representation}">
                                            <h:inputText style="width:200px;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.salariesContrats.salconIndemniteRepresentation}" >
                                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                            </h:inputText>
                                        </h:column>
                                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.var_diverse}"><h:outputText value="Indemnité diverse:" style="text-align:right;"/></h:column>
                                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.var_diverse}">
                                            <h:inputText style="width:200px;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.salariesContrats.salconIndemniteDiverse}" >
                                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                            </h:inputText>
                                        </h:column>
                                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.var_indemResons}"><h:outputText value="Indemnité de responsabilité:" style="text-align:right;"/></h:column>
                                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.var_indemResons}">
                                            <h:inputText style="width:200px;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.salariesContrats.salconIndemniteResponsabilite}" >
                                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                            </h:inputText>
                                        </h:column>
                                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.var_nourriture}"><h:outputText value="Indemnité de nurriture:" style="text-align:right;"/></h:column>
                                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.var_nourriture}">
                                            <h:inputText style="width:200px;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.salariesContrats.salconIndemniteNourriture}" >
                                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                            </h:inputText>
                                        </h:column>
                                    </h:panelGrid>
                                </h:panelGrid>
                            </c:if>
                            <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.salariesContrats.salconType=='01D'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.salariesContrats.salconType=='01I'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.salariesContrats.salconType=='02D'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.salariesContrats.salconType=='02I'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.salariesContrats.salconType=='03D'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.salariesContrats.salconType=='03I'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.salariesContrats.salconType=='04'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.salariesContrats.salconType=='12'}" var="ctr1">
                                <h:panelGrid id="idContrat1" styleClass="fichefournisseur"  width="100%">
                                    <h:panelGrid columns="4" styleClass="fichefournisseur" columnClasses="clos15,clos35,clos15,clos35" width="100%" >
                                        <h:column><h:outputText value="Base conventionnée:" style="text-align:right;"/></h:column>
                                        <h:column>
                                            <h:inputText style="width:200px;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.salariesContrats.salconBase}" disabled="true">
                                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                            </h:inputText>
                                        </h:column>
                                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.var_sursalaire}"><h:outputText value="Sursalaire:" style="text-align:right;"/></h:column>
                                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.var_sursalaire}">
                                            <h:inputText style="width:200px;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.salariesContrats.salconSursalaire}">
                                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                            </h:inputText>
                                        </h:column>
                                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.var_forfaitHeureSup}"><h:outputText value="Forfait heures sup.:" style="text-align:right;"/></h:column>
                                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.var_forfaitHeureSup}">
                                            <h:inputText style="width:200px;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.salariesContrats.salconForfaitSup}" >
                                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                            </h:inputText>
                                        </h:column>
                                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.var_outillage}"><h:outputText value="Prime outillage:" style="text-align:right;"/></h:column>
                                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.var_outillage}">
                                            <h:inputText style="width:200px;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.salariesContrats.salconPrimeOutillage}" >
                                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                            </h:inputText>
                                        </h:column>
                                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.var_astreinte}"><h:outputText value="Prime d'astreinte:" style="text-align:right;"/></h:column>
                                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.var_astreinte}">
                                            <h:inputText style="width:200px;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.salariesContrats.salconPrimeAstreinte}" >
                                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                            </h:inputText>
                                        </h:column>
                                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.var_redement}"><h:outputText value="Prime Rendement:" style="text-align:right;"/></h:column>
                                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.var_redement}">
                                            <h:inputText style="width:200px;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.salariesContrats.salconPrimeRendement}" >
                                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                            </h:inputText>
                                        </h:column>
                                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.var_responsbilite}"><h:outputText value="Prime Responsabilité:" style="text-align:right;"/></h:column>
                                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.var_responsbilite}">
                                            <h:inputText style="width:200px;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.salariesContrats.salconPrimeResponsabilite}" >
                                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                            </h:inputText>
                                        </h:column>
                                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.var_fonction}"><h:outputText value="Prime Fonction:" style="text-align:right;"/></h:column>
                                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.var_fonction}">
                                            <h:inputText style="width:200px;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.salariesContrats.salconPrimeFonction}" >
                                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                            </h:inputText>
                                        </h:column>
                                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.var_sujetion}"><h:outputText value="Prime Sujetion:" style="text-align:right;"/></h:column>
                                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.var_sujetion}">
                                            <h:inputText style="width:200px;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.salariesContrats.salconPrimeSujetion}" >
                                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                            </h:inputText>
                                        </h:column>
                                    </h:panelGrid>
                                    <h:panelGrid columns="4" styleClass="fichefournisseur" columnClasses="clos15,clos35,clos15,clos35" width="100%" >
                                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.var_caisse}"><h:outputText value="Indemnité Caisse:" style="text-align:right;"/></h:column>
                                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.var_caisse}">
                                            <h:inputText style="width:200px;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.salariesContrats.salconIndemniteCaisse}" >
                                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                            </h:inputText>
                                        </h:column>
                                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.var_transport}"><h:outputText value="Indemnité Transport:" style="text-align:right;"/></h:column>
                                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.var_transport}">
                                            <h:inputText style="width:200px;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.salariesContrats.salconIndemniteTransport}" >
                                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                            </h:inputText>
                                        </h:column>
                                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.var_logement}"><h:outputText value="Indemnité Logement:" style="text-align:right;"/></h:column>
                                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.var_logement}">
                                            <h:inputText style="width:200px;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.salariesContrats.salconIndemniteLogement}" >
                                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                            </h:inputText>
                                        </h:column>
                                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.var_deplacement}"><h:outputText value="Indemnité Déplacement:" style="text-align:right;"/></h:column>
                                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.var_deplacement}">
                                            <h:inputText style="width:200px;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.salariesContrats.salconIndemniteDeplacement}" >
                                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                            </h:inputText>
                                        </h:column>
                                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.var_kilometre}"><h:outputText value="Indemnité Kilométrique:" style="text-align:right;"/></h:column>
                                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.var_kilometre}">
                                            <h:inputText style="width:200px;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.salariesContrats.salconIndemniteKilometrique}" >
                                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                            </h:inputText>
                                        </h:column>
                                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.var_salissure}"><h:outputText value="Indemnité de salissure:" style="text-align:right;"/></h:column>
                                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.var_salissure}">
                                            <h:inputText style="width:200px;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.salariesContrats.salconIndemniteSalissure}" >
                                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                            </h:inputText>
                                        </h:column>
                                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.var_representation}"><h:outputText value="Indemnité de représentation:" style="text-align:right;"/></h:column>
                                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.var_representation}">
                                            <h:inputText style="width:200px;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.salariesContrats.salconIndemniteRepresentation}" >
                                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                            </h:inputText>
                                        </h:column>
                                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.var_diverse}"><h:outputText value="Indemnité diverse:" style="text-align:right;"/></h:column>
                                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.var_diverse}">
                                            <h:inputText style="width:200px;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.salariesContrats.salconIndemniteDiverse}" >
                                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                            </h:inputText>
                                        </h:column>
                                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.var_indemResons}"><h:outputText value="Indemnité de responsabilité:" style="text-align:right;"/></h:column>
                                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.var_indemResons}">
                                            <h:inputText style="width:200px;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.salariesContrats.salconIndemniteResponsabilite}" >
                                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                            </h:inputText>
                                        </h:column>
                                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.var_nourriture}"><h:outputText value="Indemnité de nourriture:" style="text-align:right;"/></h:column>
                                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.var_nourriture}">
                                            <h:inputText style="width:200px;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.salariesContrats.salconIndemniteNourriture}" >
                                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                            </h:inputText>
                                        </h:column>
                                    </h:panelGrid>
                                    <h:panelGrid columns="4" styleClass="fichefournisseur" columnClasses="clos15,clos35,clos15,clos35" width="100%" >
                                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.var_avn_logement}"><h:outputText value="Avt. nat. logement:" style="text-align:right;"/></h:column>
                                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.var_avn_logement}">
                                            <h:inputText style="width:200px;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.salariesContrats.salconAvnLogement}" >
                                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                            </h:inputText>
                                        </h:column>
                                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.var_avn_domesticite}"><h:outputText value="Avt. nat. Domesticité:" style="text-align:right;"/></h:column>
                                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.var_avn_domesticite}">
                                            <h:inputText style="width:200px;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.salariesContrats.salconAvnDomesticite}" >
                                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                            </h:inputText>
                                        </h:column>
                                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.var_avn_eau}"><h:outputText value="Avt. nat. Eau:" style="text-align:right;"/></h:column>
                                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.var_avn_eau}">
                                            <h:inputText style="width:200px;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.salariesContrats.salconAvnEau}" >
                                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                            </h:inputText>
                                        </h:column>
                                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.var_avn_electricite}"><h:outputText value="Avt. nat. Electricité:" style="text-align:right;"/></h:column>
                                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.var_avn_electricite}">
                                            <h:inputText style="width:200px;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.salariesContrats.salconAvnElectricite}" >
                                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                            </h:inputText>
                                        </h:column>
                                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.var_avn_nourriture}"><h:outputText value="Avt. nat. nourriture:" style="text-align:right;"/></h:column>
                                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.var_avn_nourriture}">
                                            <h:inputText style="width:200px;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.salariesContrats.salconAvnNourriture}" >
                                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                            </h:inputText>
                                        </h:column>
                                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.var_avn_vehicule}"><h:outputText value="Avt. nat. véhicule :" style="text-align:right;"/></h:column>
                                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.var_avn_vehicule}">
                                            <h:inputText style="width:200px;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.salariesContrats.salconAvnVehicule}" >
                                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                            </h:inputText>
                                        </h:column>
                                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.var_avn_telephone}"><h:outputText value="Avt. nat. Téléphone:" style="text-align:right;"/></h:column>
                                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.var_avn_telephone}">
                                            <h:inputText style="width:200px;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.salariesContrats.salconAvnTelephone}" >
                                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                            </h:inputText>
                                        </h:column>
                                    </h:panelGrid>
                                </h:panelGrid>
                            </c:if>
                        </rich:tab>    

                    </rich:tabPanel>

                    <h:panelGroup>
                        <br>
                        <center>
                            <a4j:commandButton id="idValVariable" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.saveVariables}" reRender="panelVariable,idEffectue"/>
                            <rich:hotKey key="return"  handler="#{rich:element('idValVariable')}.click()" />
                        </center>
                    </h:panelGroup>

                </h:panelGrid>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"  id="panelImpBulletin" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="650" height="350" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.showModalPanelPrintBulletin}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.showModalPanelPrintBulletin}" var="prtbul">
            <f:facet name="header"><h:outputText value="Impression" style="color:white;"/></f:facet>
            <f:facet name="controls">
                <a4j:form>
                    <h:commandButton id="idCanPrintBulletin" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.closeImpression}" image="/images/close.gif" styleClass="hidelink"/>
                    <rich:hotKey key="esc" handler="#{rich:element('idCanPrintBulletin')}.click()" />
                </a4j:form>
            </f:facet>
            <center>
                <a4j:form id="formModalImp" target="_blank">
                    <center>
                        <h:outputText value="Choisissez un format d'Impression"  style="color:green;"/>
                        <br><br>
                    </center>
                    <h:panelGrid  width="100%">
                        <h:panelGrid  width="100%" style="border:solid 1px green;background-color:white;">
                            <f:facet name="header"><h:outputText value="Format"/></f:facet>
                            <br>
                            <h:panelGrid  width="100%" columns="9" style="height:80px">
                                <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.utilPrint.imprimanteReseau}">
                                    <center>
                                        <h:commandButton image="/images/imp_print.png" onmouseover="this.src='images/imp_print_big.png'" onmouseout="this.src='images/imp_print.png'" value="PRT" title="Impression directe (Imprimantes du serveur)" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.imprimerPRT}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.localApplication&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.menupaye.imp}"/>
                                        <h:selectOneMenu id="impSelect1" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.utilPrint.monImprimante}">
                                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.utilPrint.mesImprimantesServeurItems}"/>
                                        </h:selectOneMenu>
                                    </center>
                                </h:panelGroup>
                                <h:commandButton image="/images/imp_apercu.png" onmouseover="this.src='images/imp_apercu_big.png'" onmouseout="this.src='images/imp_apercu.png'" value="JRV" title="Aperçu avant impression" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.imprimerBulletinJRV}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');"/>
                                <h:commandButton image="/images/imp_reader.png" onmouseover="this.src='images/imp_reader_big.png'" onmouseout="this.src='images/imp_reader.png'" value="PDF" title="Format PDF" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.imprimerBulletinPDF}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.menupaye.imp}"/>
                                <h:commandButton image="/images/imp_openOffice.png" onmouseover="this.src='images/imp_openOffice_big.png'" onmouseout="this.src='images/imp_openOffice.png'" value="ODT" title="Format OpenOffice" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.imprimerBulletinODT}"onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.menupaye.imp}"/>
                                <h:commandButton image="/images/imp_excel.png" onmouseover="this.src='images/imp_excel_big.png'" onmouseout="this.src='images/imp_excel.png'" value="XLS" title="Tableur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.imprimerBulletinXLS}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.menupaye.imp}"/>
                                <h:commandButton image="/images/imp_word.png" onmouseover="this.src='images/imp_word_big.png'" onmouseout="this.src='images/imp_word.png'" value="DOC" title="Traitement de texte" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.imprimerBulletinDOC}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.menupaye.imp}"/>
                                <h:commandButton image="/images/imp_html.png" onmouseover="this.src='images/imp_html_big.png'" onmouseout="this.src='images/imp_html.png'" value="HTML" title="Export HTML" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.imprimerBulletinHTML}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.menupaye.imp}"/>
                                <h:commandButton image="/images/imp_xml.png" onmouseover="this.src='images/imp_xml_big.png'" onmouseout="this.src='images/imp_xml.png'" value="XML" title="Export XML" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.imprimerBulletinXML}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.menupaye.imp}"/>
                                <a4j:commandButton image="/images/imp_mail.png" onmouseover="this.src='images/imp_mail_big.png'" onmouseout="this.src='images/imp_mail.png'" value="MAIL" title="Envoie MAIL" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.envoieBulletinMAIL}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.menupaye.imp}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="formModalImp,modAttente,panelMail"/>
                            </h:panelGrid>
                        </h:panelGrid>
                        <br>
                        <h:panelGrid  width="100%"  id="panelMail" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.affMail}">
                            <h:panelGrid  width="100%"  style="border:solid 1px green;background-color:white;" columns="2" columnClasses="clos20,clos80">
                                <h:column></h:column>
                                <h:column></h:column>
                                <h:column><h:outputText value="Emetteur:" style="text-decoration:underline;"/></h:column>
                                <h:column>
                                    <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.impEmetteur}" >
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.utilPrint.lesbalEmetteursItems}"/>
                                    </h:selectOneMenu >
                                </h:column>
                                <h:column><h:outputText value="Destinataire:" style="text-decoration:underline;"/></h:column>
                                <h:column>
                                    <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.impDestinataire}" >
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.utilPrint.lesbalDestinatairesItems}"/>
                                        <f:selectItem itemLabel="" itemValue="" />
                                    </h:selectOneMenu >
                                </h:column>
                                <h:column></h:column>
                                <h:column></h:column>
                                <h:column><h:outputText value="Copie à (CC):"/></h:column>
                                <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.impDestinataireCC}"/></h:column>
                                <h:column><h:outputText value="Copie cachée (CCI):"/></h:column>
                                <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.impDestinataireCCI}"/></h:column>
                            </h:panelGrid>
                            <h:panelGrid  width="100%" style="text-align:center;">
                                <h:commandButton image="/images/mail_envoie.png" title="Envoyer mail" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.imprimerMAIL}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.affMail}" id="print" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                            </h:panelGrid>
                        </h:panelGrid>
                    </h:panelGrid>
                </a4j:form>
            </center>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"   headerClass="headerPanel" id="panelBarProg" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="700" height="80" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.var_showBarProg}">
        <f:facet name="header"><h:outputText value="Traitement en cours..."/></f:facet>
        <center>
            <a4j:form >
                <br>
                <a4j:outputPanel id="progressPanel">
                    <rich:progressBar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.var_currentValue}" style="width:90%" interval="300" enabled="true" minValue="-1" maxValue="100" id="barprg">
                        <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.var_info} (#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.var_currentValue} %)"/>
                    </rich:progressBar>
                </a4j:outputPanel>
            </a4j:form>
        </center>
    </rich:modalPanel>

</f:subview>
