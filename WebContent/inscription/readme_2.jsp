<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>


<h:panelGrid  id="lic2" border="0" width="100%">

    <div style="text-align:center;">epegase l'Intégrale est un portail universel de gestion d'entreprise en mode SaaS</div>

    <br>

    <div style="text-align:justify;">epegase Solutions a une expertise de plus de 20 ans dans le domaine de la gestion d'entreprise. Il regroupe tous les outils pour gérer une entreprise quelque soit son activité, sa taille ou sa localisation géographique. Pour cela, epegase l'Intégrale est constitué de plusieurs modules.<br><br>
        - <b>Comptabilité</b> (Comptabilité générale et analytique, immobilisations, rapprochements bancaires, budgets de fonctionnement et budgets de trésorerie, états financiers, tableaux de bord et reporting)<br>
        - <b>Paye</b> (Gestion des salariés CDD, CDI, Horaires, expatries, vacataires, journaliers, gestion de la paye, ressources humaines, états de déclaration)<br>
        - <b>Achats</b> (gestion des produits, familles d'achat de produit, gestion des importations, calcul du PR et du PUMP, demandes d'achat, cotations, commandes, réceptions/livraisons, retours, factures, avoirs, notes de débit, bons de décaissement)<br>
        - <b>Ventes</b> (gestion des produits, familles de vente de produit, gestion des campagnes, devis/proforma, commandes, livraisons, retours, factures, avoirs, notes de débit, bons d'encaissement)<br>
        - <b>Stocks</b> (gestion des produits, gestion multi-dépôts, inventaires, bons d'entrée, bons de sortie, cessions/transferts, états des stocks)<br>
        - <b>Immobilier</b> (gestion des biens, des propriétaires des locataires, des contrats de bail, gestion des locations, gestion du syndic, gestion des travaux, gestion des PV, gestion des AG, bons d'encaissement)<br>
        - <b>Intérim</b> (gestion des feuilles de calcul par sociétés, gestion des salaries par sociétés, gestion des bulletins par sociétés, facturation aux sociétés, états de déclaration)<br>
        - <b>Projets</b> (Le point central est le Projet et tous les modules sont organisés autour du projet, comptabilité projet, paye projet, trésorerie projet)<br>
        - <b>Trésorerie</b> (opérations de caisse, bons d'entrée, bons de sortie, virements internes, traites, invntaires caisse)<br>
        - <b>Parc</b> (fiche d'identité des pars, bons de carburant, bons de lubrifiant, ordres de réparation, localisations GPS)<br>
        - <b>Médical</b> (gestion des patients, consultations générales, examens de laboratoire et paillasses, gestion pharmacie, hospitalisations, gestion du tiers payant, refacturation aux tiers)<br>
    </div>
    <br>
    <div style="text-align:justify;">Tous les modules se transfèrent dans la comptabilité. Les transfèrent prennent en charge les imputations analytiques. Chaque compte général et chaque imputation analytiue sont paramétrables. Le schéma des écritures est également paramétrable mais reste conforme aux normes fiscales en vigueur. Les saisies directes en comptabilité sont donc réduites.<br>
    </div>
    <br>
    <div style="text-align:justify;">e-Pégase est multi-fiscalités, c'est à dire qu'il peut prendre en charge n'importe qu'elle fiscalité. Il est aussi multi-devises.<br>
    </div>
    <br>
    <div style="text-align:justify;">Chaque module possède ses propres états d'impression livrés en standard mais vous avez la possiblité de modifier les états existents ou de rajouter de nouveaux états. Le générateur d'état repose sur un requêteur graphique: ireport. Vous disposez également d'état de synthèses et de reporting entièrement paramêtrable par vous même.<br>
    </div>
    <br>
    <div style="text-align:justify;">Si votre métier n'est pas encore géré par e-Pégase ou si vous avez des spécifités particulières, alors e-Pégase peut être aménagé pour prendre en compte votre cas. Un cahier des charges sera alors rédigé entre les deux parties (vous et nous) et un développement spécifique sera réalisé conformément au CDG dûment rempli, signé et accepté.<br><br>
    </div>
    <div style="text-align:center;"><b>Screenshots d'e-Pegase.</b><br>
        <center>

            <rich:tabPanel switchType="client" immediate="true" id="panelModule" style="font-family:Arial;font-size:12px;border:0px;background-color:transparent;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="100%" >

                <rich:tab id="tabMod1" label="Comptabilité" >
                    <rich:extendedDataTable styleClass="bg" enableContextMenu="false" id="table1" noDataLabel=" " border="0" width="100%" height="300px" value="#{bakingbeanepegase.lesScreenShotCompta}" var="var1">
                        <rich:column label="Screenshot" width="100%" style="text-align:center">
                            <h:graphicImage value="#{var1}" alt="pho" width="100%" height="100%" style="text-align:center"/>
                        </rich:column>
                    </rich:extendedDataTable>
                </rich:tab>

                <rich:tab id="tabMod2" label="Paye" >
                    <rich:extendedDataTable styleClass="bg" enableContextMenu="false" id="table2" noDataLabel=" " border="0" width="100%" height="300px" value="#{bakingbeanepegase.lesScreenShotPaye}" var="var2">
                        <rich:column label="Screenshot" width="100%" style="text-align:center">
                            <h:graphicImage value="#{var2}" alt="pho" width="100%" height="100%" style="text-align:center"/>
                        </rich:column>
                    </rich:extendedDataTable>
                </rich:tab>

                <rich:tab id="tabMod3" label="Achats" >
                    <rich:extendedDataTable styleClass="bg" enableContextMenu="false" id="table3" noDataLabel=" " border="0" width="100%" height="300px" value="#{bakingbeanepegase.lesScreenShotAchats}" var="var3">
                        <rich:column label="Screenshot" width="100%" style="text-align:center">
                            <h:graphicImage value="#{var3}" alt="pho" width="100%" height="100%" style="text-align:center"/>
                        </rich:column>
                    </rich:extendedDataTable>
                </rich:tab>

                <rich:tab id="tabMod4" label="Ventes" >
                    <rich:extendedDataTable styleClass="bg" enableContextMenu="false" id="table4" noDataLabel=" " border="0" width="100%" height="300px" value="#{bakingbeanepegase.lesScreenShotVentes}" var="var4">
                        <rich:column label="Screenshot" width="100%" style="text-align:center">
                            <h:graphicImage value="#{var4}" alt="pho" width="95%" height="95%" style="text-align:center"/>
                        </rich:column>
                    </rich:extendedDataTable>
                </rich:tab>

                <rich:tab id="tabMod5" label="Stocks" >
                    <rich:extendedDataTable styleClass="bg" enableContextMenu="false" id="table5" noDataLabel=" " border="0" width="100%" height="300px" value="#{bakingbeanepegase.lesScreenShotStocks}" var="var5">
                        <rich:column label="Screenshot" width="100%" style="text-align:center">
                            <h:graphicImage value="#{var5}" alt="pho" width="100%" height="100%" style="text-align:center"/>
                        </rich:column>
                    </rich:extendedDataTable>
                </rich:tab>

                <rich:tab id="tabMod6" label="Immobilier" >
                    <rich:extendedDataTable styleClass="bg" enableContextMenu="false" id="table6" noDataLabel=" " border="0" width="100%" height="300px" value="#{bakingbeanepegase.lesScreenShotImmobilier}" var="var6">
                        <rich:column label="Screenshot" width="100%" style="text-align:center">
                            <h:graphicImage value="#{var6}" alt="pho" width="100%" height="100%" style="text-align:center"/>
                        </rich:column>
                    </rich:extendedDataTable>
                </rich:tab>

                <rich:tab id="tabMod7" label="Trésorerie" >
                    <rich:extendedDataTable styleClass="bg" enableContextMenu="false" id="table7" noDataLabel=" " border="0" width="100%" height="300px" value="#{bakingbeanepegase.lesScreenShotTresorerie}" var="var7">
                        <rich:column label="Screenshot" width="100%" style="text-align:center">
                            <h:graphicImage value="#{var7}" alt="pho" width="100%" height="100%" style="text-align:center"/>
                        </rich:column>
                    </rich:extendedDataTable>
                </rich:tab>

                <rich:tab id="tabMod8" label="Parc" >
                    <rich:extendedDataTable styleClass="bg" enableContextMenu="false" id="table8" noDataLabel=" " border="0" width="100%" height="300px" value="#{bakingbeanepegase.lesScreenShotParc}" var="var8">
                        <rich:column label="Screenshot" width="100%" style="text-align:center">
                            <h:graphicImage value="#{var8}" alt="pho" width="100%" height="100%" style="text-align:center"/>
                        </rich:column>
                    </rich:extendedDataTable>
                </rich:tab>

                <rich:tab id="tabMod9" label="Médical" >
                    <rich:extendedDataTable styleClass="bg" enableContextMenu="false" id="table9" noDataLabel=" " border="0" width="100%" height="300px" value="#{bakingbeanepegase.lesScreenShotMedical}" var="var9">
                        <rich:column label="Screenshot" width="100%" style="text-align:center">
                            <h:graphicImage value="#{var9}" alt="pho" width="100%" height="100%" style="text-align:center"/>
                        </rich:column>
                    </rich:extendedDataTable>
                </rich:tab>

            </rich:tabPanel>
        </center>
    </div>
</h:panelGrid>


