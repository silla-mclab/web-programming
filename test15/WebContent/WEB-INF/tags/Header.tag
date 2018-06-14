<%@ attribute name="subTitle" required="false" rtexprvalue="true" %>
<%@ attribute name="fontColor" required="true" rtexprvalue="true" %>

<%@ tag body-content="tagdependent" %>

<img src="/test15/webservice.jpg"  width="320" height="320" /><br>
<%--
<h3><em>${subTitle}</em></h3>
 --%>
<h3><em><font color="${fontColor}"><jsp:doBody /></font></em></h3> 
 