/**
 * check.js
 */
 




$("#checkALL").click(function(){
	
	$(".check").prop("checked",$("#checkALL").prop("checked"));
	
});


$(".check").click(function(){
	let result = true;
		$(".check").each(function(v1,v2){
			if(!$(v2).prop("checked")){
				result=false;
				console.log(v1, $(v2).prop("checked"));
				//break each문 내에서 사용불가
			}
		});
		
		$("checkALL").prop("checked", result);

});





