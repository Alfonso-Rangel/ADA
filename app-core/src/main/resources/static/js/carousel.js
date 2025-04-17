const carousel = document.querySelector(".category-carousel");
const prevButton = document.querySelector(".prev");
const nextButton = document.querySelector(".next");
let position = 0;

function moveCarousel(direction) {
  const itemWidth = carousel.firstElementChild.offsetWidth;
  const maxPosition = (carousel.children.length - 3) * itemWidth;

  if (direction === "next" && position > -maxPosition) {
    position -= itemWidth;
  } else if (direction === "prev" && position < 0) {
    position += itemWidth;
  }

  carousel.style.transform = `translateX(${position}px)`;
}

prevButton.addEventListener("click", () => moveCarousel("prev"));
nextButton.addEventListener("click", () => moveCarousel("next"));

function getProductos() {
  var object = {};

  fetch("http://localhost:8080/api/productos", {
    method: "GET", // *GET, POST, PUT, DELETE, etc.
    headers: {
      "Content-Type": "application/json",
      // 'Content-Type': 'application/x-www-form-urlencoded',
    },
  })
    .then((res) => res.json())
    .then((data) => {
      console.log(data);
    })
    .catch((e) => {
      console.error(e);
      alert("No se encontraron productos");
    });
}

getProductos();
