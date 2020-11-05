<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<h:panelGrid  width="100%" id="labo">
    <h:panelGrid columns="2" columnClasses="clos15,clos85" width="100%">
        <h:column><h:outputText value="Forfait bilan:"/></h:column>
        <h:column>
            <h:selectOneMenu style="width:250px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.produits.proPecBilan}">
                <f:selectItem itemLabel="Pris en charge par le forfait" itemValue="0"/>
                <f:selectItem itemLabel="Hors forfait" itemValue="1"/>
            </h:selectOneMenu>
        </h:column>
        <h:column><h:outputText value="Affichage résultat:"/></h:column>
        <h:column>
            <h:selectOneMenu style="width:250px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.produitsLaboratoire.prolabAnonyme}">
                <f:selectItem itemLabel="Résultat nominatif" itemValue="0"/>
                <f:selectItem itemLabel="Résultat anomyme" itemValue="1"/>
            </h:selectOneMenu>
        </h:column>
        <h:column><h:outputText value="Gestion étiquette:"/></h:column>
        <h:column>
            <h:selectOneMenu style="width:250px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.produitsLaboratoire.prolabEtiquette}">
                <f:selectItem itemLabel="Sans étiquette pour résultat" itemValue="0"/>
                <f:selectItem itemLabel="Avec étiquette pour résultat" itemValue="1"/>
            </h:selectOneMenu>
        </h:column>
        <h:column><h:outputText value="Type résultat:"/></h:column>
        <h:column>
            <h:selectOneMenu style="width:250px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.produitsLaboratoire.prolabType}">
                <f:selectItem itemLabel="Sélectionnez  un type" itemValue="0"/>
                <f:selectItem itemLabel="Numérique" itemValue="1"/>
                <f:selectItem itemLabel="Numérique + (Négatif ou Positif)" itemValue="11"/>
                <f:selectItem itemLabel="Date" itemValue="2"/>
                <f:selectItem itemLabel="Image/Rapport PDF" itemValue="3"/>
                <f:selectItem itemLabel="Texte long" itemValue="4"/>
                <f:selectItem itemLabel="Texte court" itemValue="9"/>
                <f:selectItem itemLabel="Texte court + (Négatif ou Positif)" itemValue="10"/>
                <f:selectItem itemLabel="Réponse unique" itemValue="5"/>
                <f:selectItem itemLabel="Réponse multiple" itemValue="7"/>
                <f:selectItem itemLabel="Sélection examen" itemValue="6"/>
                <f:selectItem itemLabel="Détail examens" itemValue="8"/>
                <a4j:support eventsQueue="maQueue" event="onchange" reRender="labo,numerique1,numerique2,reponse1,reponse2,detailExamen,idCat1,idCat2"/>
            </h:selectOneMenu>
        </h:column>
        <h:column id="idCat1" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.produitsLaboratoire.prolabType!=8}"><h:outputText value="Catégorie:"/></h:column>
        <h:column id="idCat2" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.produitsLaboratoire.prolabType!=8}">
            <h:selectOneMenu id="idcategorie" style="width:250px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.produitsLaboratoire.prolabCategorie}">
                <f:selectItem itemLabel="Sans catégorie" itemValue=""/>
                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.mesCategoriesExamensItems}"/>
            </h:selectOneMenu>
        </h:column>
        <h:column><h:outputText value="Technique utilisée:"/></h:column>
        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.produitsLaboratoire.prolabTechnique}" style="width:100%"/></h:column>
        <h:column><h:outputText value="Normes statiques:"/></h:column>
        <h:column><h:inputTextarea rows="5" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.produitsLaboratoire.prolabNorme}" style="width:100%"/></h:column>
        <h:column><h:outputText value="Interprétations (texte):"/></h:column>
        <h:column><h:inputTextarea rows="5" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.produitsLaboratoire.prolabInterpretaionTexte}" style="width:100%"/></h:column>
        <h:column><h:outputText value="Interprétations (image):"/></h:column>
        <h:column>
            <h:panelGrid id="panInterpretation1" columns="2" style="height:150px" width="100%">
                <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.produitsLaboratoire.prolabInterpretation==null}">
                    <t:inputFileUpload id="file1" storage="file" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.uploadedFile}" accept="image/*"/>
                    <h:commandButton  styleClass="exp_lienmenu"value="Sauvegarder" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.ajoutInterpretation1}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.var_action==3}">
                        <a4j:support eventsQueue="maQueue" immediate="true" reRender="grpI1"/>
                    </h:commandButton>
                    <h:message for="file" infoStyle="color: green;" errorStyle="color: red;" />
                </h:panelGroup>
                <br/>
                <h:panelGroup  id="grpI1" style="width:90px;height:90px;" >
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.produitsLaboratoire.prolabInterpretation!=null}">
                        <img alt="photoInterpretation" src="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.urlIpProd}/epegase/imageServlet/${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.urlphotoInterpretation1}" width="600px" height="100px"/>&nbsp;
                        <h:commandButton image="/images/annuler.gif"title="supprimer Interpretation" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.reInitInterpretation1}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.var_action==3}"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.produitsLaboratoire.prolabInterpretation==null}">
                        <img alt="photoInterpretation" src="images/no_image.jpeg" width="100px" height="100px" />
                    </c:if>
                </h:panelGroup>
            </h:panelGrid>
        </h:column>
        <h:column><h:outputText value="Conclusion:"/></h:column>
        <h:column>
            <h:selectOneMenu style="width:250px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.produitsLaboratoire.prolabConclusion}">
                <f:selectItem itemLabel="Conclusion libre" itemValue="0"/>
                <f:selectItem itemLabel="Conclusion pré-définie" itemValue="1"/>
                <a4j:support eventsQueue="maQueue" event="onchange" reRender="labo"/>
            </h:selectOneMenu>
        </h:column>
    </h:panelGrid>

    <h:panelGrid width="100%" columns="2" columnClasses="clos15,clos85" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.produitsLaboratoire.prolabConclusion==1}">
        <h:column><h:outputText value="Pré-définition"/></h:column>
        <h:inputTextarea rows="8" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.produitsLaboratoire.prolabConclusionDef}">
        </h:inputTextarea>
    </h:panelGrid>

    <h:panelGrid id="numerique1" columns="2" columnClasses="clos15,clos85" width="100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.produitsLaboratoire.prolabType==1}">
        <h:column><h:outputText value="Unité:"/></h:column>
        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.produitsLaboratoire.prolabUnite}" maxlength="20"/></h:column>
        <h:column><h:outputText value="Conversion:"/></h:column>
        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.produitsLaboratoire.prolabCoef}"/></h:column>
        <h:column><h:outputText value="Unité convertie:"/></h:column>
        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.produitsLaboratoire.prolabUniteConv}" maxlength="20"/></h:column>
        <h:column><h:outputText value="Fourchette (texte):"/></h:column>
        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.produitsLaboratoire.prolabFourchette}" maxlength="100"/></h:column>
    </h:panelGrid>

    <h:panelGrid id="numerique2" width="100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.produitsLaboratoire.prolabType==1}">
        <center>
            <h:panelGrid id="panelBoutonFourchette" columns="3" width="150px">
                <a4j:commandButton title="Ajouter fourchette" image="/images/ajouter.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.ajouterFourchette}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.var_ajt}"  oncomplete="javascript:Richfaces.showModalPanel('panelFourchette');" reRender="panelFourchette"/>
                <a4j:commandButton title="Modifier fourchette" image="/images/modifier.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.modifierFourchette}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.afficheButtFourchette&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.var_mod}"  oncomplete="javascript:Richfaces.showModalPanel('panelFourchette');" reRender="panelFourchette"/>
                <a4j:commandButton title="Supprimer fourchette" image="/images/supprimer.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.supprimerFourchette}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.afficheButtFourchette&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.var_sup}"  onclick="if (!confirm('Etes-vous sur de vouloir supprimer cet élément?')) return false"  reRender="tableauFourchette,panelBoutonFourchette"/>
            </h:panelGrid>
        </center>
        <a4j:region renderRegionOnly="false">
            <rich:extendedDataTable width="100%" style="border:solid 0px green;" border="0"  height="250px" id="tableauFourchette" footerClass="bard" activeClass="active-row" noDataLabel=" " headerClass="headerTab" rowClasses="rows1,rows2,rowsd"  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.datamodelFourchette}" var="four">
                <a4j:support eventsQueue="maQueue" event="onRowClick" reRender="panelBoutonFourchette"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.selectionFourchette}"/>
                <rich:column sortable="false" sortBy="#{four.var_sexe}" width="10%" sortOrder="ASCENDING">
                    <f:facet name="header" ><h:outputText  value="Type Sexe"/></f:facet>
                    <h:outputText value="#{four.var_sexe}"/>
                </rich:column>
                <rich:column sortable="false" sortBy="#{four.var_age}" width="10%">
                    <f:facet name="header" ><h:outputText  value="Type Age"/></f:facet>
                    <h:outputText value="#{four.var_age}"/>
                </rich:column>
                <rich:column sortable="false" width="10%" style="text-align:right;">
                    <f:facet name="header" ><h:outputText  value="Age Début"/></f:facet>
                    <h:outputText value="#{four.profchAgeDebut}" rendered="#{four.profchAge!=0}"/>
                </rich:column>
                <rich:column sortable="false" width="10%" style="text-align:right;">
                    <f:facet name="header" ><h:outputText  value="Age Fin"/></f:facet>
                    <h:outputText value="#{four.profchAgeFin}" rendered="#{four.profchAge!=0}"/>
                </rich:column>
                <rich:column sortable="false" width="10%" style="text-align:right;">
                    <f:facet name="header" ><h:outputText  value="Mini."/></f:facet>
                    <h:outputText value="#{four.profchFmini}"/>
                </rich:column>
                <rich:column sortable="false" width="10%" style="text-align:right;">
                    <f:facet name="header" ><h:outputText  value="Maxi."/></f:facet>
                    <h:outputText value="#{four.profchFmaxi}" />
                </rich:column>
                <rich:column sortable="false" width="40%">
                    <f:facet name="header" ><h:outputText  value="Normes"/></f:facet>
                    <h:outputText value="#{four.profchNorme}"/>
                </rich:column>
            </rich:extendedDataTable>
        </a4j:region>
    </h:panelGrid>

    <h:panelGrid id="reponse1" width="100%" rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.produitsLaboratoire.prolabType==5||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.produitsLaboratoire.prolabType==7)}">
        <center>
            <h:panelGrid id="panelBoutonReponse" columns="3" width="150px">
                <a4j:commandButton title="Ajouter réponse" image="/images/ajouter.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.ajouterReponse}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.var_ajt}"  oncomplete="javascript:Richfaces.showModalPanel('panelReponse');" reRender="panelReponse"/>
                <a4j:commandButton title="Modifier réponse" image="/images/modifier.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.modifierReponse}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.afficheButtReponse&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.var_mod}"  oncomplete="javascript:Richfaces.showModalPanel('panelReponse');" reRender="panelReponse"/>
                <a4j:commandButton title="Supprimer réponse" image="/images/supprimer.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.supprimerReponse}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.afficheButtReponse&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.var_sup}"  onclick="if (!confirm('Etes-vous sur de vouloir supprimer cet élément?')) return false"  reRender="tableauReponse,panelBoutonReponse"/>
            </h:panelGrid>
        </center>
        <a4j:region renderRegionOnly="false">
            <rich:extendedDataTable width="100%" style="border:solid 0px green;" border="0"  height="250px" id="tableauReponse" footerClass="bard" activeClass="active-row" noDataLabel=" " headerClass="headerTab" rowClasses="rows1,rows2,rowsd" enableContextMenu="false" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.datamodelReponse}" var="rep">
                <a4j:support eventsQueue="maQueue" event="onRowClick" reRender="panelBoutonReponse"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.selectionReponse}"/>
                <rich:column sortable="false" width="10%" >
                    <f:facet name="header" ><h:outputText  value="Ordre"/></f:facet>
                    <h:outputText value="#{rep.prorepOrdre}"/>
                </rich:column>
                <rich:column style="height:20px;" width="5%" sortable="false">
                    <f:facet name="header"><h:outputText  value="Down" /></f:facet>
                    <h:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.descendreReponse}" image="/images/downarrow.png" rendered="#{((bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.datamodelReponse.rowIndex+1)<bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.datamodelReponse.rowCount)==true}" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                </rich:column>
                <rich:column style="height:20px;" width="5%" sortable="false" >
                    <f:facet name="header"><h:outputText value="Up"/></f:facet>
                    <h:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.monterReponse}" image="/images/uparrow.png" rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.datamodelReponse.rowIndex>=1)==true}" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                </rich:column>
                <rich:column sortable="false" width="80%">
                    <f:facet name="header" ><h:outputText  value="Réponse"/></f:facet>
                    <h:outputText value="#{rep.prorepReponse}"/>
                </rich:column>
            </rich:extendedDataTable>
        </a4j:region>
    </h:panelGrid>

    <h:panelGrid id="reponse2" width="100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.produitsLaboratoire.prolabType==6}">
        <center>
            <h:panelGrid id="panelBoutonExamenChaine" columns="2" width="100px">
                <a4j:commandButton title="Ajouter examen chainé" image="/images/ajouter.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.ajouterExamenChaine}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.var_ajt}"  oncomplete="javascript:Richfaces.showModalPanel('panelExamenChaine');" reRender="panelExamenChaine"/>
                <a4j:commandButton title="Supprimer examen chainé" image="/images/supprimer.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.supprimeExamenChaine}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.afficheButtReponse&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.var_sup}"  onclick="if (!confirm('Etes-vous sur de vouloir supprimer cet élément?')) return false"  reRender="tableauExamenChaine,panelBoutonExamneChaine"/>
            </h:panelGrid>
        </center>
        <a4j:region renderRegionOnly="false">
            <rich:extendedDataTable width="100%" style="border:solid 0px green;" border="0"  height="250px" id="tableauExamenChaine" footerClass="bard" activeClass="active-row" noDataLabel=" " headerClass="headerTab" rowClasses="rows1,rows2,rowsd" enableContextMenu="false" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.datamodelReponse}" var="rep">
                <a4j:support eventsQueue="maQueue" event="onRowClick" reRender="panelBoutonExamenChaine" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.selectionExamenChaine}"/>
                <rich:column sortable="false" width="10%" >
                    <f:facet name="header" ><h:outputText  value="Ordre"/></f:facet>
                    <h:outputText value="#{rep.prorepOrdre}"/>
                </rich:column>
                <rich:column style="height:20px;" width="5%" sortable="false">
                    <f:facet name="header"><h:outputText  value="Down" /></f:facet>
                    <h:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.descendreReponse}" image="/images/downarrow.png" rendered="#{((bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.datamodelReponse.rowIndex+1)<bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.datamodelReponse.rowCount)==true}" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                </rich:column>
                <rich:column style="height:20px;" width="5%" sortable="false" >
                    <f:facet name="header"><h:outputText value="Up"/></f:facet>
                    <h:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.monterReponse}" image="/images/uparrow.png" rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.datamodelReponse.rowIndex>=1)==true}" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                </rich:column>
                <rich:column sortable="false" width="10%">
                    <f:facet name="header" ><h:outputText  value="Code"/></f:facet>
                    <h:outputText value="#{rep.prorepCodeExamen}"/>
                </rich:column>
                <rich:column sortable="false" width="70%">
                    <f:facet name="header" ><h:outputText  value="Examen"/></f:facet>
                    <h:outputText value="#{rep.prorepLibelleExamen}"/>
                </rich:column>
            </rich:extendedDataTable>
        </a4j:region>
    </h:panelGrid>

    <h:panelGrid id="detailExamen" width="100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.produitsLaboratoire.prolabType==8}">
        <center>
            <h:panelGrid id="panelBoutonDetail" columns="3" width="150px">
                <a4j:commandButton title="Ajouter détail" image="/images/ajouter.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.ajouterDetail}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.var_ajt}"  oncomplete="javascript:Richfaces.showModalPanel('panelDetail');" reRender="panelDetail"/>
                <a4j:commandButton title="Modifier détail" image="/images/modifier.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.modifierDetail}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.afficheButtDetail&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.var_mod}"  oncomplete="javascript:Richfaces.showModalPanel('panelDetail');" reRender="panelDetail"/>
                <a4j:commandButton title="Supprimer détail" image="/images/supprimer.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.supprimerDetail}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.afficheButtDetail&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.var_sup}"  onclick="if (!confirm('Etes-vous sur de vouloir supprimer cet élément?')) return false"  reRender="tableauDetail,panelBoutonDetail"/>
            </h:panelGrid>
        </center>
        <a4j:region renderRegionOnly="false">
            <rich:extendedDataTable width="100%" style="border:solid 0px green;" border="0"  height="250px" id="tableauDetail" footerClass="bard" activeClass="active-row" noDataLabel=" " headerClass="headerTab" rowClasses="rows1,rows2,rowsd" enableContextMenu="false" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.datamodelDetail}" var="det">
                <a4j:support eventsQueue="maQueue" event="onRowClick"  reRender="panelBoutonDetail"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.selectionDetail}"/>
                <rich:column sortable="false"  width="5%" >
                    <f:facet name="header" ><h:outputText  value="Ordre"/></f:facet>
                    <h:outputText value="#{det.prodetOrdre}"/>
                </rich:column>
                <rich:column style="height:20px;text-align:center" width="5%" sortable="false">
                    <f:facet name="header"><h:outputText  value="Down" /></f:facet>
                    <h:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.descendreDetail}" image="/images/downarrow.png" rendered="#{((bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.datamodelDetail.rowIndex+1)<bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.datamodelDetail.rowCount)==true}" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                </rich:column>
                <rich:column style="height:20px;text-align:center" width="5%" sortable="false" >
                    <f:facet name="header"><h:outputText  value="Up" /></f:facet>
                    <h:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.monterDetail}"  image="/images/uparrow.png" rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.datamodelDetail.rowIndex>=1)==true}" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                </rich:column>
                <rich:column sortable="false"  width="20%">
                    <f:facet name="header" ><h:outputText  value="Catégorie"/></f:facet>
                    <h:outputText value="#{det.prodetCategorie}"/>
                </rich:column>
                <rich:column sortable="false"  width="40%">
                    <f:facet name="header" ><h:outputText  value="Libellé"/></f:facet>
                    <h:outputText value="#{det.prodetLibelle}"/>
                </rich:column>
                <rich:column sortable="false"  width="15%">
                    <f:facet name="header" ><h:outputText  value="Type"/></f:facet>
                    <h:outputText value="#{det.var_lib_type}"/>
                </rich:column>
                <rich:column sortable="false"  width="10%">
                    <f:facet name="header" ><h:outputText  value="Unité"/></f:facet>
                    <h:outputText value="#{det.prodetUnite}"/>
                </rich:column>
            </rich:extendedDataTable>
        </a4j:region>
    </h:panelGrid>

</h:panelGrid>



