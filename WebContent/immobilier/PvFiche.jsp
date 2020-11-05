<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>

<f:subview id="pvfiche">

    <a4j:form>
        <rich:hotKey key="return" handler="return false;"/>

        <center><h2><h:outputText value="GESTION D'UNE PREPARATION DE PV" style="color:green;"/></h2></center>

        <h:panelGrid width="100%">

            <rich:tabPanel switchType="client" immediate="true" id="panelGlobal" style="border:0px;background-color:white;">

                <rich:tab id="tabDoc" label="Description" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formPvImmobilier.var_acc_document}">
                    <h:panelGrid width="100%" columns="4" columnClasses="clos12d,clos55g,clos12d,clos21g" id="idPanGlob">
                        <h:column><h:outputText value="Sélection Date:"/></h:column>
                        <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formPvImmobilier.var_date}" inputSize="8"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formPvImmobilier.var_action==3}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrDateVte==0}"/></h:column>
                        <h:column><h:outputText value="Sélection Série:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:100%" id="idSerie" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formPvImmobilier.var_serie}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formPvImmobilier.var_action==3}">
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formPvImmobilier.mesSerieUserItem}"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Sélection Bien:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:100%" id="idBien" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formPvImmobilier.var_idImmeuble}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formPvImmobilier.var_action==3}">
                                <f:selectItem itemLabel="Sélection bien" itemValue="0"/>
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formPvImmobilier.mesBiensItems}"/>
                            </h:selectOneMenu>
                        </h:column>
                    </h:panelGrid>
                </rich:tab>

            </rich:tabPanel>

        </h:panelGrid>
        <br/>  <br/>
        <center>
            <h:panelGroup id="valideFacture">
                <br><br>
                <a4j:commandButton image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formPvImmobilier.annulerPv}" reRender="idSubView"/>&nbsp;&nbsp;
                <a4j:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formPvImmobilier.savePv}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formPvImmobilier.var_action!=21}"/>
            </h:panelGroup>
        </center>
    </a4j:form>

</f:subview>
