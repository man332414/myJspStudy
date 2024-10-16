let btn = document.querySelector("#btn");
console.log(btn);
btn.addEventListener("click", checkAddBook);

function checkAddBook()
{
	console.log("연결");
	let form = document.querySelector("#form");
	let bookId = document.querySelector("#bookId").value;
	let name = document.querySelector("#name").value;
	let unitPrice = document.querySelector("#unitPrice").value;
	let author = document.querySelector("#author").value;
	let publisher = document.querySelector("#publisher").value;
	let releaseDate = document.querySelector("#releaseDate").value;
	let category = document.querySelector("#category").value;
	let unitsInSrock = document.querySelector("#unitsInSrock").value;
	console.log(bookId);
	console.log(name);
	console.log(unitPrice);
	console.log(author);
	console.log(publisher);
	console.log(releaseDate);
	console.log(category);
	console.log(unitsInSrock);
	
	let regExpBookId = /^ISBN[0-9]{4,11}$/; 
	
	if(!regExpBookId.test(bookId))
	{
		alert("[도서코드]\nISBN과 숫자를 조합하여 5~12자까지 입력하세요\n첫 글자는 ISBN으로 시작해야 합니다.");
		form.bookId.select();
		return false;
	}
	
	if(name.length<4 || name.length > 50)
	{
		alert("[도서명]\n최소 4자에서 최대 50자까지 입력하세요");
		form.name.select();
		return false;
	}
	
	if(unitPrice.length == 0 || isNaN(unitPrice))
	{
		alert("[가격]\n숫자만 입력하세요")
		form.unitPrice.select();
		return false;
	}
	
	if(unitPrice<0)
	{
		alert("[가격]\n음수를 입력할 수 없습니다.")
		form.unitPrice.select();
		return false;
	}
	
	if(isNaN(unitsInSrock))
	{
		alert("[재고수]\n숫자만 입력할 수 있습니다.")
		form.unitsInSrok.select();
		return false;
	}
	form.submit();
}