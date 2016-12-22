
 	function buy(){
 		$.ajax({
 			url:'buy.do?id='+ $(".id").val()+'&filmname='+$(".filmname").html(),
 			type:'POST',
 			success:function(data){
 				alert(data);
 			}
 		});
 	}
 	
 	
 	setInterval("myInterval()",3000);
    function myInterval()
    {
         $.ajax({
        	 url:'refresh.do?id='+ $(".id").val(),
  			 type:'POST',
        	 success:function(data){
        		 $(".number").text(data);
        	 }
         });
     }