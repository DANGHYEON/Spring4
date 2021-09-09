/**
 * select.js
 */
 
 
const c1 = document.getElementsByClassName("c1");
const btn = document.getElementById("btn") ;
 
/*for(let i of c1){
	
	i.addEventListener('click',function(){
		
			//alert(i.value);
			alert(i.checked);
	});
   
 }*/
 
 btn.addEventListener("click",function(){
	
	 for(let i of c1){
	
		i.checked=true;   
 }
	
	
})
 
 
