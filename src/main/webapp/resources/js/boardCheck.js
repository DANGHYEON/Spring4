/**
 * 
 */
 
const btn = document.getElementById("bt1");

const title = document.getElementById("title");
const writer = document.getElementById("writer");
const frm = document.getElementById("frm");

const t1 = document.getElementById("t1");
const w1 = document.getElementById("w1");

btn.addEventListener("click", function(){
	t1.innerHTML="";
	w1.innerHTML="";
	let check=false;
	
	
	
	
	if(title.value=="" || writer.value==""){
		
	
		 check = false;
	}else{
		 check = true;
	}
	
	if(title.value==""){
		t1.innerHTML="필수 입력"
		}
			
		if(writer.value==""){
		w1.innerHTML="필수 입력"
		}
	
	if(check){
		frm.submit();
	}else{
		alert('입력하세요!!');
	}
	
})




