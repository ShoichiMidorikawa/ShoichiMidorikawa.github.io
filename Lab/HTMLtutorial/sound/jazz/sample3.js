// IFrame Player API の読み込み
  var tag = document.createElement('script');
  tag.src = "https://www.youtube.com/iframe_api";
  var firstScriptTag = document.getElementsByTagName('script')[0];
  firstScriptTag.parentNode.insertBefore(tag, firstScriptTag);

  function onYouTubeIframeAPIReady() {
      ytPlayer1 = new YT.Player(
         'sample1', // 埋め込む場所
         {
            width: '0',  // プレーヤー幅
            height: '0', // プレーヤー高さ
            videoId: 'Tn3acz2KI9M'  // YouTubeID
         }
      );
      ytPlayer2 = new YT.Player(
             'sample2', 
             {
                width: '0', 
                height: '0',
                videoId: 'KV8Hj_E8LJc'
             }
      );
      ytPlayer3 = new YT.Player(
             'sample3', // 埋め込む場所の指定
             {
                width: '0', 
                height: '0', 
                videoId: 'omjZ73GFPaQ' 
             }
      );
      ytPlayer4 = new YT.Player(
             'sample4', // 埋め込む場所の指定
             {
                width: '0', 
                height: '0', 
                videoId: 'YsVJuulCmAE' 
             }
      );
  };


onload = function(){
  var sl=document.getElementById('sel1');

       $('#play').click(function() {
         ytPlayer1.playVideo();
       });
       $('#pause').click(function() {
         ytPlayer1.pauseVideo();
       });
       $('#stop').click(function() {
         ytPlayer1.pauseVideo().seekTo(0);
       });

  sl.onchange = function(){

    var selectedItem = this.options[this.selectedIndex];
  
    if(selectedItem.value == 0){
       $('#play').click(function() {
         ytPlayer2.pauseVideo();
         ytPlayer3.pauseVideo();
         ytPlayer4.pauseVideo();
         ytPlayer1.playVideo();
   ytPlayer1.playVideo();
       });
       $('#pause').click(function() {
         ytPlayer1.pauseVideo();
       });
       $('#stop').click(function() {
         ytPlayer1.pauseVideo().seekTo(0);
       });
    }else if(selectedItem.value == 1){
       $('#play').click(function() {
         ytPlayer1.pauseVideo();
         ytPlayer3.pauseVideo();
         ytPlayer4.pauseVideo();
         ytPlayer2.playVideo();
       });
       $('#pause').click(function() {
         ytPlayer2.pauseVideo();
       });
       $('#stop').click(function() {
         ytPlayer2.pauseVideo().seekTo(0);
       });    
    }else if(selectedItem.value == 2){
       $('#play').click(function() {
         ytPlayer1.pauseVideo();
         ytPlayer2.pauseVideo();
         ytPlayer4.pauseVideo();
         ytPlayer3.playVideo();
       });
       $('#pause').click(function() {
         ytPlayer3.pauseVideo();
       });
       $('#stop').click(function() {
         ytPlayer3.pauseVideo().seekTo(0);
       });    
    }else if(selectedItem.value == 3){
       $('#play').click(function() {
         ytPlayer1.pauseVideo();
         ytPlayer2.pauseVideo();
         ytPlayer3.pauseVideo();
         ytPlayer4.playVideo();
       });
       $('#pause').click(function() {
         ytPlayer4.pauseVideo();
       });
       $('#stop').click(function() {
         ytPlayer4.pauseVideo().seekTo(0);
       });    
    }
  }

};

