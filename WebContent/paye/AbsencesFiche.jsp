<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>


<f:subview id="fichesabs">

    <a4j:form>

        <center> <h2><h:outputText value="FICHE : #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.var_lib_cp}" style="color:green;"/></h2></center>

        <h:panelGrid id="idPanGlobal" width="100%">
            <h:panelGrid id="idRecherche" columns="4" columnClasses="clos15,clos35,clos15,clos35" width="100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.var_action==1}">
                <h:column><h:outputText value="Rechercher Agent:" style="text-decoration:underline;"/></h:column>
                <h:column>
                    <h:inputText id="idSalarie" style="width:200px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.nomSalarie}">
                        <rich:toolTip followMouse="true" direction="top-right" showDelay="1000" value="chaine = Recherche qui commence... / *chaine = Recherche qui contient... / * = Recherche tous les salariés (puis tabuler)" style="background-color:#FFF8D4;"/>
                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.rechercheSalarie}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView,tabPanelsalaries,FichSalarie,panelListeSalaries,formModalListeSalaries,idSalarie,idRecherche,panelValide,idPanGlobal"/>
                    </h:inputText>
                </h:column>
                <h:column></h:column>
                <h:column></h:column>
            </h:panelGrid>

            <h:panelGrid id="FichSalarie" width="100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.salaries.salId!=0}">
                <jsp:include flush="true" page="/paye/CongesPayesCommun.jsp" />
            </h:panelGrid>

            <h:panelGrid id="tabPanelsalaries" width="100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.salaries.salId!=0}">
                <h:panelGrid style="width:100%;" id="panConges">
                    <h:panelGrid columns="2" id="idAbsences" styleClass="fichefournisseur1" columnClasses="clos30,clos70" width="100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.var_nat_rec>=10&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.var_nat_rec<20}">
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.salariesAbsences.salcngNature==10}"><h:outputText value="Sélection type absence:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.salariesAbsences.salcngNature==10}">
                            <h:selectOneMenu style="width:200px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.salariesAbsences.salcngNature}">
                                <f:selectItem itemLabel="Absence payée" itemValue="11"/>
                                <f:selectItem itemLabel="Absence non payée" itemValue="12"/>
                                <f:selectItem itemLabel="Absence payée à déduire sur Congés" itemValue="13"/>
                                <f:selectItem itemLabel="Absence payée pour repos médical" itemValue="16"/>
                                <f:selectItem itemLabel="Absence payée pour visite médicale" itemValue="17"/>
                                <f:selectItem itemLabel="Demande rejetée" itemValue="19" />
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Contrat:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:200px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.salariesAbsences.salcngContrat}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.var_action_conges==3}">
                                <f:selectItems  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.lesContratsActifsItems}"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.salariesAbsences.salcngNature!=14&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.salariesAbsences.salcngNature!=15}"><h:outputText value="Date début (JJ/MM/AAAA):"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.salariesAbsences.salcngNature==14||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.salariesAbsences.salcngNature==15}"><h:outputText value="Absent(e) le (JJ/MM/AAAA):"/></h:column>
                        <h:column>
                            <rich:calendar enableManualInput="true" datePattern="dd/MM/yyyy" locale="fr" style=" background-color:white;"  inputSize="8" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.salariesAbsences.salcngDateDebut}" popup="true" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.var_action_absences==3}">
                                <a4j:support eventsQueue="maQueue" event="oninputblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.calculDureeAbsences}" reRender="idAbsences,idDuree"/>
                            </rich:calendar>&nbsp;&nbsp;&nbsp;
                            <h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.salariesAbsences.salcngAm}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.salariesAbsences.salcngNature!=14&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.salariesAbsences.salcngNature!=15}">
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.calculDureeAbsences}" reRender="idAbsences,idDuree"/>
                            </h:selectBooleanCheckbox>&nbsp;&nbsp;
                            <h:outputText value="Absent à partir du matin" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.salariesAbsences.salcngNature!=14&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.salariesAbsences.salcngNature!=15}"/>
                        </h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.salariesAbsences.salcngNature!=14&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.salariesAbsences.salcngNature!=15}"><h:outputText value="Date retour:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.salariesAbsences.salcngNature!=14&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.salariesAbsences.salcngNature!=15}">
                            <rich:calendar  enableManualInput="true" datePattern="dd/MM/yyyy" locale="fr" style=" background-color:white;"  inputSize="8" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.salariesAbsences.salcngDateFin}" popup="true" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.var_action_absences==3}">
                                <a4j:support eventsQueue="maQueue" event="oninputblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.calculDureeAbsences}" reRender="idAbsences,idDuree"/>
                            </rich:calendar>&nbsp;&nbsp;&nbsp;
                            <h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.salariesAbsences.salcngPm}">
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.calculDureeAbsences}" reRender="idAbsences,idDuree"/>
                            </h:selectBooleanCheckbox>&nbsp;&nbsp;
                            <h:outputText value="Absent jusqu'au soir"/>
                        </h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.salariesAbsences.salcngNature!=14&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.salariesAbsences.salcngNature!=15}"><h:outputText value="Durée:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.salariesAbsences.salcngNature!=14&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.salariesAbsences.salcngNature!=15}"><h:inputText id="idDuree"  style="width:100px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.salariesAbsences.salcngDuree}" disabled="true"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.salariesAbsences.salcngNature==14||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.salariesAbsences.salcngNature==15}"><h:outputText value="Nombre heures retard:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.salariesAbsences.salcngNature==14||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.salariesAbsences.salcngNature==15}"><h:inputText style="width:100px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.salariesAbsences.salcngNbHeure}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.var_action_absences==3}"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.salariesAbsences.salcngNature!=14&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.salariesAbsences.salcngNature!=15&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.salariesAbsences.salcngNature!=17}"><h:outputText value="Nombre jours exclus:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.salariesAbsences.salcngNature!=14&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.salariesAbsences.salcngNature!=15&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.salariesAbsences.salcngNature!=17}">
                            <h:inputText style="width:100px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.salariesAbsences.salcngNbJoursExclus}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.var_action_absences==3}"/>&nbsp;&nbsp;
                            <h:outputText value="(Dimanches et jours fériés)"/>
                        </h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.salariesAbsences.salcngNature!=17}"><h:outputText value="Motif/objet:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.salariesAbsences.salcngNature!=17}"><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.salariesAbsences.salcngObjet}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.var_action_absences==3}"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.salariesAbsences.salcngNature==17}"><h:outputText value="Cabinet médical:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.salariesAbsences.salcngNature==17}">
                            <h:selectOneMenu style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.salariesAbsences.salcngObjet}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.var_action_conges==3}">
                                <f:selectItems  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.lesOrganesMedicauxItems}"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Responsable:"/></h:column>
                        <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.salariesAbsences.salcngResponsable}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.var_action_absences==3}"/></h:column>
                    </h:panelGrid>
                </h:panelGrid>
            </h:panelGrid>

            <h:panelGroup id="panelValide">
                <center>
                    <h:commandButton image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.annulerAbsences}"/>&nbsp;&nbsp;
                    <h:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.saveAbsences}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.salaries.salId!=0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.var_action!=3}"/>
                </center>
            </h:panelGroup>
        </h:panelGrid>

    </a4j:form>

</f:subview>
