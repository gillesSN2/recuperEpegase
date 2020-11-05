<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>


<h:panelGrid  id="lic8" border="0" width="100%">

    <div style="text-align:center;">Les produits d'Horus solutions sont orientés Web et Android.</div>

    <br>

    <h:panelGrid width="100%">
        <center>

            <rich:tabPanel switchType="client" immediate="true" style="border:0px;" width="100%">

                <rich:tab label="Le catalogue">

                    <h:panelGrid width="100%" style="border:solid 1px red;">
                        <h:panelGrid width="100%">
                            <h:outputText value="Horus l'Intégrale" style="font-weight:bold;"></h:outputText><br>
                            <div style="text-align:justify;">Horus l'Intégrale est la plate forme Web de gestion d'entreprise en mode SaaS. Elle est entièrement configurable et sait s'adapter à chaque pays dans le respect des normes et des lois en vigueur.<br>
                            </div>
                        </h:panelGrid>
                    </h:panelGrid>
                            <br>
                    <h:panelGrid width="100%" style="border:solid 1px red;">
                        <h:panelGrid width="100%">
                            <h:outputText value="Horus Security" style="font-weight:bold;"></h:outputText><br>
                            <div style="text-align:justify;">Horus Sécurity permet, à partir d'un QR code imprimé sur les documents générés par Horus l'Intégrale d'avoir sur l'écran du téléphone les éléments du document en concerné pour le comparer avec le document papier. Ce produit permet de détecter les faux documents.<br>
                            </div>
                        </h:panelGrid>
                    </h:panelGrid>
                            <br>
                    <h:panelGrid width="100%" style="border:solid 1px red;">
                        <h:panelGrid width="100%">
                            <h:outputText value="Horus Rendez-vous" style="font-weight:bold;"></h:outputText><br>
                            <div style="text-align:justify;">Horus Rendez-vous est destiné aux agents de terrains. Ils peuvent prendre leur rendez-vous ou faire des notes de frais. Lors du rendez-vous, l'agent de terrain va chercher le client dans la base d'Horus l'Intégrale. S'il existe il va le sémectionner. S'il n'existe pas, il sera créé en tant que prospect. Ensuite, il définit l'objet de sa visite ou de son intervention. En fin de rendez-vous, il peut saisir son rapport et mettre le statut du rendez-vous.<br>
                            </div><br>
                            <div style="text-align:justify;">L'agent de terrain peut également saisir ses notes de frais. Sur chaque note, il spécifie sa nature, met le montant qu'il a payé et prend la photo de sa facture. Tous ces éléments sont envoyés dans Horus l'Intégrale dans les notes externes du module de la coptabilité. Lors du traitement de ces notes, les écritures comptables sont générées grace à la nature de la pièce.<br>
                            </div>
                        </h:panelGrid>
                    </h:panelGrid>
                            <br>
                    <h:panelGrid width="100%" style="border:solid 1px red;">
                        <h:panelGrid width="100%">
                            <h:outputText value="Horus Pointage" style="font-weight:bold;"></h:outputText><br>
                            <div style="text-align:justify;">Horus Pointage permet aux agents de faire leur pointage. ILs commencent par le début de la journée. Ils peuvent gérer les pauses. enfin ils doivent pointer en fin de journée.<br>
                            </div>
                        </h:panelGrid>
                    </h:panelGrid>
                            <br>
                    <h:panelGrid width="100%" style="border:solid 1px red;">
                        <h:panelGrid width="100%">
                            <h:outputText value="Horus Inventaire Immobilisations" style="font-weight:bold;"></h:outputText><br>
                            <div style="text-align:justify;">Horus Inventaire Immobilisation permet de faire l'inventaire des biens immobilisations présent dans le module de comptabilité d'Horus l'Intégrale. Chaque bien posséde un QR code qui est généré par l'Intégrale. Ce dernier est collé sur chaque bien. Lors de l'inventaire, il suffit de scanner le QR Code, de saisir un petit commentaire et de statuer sur l'état du bien. On peut également faire la photo du bien. L'ensemble des éléments est transmis à Horus l'Intégrale et se positionne dans l'onglet inventaire du bien concerné.<br>
                            </div>
                        </h:panelGrid>
                    </h:panelGrid>
                            <br>
                    <h:panelGrid width="100%" style="border:solid 1px red;">
                        <h:panelGrid  width="100%">
                            <h:outputText value="Horus Ronde" style="font-weight:bold;"></h:outputText><br>
                            <div style="text-align:justify;">Horus Ronde est destiné aux sociétés de gardiennage. Chaque point de controle posséde un QR Code. Le gardien, lors de sa ronde, scanne chaque point de controle. Un bonton alerte peut envoyé au poste de controle une alerte en cas de problèmes majeurs. L'ensemble des informations est transférer dans le parcours de l'agent concerné d'Horus l'Intégrale.<br>
                            </div>
                        </h:panelGrid>
                    </h:panelGrid>
                            <br>
                    <h:panelGrid width="100%" style="border:solid 1px red;">
                        <h:panelGrid  width="100%">
                            <h:outputText value="Horus Feuille des temps" style="font-weight:bold;"></h:outputText><br>
                            <div style="text-align:justify;">Horus Feuille des temps petmet aux cabinets comptable de saisir la feuille des temps directement chez le client. L'ensemeble des informations va alimenter la feuille des temps de l'utilisateur d'Horus l'Intégrale.<br>
                            </div>
                        </h:panelGrid>
                    </h:panelGrid>
                            <br>
                    <div style="text-align:justify;">Attention: tous les éléments manipuler par l'Android sont horadatés et géolocalisés. Ils sont imputés sur les utilisateurs d'Horus l'Intégrale.<br>
                    </div>
                            <br>
                </rich:tab>

            </rich:tabPanel>
        </center>
    </h:panelGrid>
</h:panelGrid>


