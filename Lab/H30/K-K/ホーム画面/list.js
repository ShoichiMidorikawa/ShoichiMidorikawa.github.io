var map;
var marker1_daigaku;
var marker2_makuba;
var marker3_roson;
var marker4_famima;
var marker5_sebun;
var marker6_takahasi;
var marker7_tibasyokudou;
var marker8_tarukou;
var marker9_hokatei;
var marker10_yosijun;
var marker11_nekokafe;
var marker12_kafehiguti;
var marker13_ramensyopu;
var marker14_maruhuku;
var marker15_hinataboko;
var marker16_Oeuf;
var marker17_konkichin;
var marker18_yakkyoku;
var marker19_famirikuriniku;
var marker20_sekotuin;
var marker21_mikamiiin;
var marker22_takenamisika;
var marker23_sekisika;
var marker24_koubatasika;
var marker25_airuhamanaka;
var marker26_tehutehu;
var marker27_CHELSEA;
var marker28_SUPERMAN;
var marker29_atorie;
var marker30_ron;
var marker31__kudou;
var marker32_aogin;
var marker33_aoginiten;
var marker34_yuubin;
var marker35_aodaimae;
var marker36_aodaimae2;
var marker37_aodaimae3;
var marker38_higasidouri1;
var marker39_higasidouri2;
var marker40_koubatadanti1;
var marker41_koubatadanti2;
var marker42_nisiguti1;
var marker43_nisiguti2;
var marker44_syougakoumae1;
var marker45_syougakoumae2;
var marker46_kouban;
document.onkeydown = pageMove;

function initialize() {
  var latlng = new google.maps.LatLng(40.78456153, 140.781552);
  var opts = {
    zoom: 16,
    center: latlng,
    mapTypeId: google.maps.MapTypeId.ROADMAP
  };

  map = new google.maps.Map(document.getElementById("map_canvas"), opts);

  var infowindow_1 = new google.maps.InfoWindow({
    content: contentStr1
  });
  var infowindow_2 = new google.maps.InfoWindow({
    content: contentStr2
  });
  var infowindow_3 = new google.maps.InfoWindow({
    content: contentStr3
  });
  var infowindow_3 = new google.maps.InfoWindow({
    content: contentStr3
  });
  var infowindow_4 = new google.maps.InfoWindow({
    content: contentStr4
  });
  var infowindow_5 = new google.maps.InfoWindow({
    content: contentStr5
  });
  var infowindow_6 = new google.maps.InfoWindow({
    content: contentStr6
  });
  var infowindow_7 = new google.maps.InfoWindow({
    content: contentStr7
  });
  var infowindow_8 = new google.maps.InfoWindow({
    content: contentStr8
  });
  var infowindow_9 = new google.maps.InfoWindow({
    content: contentStr9
  });
  var infowindow_10 = new google.maps.InfoWindow({
    content: contentStr10
  });
  var infowindow_11 = new google.maps.InfoWindow({
    content: contentStr11
  });
  var infowindow_12 = new google.maps.InfoWindow({
    content: contentStr12
  });
  var infowindow_13 = new google.maps.InfoWindow({
    content: contentStr13
  });
  var infowindow_14 = new google.maps.InfoWindow({
    content: contentStr14
  });
  var infowindow_15 = new google.maps.InfoWindow({
    content: contentStr15
  });
  var infowindow_16 = new google.maps.InfoWindow({
    content: contentStr16
  });
  var infowindow_17 = new google.maps.InfoWindow({
    content: contentStr17
  });
  var infowindow_18 = new google.maps.InfoWindow({
    content: contentStr18
  });
  var infowindow_19 = new google.maps.InfoWindow({
    content: contentStr19
  });
  var infowindow_20 = new google.maps.InfoWindow({
    content: contentStr20
  });
  var infowindow_21 = new google.maps.InfoWindow({
    content: contentStr21
  });
  var infowindow_22 = new google.maps.InfoWindow({
    content: contentStr22
  });
  var infowindow_23 = new google.maps.InfoWindow({
    content: contentStr23
  });
  var infowindow_24 = new google.maps.InfoWindow({
    content: contentStr24
  });
  var infowindow_25 = new google.maps.InfoWindow({
    content: contentStr25
  });
  var infowindow_26 = new google.maps.InfoWindow({
    content: contentStr26
  });
  var infowindow_27 = new google.maps.InfoWindow({
    content: contentStr27
  });
  var infowindow_28 = new google.maps.InfoWindow({
    content: contentStr28
  });
  var infowindow_29 = new google.maps.InfoWindow({
    content: contentStr29
  });
  var infowindow_30 = new google.maps.InfoWindow({
    content: contentStr30
  });
  var infowindow_31 = new google.maps.InfoWindow({
    content: contentStr31
  });
  var infowindow_32 = new google.maps.InfoWindow({
    content: contentStr32
  });
  var infowindow_33 = new google.maps.InfoWindow({
    content: contentStr33
  });
  var infowindow_34 = new google.maps.InfoWindow({
    content: contentStr34
  });
  var infowindow_35 = new google.maps.InfoWindow({
    content: contentStr35
  });
  var infowindow_36 = new google.maps.InfoWindow({
    content: contentStr36
  });
  var infowindow_37 = new google.maps.InfoWindow({
    content: contentStr37
  });
  var infowindow_38 = new google.maps.InfoWindow({
    content: contentStr38
  });
  var infowindow_39 = new google.maps.InfoWindow({
    content: contentStr39
  });
  var infowindow_40 = new google.maps.InfoWindow({
    content: contentStr40
  });
  var infowindow_41 = new google.maps.InfoWindow({
    content: contentStr41
  });
  var infowindow_42 = new google.maps.InfoWindow({
    content: contentStr42
  });
  var infowindow_43 = new google.maps.InfoWindow({
    content: contentStr43
  });
  var infowindow_44 = new google.maps.InfoWindow({
    content: contentStr44
  });
  var infowindow_45 = new google.maps.InfoWindow({
    content: contentStr45
  });
  var infowindow_46 = new google.maps.InfoWindow({
    content: contentStr46
  });

  var iconImage1="http://maps.google.com/mapfiles/kml/pal2/icon10.png";
  var iconImage2="su-pa-.jpg";
  var iconImage3="bank.png";
  var iconImage4="basu.png";
  var iconImage5="byouin.png";
  var iconImage6="ha.png";
  var iconImage7="hone.png";
  var iconImage8="insyoku.png";
  var iconImage9="kami.png";
  var iconImage10="koban.png";
  var iconImage11="konbini.png";
  var iconImage12="kusuri.png";
  var iconImage13="neko.png";
  var iconImage14="suitu.png";
  var iconImage15="yubin.png";

  var m_latlng1 = new google.maps.LatLng(40.784056, 140.781172);
  marker1_daigaku = new google.maps.Marker({
    position: m_latlng1,
    icon:iconImage1
  });
  marker1_daigaku.addListener('click', function() {
    infowindow_1.open(map, marker1_daigaku);
  });

  var m_latlng2 = new google.maps.LatLng(40.7813629, 140.78369350000003);
  marker2_makuba = new google.maps.Marker({
    position: m_latlng2,
    icon:iconImage2
  });
  marker2_makuba.addListener('click', function() {
    infowindow_2.open(map, marker2_makuba);
  });

  var m_latlng3 = new google.maps.LatLng(40.784505852991366, 140.7808095216751);
  marker3_roson = new google.maps.Marker({
    position: m_latlng3,
    icon:iconImage11
  });
  marker3_roson.addListener('click', function() {
    infowindow_3.open(map, marker3_roson);
  });

  var m_latlng4 = new google.maps.LatLng(40.7844875, 140.77892710000003);
  marker4_famima = new google.maps.Marker({
    position: m_latlng4,
    icon:iconImage11
  });
  marker4_famima.addListener('click', function() {
    infowindow_4.open(map, marker4_famima);
  });


  var m_latlng5 = new google.maps.LatLng(40.7855263, 140.7818241);
  marker5_sebun = new google.maps.Marker({
    position: m_latlng5,
    icon:iconImage11
  });
  marker5_sebun.addListener('click', function() {
    infowindow_5.open(map, marker5_sebun);
  });

  var m_latlng6 = new google.maps.LatLng(40.78145132, 140.77878714);
  marker6_takahasi = new google.maps.Marker({
    position: m_latlng6,
    icon:iconImage11
  });
  marker6_takahasi.addListener('click', function() {
    infowindow_6.open(map, marker6_takahasi);
  });

  var m_latlng7 = new google.maps.LatLng(40.781313212719425, 140.7807371020317);
  marker7_tibasyokudou = new google.maps.Marker({
    position: m_latlng7,
    icon:iconImage8
  });
  marker7_tibasyokudou.addListener('click', function() {
    infowindow_7.open(map, marker7_tibasyokudou);
  });

  var m_latlng8 = new google.maps.LatLng(40.78097403644637, 140.78093022108078);
  marker8_tarukou = new google.maps.Marker({
    position: m_latlng8,
    icon:iconImage8
  });
  marker8_tarukou.addListener('click', function() {
    infowindow_8.open(map, marker8_tarukou);
  });

  var m_latlng9 = new google.maps.LatLng(40.7842264, 140.77822730000003);
  marker9_hokatei = new google.maps.Marker({
    position: m_latlng9,
    icon:iconImage8
  });
  marker9_hokatei.addListener('click', function() {
    infowindow_9.open(map, marker9_hokatei);
  });

  var m_latlng10 = new google.maps.LatLng(40.7846875, 140.78006870000002);
  marker10_yosijun = new google.maps.Marker({
    position: m_latlng10,
    icon:iconImage8
  });
  marker10_yosijun.addListener('click', function() {
    infowindow_10.open(map, marker10_yosijun);
  });

  var m_latlng11 = new google.maps.LatLng(40.78087147, 140.78710064);
  marker11_nekokafe = new google.maps.Marker({
    position: m_latlng11,
    icon:iconImage13
  });
  marker11_nekokafe.addListener('click', function() {
    infowindow_11.open(map, marker11_nekokafe);
  });

  var m_latlng12 = new google.maps.LatLng(40.78259272, 140.78503668);
  marker12_kafehiguti = new google.maps.Marker({
    position: m_latlng12,
    icon:iconImage13
  });
  marker12_kafehiguti.addListener('click', function() {
    infowindow_12.open(map, marker12_kafehiguti);
  });

  var m_latlng13 = new google.maps.LatLng(40.78756931, 140.78481586);
  marker13_ramensyopu = new google.maps.Marker({
    position: m_latlng13,
    icon:iconImage8
  });
  marker13_ramensyopu.addListener('click', function() {
    infowindow_13.open(map, marker13_ramensyopu);
  });


  var m_latlng14 = new google.maps.LatLng(40.78129696, 140.77961192);
  marker14_maruhuku = new google.maps.Marker({
    position: m_latlng14,
    icon:iconImage8
  });
  marker14_maruhuku.addListener('click', function() {
    infowindow_14.open(map, marker14_maruhuku);
  });


  var m_latlng15 = new google.maps.LatLng(40.78089381, 140.78092125);
  marker15_hinataboko = new google.maps.Marker({
    position: m_latlng15,
    icon:iconImage13
  });
  marker15_hinataboko.addListener('click', function() {
    infowindow_15.open(map, marker15_hinataboko);
  });

  var m_latlng16 = new google.maps.LatLng(40.7839736, 140.77765490000002);
  marker16_Oeuf = new google.maps.Marker({
    position: m_latlng16,
    icon:iconImage14
  });
  marker16_Oeuf.addListener('click', function() {
    infowindow_16.open(map, marker16_Oeuf);
  });

  var m_latlng17 = new google.maps.LatLng(40.7827266, 140.78049929999997);
  marker17_konkichin = new google.maps.Marker({
    position: m_latlng17,
    icon:iconImage8
  });
  marker17_konkichin.addListener('click', function() {
    infowindow_17.open(map, marker17_konkichin);
  });

  var m_latlng18 = new google.maps.LatLng(40.78797453, 140.78469336);
  marker18_yakkyoku = new google.maps.Marker({
    position: m_latlng18,
    icon:iconImage12
  });
  marker18_yakkyoku.addListener('click', function() {
    infowindow_18.open(map, marker18_yakkyoku);
  });

  var m_latlng19 = new google.maps.LatLng(40.78799542, 140.78449803);
  marker19_famirikuriniku = new google.maps.Marker({
    position: m_latlng19,
    icon:iconImage5
  });
  marker19_famirikuriniku.addListener('click', function() {
    infowindow_19.open(map, marker19_famirikuriniku);
  });

  var m_latlng20 = new google.maps.LatLng(40.7813066, 140.78091929);
  marker20_sekotuin = new google.maps.Marker({
    position: m_latlng20,
    icon:iconImage7
  });
  marker20_sekotuin.addListener('click', function() {
    infowindow_20.open(map, marker20_sekotuin);
  });

  var m_latlng21 = new google.maps.LatLng(40.78267599, 140.77701017);
  marker21_mikamiiin = new google.maps.Marker({
    position: m_latlng21,
    icon:iconImage5
  });
  marker21_mikamiiin.addListener('click', function() {
    infowindow_21.open(map, marker21_mikamiiin);
  });

  var m_latlng22 = new google.maps.LatLng(40.78154881, 140.77863961);
  marker22_takenamisika = new google.maps.Marker({
    position: m_latlng22,
    icon:iconImage6
  });
  marker22_takenamisika.addListener('click', function() {
    infowindow_22.open(map, marker22_takenamisika);
  });

  var m_latlng23 = new google.maps.LatLng(40.781279, 140.78139807);
  marker23_sekisika = new google.maps.Marker({
    position: m_latlng23,
    icon:iconImage6
  });
  marker23_sekisika.addListener('click', function() {
    infowindow_23.open(map, marker23_sekisika);
  });

  var m_latlng24 = new google.maps.LatLng(40.78453987, 140.78384914);
  marker24_koubatasika = new google.maps.Marker({
    position: m_latlng24,
    icon:iconImage6
  });
  marker24_koubatasika.addListener('click', function() {
    infowindow_24.open(map, marker24_koubatasika);
  });

  var m_latlng25 = new google.maps.LatLng(40.78415552, 140.77808037);
  marker25_airuhamanaka = new google.maps.Marker({
    position: m_latlng25,
    icon:iconImage6
  });
  marker25_airuhamanaka.addListener('click', function() {
    infowindow_25.open(map, marker25_airuhamanaka);
  });

  var m_latlng26 = new google.maps.LatLng(40.78459927, 140.77972725);
  marker26_tehutehu = new google.maps.Marker({
    position: m_latlng26,
    icon:iconImage9
  });
  marker26_tehutehu.addListener('click', function() {
    infowindow_26.open(map, marker26_tehutehu);
  });

  var m_latlng27 = new google.maps.LatLng(40.78106693, 140.78089515);
  marker27_CHELSEA = new google.maps.Marker({
    position: m_latlng27,
    icon:iconImage9
  });
  marker27_CHELSEA.addListener('click', function() {
    infowindow_27.open(map, marker27_CHELSEA);
  });

  var m_latlng28 = new google.maps.LatLng(40.78428245, 140.77858195);
  marker28_SUPERMAN = new google.maps.Marker({
    position: m_latlng28,
    icon:iconImage9
  });
  marker28_SUPERMAN.addListener('click', function() {
    infowindow_28.open(map, marker28_SUPERMAN);
  });

  var m_latlng29 = new google.maps.LatLng(40.78193748, 140.78358883);
  marker29_atorie = new google.maps.Marker({
    position: m_latlng29,
    icon:iconImage9
  });
  marker29_atorie.addListener('click', function() {
    infowindow_29.open(map, marker29_atorie);
  });

  var m_latlng30 = new google.maps.LatLng(40.78242508, 140.78393573);
  marker30_ron = new google.maps.Marker({
    position: m_latlng30,
    icon:iconImage9
  });
  marker30_ron.addListener('click', function() {
    infowindow_30.open(map, marker30_ron);
  });

  var m_latlng31 = new google.maps.LatLng(40.78369472, 140.78453808);
  marker31_kudou = new google.maps.Marker({
    position: m_latlng31,
    icon:iconImage9
  });
  marker31_kudou.addListener('click', function() {
    infowindow_31.open(map, marker31_kudou);
  });

  var m_latlng32 = new google.maps.LatLng(40.78144929, 140.78374788);
  marker32_aogin = new google.maps.Marker({
    position: m_latlng32,
    icon:iconImage3
  });
  marker32_aogin.addListener('click', function() {
    infowindow_32.open(map, marker32_aogin);
  });

  var m_latlng33 = new google.maps.LatLng(40.78061481, 140.78121799);
  marker33_aoginiten = new google.maps.Marker({
    position: m_latlng33,
    icon:iconImage3
  });
  marker33_aoginiten.addListener('click', function() {
    infowindow_33.open(map, marker33_aoginiten);
  });

  var m_latlng34 = new google.maps.LatLng(40.78135383, 140.78119576);
  marker34_yuubin = new google.maps.Marker({
    position: m_latlng34,
    icon:iconImage15
  });
  marker34_yuubin.addListener('click', function() {
    infowindow_34.open(map, marker34_yuubin);
  });

  var m_latlng35 = new google.maps.LatLng(40.78529981835521, 140.7818879143848);
  marker35_aodaimae = new google.maps.Marker({
    position: m_latlng35,
    icon:iconImage4
  });
  marker35_aodaimae.addListener('click', function() {
    infowindow_35.open(map, marker35_aodaimae);
  });

  var m_latlng36 = new google.maps.LatLng(40.78506584330007, 140.7828849021248);
  marker36_aodaimae2 = new google.maps.Marker({
    position: m_latlng36,
    icon:iconImage4
  });
  marker36_aodaimae2.addListener('click', function() {
    infowindow_36.open(map, marker36_aodaimae2);
  });

  var m_latlng37 = new google.maps.LatLng(40.785221936209595, 140.78292095102051);
  marker37_aodaimae3 = new google.maps.Marker({
    position: m_latlng37,
    icon:iconImage4
  });
  marker37_aodaimae3.addListener('click', function() {
    infowindow_37.open(map, marker37_aodaimae3);
  });

  var m_latlng38 = new google.maps.LatLng(40.78301258331486, 140.78428398599635);
  marker38_higasidouri1 = new google.maps.Marker({
    position: m_latlng38,
    icon:iconImage4
  });
  marker38_higasidouri1.addListener('click', function() {
    infowindow_38.open(map, marker38_higasidouri1);
  });

  var m_latlng39 = new google.maps.LatLng(40.78252023972352, 140.78430308552356);
  marker39_higasidouri2 = new google.maps.Marker({
    position: m_latlng39,
    icon:iconImage4
  });
  marker39_higasidouri2.addListener('click', function() {
    infowindow_39.open(map, marker39_higasidouri2);
  });

  var m_latlng40 = new google.maps.LatLng(40.781431279561744, 140.78236258675588);
  marker40_koubatadanti1 = new google.maps.Marker({
    position: m_latlng40,
    icon:iconImage4
  });
  marker40_koubatadanti1.addListener('click', function() {
    infowindow_40.open(map, marker40_koubatadanti1);
  });

  var m_latlng41 = new google.maps.LatLng(40.78109520243667, 140.78135401127952);
  marker41_koubatadanti2 = new google.maps.Marker({
    position: m_latlng41,
    icon:iconImage4
  });
  marker41_koubatadanti2.addListener('click', function() {
    infowindow_41.open(map, marker41_koubatadanti2);
  });

  var m_latlng42 = new google.maps.LatLng(40.78178880225462, 140.77797360006502);
  marker42_nisiguti1 = new google.maps.Marker({
    position: m_latlng42,
    icon:iconImage4
  });
  marker42_nisiguti1.addListener('click', function() {
    infowindow_42.open(map, marker42_nisiguti1);
  });

  var m_latlng43 = new google.maps.LatLng(40.78234160970877, 140.7769245141924);
  marker43_nisiguti2 = new google.maps.Marker({
    position: m_latlng43,
    icon:iconImage4
  });
  marker43_nisiguti2.addListener('click', function() {
    infowindow_43.open(map, marker43_nisiguti2);
  });

  var m_latlng44 = new google.maps.LatLng(40.78732897, 140.7843517);
  marker44_syougakoumae1 = new google.maps.Marker({
    position: m_latlng44,
    icon:iconImage4
  });
  marker44_syougakoumae1.addListener('click', function() {
    infowindow_44.open(map, marker44_syougakoumae1);
  });

  var m_latlng45 = new google.maps.LatLng(40.78740092, 140.78452534);
  marker45_syougakoumae2 = new google.maps.Marker({
    position: m_latlng45,
    icon:iconImage4
  });
  marker45_syougakoumae2.addListener('click', function() {
    infowindow_45.open(map, marker45_syougakoumae2);
  });

  var m_latlng46 = new google.maps.LatLng(40.78543193, 140.78225255);
  marker46_kouban = new google.maps.Marker({
    position: m_latlng46,
    icon:iconImage10
  });
  marker46_kouban.addListener('click', function() {
    infowindow_46.open(map, marker46_kouban);
  });

}

function doOpen() {
  marker1_daigaku.setMap(map);
  marker2_makuba.setMap(map);
  marker3_roson.setMap(map);
  marker4_famima.setMap(map);
  marker5_sebun.setMap(map);
  marker6_takahasi.setMap(map);
  marker7_tibasyokudou.setMap(map);
  marker8_tarukou.setMap(map);
  marker9_hokatei.setMap(map);
  marker10_yosijun.setMap(map);
  marker11_nekokafe.setMap(map);
  marker12_kafehiguti.setMap(map);
  marker13_ramensyopu.setMap(map);
  marker14_maruhuku.setMap(map);
  marker15_hinataboko.setMap(map);
  marker16_Oeuf.setMap(map);
  marker17_konkichin.setMap(map);
  marker18_yakkyoku.setMap(map);
  marker19_famirikuriniku.setMap(map);
  marker20_sekotuin.setMap(map);
  marker21_mikamiiin.setMap(map);
  marker22_takenamisika.setMap(map);
  marker23_sekisika.setMap(map);
  marker24_koubatasika.setMap(map);
  marker25_airuhamanaka.setMap(map);
  marker26_tehutehu.setMap(map);
  marker27_CHELSEA.setMap(map);
  marker28_SUPERMAN.setMap(map);
  marker29_atorie.setMap(map);
  marker30_ron.setMap(map);
  marker31_kudou.setMap(map);
  marker32_aogin.setMap(map);
  marker33_aoginiten.setMap(map);
  marker34_yuubin.setMap(map);
  marker35_aodaimae.setMap(map);
  marker36_aodaimae2.setMap(map);
  marker37_aodaimae3.setMap(map);
  marker38_higasidouri1.setMap(map);
  marker39_higasidouri2.setMap(map);
  marker40_koubatadanti1.setMap(map);
  marker41_koubatadanti2.setMap(map);
  marker42_nisiguti1.setMap(map);
  marker43_nisiguti2.setMap(map);
  marker44_syougakoumae1.setMap(map);
  marker45_syougakoumae2.setMap(map);
  marker46_kouban.setMap(map);
}

function doClose() {
  marker1_daigaku.setMap(null);
  marker2_makuba.setMap(null);
  marker3_roson.setMap(null);
  marker4_famima.setMap(null);
  marker5_sebun.setMap(null);
  marker6_takahasi.setMap(null);
  marker7_tibasyokudou.setMap(null);
  marker8_tarukou.setMap(null);
  marker9_hokatei.setMap(null);
  marker10_yosijun.setMap(null);
  marker11_nekokafe.setMap(null);
  marker12_kafehiguti.setMap(null);
  marker13_ramensyopu.setMap(null);
  marker14_maruhuku.setMap(null);
  marker15_hinataboko.setMap(null);
  marker16_Oeuf.setMap(null);
  marker17_konkichin.setMap(null);
  marker18_yakkyoku.setMap(null);
  marker19_famirikuriniku.setMap(null);
  marker20_sekotuin.setMap(null);
  marker21_mikamiiin.setMap(null);
  marker22_takenamisika.setMap(null);
  marker23_sekisika.setMap(null);
  marker24_koubatasika.setMap(null);
  marker25_airuhamanaka.setMap(null);
  marker26_tehutehu.setMap(null);
  marker27_CHELSEA.setMap(null);
  marker28_SUPERMAN.setMap(null);
  marker29_atorie.setMap(null);
  marker30_ron.setMap(null);
  marker31_kudou.setMap(null);
  marker32_aogin.setMap(null);
  marker33_aoginiten.setMap(null);
  marker34_yuubin.setMap(null);
  marker35_aodaimae.setMap(null);
  marker36_aodaimae2.setMap(null);
  marker37_aodaimae3.setMap(null);
  marker38_higasidouri1.setMap(null);
  marker39_higasidouri2.setMap(null);
  marker40_koubatadanti1.setMap(null);
  marker41_koubatadanti2.setMap(null);
  marker42_nisiguti1.setMap(null);
  marker43_nisiguti2.setMap(null);
  marker44_syougakoumae1.setMap(null);
  marker45_syougakoumae2.setMap(null);
  marker46_kouban.setMap(null);
}

function doOpen_1() {
   marker1_daigaku.setMap(map);
  marker3_roson.setMap(map);
  marker4_famima.setMap(map);
  marker5_sebun.setMap(map);
  marker6_takahasi.setMap(map);
}

function doOpen_2() {
   marker1_daigaku.setMap(map);
  marker26_tehutehu.setMap(map);
  marker27_CHELSEA.setMap(map);
  marker28_SUPERMAN.setMap(map);
  marker29_atorie.setMap(map);
  marker30_ron.setMap(map);
  marker31_kudou.setMap(map);
}

function doOpen_3() {
   marker1_daigaku.setMap(map);
  marker18_yakkyoku.setMap(map);
  marker19_famirikuriniku.setMap(map);
  marker20_sekotuin.setMap(map);
  marker21_mikamiiin.setMap(map);
  marker22_takenamisika.setMap(map);
  marker23_sekisika.setMap(map);
  marker24_koubatasika.setMap(map);
  marker25_airuhamanaka.setMap(map);
}

function doOpen_4() {
   marker1_daigaku.setMap(map);
  marker7_tibasyokudou.setMap(map);
  marker8_tarukou.setMap(map);
  marker9_hokatei.setMap(map);
  marker10_yosijun.setMap(map);
  marker11_nekokafe.setMap(map);
  marker12_kafehiguti.setMap(map);
  marker13_ramensyopu.setMap(map);
  marker14_maruhuku.setMap(map);
  marker15_hinataboko.setMap(map);
  marker16_Oeuf.setMap(map);
  marker17_konkichin.setMap(map);
}

function doOpen_5() {
   marker1_daigaku.setMap(map);
  marker2_makuba.setMap(map);
}

function doOpen_6() {
   marker1_daigaku.setMap(map);
  marker35_aodaimae.setMap(map);
  marker36_aodaimae2.setMap(map);
  marker37_aodaimae3.setMap(map);
  marker38_higasidouri1.setMap(map);
  marker39_higasidouri2.setMap(map);
  marker40_koubatadanti1.setMap(map);
  marker41_koubatadanti2.setMap(map);
  marker42_nisiguti1.setMap(map);
  marker43_nisiguti2.setMap(map);
  marker44_syougakoumae1.setMap(map);
  marker45_syougakoumae2.setMap(map);
}

function doOpen_7() {
  marker1_daigaku.setMap(map);
  marker32_aogin.setMap(map);
  marker33_aoginiten.setMap(map);
  marker34_yuubin.setMap(map);
  marker46_kouban.setMap(map);
}
