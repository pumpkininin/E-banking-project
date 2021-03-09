var slides = document.querySelectorAll(".mySlides");
var numOfSlide = slides.length;
var index = 0;

slides[index].classList.add("show");

 prev = () => {
	
	slides[index].classList.remove("show");
	index = index > 0 ? --index  : numOfSlide - 1;
	slides[index].classList.add("show");
	console.log(index)
}
next = () => {
	slides[index].classList.remove("show");
	index = index === numOfSlide-1 ? 0  : ++index;
	slides[index].classList.add("show");
	console.log(index)
	
}


