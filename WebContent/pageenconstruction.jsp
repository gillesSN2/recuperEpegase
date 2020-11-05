<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="pageEncoursdeContruction" >

    <center> <h2 style="color:green;font-size:18px;">Page en construction</h2></center>

    <h:panelGrid width="100%" border="0">

        <h:panelGrid id="p1" width="100%" >

            <center>
                <br/><br/>
                <img src="images/work.png"  alt="work"/>
                <br/><br/>
                Cette fonction ou cette page sont en cours de construction et seront disponbiles dans une prochaine version...
                <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.internetActif>=1}">
                    <script type="text/javascript" language="Javascript">
                        setTimeout(responsiveVoice.speak("Nous sommes désolés mais cette fonction n est pas encore opérationnelle. Veuillez reessayer ultérieurement.", "${bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.genreAssistant}"),20);
                    </script>
                </c:if>
                <br/><br/>
            </center>

        </h:panelGrid>

    </h:panelGrid>

</f:subview>