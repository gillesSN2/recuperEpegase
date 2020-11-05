<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="filiereseducation">

    <a4j:form>

        <center> <h2><h:outputText value="CLASSES/FILIERES DE L'EDUCATION" style="color:green;"/></h2></center>

        <center>
            <h:panelGrid id="panelBouton" columns="4" width="300px">
                <a4j:commandButton title="Ajouter une nouvelle filière" image="/images/ajouter.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFilieres.ajouterFiliere}" reRender="panelFiliere"/>
                <a4j:commandButton title="Modifier la filière sélectionnée" image="/images/modifier.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFilieres.modifierFiliere}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFilieres.visibiliteBton}" reRender="panelFiliere"/>
                <a4j:commandButton title="Supprimer la filière sélectionnée" image="/images/supprimer.png" onclick="if (!confirm('Etes vous sur de vouloir supprimer cet élément?')) return false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFilieres.supprimerFiliere}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFilieres.visibiliteBton}" reRender="table,panelBouton"/>
                <a4j:commandButton title="Imprimer les filières" image="/images/print.png" oncomplete="javascript:Richfaces.showModalPanel('panelImp');"/>
            </h:panelGrid>
        </center>
        <br>
        <center>
            <a4j:region renderRegionOnly="false">
                <rich:extendedDataTable id="table" headerClass="headerTab" enableContextMenu="false" activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" border="0" styleClass="bg" style="max-height:100%;border:solid 0px green;text-align:left;" width="100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFilieres.dataModelFilieres}" var="fil">
                    <a4j:support eventsQueue="maQueue"  event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFilieres.selectionFiliere}" reRender="panelBouton"/>
                    <rich:column label="Code" sortable="true" width="7%" sortBy="#{fil.filCode}">
                        <f:facet name="header"><h:outputText  value="Code"/></f:facet>
                        <h:outputText value="#{fil.filCode}" />
                    </rich:column>
                    <rich:column label="Libellé" sortable="true" width="13%" >
                        <f:facet name="header"><h:outputText  value="Libellé"/></f:facet>
                        <h:outputText value="#{fil.filLibelle}"/>
                    </rich:column>
                    <rich:column label="Type" sortable="true" width="10%">
                        <f:facet name="header"><h:outputText  value="Type"/></f:facet>
                        <h:outputText value="#{fil.libelleType}" />
                    </rich:column>
                    <rich:column label="Mode" sortable="true" width="10%">
                        <f:facet name="header"><h:outputText  value="Mode"/></f:facet>
                        <h:outputText value="#{fil.libelleMode}" />
                    </rich:column>
                    <rich:column label="Montant insciption" sortable="true" width="10%" style="text-align:right;">
                        <f:facet name="header"><h:outputText  value="Inscription"/></f:facet>
                        <h:outputText value="#{fil.filTarifInscription}">
                            <jsp:include flush="true" page="../../commun/formatNombreStructure.jsp"/>
                        </h:outputText>
                    </rich:column>
                    <rich:column label="Montant re-inscription" sortable="true" width="10%" style="text-align:right;">
                        <f:facet name="header"><h:outputText  value="Ré-inscription"/></f:facet>
                        <h:outputText value="#{fil.filTarifReinscription}">
                            <jsp:include flush="true" page="../../commun/formatNombreStructure.jsp"/>
                        </h:outputText>
                    </rich:column>
                    <rich:column label="Montant scolarité" sortable="true" width="10%" style="text-align:right;">
                        <f:facet name="header"><h:outputText  value="Scolarité"/></f:facet>
                        <h:outputText value="#{fil.filTarifScolarite}">
                            <jsp:include flush="true" page="../../commun/formatNombreStructure.jsp"/>
                        </h:outputText>
                    </rich:column>
                    <rich:column label="Montant tenue" sortable="true" width="10%" style="text-align:right;">
                        <f:facet name="header"><h:outputText  value="Tenue"/></f:facet>
                        <h:outputText value="#{fil.filTarifTenue}">
                            <jsp:include flush="true" page="../../commun/formatNombreStructure.jsp"/>
                        </h:outputText>
                    </rich:column>
                    <rich:column label="Montant cantine" sortable="true" width="10%" style="text-align:right;">
                        <f:facet name="header"><h:outputText  value="Cantine"/></f:facet>
                        <h:outputText value="#{fil.filTarifCantine}">
                            <jsp:include flush="true" page="../../commun/formatNombreStructure.jsp"/>
                        </h:outputText>
                    </rich:column>
                    <rich:column label="Montant examen" sortable="true" width="10%" style="text-align:right;">
                        <f:facet name="header"><h:outputText  value="Examen"/></f:facet>
                        <h:outputText value="#{fil.filTarifExamens}">
                            <jsp:include flush="true" page="../../commun/formatNombreStructure.jsp"/>
                        </h:outputText>
                    </rich:column>
                    <rich:column label="Montant association etudint" sortable="true" width="10%" style="text-align:right;">
                        <f:facet name="header"><h:outputText  value="Association"/></f:facet>
                        <h:outputText value="#{fil.filTarifAssociation}">
                            <jsp:include flush="true" page="../../commun/formatNombreStructure.jsp"/>
                        </h:outputText>
                    </rich:column>
                </rich:extendedDataTable>
            </a4j:region>
        </center>
        <br>
        <center>
            <h:commandButton id="idCancel" value="RETOUR"styleClass="exp_lienmenu" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.retourLigne}" />
            <rich:hotKey key="esc"  handler="#{rich:element('idCancel')}.click()" />
        </center>

    </a4j:form>


    <rich:modalPanel domElementAttachment="parent" id="panelFiliere" width="700" height="450" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFilieres.showModalPanel}" autosized="true">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFilieres.showModalPanel}" var="ajt">
            <f:facet name="header"><h:outputText value="GESTION D'UNE CLASSE/FILIERE"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFilieres.annuleSaisie}" image="/images/close.gif" styleClass="hidelink" id="hidelink" reRender="panelFiliere"/>
                </a4j:form>
            </f:facet>
            <a4j:form >
                <h:panelGrid  style="width:100%;" id="pngGlob">
                    <rich:tabPanel switchType="client" immediate="true" id="panelGlobal" style="border:0px;background-color:white;">

                        <rich:tab id="tabDoc" label="Description">
                            <h:panelGrid  columns="2" style="width:100%;" columnClasses="clos40,clos60g">
                                <h:column><h:outputText value="Type:"/></h:column>
                                <h:column>
                                    <h:selectOneMenu style="width:200px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFilieres.filieres.filType}">
                                        <f:selectItem itemLabel="Sélectionnez un type" itemValue="100"/>
                                        <f:selectItem itemLabel="Maternelle" itemValue="0"/>
                                        <f:selectItem itemLabel="Elémentaire" itemValue="1"/>
                                        <f:selectItem itemLabel="Collège" itemValue="2"/>
                                        <f:selectItem itemLabel="Lycée" itemValue="3"/>
                                        <f:selectItem itemLabel="Supérieur" itemValue="4"/>
                                        <f:selectItem itemLabel="Centre de formation" itemValue="5"/>
                                        <f:selectItem itemLabel="Cours du soir" itemValue="6"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column><h:outputText value="Code:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFilieres.filieres.filCode}" onkeypress="return scanToucheLettre(event)" style="width:100%;text-transform:uppercase"/></h:column>
                                <h:column><h:outputText value="Libellé:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFilieres.filieres.filLibelle}" onkeypress="return scanToucheLettre(event)" style="width:100%;text-transform:uppercase"/></h:column>
                                <h:column><h:outputText value="Mode:"/></h:column>
                                <h:column>
                                    <h:selectOneMenu style="width:200px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFilieres.filieres.filMode}">
                                        <f:selectItem itemLabel="Sélectionnez un mode de calcul" itemValue="100"/>
                                        <f:selectItem itemLabel="Appréciation" itemValue="0"/>
                                        <f:selectItem itemLabel="Moyenne" itemValue="1"/>
                                        <f:selectItem itemLabel="U.E." itemValue="2"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column><h:outputText value="Salle par défaut:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFilieres.filieres.filSalle}"/></h:column>
                                <h:column><h:outputText value="Période du:"/></h:column>
                                <h:column>
                                    <h:selectOneMenu style="width:200px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFilieres.filieres.filMoisDebut}">
                                        <f:selectItem itemLabel="Sélectionnez le mois de début" itemValue="00"/>
                                        <f:selectItem itemLabel="Janvier" itemValue="01"/>
                                        <f:selectItem itemLabel="Février" itemValue="02"/>
                                        <f:selectItem itemLabel="Mars" itemValue="03"/>
                                        <f:selectItem itemLabel="Avril" itemValue="04"/>
                                        <f:selectItem itemLabel="Mai" itemValue="05"/>
                                        <f:selectItem itemLabel="Juin" itemValue="06"/>
                                        <f:selectItem itemLabel="Juillet" itemValue="07"/>
                                        <f:selectItem itemLabel="Aout" itemValue="08"/>
                                        <f:selectItem itemLabel="Septembre" itemValue="09"/>
                                        <f:selectItem itemLabel="Octobre" itemValue="10"/>
                                        <f:selectItem itemLabel="Novembre" itemValue="11"/>
                                        <f:selectItem itemLabel="Décembre" itemValue="12"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column><h:outputText value="au:"/></h:column>
                                <h:column>
                                    <h:selectOneMenu style="width:200px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFilieres.filieres.filMoisFin}">
                                        <f:selectItem itemLabel="Sélectionnez le mois de fin" itemValue="00"/>
                                        <f:selectItem itemLabel="Janvier" itemValue="01"/>
                                        <f:selectItem itemLabel="Février" itemValue="02"/>
                                        <f:selectItem itemLabel="Mars" itemValue="03"/>
                                        <f:selectItem itemLabel="Avril" itemValue="04"/>
                                        <f:selectItem itemLabel="Mai" itemValue="05"/>
                                        <f:selectItem itemLabel="Juin" itemValue="06"/>
                                        <f:selectItem itemLabel="Juillet" itemValue="07"/>
                                        <f:selectItem itemLabel="Aout" itemValue="08"/>
                                        <f:selectItem itemLabel="Septembre" itemValue="09"/>
                                        <f:selectItem itemLabel="Octobre" itemValue="10"/>
                                        <f:selectItem itemLabel="Novembre" itemValue="11"/>
                                        <f:selectItem itemLabel="Décembre" itemValue="12"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column><h:outputText value="Nb mois annuel:"/></h:column>
                                <h:column>
                                    <h:selectOneMenu style="width:200px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFilieres.filieres.filnbMois}">
                                        <f:selectItem itemLabel="01" itemValue="1"/>
                                        <f:selectItem itemLabel="02" itemValue="2"/>
                                        <f:selectItem itemLabel="03" itemValue="3"/>
                                        <f:selectItem itemLabel="04" itemValue="4"/>
                                        <f:selectItem itemLabel="05" itemValue="5"/>
                                        <f:selectItem itemLabel="06" itemValue="6"/>
                                        <f:selectItem itemLabel="07" itemValue="7"/>
                                        <f:selectItem itemLabel="08" itemValue="8"/>
                                        <f:selectItem itemLabel="09" itemValue="9"/>
                                        <f:selectItem itemLabel="10" itemValue="10"/>
                                        <f:selectItem itemLabel="11" itemValue="11"/>
                                        <f:selectItem itemLabel="12" itemValue="12"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column><h:outputText value="Nb trimestre annuel:"/></h:column>
                                <h:column>
                                    <h:selectOneMenu style="width:200px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFilieres.filieres.filnbTrimestre}">
                                        <f:selectItem itemLabel="01" itemValue="1"/>
                                        <f:selectItem itemLabel="02" itemValue="2"/>
                                        <f:selectItem itemLabel="03" itemValue="3"/>
                                        <f:selectItem itemLabel="04" itemValue="4"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column><h:outputText value="Nb semestre annuel:"/></h:column>
                                <h:column>
                                    <h:selectOneMenu style="width:200px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFilieres.filieres.filnbSemestre}">
                                        <f:selectItem itemLabel="01" itemValue="1"/>
                                        <f:selectItem itemLabel="02" itemValue="2"/>
                                    </h:selectOneMenu>
                                </h:column>
                            </h:panelGrid>
                        </rich:tab>

                        <rich:tab id="tabInfo" label="Informations">
                            <rich:editor theme="advanced" plugins="safari,spellchecker,pagebreak,style,layer,table,save,advhr,advimage,advlink,iespell,inlinepopups,insertdatetime,preview,media,searchreplace,print,contextmenu,paste,directionality,fullscreen,noneditable,visualchars,nonbreaking,xhtmlxtras,template" viewMode="visual" style="width:100%;background:white;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFilieres.filieres.filDescription}">
                                <jsp:include flush="true" page="../../css/tdt.jsp"/>
                            </rich:editor>
                        </rich:tab>

                        <rich:tab id="tabTarif" label="Tarifs">
                            <h:panelGrid  columns="2" style="width:100%;" columnClasses="clos30,clos70d">
                                <h:column><h:outputText value="Frais dossier:"/></h:column>
                                <h:column>
                                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFilieres.filieres.filTarifDossier}" style="text-align:right;">
                                        <jsp:include flush="true" page="../../commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                                <h:column><h:outputText value="Frais inscription:"/></h:column>
                                <h:column>
                                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFilieres.filieres.filTarifInscription}" style="text-align:right;">
                                        <jsp:include flush="true" page="../../commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                                <h:column><h:outputText value="Frais ré-inscription:"/></h:column>
                                <h:column>
                                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFilieres.filieres.filTarifReinscription}" style="text-align:right;">
                                        <jsp:include flush="true" page="../../commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                                <h:column><h:outputText value="Frais scolarité (annuel):"/></h:column>
                                <h:column>
                                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFilieres.filieres.filTarifScolarite}" style="text-align:right;">
                                        <jsp:include flush="true" page="../../commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                                <h:column><h:outputText value="Frais transport (annuel):"/></h:column>
                                <h:column>
                                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFilieres.filieres.filTarifTransport}" style="text-align:right;">
                                        <jsp:include flush="true" page="../../commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                                <h:column><h:outputText value="Frais restauration/cantine (annuel):"/></h:column>
                                <h:column>
                                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFilieres.filieres.filTarifCantine}" style="text-align:right;">
                                        <jsp:include flush="true" page="../../commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                                <h:column><h:outputText value="Frais tenue:"/></h:column>
                                <h:column>
                                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFilieres.filieres.filTarifTenue}" style="text-align:right;">
                                        <jsp:include flush="true" page="../../commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                                <h:column><h:outputText value="Frais examens:"/></h:column>
                                <h:column>
                                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFilieres.filieres.filTarifExamens}" style="text-align:right;">
                                        <jsp:include flush="true" page="../../commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                                <h:column><h:outputText value="Frais association étudiante:"/></h:column>
                                <h:column>
                                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFilieres.filieres.filTarifAssociation}" style="text-align:right;">
                                        <jsp:include flush="true" page="../../commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                                <h:column><h:outputText value="Frais divers:"/></h:column>
                                <h:column>
                                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFilieres.filieres.filTarifDivers}" style="text-align:right;">
                                        <jsp:include flush="true" page="../../commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                            </h:panelGrid>
                        </rich:tab>

                        <rich:tab id="tabMatieres" label="Matières" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFilieres.filieres.filId!=0}">
                            <h:panelGrid width="200px" id="panelBoutonMatiere" columns="3">
                                <a4j:commandButton title="Ajouter une nouvelle matières" image="/images/ajouter.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFilieres.ajouterMatiere}" reRender="panelMatiere"/>
                                <a4j:commandButton title="Modifier la matière sélectionnée" image="/images/modifier.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFilieres.modifierMatiere}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFilieres.visibiliteBtonMatiere}" reRender="panelMatiere"/>
                                <a4j:commandButton title="Supprimer la matière sélectionnée" image="/images/supprimer.png" onclick="if (!confirm('Etes vous sur de vouloir supprimer cet élément?')) return false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFilieres.supprimerMatiere}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFilieres.visibiliteBtonMatiere}" reRender="tableMatiere,panelBoutonMatiere"/>
                            </h:panelGrid>
                            <a4j:region renderRegionOnly="false">
                                <rich:extendedDataTable id="tableMatiere" headerClass="headerTab" enableContextMenu="false" activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" border="0" styleClass="bg" style="border:solid 0px green;text-align:left;" height="300px" width="100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFilieres.dataModelMatieres}" var="mat">
                                    <a4j:support eventsQueue="maQueue"  event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFilieres.selectionMatiere}" reRender="panelBoutonMatiere"/>
                                    <rich:column label="Code" sortable="true" width="10%" sortBy="#{mat.filmatCode}">
                                        <f:facet name="header"><h:outputText  value="Code"/></f:facet>
                                        <h:outputText value="#{mat.filmatCode}" />
                                    </rich:column>
                                    <rich:column label="Libellé" sortable="true" width="30%" sortBy="#{mat.filmatLibelle}">
                                        <f:facet name="header"><h:outputText  value="Libellé"/></f:facet>
                                        <h:outputText value="#{mat.filmatLibelle}"/>
                                    </rich:column>
                                    <rich:column label="Mode" sortable="true" width="15%" sortBy="#{mat.libelleMode}">
                                        <f:facet name="header"><h:outputText  value="Mode"/></f:facet>
                                        <h:outputText value="#{mat.libelleMode}" />
                                    </rich:column>
                                    <rich:column label="Professeur" sortable="true" width="30%" sortBy="#{mat.filmatNomProfesseur}">
                                        <f:facet name="header"><h:outputText  value="Professeur"/></f:facet>
                                        <h:outputText value="#{mat.filmatNomProfesseur}"/>
                                    </rich:column>
                                    <rich:column label="Nb Heures annuel" sortable="true" width="10%" sortBy="#{mat.filmatNbHeures}" style="text-align:right">
                                        <f:facet name="header"><h:outputText  value="Nb Heures"/></f:facet>
                                        <h:outputText value="#{mat.filmatNbHeures}" style="text-align:right"/>
                                    </rich:column>
                                </rich:extendedDataTable>
                            </a4j:region>
                        </rich:tab>

                    </rich:tabPanel>
                </h:panelGrid>

                <h:panelGroup id="pngValide">
                    <center>
                        <br>
                        <a4j:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFilieres.saveFilieres}" reRender="panelFiliere,table,panelBouton"/>
                    </center>
                </h:panelGroup>

            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent" id="panelMatiere" width="700" height="450" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFilieres.showModalPanelMatiere}" autosized="true">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFilieres.showModalPanelMatiere}" var="ajtmat">
            <f:facet name="header"><h:outputText value="GESTION D'UNE MATIERE DANS LA CLASSE #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFilieres.filieres.filLibelle}"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFilieres.annulerMatiere}" image="/images/close.gif" styleClass="hidelink" id="hidelink" reRender="panelMatiere"/>
                </a4j:form>
            </f:facet>
            <a4j:form >
                <h:panelGrid  style="width:100%;" id="pngGlob">
                    <rich:tabPanel switchType="client" immediate="true" id="panelGlobal" style="border:0px;background-color:white;">

                        <rich:tab id="tabDoc" label="Description">
                            <h:panelGrid  columns="2" style="width:100%;" columnClasses="clos40,clos60g">
                                <h:column><h:outputText value="Mode:"/></h:column>
                                <h:column>
                                    <h:selectOneMenu style="width:200px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFilieres.filieresMatieres.filmatMode}" disabled="true">
                                        <f:selectItem itemLabel="Appréciation" itemValue="0"/>
                                        <f:selectItem itemLabel="Moyenne" itemValue="1"/>
                                        <f:selectItem itemLabel="U.E." itemValue="2"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column><h:outputText value="Code:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFilieres.filieresMatieres.filmatCode}" onkeypress="return scanToucheLettre(event)" style="width:100%;text-transform:uppercase"/></h:column>
                                <h:column><h:outputText value="Libellé:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFilieres.filieresMatieres.filmatLibelle}" onkeypress="return scanToucheLettre(event)" style="width:100%;text-transform:uppercase"/></h:column>
                                <h:column><h:outputText value="Professeur:"/></h:column>
                                <h:column>
                                    <h:selectOneMenu style="width:200px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFilieres.professeur}">
                                        <f:selectItem itemLabel="Sélectionnez le professeur" itemValue="0"/>
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFilieres.mesProfesseursItems}"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column><h:outputText value="Nombre d'heures:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFilieres.filieresMatieres.filmatNbHeures}"/></h:column>
                            </h:panelGrid>
                        </rich:tab>

                        <rich:tab id="tabInfo" label="Informations">
                            <rich:editor theme="advanced" plugins="safari,spellchecker,pagebreak,style,layer,table,save,advhr,advimage,advlink,iespell,inlinepopups,insertdatetime,preview,media,searchreplace,print,contextmenu,paste,directionality,fullscreen,noneditable,visualchars,nonbreaking,xhtmlxtras,template" viewMode="visual" style="width:100%;background:white;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFilieres.filieresMatieres.filmatDescription}">
                                <jsp:include flush="true" page="../../css/tdt.jsp"/>
                            </rich:editor>
                        </rich:tab>

                    </rich:tabPanel>
                </h:panelGrid>

                <h:panelGroup id="pngValideMatiere">
                    <center>
                        <br>
                        <a4j:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFilieres.validerMatiere}" reRender="panelMatiere,tableMatiere,panelBoutonMatiere"/>
                    </center>
                </h:panelGroup>

            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <!-- debut Modal panel pour impression -->
    <rich:modalPanel domElementAttachment="parent"   headerClass="headerPanel" id="panelImp" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);"  width="550" height="200">
        <jsp:include flush="true" page="/commun/impressionParametre.jsp"/>
    </rich:modalPanel>


</f:subview>
