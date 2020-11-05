<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>


<h:panelGrid  id="lic3" border="0" width="100%" >

    <div style="text-align:center;">Si vous désirez des informations, remplissez le formulaire ci-aprés, en indiquant vos centres d'intéréts</div>

    <br>

    <center>
        <h:panelGrid id="idPanFormulaire" width="100%">

            <h:panelGrid width="100%" columns="2" columnClasses="clos50,clos50">
                <h:column>
                    <h:panelGrid columns="2" width="100%" headerClass="headerTab" columnClasses="clos30,clos70" style="border:1px solid white;">
                        <f:facet name="header"><h:outputText value="Identification"/></f:facet>
                        <h:column><h:outputText style="text-decoration:underline;" value="Forme juridique:"/></h:column>
                        <h:column>
                            <h:selectOneMenu id="idForme" style="border:1px solid red;width:95%"value="#{bakingbeanepegase.structurePot.strformejuridique}">
                                <f:selectItems value="#{bakingbeanepegase.mesFormesJuridiquesItems}" />
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Raison sociale:"/></h:column>
                        <h:column><h:inputText style="border:1px solid red;width:95%" onchange="javascript:this.value=this.value.toUpperCase();" id="Rsociale" value="#{bakingbeanepegase.structurePot.strraisonsociale}" maxlength="100"/></h:column>
                        <h:column><h:outputText value="Adresse:"/></h:column>
                        <h:column><h:inputText style="border:1px solid red;width:95%" id="Adresse" value="#{bakingbeanepegase.structurePot.stradresse}" maxlength="30" /></h:column>
                        <h:column><h:outputText value="Boite Postale:"/></h:column>
                        <h:column><h:inputText style="border:1px solid red;width:95%" id="Bpostale" value="#{bakingbeanepegase.structurePot.strbp}" maxlength="50"/></h:column>
                        <h:column><h:outputText value="Ville:"/></h:column>
                        <h:column><h:inputText style="border:1px solid red;width:95%" onchange="javascript:this.value=this.value.toUpperCase();" id="Ville" value="#{bakingbeanepegase.structurePot.strville}" maxlength="30"/></h:column>
                        <h:column><h:outputText value="Téléphone:"/></h:column>
                        <h:column> <h:inputText style="border:1px solid red;width:95%" id="Telephone" value="#{bakingbeanepegase.structurePot.strtel1}" maxlength="30"/></h:column>
                        <h:column><h:outputText style="text-decoration:underline;" value="Pays:"/></h:column>
                        <h:column>
                            <h:selectOneMenu id="idPays" style="border:1px solid red;width:95%" value="#{bakingbeanepegase.structurePot.strnompays}">
                                <f:selectItems  value="#{bakingbeanepegase.mesPaysItems}" />
                            </h:selectOneMenu>&nbsp;&nbsp;
                            <h:outputText style="font-size:11px;color:red;text-decoration:blink;" value="(Conditionne les normes fiscales et sociales)"/>
                        </h:column>
                        <h:column><h:outputText style="text-decoration:underline;" value="Devise:"/></h:column>
                        <h:column>
                            <h:selectOneMenu  id="idDevise" style="border:1px solid red;width:95%" value="#{bakingbeanepegase.structurePot.strdevise}">
                                <f:selectItems value="#{bakingbeanepegase.mesDevisesItems}" />
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText style="text-decoration:underline;" value="Langue:"/></h:column>
                        <h:column>
                            <h:selectOneMenu id="idlangue" style="border:1px solid red;width:95%"value="#{bakingbeanepegase.structurePot.strlangue}">
                                <f:selectItems value="#{bakingbeanepegase.mesLanguesItems}" />
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText style="text-decoration:underline;" value="Civilité contact:"/></h:column>
                        <h:column>
                            <h:selectOneMenu id="idcivilite" style="border:1px solid red;width:95%"value="#{bakingbeanepegase.structurePot.strcivilite}">
                                <f:selectItem itemLabel="Monsieur" itemValue="1" />
                                <f:selectItem itemLabel="Madame" itemValue="0" />
                                <f:selectItem itemLabel="Mademoiselle" itemValue="2" />
                            </h:selectOneMenu>
                        </h:column>
                        <h:column>
                            <h:outputText value="Nom contact:"/>&nbsp;
                            <h:outputText value="(*)" style="color:red"/>
                        </h:column>
                        <h:column>
                            <h:inputText style="border:1px solid red;width:95%" onchange="javascript:this.value=this.value.toUpperCase();" id="idcontact" value="#{bakingbeanepegase.structurePot.strcontact}" maxlength="100">
                                <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.verifDemande}" reRender="idPanFormulaire,idValider"/>
                            </h:inputText>
                        </h:column>
                        <h:column>
                            <h:outputText value="Mail contact:"/>&nbsp;
                            <h:outputText value="(*)" style="color:red"/>
                        </h:column>
                        <h:column>
                            <h:inputText style="border:1px solid red;width:95%" id="idmail" value="#{bakingbeanepegase.structurePot.strmail}" maxlength="30" >
                                 <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.verifDemande}" reRender="idPanFormulaire,idValider"/>
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Mobile contact:"/></h:column>
                        <h:column><h:inputText style="border:1px solid red;width:95%" id="idcel" value="#{bakingbeanepegase.structurePot.strcel1}" maxlength="50"/></h:column>
                        <h:column><h:outputText value=""/></h:column>
                        <h:column><h:outputText value="(*) les champs signalés sont obligatoires..." style="font-size:11px;color:red;text-decoration:blink;"/></h:column>
                    </h:panelGrid>
                </h:column>
                <h:column>
                    <h:panelGrid columns="2" cellspacing="3" width="100%" headerClass="headerTab" columnClasses="clos20,clos80" style="border:1px solid white;">
                        <f:facet name="header"><h:outputText value="Centres d'intérêt"/></f:facet>
                        <h:column><h:outputText value="Comptabilité:"/></h:column>
                        <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.structurePot.strmod1}"/></h:column>
                        <h:column><h:outputText value="Paye:"/></h:column>
                        <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.structurePot.strmod2}"/></h:column>
                        <h:column><h:outputText value="Achats:"/></h:column>
                        <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.structurePot.strmod3}"/></h:column>
                        <h:column><h:outputText value="Ventes:"/></h:column>
                        <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.structurePot.strmod4}"/></h:column>
                        <h:column><h:outputText value="Stocks:"/></h:column>
                        <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.structurePot.strmod5}"/></h:column>
                        <h:column><h:outputText value="Immobilier:"/></h:column>
                        <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.structurePot.strmod6}"/></h:column>
                        <h:column><h:outputText value="Trésorerie:"/></h:column>
                        <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.structurePot.strmod7}"/></h:column>
                        <h:column><h:outputText value="Parc:"/></h:column>
                        <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.structurePot.strmod8}"/></h:column>
                        <h:column><h:outputText value="Médical:"/></h:column>
                        <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.structurePot.strmod9}"/></h:column>
                        <h:column><h:outputText value="Observations:"/></h:column>
                        <h:column><h:inputTextarea style="border:1px solid white;" id="obs" value="#{bakingbeanepegase.structurePot.strobservations}" rows="7" cols="30"/></h:column>
                    </h:panelGrid>
                </h:column>
            </h:panelGrid>

            <br/>
            
                <h:panelGroup>
                    <center>
                        <h:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.envoieProspection}" id="idValider" rendered="#{bakingbeanepegase.validerDemande}"/>
                    </center>
                </h:panelGroup>
            

        </h:panelGrid>
    </center>

</h:panelGrid>


