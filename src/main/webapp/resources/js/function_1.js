let fn2 = function(){
	alert("익명함수");
	fn1();
};


let d3 = document.getElementById("d3");
//d3.onmouseenter=fn2;


d3.addEventListener("mouseleave",fn2);


/*d3.addEventListener("mouseleave",function(){
	
	fn1();
} );*/

function fn1(){
	alert('fn1');
}