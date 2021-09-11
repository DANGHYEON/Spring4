/**
 * join.js
 */
 
 
 const btn = document.getElementById("btn");
 const es = document.getElementsByClassName("es");
 const pw = document.getElementsByClassName("pw");
 const frm = document.getElementById("frm");
 const id = document.getElementById("id");
 const idResult = document.getElementById("idResult");
 const idCheck = document.getElementById("idCheck");
 


idCheck.addEventListener("click",function(){
	//location.href="./idCheck?id="+idCheck.value;
		open("./idCheck?id="+id.value,"","width=400, height=200, top=200, left=300");
	
});



id.addEventListener("change",function(){
	
		 alert('change');
	
});


 
 
 
 
 
 btn.addEventListener("click",function(){
		// 비어있는것들 검사
	let  ce	= checkEmpty(es);
		// 두개값이 같은지 검사
	let  ce2 = checkEqual(pw[0],pw[1]);
		// 글자수 검사
	let cl = checkLength();
	
	
	if(ce&&ce2&&cl){
		frm.submit();
	}else{	
		alert("필수 입력")
	}
		
	
})

function checkLength(){
 let l = pw[0].value.trim().length;
 
 	if(l>=6){
		return true;	
	}else{
		return false;
	}
 
 
}



function checkEmpty(es){
	
	let result = true;
	
	for(let r of es){
		if(r.value.trim() == ""){
			result = false;
			break;
		}
	}
	
	return result;
	
}


function checkEqual(check1,check2){
	return check1.value == check2.value;
	
}

/* id.addEventListener("blur",function(){
	
		 if(id.value.trim().length>=6){
			idResult.innerHTML="올바른ID";
			}else{
			idResult.innerHTML="ID는 6글자 이상"
			}
	
});
 */
 
 
  
/* id.addEventListener("blur",function(){
	
		 if(id.value.trim().length<6){
				id.focus();
			}
	
});*/
