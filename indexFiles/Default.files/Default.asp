<HTML>
<HEAD><TITLE>Midorikawa's HomePage</TITLE></HEAD>
<BODY>
<H1>Welcome to Midorikawa's Page</H1>

<H2>����������</H2>
<P>����ɂ��́A�ΐ�ł��B��낵���B</P>



<%
      iHour = Hour(Now)
      If iHour <  12 Then
           Response.Write "���͂悤�������܂��B"
      ElseIf iHour <  18 Then
           Response.Write "����ɂ���B"
      Else
           Response.Write "����΂�́B"
      End If
%>


<BR><BR>
���� <%  =Now() %>  �ł��B



<FORM method=post>
<P align=center><FONT size=6>��������<INPUT size=15 name=watch>�ł��B 
</FONT></P></FORM>
<SCRIPT language=JavaScript>
function watch() {
	now = new Date();
	hour = now.getHours();
	min = now.getMinutes();
	sec = now.getSeconds();
	if (hour < 10) {
		hour = "0" + hour;
	}
	if (min < 10) {
		min = "0" + min;
	}
	if (sec < 10) {
		sec = "0" + sec;
	}
	document.forms[0].elements[0].value = hour+":"+min+":"+sec;
	setTimeout('watch()', 999); // 1000msec = 1sec
}
watch();
</SCRIPT>

<P align=center>



</BODY>
</HTML>

