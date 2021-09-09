/**
 * check.js
 */
 
 const ch = document.getElementById("checkALL");
 const ch1 = document.getElementsByClassName("check");
 const btn = document.getElementById("btn");
 const ch2 = document.getElementsByClassName("check1");
 let pel = false;
 
ch.addEventListener("click",function(){
		
		for(let i of ch1){	
			i.checked=true;
		}
		
		if(!ch.checked){
			for(let i of ch1){	
			i.checked=false;
				}
		}
			
		
})


for(let i of ch1){
	
	i.addEventListener("click",function(){
		
		let result = true;
		
		for(let j of ch1){
			if(!j.checked){
				result=false;
				break;
			}
		}
		
		ch.checked=result;
	
		
	})
	

}

for(let i of ch2){
	
	i.addEventListener("click",function(){
		
		let result = true;
		
		for(let j of ch2){
			if(!j.checked){
				result=false;
				break;
			}
		}
		
		pel=result;
		
	})

}


btn.addEventListener("click", function(){
	
	if(ch.checked){
		pel=true;
	}
	
	if(pel){
		/*location.replace("./join");*/ /*리다이렉트*/
		location.href="./join";
	}else{
		alert("필수 약관에 동의해야함");
	}
	
})




