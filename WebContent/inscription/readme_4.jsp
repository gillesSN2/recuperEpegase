<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>


<h:panelGrid  id="lic4" border="0" width="100%">

    <div style="text-align:center;">e-Pégase se décline en plusieurs versions. Ainsi, vous pouvez choisir la configuration qui est la mieux adaptée à vos objectifs et à vos désirs.</div>

    <br>

    <rich:tabPanel switchType="client" immediate="true"  id="licence" style="border:0px;" width="100%">

        <rich:tab label="Mode SaaS">
            <h:panelGrid  width="100%">
                <div style="text-align:center;text-decoration:underline;">Qu'est ce qu'un logiciel en mode SaaS public?
                </div>
                <br><br>
                <div style="text-align:justify;">Le portail de gestion en mode SaaS e-Pégase (Software as a Service) est une plate forme de travail qui est livrée, non pas en l’installant sur un serveur interne ou un poste de travail dans l’entreprise, mais en tant qu’application accessible à distance, comme un service, par le biais d’Internet.
                    Par voie de conséquence, le modèle SaaS offre de nombreux avantages pour l'utilisateur final et pour l'entreprise :<br><br>
                    <b>Réduction des coûts informatiques et amélioration du ROI (Return On Investment) :</b> <br>
                    - Le mode locatif sous entend hébergement distant de l’application donc pas d’investissements en matériel (serveur) et en logiciel (pas d’achat de licences) <br>
                    - Réduction des coûts de support <br>
                    - Maîtrise du budget informatique : les coûts sont connus à l'avance <br>
                    - Réduction du TCO (Total Cost Of Ownership) <br>
                    - Réduction des besoins en ressources informatiques <br>
                    - Budget de fonctionnement étalé dans le temps <br>
                    - Faibles coûts de maintenance <br><br>
                    <b>Amélioration de vos outils de gestion :</b><br>
                    - Implémentation plus rapide <br>
                    - Meilleure qualité de services <br>
                    - Données accessibles de n’importe où <br>
                    - Meilleure gestion de la sécurité et du risque informatique <br>
                    - Modèle adaptable en fonction du mode d’utilisation et de l’activité <br>
                    - Mode de gestion adapté à la mobilité <br>
                    - Utilisation plus intuitive, plus facile  <br><br>
                    <b>Innovation continue</b><br>
                    - Mises à niveau automatiques des programmes  <br>
                    - SaaS innove en permanence et ses innovations sont exploitables d’emblée, sans nécessiter de réinstallation ou de reconfiguration.   <br>
                    - Conformité réglementaire : quand la loi change, le portail e-Pégase s'adapte automatiquement <br>
                    - Mise à jour automatique des devises <br><br>
                    <b>Sécurité</b><br>
                    - Sécurité élevée <br>
                    - L’accès aux données confidentielles est contrôlé par mot de passe, au moyen de certificats, cartes à puce et via des espaces de travail isolés. Le modèle SaaS offre, dans de nombreux cas, une sécurité supérieure à celle offerte par l’installation de logiciels en local. <br><br>
                    <b>Effectif</b><br>
                    - Moindre sollicitation du personnel informatique  <br>
                    - SaaS prend tout en charge : support, maintenance, compatibilité, sécurité, correctifs, protection contre les logiciels malveillants… Inutile d’embaucher un spécialiste pour ces tâches.  <br><br>
                    Malgré tous ces nombreux avantages, le SaaS a quelques incovénients secondaires, à savoir :<br><br>
                    <b>Incovénients</b><br>
                    - Le protocole internet étant indispensable, dès qu'il n'y a plus internet, il n'y a plus de travail dans la plate forme.  <br>
                    - Le traitement des opérations s'effectuant dans nos Data Center et le visuel étant géré pour les navigateurs locaux, l'affichage est plus lent que les logiciels installés en local.<br><br>
                </div>
            </h:panelGrid>
        </rich:tab>

        <rich:tab label="Mode Licence">
            <h:panelGrid  width="100%">
                <div style="text-align:center;text-decoration:underline;">Qu'est ce qu'un logiciel en mode SaaS privé?<br><br>
                </div>
                <div style="text-align:justify;">Le portail de gestion e-Pégase peut être livré en l’installant sur un serveur interne de l’entreprise. Dans ce cas, l'utilisation se comporte comme celle en mode Saas (sur internet) mais avec un serveur installé en local. Le service est accessible aussi bien en intranet que sur internet via soit un VPN soit une IP fixe soit une adresse DynDns.
                    On peut considérer, alors, que tous les avantages du mode SaaS public deviennent des inconvénients en mode SaaS privé et que tous les inconvénients du mode SaaS public deviennent des avantages en mode SaaS privé.
                    Les avantages du mode SaaS privé sont les suivants :<br><br>
                    - Disponibilité des ressources 24h/24h  <br>
                    - Les traitements étant effectués au sein du réseau de l'entreprise, la vitesse de travail est optimisée <br>
                    - L'entreprise devra souscrire un contrat d'abonnement. Le contrat d'abonnenment couvre la maintenance des bases, la sauvegarde hebdomadaire des données, les mises à jour obligatoire suite à un changement de lois et l'assistance sur le logiciel, la mise à disposition d'une adresse internet publique et l'assistance en continue. Elle ne couvre ni la formation du personnel ni les mises à jour suite à des développements spécifiques, qui sont facturées à part.<br>
                    Toutefois, le cout de l'installation doit prendre en compte non seulement le prix du seveur mais aussi le prix des systèmes de protection. <br>
                    Dans cette configuration, le service informatique a un grande resposabilité, tant au niveau de l'installation, des mises à jour que de la maintenance (entretien des bases de données et sauvegarde de celles-ci). <br>
                    Il faut prévoir un transfert de compétence pour le personnel technique en plus de la formation des utilisateurs. <br><br>
                </div>
            </h:panelGrid>
        </rich:tab>

        <rich:tab label="Contrat epegase">
            <h:panelGrid  width="100%">
                <object data="contrat_SaaS_horus.pdf" type="text/html" codetype="application/pdf" width="100%" height="800" align="middle"></object>
            </h:panelGrid>
        </rich:tab>

        <rich:tab label="Glossaire">
            <h:panelGrid  width="100%">
                <div style="text-align:justify;">Les termes ont la signification qui leur est donnée ci-après. <br> <br>
                    <b>Solutions</b><br>
                    dans le cadre des Services Applicatifs objets du contrat ; désignent les informations, publications et, de manière générale, les données de la base de données.<br> <br>
                    <b>Données</b><br>
                    Les données Client dont l'utilisation est l'objet du présent contrat, pouvant être consultées uniquement par les Utilisateurs ;<br><br>
                    <b>Identifiants</b><br>
                    Désignent tant l'identifiant propre de l’utilisateur ("login") que le mot de passe de connexion ("password"), communiqués après inscription au service ;<br> <br>
                    <b>Internet</b><br>
                    Désigne l’ensemble de réseaux interconnectés, lesquels sont localisés dans toutes les régions du monde ;<br><br>
                    <b>Intranet</b><br>
                    Désigne le réseau informatique propre à une entreprise ou une organisation, utilisant les protocoles TCP/IP et, plus généralement, les technologies de l’Internet et pouvant être reliées au réseau Internet ;<br><br>
                    <b>Logiciel</b><br>
                    Désigne tout logiciel fourni par le Prestataire au Client et en particulier les Solutions associées. <br><br>
                    <b>Service applicatif</b><br>
                    Désigne le service proposé en mode SaaS par le Prestataire, permettant l’utilisation des Solutions par le Client ;<br><br>
                    <b>Utilisateur</b><br>
                    Désigne la personne placée sous la responsabilité du Client (préposé, salarié, représentant, etc.) et bénéficiant d’un accès aux Services applicatifs sur son ordinateur en vertu de la licence d’utilisation contractée par le Client.
                </div>
            </h:panelGrid>
        </rich:tab>

        <rich:tab label="Pré-requis">
            <h:panelGrid  width="100%">
                <div style="text-align:justify;"><b>Configurations pour e-Pégase en mode SaaS.</b> <br><br>
                    Veuillez trouver ci-après les configurations minimales (coté client) pour e-Pégase :<br><br>
                    - Plateforme Mac ou PC sous windows ou sous linux<br>
                    - Ecran 20" (1600 * 900) fortement conseillé <br>
                    - Explorateur : Mozilla FireFox version 3.6 <br>
                    - Explorateur : Environnement JAVA activé <br><br><br>
                </div>
                <div style="text-align:justify;"><b>Configurations e-Pégase en mode Licence.</b> <br><br>
                    Veuillez trouver ci-après les configurations minimales (coté serveur) pour e-Pégase :<br><br>
                    - Mémoire vive (minimum) : 12Go <br>
                    - Disque dur (minimum) : 500 Go <br>
                    - Système d'exploitation : UBUNTU version 14.04 <br>
                    - Système d'administration : WEBMIN version 1.810 <br>
                    - Serveur Web : APACHE version 2 <br>
                    - Serveur d'application Glassfish version 2 <br>
                    - Serveur de base de données : MySql version 5.6 <br>
                    - Environement JAVA version 6 update 22 <br><br>
                    Veuillez trouver ci-après les configurations minimales (coté client) pour e-Pégase :<br><br>
                    - Plateforme Mac ou PC sous windows ou sous linux<br>
                    - Ecran 20" (1600 * 900) fortement conseillé <br>
                    - Explorateur : Mozilla FireFox version 3.6 <br>
                    - Explorateur : Environnement JAVA activé <br>
                </div>
            </h:panelGrid>
        </rich:tab>

        <rich:tab label="Versions">
            <h:panelGrid  width="100%">
                <table style="width: 620px; height: 150px;" border="0">
                    <tbody>
                        <tr style="text-align: center;">
                            <td style="text-align: center;"><strong>Outils utilisés<br /></strong></td>
                            <td><strong> N° version<br /></strong></td>
                            <td><strong>Fonction<br /></strong></td>
                        </tr>
                        <tr>
                            <td>Ireport</td>
                            <td>3.7.1</td>
                            <td>Gestion des rapports</td>
                        </tr>
                        <tr>
                            <td>Netbeans</td>
                            <td>6.7.1</td>
                            <td>Plateforme de développement</td>
                        </tr>
                        <tr>
                            <td>MySql</td>
                            <td>5.6</td>
                            <td>Base de données</td>
                        </tr>
                        <tr>
                            <td>Glassfish</td>
                            <td>V.2</td>
                            <td>Serveur d'application</td>
                        </tr>
                    </tbody>
                </table>
            </h:panelGrid>
        </rich:tab>

        <rich:tab label="Paiements">
            <h:panelGrid  width="100%">
                <div style="text-align:justify;"><b>Modes de paiements des abonnements</b> <br><br>
                    Veuillez trouver ci-après les différentes modalités de paiement des abonnements et des services d'e-Pégase<br><br>
                    <b>(Si facture au MALI)</b> <br>
                    - Paiement en ligne par carte bancaire Visa dans l'onglet Espace client<br>
                    - Paiement par chèque bancaire en Fcfa à l'ordre de epegase SOLUTIONS<br>
                    - Paiement par virement bancaire aux coordonnées suivantes :<br>
                    Banque : BDM <br>
                    Adresse  : Agence de KOROFINA <br>
                    En faveur de : epegase SOLUTIONS <br>
                    Code banque : ML016 <br>
                    Code guichet : 01205 <br>
                    N° Compte : 20401318214 <br>
                    Cle : 15 <br>
                    IBAN : ML016 01205 20401318214 15 <br><br>
                    <b>(Si facture au SENEGAL)</b> <br>
                    - Paiement en ligne par carte bancaire Visa dans l'onglet Espace client<br>
                    - Paiement par chèque bancaire en Fcfa à l'ordre de epegase SOLUTIONS<br>
                    - Paiement par virement bancaire aux coordonnées suivantes :<br>
                    Banque : DIAMOND BANK <br>
                    Adresse  : route de l'aéroport <br>
                    En faveur de : epegase SOLUTIONS <br>
                    Code pays : SN  <br>
                    Code banque : SN159 <br>
                    Code guichet : 01304 <br>
                    N° Compte: 262104601015 <br>
                    Cle : 73 <br>
                    SWIFT : DBLNSNDA <br><br>
                    <b>(Si facture au Gabon)</b> <br>
                    - Paiement en ligne par carte bancaire Visa dans l'onglet Espace client<br>
                    - Paiement par chèque bancaire en Fcfa à l'ordre de epegase SOLUTIONS<br>
                    - Paiement par virement bancaire aux coordonnées suivantes :<br>
                    Banque : ORABANK GABON <br>
                    Adresse  : AKANDA <br>
                    En faveur de : epegase SOLUTIONS <br>
                    Code pays : GA21  <br>
                    Code banque : 40021 <br>
                    Code guichet : 01007 <br>
                    N° Compte: 21257700201 <br>
                    Cle : 57 <br>
                    BIC : ORBKGALI <br>
                    IBAN : GA21 4002 1010 0721 2577 0020 157 <br>
                </div>
            </h:panelGrid>
        </rich:tab>

    </rich:tabPanel>
</h:panelGrid>


