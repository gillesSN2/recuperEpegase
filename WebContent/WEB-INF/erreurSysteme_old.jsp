<!DOCTYPE html>
<%@page isErrorPage="true" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

    <head>
        <title>epegase : ERREUR SYSTEME</title>
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrAssistant!=0&&bakingbeanepegase.menuModuleHorizontalCtrl.internetActif>=1}">
            <script type="text/javascript" src='https://code.responsivevoice.org/responsivevoice.js'></script>
        </c:if>
    </head>

    <body>

        <center>
            <h1>Oups! une erreur système est survenue...</h1>
            <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrAssistant!=0&&bakingbeanepegase.menuModuleHorizontalCtrl.internetActif>=1}">
                <script type="text/javascript" language="Javascript">
                    setTimeout(responsiveVoice.speak("Une erreur système est survenue. Nous sommes désolés pour ce désagrément. Un technicien va déterminer la source du problème et nous la corrigerons le plus rapidement. En attendant vous pouvez vous reconnecter en cliquant sur le bouton ci-après", "${bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.genreAssistant}"),20);
                </script>
            </c:if>
        </center>

        <br><br>

        <table width="100%" border="0">
            <tr valign="top">
                <td width="15%"><b>Descrption erreur:</b></td>
                <td>${pageContext.exception}</td>
            </tr>
            <tr valign="top">
                <td><b>Adresse erreur:</b></td>
                <td>${pageContext.errorData.requestURI}</td>
            </tr>
            <tr valign="top">
                <td><b>Code erreur:</b></td>
                <td>${pageContext.errorData.statusCode}</td>
            </tr>
            <tr valign="top">
                <td><b>Message erreur:</b></td>
                <td>${pageContext.exception.message}</td>
            </tr>
            <tr valign="top">
                <td><b>Cause erreur:</b></td>
                <td>${pageContext.exception.cause}</td>
            </tr>
        </table>

        <center>
            <br>
            <h3>Veuillez contacter notre service d'assistance par mail (<a href="mailto:epegase.biz@gmail.com?subject=Incidents de ${bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strraisonsociale}&body=${pageContext.exception.message}">assistance@e-pegase.biz</a>)</h3>
            <br><br>
            Reconnectez vous sur votre plate forme de travail : <a href="../../epegase/" style="text-decoration:none;font-family:sans-serif;color:green;font-weight:bold;">Horus l'Intégrale</a>
        </center>

        <br> <br><br> <br><br> <br><br> <br><br> <br><br> <br><br> <br><br><br> <br><br> <br>

        <div class="requestAttributs" >
            <%
            java.util.Enumeration en = request.getAttributeNames();
            while (en.hasMoreElements()) {
                String name = (String) en.nextElement();
                if (request.getAttribute(name) == null) {
            %>
            <div>
                <%=name%>=null
            </div>
            <%
                } else {
            %>
            <div>
                <%=name%>=<%=request.getAttribute(name).toString()%>
            </div>
            <%
                }
            }
            %>
        </div>

        <div class="requestParameters">
            <%
            en = request.getParameterNames();
            while (en.hasMoreElements()) {
                String name = (String) en.nextElement();
                if (request.getParameter(name) == null) {
            %>
            <div>
                <%=name%>=null
            </div>
            <%
                } else {
            %>
            <div>
                <%=name%>=<%=request.getParameter(name).toString()%>
            </div>
            <%
                }
            }
            %>
        </div>

        <h1>Exception</h1>
        <div>
            <%
            Throwable th = pageContext.getException();
            if (th != null) {
                printRecursiveException(out, th);
            }
            %>
        </div>

        <%! public void printRecursiveException(JspWriter out, Throwable th) throws java.io.IOException {
                        out.println("<div>" + th.getClass().getName() + ":" + th.getMessage() + "</div>");
                        StackTraceElement ste;
                        for(int x=0;x < th.getStackTrace().length;x++) {
                                out.println("<div>" + th.getStackTrace()[x].toString() + "</div>");
                        }

                        Throwable parent = th.getCause();
                        if(parent != null) {
                                out.println("<div class=\"parentCause\">");
                                printRecursiveException(out,parent);
                                out.println("</div>");
                        }
                }
        %>

    </body>
</html>














