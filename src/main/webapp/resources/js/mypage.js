/**
 * mypage.js
 */
 
 const btn = document.getElementById("btn");
 const frm = document.getElementById("frm");
 
 btn.addEventListener("click",function(){
	
	let con = confirm("정말 회원탈퇴 하시겠습니까?")
	
	if(con==true){
		frm.submit();
		
	}else{
		return;
	}
	
	
	
	
})

