<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="fichetemps1">

    <a4j:form >

        <center> <h2><h:outputText value="FEUILLE DES TEMPS (#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPointage.salaries.patronyme} #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPointage.periode})" styleClass="titre"/></h2></center>

        <h:panelGrid id="panelGlobal" width="100%" >

            <h:panelGrid width="100%" columns="2" columnClasses="clos20,clos80">
                <h:column><h:outputText value="Jour:" style="text-decoration:underline;"/></h:column>
                <h:column>
                    <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPointage.jour}" style="width:150px;" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPointage.var_action>=3}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPointage.var_action>=3}">
                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPointage.lesjoursItems}"/>
                    </h:selectOneMenu>
                </h:column>
                <h:column><h:outputText value="Nom client:" style="text-decoration:underline;width:100%"/></h:column>
                <h:column>
                    <h:inputText style="width:100%" id="idTiers" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPointage.salariesPointage.salpoiNomTiers}" maxlength="100" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPointage.var_action>=3}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPointage.var_action>=3}">
                        <rich:toolTip followMouse="true" direction="top-right" showDelay="1000" value="chaine = Recherche qui commence... / *chaine = Recherche qui contient... / * = Recherche tous les clients (puis tabuler)" style="background-color:#FFF8D4;"/>
                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPointage.rechercheTiers}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView,panelListeTiers,formModalListeTiers,tabDoc,idResponsable,idTiers,panelPage,idSerie,idDevise,panelDate,idpanel1,panelTiers,panelTiersInformations,panelContact,panelValide,panelBoutonLigne,panelLigne,idTiersDivers"/>
                    </h:inputText>
                </h:column>
                <h:column><h:outputText value="Mission:" style="text-decoration:underline;"/></h:column>
                <h:column>
                    <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPointage.salariesPointage.salpoiMission}" style="width:100%;" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPointage.var_action>=3}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPointage.var_action>=3}">
                        <f:selectItem itemLabel="Sélectionnez mission" itemValue=""/>
                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPointage.mesMissionsItems}"/>
                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPointage.calculeTache}" reRender="idTacheMission"/>
                    </h:selectOneMenu>
                </h:column>
                <h:column><h:outputText value="Tache:" style="text-decoration:underline;"/></h:column>
                <h:column>
                    <h:selectOneMenu id="idTacheMission" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPointage.tache}" style="width:100%;" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPointage.var_action>=3}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPointage.var_action>=3}">
                        <f:selectItem itemLabel="Sélectionnez tache" itemValue=""/>
                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPointage.mesTachesItems}"/>
                    </h:selectOneMenu>
                </h:column>
                <h:column><h:outputText value="Service:" style="text-decoration:underline;"/></h:column>
                <h:column>
                    <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPointage.salariesPointage.salpoiService}" style="width:100%;" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPointage.var_action>=3}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPointage.var_action>=3}">
                        <f:selectItem itemLabel="Sélectionnez service" itemValue=""/>
                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPointage.mesServiceItems}"/>
                    </h:selectOneMenu>
                </h:column>
                <h:column><h:outputText value="Activité:" style="text-decoration:underline;"/></h:column>
                <h:column>
                    <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPointage.salariesPointage.salpoiActivite}" style="width:100%;" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPointage.var_action>=3}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPointage.var_action>=3}">
                        <f:selectItem itemLabel="Sélectionnez activité" itemValue=""/>
                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPointage.mesActiviteItems}"/>
                    </h:selectOneMenu>
                </h:column>
                <h:column><h:outputText value="Nb d'heures:"/></h:column>
                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPointage.salariesPointage.salpoiDuree}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPointage.var_action>=3}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPointage.var_action>=3}"/></h:column>
                <h:column><h:outputText value="Observation:"/></h:column>
                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPointage.salariesPointage.salpoiObjet}"  style="width:100%" maxlength="100" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPointage.var_action>=3}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPointage.var_action>=3}"/></h:column>
            </h:panelGrid>

            <h:panelGroup id="panelValide">
                <center>
                    <h:commandButton image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPointage.annulerTemps}"/>&nbsp;&nbsp;
                    <h:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPointage.saveTemps}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPointage.var_action!=3}"/>
                </center>
            </h:panelGroup>
        </h:panelGrid>

    </a4j:form>

</f:subview>
