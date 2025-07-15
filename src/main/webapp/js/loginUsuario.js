document.querySelector("form").addEventListener("submit", function (e) {
  e.preventDefault();

  const email = document.getElementById("email").value.trim();
  const senha = document.getElementById("senha").value;

  const usuarios = JSON.parse(localStorage.getItem("usuarios")) || [];
  const usuario = usuarios.find(u => u.email === email && u.senha === senha);

  if (usuario) {
    localStorage.setItem("userData", JSON.stringify(usuario));
    alert("Login bem-sucedido!");
    window.location.href = "home.html";
  } else {
    alert("Email ou senha incorretos!");
  }
});