console.log("Hola mundo");

async function sendRequest(e) {
  e.preventDefault();

  const formData = new FormData(e.target);

  var object = {};
  formData.forEach((value, key) => (object[key] = value));
  var body = JSON.stringify(object);

  fetch("http://localhost:8080/api/login", {
    method: "POST", // *GET, POST, PUT, DELETE, etc.
    headers: {
      "Content-Type": "application/json",
      // 'Content-Type': 'application/x-www-form-urlencoded',
    },
    body: body,
  })
    .then((res) => res.json())
    .then((data) => {
      console.log(data);
      if (data.contrasenia) {
        localStorage.setItem("usuario", JSON.stringify(data));
        window.location.href = "../Pagina principal/index-paginaPrin.html";
        //localStorage.getItem("usuario"); //JSON.parse(usuario)
      } else {
        console.error(e);
        alert(data.message);
      }
    })
    .catch((e) => {
      console.error(e);
      alert("No se puedo iniciar sesion intenta despues");
    });
}
