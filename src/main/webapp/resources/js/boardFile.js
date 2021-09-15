/**
 * 
 최대 5개 까지만 추가 가능
 */
 
 let files = '<div class="input-group mb-3">';
 files = files + '<input type="file" name="files" class="form-control">';
 files = files + '<button class="btn btn-outline-secondary del" type="button">X</button>';
 files = files + '</div>';

 
 
 let num = 0;
//  let index=0;
 
 

 
 $("#btn1").click(function(){
	
/*	index++;

 let files = '<div class="input-group mb-3" id="del'+index+'">';
 files = files + '<input type="file" class="form-control">';
 files = files + '<button data-btn-id="'+index+'" class="btn btn-outline-secondary del" type="button">X</button>';
 files = files + '</div>';*/
	

	
	num++;
	if(num<6){
	
	$("#fileAddResult").append(files);
	}else{
		alert("생성 불가!")
	}
	
	
})
 
 
 
 $("#fileAddResult").on('click','.del' ,function(){
	//let num = $(this).attr('data-btn-id');
	//$("#del"+num).remove();
	
	
	$(this).parent().remove();
	
	
	num--;
});
 