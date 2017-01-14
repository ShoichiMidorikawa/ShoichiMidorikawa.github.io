<HTML>
<HEAD><TITLE>Midorikawa's HomePage</TITLE></HEAD>
<BODY>
<H1>Welcome to Midorikawa's Page</H1>

<H2>ごあいさつ</H2>
<P>こんにちは、緑川です。よろしく。</P>



<%
      iHour = Hour(Now)
      If iHour <  12 Then
           Response.Write "おはようございます。"
      ElseIf iHour <  18 Then
           Response.Write "こんにちわ。"
      Else
           Response.Write "こんばんは。"
      End If
%>


<BR><BR>
現在 <%  =Now() %>  です。



<FORM method=post>
<P align=center><FONT size=6>ただいま<INPUT size=15 name=watch>です。 
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

