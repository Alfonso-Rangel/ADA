fetch("/api/productos/saludo")
  .then(response => response.text())
  .then(text => {
    document.getElementById("saludo").textContent = text;
  });
